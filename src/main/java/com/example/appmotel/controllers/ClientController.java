package com.example.appmotel.controllers;

import com.example.appmotel.model.Client;
import com.example.appmotel.response.ClienteResponse;
import com.example.appmotel.services.ClientServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private  final ClientServices clientServices;

    public ClientController(ClientServices clientServices) {
        this.clientServices = clientServices;
    }

    @GetMapping
    public List<Client>list(){
        return clientServices.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> findClient(@PathVariable("id") Long id){
        return clientServices.findClientById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Client register(@RequestBody Client client) {
        return clientServices.registerClient(client);
    }

    @PutMapping("/{clientId}")
    public Client AlterClientData(@PathVariable Long clientId, @RequestBody Client client) {
       return clientServices.updateClientData(clientId, client);
    }
    @DeleteMapping("/{clientId}")
    public ResponseEntity<Client> removeClient(@PathVariable Long clientId) {
       return clientServices.removeClient(clientId);
    }
}
