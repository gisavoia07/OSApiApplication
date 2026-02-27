/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gii.OSApiApplication.api.controller;

import br.com.gii.OSApiApplication.domain.model.Cliente;
import br.com.gii.OSApiApplication.domain.repository.ClienteRepository;
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

    @GetMapping("/clientes")
    public List<Cliente> listas() {
        return clienteRepository.findAll();

    }

    @GetMapping("/clientes/{clienteID}")
    public Cliente buscar(@PathVariable Long clienteID) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteID);
        return cliente.orElse(null);
    }
          @PostMapping ("/clientes")
         @ResponseStatus(HttpStatus.CREATED)
         public Cliente adicionar (@Valid @RequestBody Cliente cliente) {
        
        return clienteRepository.save(cliente);
    }
         @PutMapping("/cliente/{clienteID}")
         public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteID,
                 @RequestBody Cliente cliente){
             
             //Verifique se o cliente exist 
             if(!clienteRepository.existsById(clienteID)){
                 return ResponseEntity.notFound().build();
             }
             cliente.setId(clienteID);
             cliente = clienteRepository.save(cliente);
             return ResponseEntity.ok(cliente);
             
         }
         @DeleteMapping("/cliente/{clienteID}")
         public ResponseEntity<Void> excluir (@PathVariable long clienteID){
             //Verificar se cliente existe ou não
             
             if (!clienteRepository.existsById(clienteID)){
                 return ResponseEntity.notFound().build();
         }
             clienteRepository.deleteById((clienteID));
             return ResponseEntity.noContent().build();
             

}
}
