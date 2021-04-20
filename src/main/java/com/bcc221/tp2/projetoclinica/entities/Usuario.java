package com.bcc221.tp2.projetoclinica.entities;

import com.bcc221.tp2.projetoclinica.enums.Permissoes;
import java.io.Serializable;

/**
 * Representação da classe usuário
 * @author paulo
 */
public class Usuario implements Serializable {
    
    /**
     * Enum de permissões e variáveis da classe
     */
    public  Permissoes permissoes = Permissoes.USUARIO;
    private Integer codigo;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String login;

    /**
     * Construtor dvazio
     */
    public Usuario() {
    }
    
    /**
     * Construtor com parâmetros
     * @param codigo
     * @param nome
     * @param cpf
     * @param email
     * @param senha
     * @param login
     */
    public Usuario(Integer codigo, String nome, String cpf, String email, String senha, String login) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.login = login;
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Getter permissões
     * @return
     */
    public Permissoes getPermissoes() {
        return permissoes;
    }

    /**
     * Setter permissões
     * @param permissoes
     */
    public void setPermissoes(Permissoes permissoes) {
        this.permissoes = permissoes;
    }
    
    
    
}
