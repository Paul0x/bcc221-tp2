package com.bcc221.tp2.projetoclinica.enums;

/**
 * Enum para controlar as permissões
 * @author ufop
 */
public enum Permissoes {

    /**
     * Permissões de um administrador
     */
    ADMINSTRADOR(true,true,true,true,true),

    /**
     * Permissões de um assistente
     */
    ASSISTENTE(true,true,true,false,false),

    /**
     * Permissões de um usuário normal
     */
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

    /**
     *
     * @return
     */
    public boolean isAgendaConsulta() {
        return agendaConsulta;
    }

    /**
     *
     * @param agendaConsulta
     */
    public void setAgendaConsulta(boolean agendaConsulta) {
        this.agendaConsulta = agendaConsulta;
    }

    /**
     *
     * @return
     */
    public boolean isPontoSalario() {
        return pontoSalario;
    }

    /**
     *
     * @param pontoSalario
     */
    public void setPontoSalario(boolean pontoSalario) {
        this.pontoSalario = pontoSalario;
    }

    /**
     *
     * @return
     */
    public boolean isPagamento() {
        return pagamento;
    }

    /**
     *
     * @param pagamento
     */
    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }

    /**
     *
     * @return
     */
    public boolean isRelatorio() {
        return relatorio;
    }

    /**
     *
     * @param relatorio
     */
    public void setRelatorio(boolean relatorio) {
        this.relatorio = relatorio;
    }

    /**
     *
     * @return
     */
    public boolean isUsuarios() {
        return usuarios;
    }

    /**
     *
     * @param usuarios
     */
    public void setUsuarios(boolean usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
