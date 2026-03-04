/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gii.OSApiApplication.domain.model;

import br.com.gii.OSApiApplication.domain.repository.ClienteRepository;
import br.eti.gii.OSApiApplication.domain.exceptio.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesi3dia
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());

        //Lembre-se que o metodo SAVE pode ser usado para atualizar um  cliente tambem!!
        //ID vazio --> Novo Registro
        ///ID Preenchido --> ALterar existente
    
    //Verifique se o cliente existe 
    if (clienteExistente != null && !clienteExistente.equals(cliente)) {
            //Lançar exception
            throw new DomainException("Ja existe um cliente cadastrado com esse email!");
        }
        return clienteRepository.save(cliente);

    }

    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
