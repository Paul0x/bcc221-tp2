package com.bcc221.tp2.projetoclinica.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Classe para representar um registro na agenda
 * @author paulo
 */
public class RegistroAgenda implements Serializable{
    
    Integer codigo;
    LocalDate data;
    LocalTime hora;
    String descricao;

    /**
     *  Construtor vazio
     */
    public RegistroAgenda() {
    }

    /**
     * Construtor de agenda recebendo parâmetros
     * @param codigo
     * @param data
     * @param hora
     * @param descricao
     */
    public RegistroAgenda(Integer codigo, LocalDate data, LocalTime hora, String descricao) {
        this.codigo = codigo;
        this.data = data;
        this.descricao = descricao;
        this.hora = hora;
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
     * Getter da hora
     * @return
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Setter da hora
     * @param hora
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
    /**
     * Transforma a propriedade hora e data em LocalDateTime
     * @return
     */
    public LocalDateTime getDateTime() {
        return LocalDateTime.of(this.getData(), this.getHora());
    }
    
}
