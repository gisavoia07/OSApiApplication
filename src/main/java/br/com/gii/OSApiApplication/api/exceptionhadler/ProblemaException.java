/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gii.OSApiApplication.api.exceptionhadler;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author sesi3dia
 */
public class ProblemaException {
    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<CampoProblema> getListaCampoProblema() {
        return listaCampoProblema;
    }

    public void setListaCampoProblema(List<CampoProblema> listaCampoProblema) {
        this.listaCampoProblema = listaCampoProblema;
    }
    
    
    
    private List<CampoProblema> listaCampoProblema;
    
    public List<CampoProblema> getCampos(){
        return listaCampoProblema;
    }
   public void setCampo(List<CampoProblema> campos){   
   }
    
    public static class CampoProblema{
        private String nomeCampo;
        private String mensagemCampo;
        
        public CampoProblema(String nomeCampo, String mensagemCampo){
            this.nomeCampo = nomeCampo;
            this.mensagemCampo = mensagemCampo;  
        }
        public String getNomeCampo(){
            return nomeCampo;
        }
        public void setNomeCampo (String nomeCampo){
            this.nomeCampo = nomeCampo;
        }
        public String getMensagemCampo(){
            return mensagemCampo;
        }
        public void setMensagemCampo(String mensagemCampo){
            this.mensagemCampo = mensagemCampo;
        }
        
        
    }
      
}
