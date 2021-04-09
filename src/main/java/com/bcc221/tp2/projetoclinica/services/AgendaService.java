/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcc221.tp2.projetoclinica.services;

import com.bcc221.tp2.projetoclinica.entities.Especialista;
import java.util.List;

/**
 *
 * @author paulo
 */
public class AgendaService {
    
    private Especialista currentEspecialista;
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
    
    
    
    
}
