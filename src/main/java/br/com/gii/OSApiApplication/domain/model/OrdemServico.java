/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gii.OSApiApplication.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;





/**
 *
 * @author sesi3dia
 */
@Entity
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @ManyToOne
    private Cliente cliente;
    
    private String descricao;
    private BigDecimal preco;
    
    @Enumerated(EnumType.STRING)
    private StatusOrdemServico status;
    
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFinalizacao;
    
    
    
    
}
