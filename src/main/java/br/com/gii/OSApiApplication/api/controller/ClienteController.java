/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gii.OSApiApplication.api.controller;

import br.com.gii.OSApiApplication.domain.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
public class ClienteController {
    List<Cliente> listaClientes;
    
    @GetMapping("/clientes")
    public List<Cliente> listas(){
        listaClientes = new ArrayList<Cliente>();
        listaClientes.add(new Cliente(1, "gii", "gii@teste.com", "12 98989-8989"));
        listaClientes.add(new Cliente(1, "lu", "lu@teste.com", "12 77777-8888"));
        listaClientes.add(new Cliente(1, "lau", "lau@teste.com", "12 66666-5555"));
        
        return listaClientes;
    }
    
}
