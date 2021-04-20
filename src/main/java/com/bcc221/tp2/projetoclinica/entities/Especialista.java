package com.bcc221.tp2.projetoclinica.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe para representar um Especialista
 * @author paulo
 */
public class Especialista extends Funcionario implements Serializable{
    
    private List<RegistroAgenda> agenda = new ArrayList<>();
    private List<RegistroConsulta> consultas = new ArrayList<>();

    /**
     * Construtor vazio
     */
    public Especialista() {
    }

    /**
     * Getter da lista de agendas
     * @return
     */
    public List<RegistroAgenda> getAgenda() {
        return agenda;
    }

    /**
     * Setter da lista de agendas
     * @param agenda
     */
    public void setAgenda(List<RegistroAgenda> agenda) {
        this.agenda = agenda;
    }

    /**
     * Getter da lista de consultas
     * @return
     */
    public List<RegistroConsulta> getConsultas() {
        return consultas;
    }

    /**
     * Setter da lista de consultas
     * @param consultas
     */
    public void setConsultas(List<RegistroConsulta> consultas) {
        this.consultas = consultas;
    }
    
    
    
}
