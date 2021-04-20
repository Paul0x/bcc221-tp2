package com.bcc221.tp2.projetoclinica.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Classe para representar um Registro de Pagamento
 * @author paulo
 */
public class RegistroPagamento implements Serializable {

    String descricao;
    LocalDate dataPagamento;
    LocalDate dataVencimento;
    String tipo;
    BigDecimal valor;
    
    /**
     * Construtor vazio
     */
    public RegistroPagamento() {
    }

    /**
     * Getter da descrição
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Setter da descrição
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Getter da data de pagamento
     * @return
     */
    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    /**
     * Setter da data de pagamento
     * @param dataPagamento
     */
    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    /**
     * Getter da data de vencimento
     * @return
     */
    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    /**
     * Setter da data de vencimento
     * @param dataVencimento
     */
    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    /**
     * Getter do tipo
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Setter do tipo
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
