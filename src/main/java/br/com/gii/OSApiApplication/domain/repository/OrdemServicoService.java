/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gii.OSApiApplication.domain.repository;

import br.com.gii.OSApiApplication.domain.model.Cliente;
import br.com.gii.OSApiApplication.domain.model.OrdemServico;
import br.com.gii.OSApiApplication.domain.model.StatusOrdemServico;
import br.eti.gii.OSApiApplication.domain.exceptio.DomainException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesi3dia
 *
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

    public void remover(Long id) {
        ordemServicoRepository.deleteById(id);

    }

    public OrdemServico buscar(Long id) {
        return ordemServicoRepository.findById(id).orElse(null);
    }

    public List<OrdemServico> listarPorCliente(Long clienteId) {
        Cliente cliBusca = new Cliente();
        cliBusca.setId(clienteId);
        return ordemServicoRepository.findByCliente(cliBusca);
    }

    public OrdemServico atualizar(long id, OrdemServico novaOrdem) {
        OrdemServico ordem = ordemServicoRepository.findById(id).orElse(null);
        if (ordem != null) {
            ordem.setDescricao(novaOrdem.getDescricao());
            ordem.setPreco(novaOrdem.getPreco());
            return ordemServicoRepository.save(ordem);
        }
        return null;
    }

    /**
     *
     * @param ordemServicoID
     * @param status
     * @return Optional<OrdemServico> or throw if not found
     */
    public Optional<OrdemServico> atualizaStatus(Long ordemServicoID, StatusOrdemServico status) {

        Optional<OrdemServico> optOrdemServico = ordemServicoRepository.findById(ordemServicoID);

        if (optOrdemServico.isPresent()) {

            OrdemServico ordemServico = optOrdemServico.get();

            if (ordemServico.getStatus() == StatusOrdemServico.ABERTA
                    && status != StatusOrdemServico.ABERTA) {

                ordemServico.setStatus(status);
                ordemServico.setDataFinalizacao(LocalDateTime.now());
                ordemServicoRepository.save(ordemServico);
                return Optional.of(ordemServico);

            } else {
                return Optional.empty();

            }

        } else {
            // Lançar exception se ID não encontrado
            throw new DomainException("Não existe OS com o id " + ordemServicoID);
        }
    }
}
