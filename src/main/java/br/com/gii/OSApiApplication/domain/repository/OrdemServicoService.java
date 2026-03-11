/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gii.OSApiApplication.domain.repository;

import br.com.gii.OSApiApplication.domain.model.OrdemServico;
import br.com.gii.OSApiApplication.domain.model.StatusOrdemServico;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author sesi3dia
 */
@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public OrdemServico criar(OrdemServico ordemServico) {
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());

        return ordemServicoRepository.save(ordemServico);
    }
}