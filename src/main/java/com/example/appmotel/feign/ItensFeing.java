package com.example.appmotel.feign;

import com.example.appmotel.model.Itens;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@FeignClient(name = "itens-consumer", url = "localhost:8080/itens")
public interface ItensFeing {
    @GetMapping
    List<Itens> listItens();

    @PostMapping
    Itens criaItens(@RequestBody Itens descricao);

    @GetMapping("/{itemId}")
    Itens findItemById(@PathVariable ("itemId") Long itemId);

    @GetMapping("/itemVazio")
    Itens itemVazio();
}
