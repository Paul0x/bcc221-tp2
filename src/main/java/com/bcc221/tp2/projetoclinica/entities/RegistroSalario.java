package com.bcc221.tp2.projetoclinica.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Classe para representar um registro de salário
 * @author paulo
 */
public class RegistroSalario implements Serializable {

    private Integer ano;
    private Integer mes;
    private BigDecimal valor;
    private String observacao;
    private LocalDate dtPagamento;

    /**
     * Construtor vazio
     */
    public RegistroSalario() {
    }

    /**
     * Construtor com parâmetros
     * @param ano
     * @param mes
     */
    public RegistroSalario(Integer ano, Integer mes) {
        this.ano = ano;
        this.mes = mes;
    }
    
    /**
     * Getter ano
     * @return
     */
    public Integer getAno() {
        return ano;
    }

    /**
     * Setter ano
     * @param ano
     */
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    /**
     * Getter mês
     * @return
     */
    public Integer getMes() {
        return mes;
    }

    /**
     * Setter mês
     * @param mes
     */
    public void setMes(Integer mes) {
        this.mes = mes;
    }

    /** 
     * Getter valor
     * @return
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * Setter valor
     * @param valor
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    /**
     * Getter observação
     * @return
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * Setter observação
     * @param observacao
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * Getter data de pagamento
     * @return
     */
    public LocalDate getDtPagamento() {
        return dtPagamento;
    }

    /**
     * Setter data de pagamento
     * @param dtPagamento
     */
    public void setDtPagamento(LocalDate dtPagamento) {
        this.dtPagamento = dtPagamento;
    }   

    /**
     * Hash code veriifcando o ano e o mês
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.ano);
        hash = 59 * hash + Objects.hashCode(this.mes);
        return hash;
    }

    /**
     * Equals utilizando apenas o ano e o mês para verificação
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegistroSalario other = (RegistroSalario) obj;
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        if (!Objects.equals(this.mes, other.mes)) {
            return false;
        }
        return true;
    }    
    
}
