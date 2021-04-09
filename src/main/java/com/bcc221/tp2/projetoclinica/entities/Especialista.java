/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcc221.tp2.projetoclinica.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulo
 */
public class Especialista extends Funcionario implements Serializable{
    
    private List<RegistroAgenda> agenda = new ArrayList<>();
    private List<RegistroConsulta> consultas = new ArrayList<>();

    public Especialista() {
    }

    public List<RegistroAgenda> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<RegistroAgenda> agenda) {
        this.agenda = agenda;
    }

    public List<RegistroConsulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<RegistroConsulta> consultas) {
        this.consultas = consultas;
    }
    
    
    
}
