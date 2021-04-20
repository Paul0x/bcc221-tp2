package com.bcc221.tp2.projetoclinica.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe para representar um funcionário, herdado da classe Usuário
 * @author paulo
 */
public class Funcionario  extends Usuario implements Serializable{
    
    private Map<RegistroSalario, List<RegistroPonto>> pontoSalario = new HashMap<>();

    /**
     * Construtor vazio funcionário
     */
    public Funcionario() {
    }

    /**
     * Retorna map dos pontos e salários
     * @return
     */
    public Map<RegistroSalario, List<RegistroPonto>> getPontoSalario() {
        return pontoSalario;
    }

    /**
     * Setter dos pontos e salários
     * @param pontoSalario
     */
    public void setPontoSalario(Map<RegistroSalario, List<RegistroPonto>> pontoSalario) {
        this.pontoSalario = pontoSalario;
    }
    
    
    
    
    
}
