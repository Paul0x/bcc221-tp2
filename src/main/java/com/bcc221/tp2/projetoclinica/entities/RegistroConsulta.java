/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcc221.tp2.projetoclinica.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author paulo
 */
public class RegistroConsulta implements Serializable {
    
    Integer codigo;
    LocalDate data;
    String cliente;
    BigDecimal valor;

    public RegistroConsulta() {
    }

    public RegistroConsulta(Integer codigo, LocalDate data, String cliente, BigDecimal valor) {
        this.codigo = codigo;
        this.data = data;
        this.cliente = cliente;
        this.valor = valor;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    
    
}
