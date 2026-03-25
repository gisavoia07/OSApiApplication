/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gii.OSApiApplication.domain.repository;

import br.com.gii.OSApiApplication.domain.model.Cliente;
import br.com.gii.OSApiApplication.domain.model.OrdemServico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sesi3dia
 */
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>{
    
    public List<OrdemServico> findByCliente(Cliente cliente);
    
    
}
    
    

