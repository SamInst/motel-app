package com.example.appmotel.controllers;

import com.example.appmotel.model.MapaGeral;
import com.example.appmotel.response.MapaGeralResponse;
import com.example.appmotel.services.MapaGeralService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/maps")
public class MapaGeralController {
private final MapaGeralService mapaGeralService;
    public MapaGeralController(MapaGeralService mapaGeralService) {
        this.mapaGeralService = mapaGeralService;
    }

    @GetMapping
    public List<MapaGeral> list(){
        return mapaGeralService.listAllMaps();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<MapaGeralResponse> findMapaGeral(@PathVariable("userId") Long id) {
        return mapaGeralService.findMapaGeral(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MapaGeral add(@RequestBody MapaGeral mapaGeral) {
        return mapaGeralService.add(mapaGeral);
    }

    @GetMapping("/findByDate")
    public List<MapaGeral> findByData(LocalDate date){
        return mapaGeralService.findByData(date);
    }
}