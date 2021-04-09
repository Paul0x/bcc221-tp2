/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcc221.tp2.projetoclinica.entities;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author paulo
 */
public class RegistroAgenda implements Serializable{
    
    Integer codigo;
    LocalDate data;
    String descricao;

    public RegistroAgenda() {
    }

    public RegistroAgenda(Integer codigo, LocalDate data, String descricao) {
        this.codigo = codigo;
        this.data = data;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
