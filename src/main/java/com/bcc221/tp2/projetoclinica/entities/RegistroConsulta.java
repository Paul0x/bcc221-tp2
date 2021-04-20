package com.bcc221.tp2.projetoclinica.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Classe representando um registro de consulta
 * @author paulo
 */
public class RegistroConsulta implements Serializable {
    
    Integer codigo;
    LocalDate data;
    String cliente;
    BigDecimal valor;

    /**
     * Construtor vazio
     */
    public RegistroConsulta() {
    }

    /**
     * Construtor com parâmetros
     * @param codigo
     * @param data
     * @param cliente
     * @param valor
     */
    public RegistroConsulta(Integer codigo, LocalDate data, String cliente, BigDecimal valor) {
        this.codigo = codigo;
        this.data = data;
        this.cliente = cliente;
        this.valor = valor;
    }

    /**
     * Getter do código
     * @return
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * Setter do código
     * @param codigo
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * Getter da data
     * @return
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Setter da data
     * @param data
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /** 
     * Getter do cliente
     * @return
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Setter do cliente
     * @param cliente
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Getter do valor
     * @return
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * Setter do valor
     * @param valor
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    
    
}
