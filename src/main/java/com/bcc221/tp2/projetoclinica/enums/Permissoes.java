/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcc221.tp2.projetoclinica.enums;

/**
 *
 * @author ufop
 */
public enum Permissoes {
    ADMINSTRADOR(true,true,true,true,true),
    ASSISTENTE(true,true,true,false,false),
    USUARIO(true,false,false,false,false);
    
    private boolean agendaConsulta;
    private boolean pontoSalario;
    private boolean pagamento;
    private boolean relatorio;
    private boolean usuarios;

    private Permissoes(boolean agendaConsulta, boolean pontoSalario, boolean pagamento, boolean relatorio, boolean usuarios) {
        this.agendaConsulta = agendaConsulta;
        this.pontoSalario = pontoSalario;
        this.pagamento = pagamento;
        this.relatorio = relatorio;
        this.usuarios = usuarios;        
    }

    public boolean isAgendaConsulta() {
        return agendaConsulta;
    }

    public void setAgendaConsulta(boolean agendaConsulta) {
        this.agendaConsulta = agendaConsulta;
    }

    public boolean isPontoSalario() {
        return pontoSalario;
    }

    public void setPontoSalario(boolean pontoSalario) {
        this.pontoSalario = pontoSalario;
    }

    public boolean isPagamento() {
        return pagamento;
    }

    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }

    public boolean isRelatorio() {
        return relatorio;
    }

    public void setRelatorio(boolean relatorio) {
        this.relatorio = relatorio;
    }

    public boolean isUsuarios() {
        return usuarios;
    }

    public void setUsuarios(boolean usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
