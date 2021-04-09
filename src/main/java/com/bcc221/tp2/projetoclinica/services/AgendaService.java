/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcc221.tp2.projetoclinica.services;

import com.bcc221.tp2.projetoclinica.entities.Especialista;
import com.bcc221.tp2.projetoclinica.entities.RegistroAgenda;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author paulo
 */
public class AgendaService {

    private Especialista currentEspecialista = null;
    private List<Especialista> especialistas;

    public AgendaService() {
    }

    public Especialista getCurrentEspecialista() {
        return currentEspecialista;
    }

    public void setCurrentEspecialista(Especialista currentEspecialista) {
        this.currentEspecialista = currentEspecialista;
    }

    public List<Especialista> getEspecialistas() {
        return especialistas;
    }

    public void setEspecialistas(List<Especialista> especialistas) {
        this.especialistas = especialistas;
    }

    public void addRegistroAgenda(String data, String cliente, String descricao) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        if (this.getCurrentEspecialista() == null) {
            throw new NullPointerException("Especialista não selecionado.");
        }

        RegistroAgenda registro = new RegistroAgenda();
        registro.setCodigo(this.getCurrentEspecialista().getAgenda().size() + 1);
        registro.setData(LocalDate.parse(data, formatter));
        registro.setDescricao(descricao);
        
        // TODO: Ordenar agenda por data

    }

}
