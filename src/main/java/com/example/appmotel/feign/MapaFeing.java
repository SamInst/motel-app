package com.example.appmotel.feign;

import com.example.appmotel.model.MapaGeral;
import com.example.appmotel.response.MapaGeralResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "mapa-consumer", url = "localhost:8080/maps")
public interface MapaFeing {
    @GetMapping
    List<MapaGeral> mapaGeralList();

    @GetMapping("/{mapaID}")
    ResponseEntity<MapaGeralResponse> findMapaGeral(@PathVariable("mapaID") Long id);

    @PostMapping
    MapaGeral createMapa(@RequestBody MapaGeral mapaGeral);

    @GetMapping("/findByDate")
    List<MapaGeral> findByData(LocalDate date);

    @GetMapping("/getTotalMapaGeral")
    Float totalMapaGeral();
}
