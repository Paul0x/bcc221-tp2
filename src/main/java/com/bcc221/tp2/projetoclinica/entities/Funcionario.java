/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcc221.tp2.projetoclinica.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author paulo
 */
public class Funcionario  extends Usuario implements Serializable{
    
    private Map<RegistroSalario, List<RegistroPonto>> pontoSalario = new HashMap<>();

    public Funcionario() {
    }

    public Map<RegistroSalario, List<RegistroPonto>> getPontoSalario() {
        return pontoSalario;
    }

    public void setPontoSalario(Map<RegistroSalario, List<RegistroPonto>> pontoSalario) {
        this.pontoSalario = pontoSalario;
    }
    
    
    
    
    
}
