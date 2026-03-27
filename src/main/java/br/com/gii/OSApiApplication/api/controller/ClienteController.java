/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gii.OSApiApplication.api.controller;

import br.com.gii.OSApiApplication.domain.model.Cliente;
import br.com.gii.OSApiApplication.domain.model.ClienteService;
import br.com.gii.OSApiApplication.domain.repository.ClienteRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    @Operation(summary = "Lista todos os clientes", description = "Lista todos os Clientes da base de dados")
    public List<Cliente> listas() {
        return clienteRepository.findAll();

    }

    @Operation(summary = "Cliente por ID", description = "Returna um cliente por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - O Cliente não existe.")
    })

    @GetMapping("/clientes/{clienteID}")
    public ResponseEntity<Cliente> buscar(
            @PathVariable 
            @Parameter(name = "clienteID", description = "ID do Cliente", example = "1") 
                    Long clienteID) {
        
        
        Optional<Cliente> cliente = clienteRepository.findById(clienteID);
        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cliente.get());
        }

    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @PutMapping("/cliente/{clienteID}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteID,
            @RequestBody Cliente cliente) {

        //Verifique se o cliente exist 
        if (!clienteRepository.existsById(clienteID)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteID);
        cliente = clienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);

    }

    @DeleteMapping("/cliente/{clienteID}")
    public ResponseEntity<Void> excluir(@PathVariable long clienteID) {
        //Verificar se cliente existe ou não

        if (!clienteRepository.existsById(clienteID)) {
            return ResponseEntity.notFound().build();
        }
        clienteService.excluir((clienteID));
        return ResponseEntity.noContent().build();
    }

}
