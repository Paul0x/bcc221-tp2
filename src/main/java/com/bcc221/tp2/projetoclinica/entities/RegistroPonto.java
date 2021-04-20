/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcc221.tp2.projetoclinica.entities;

import java.io.Serializable;

/**
 * Classe para representar um Registro de POnto
 * @author paulo
 */
public class RegistroPonto implements Serializable {

    private Integer dia;
    private String observacao;

    /**
     * Construtor vazio
     */
    public RegistroPonto() {
    }
    
    /**
     * Getter do dia
     * @return
     */
    public Integer getDia() {
        return dia;
    }

    /** 
     * Setter do dia
     * @param dia
     */
    public void setDia(Integer dia) {
        this.dia = dia;
    }

    /**
     * Getter da observação
     * @return
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * Setter da observação
     * @param observacao
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
