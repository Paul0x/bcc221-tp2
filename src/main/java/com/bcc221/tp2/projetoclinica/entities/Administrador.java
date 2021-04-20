package com.bcc221.tp2.projetoclinica.entities;

import com.bcc221.tp2.projetoclinica.enums.Permissoes;

/**
 * Classe para representar um administrador do sistema.
 * @author paulo
 */
public class Administrador extends Usuario{
    
    // ENUM de permissões
    private Permissoes permissoes = Permissoes.ADMINSTRADOR;

    @Override
    /**
     * Getter de permissões
     */
    public Permissoes getPermissoes() {
        return permissoes;
    }

    /**
     * Setter de permissões
     * @param permissoes 
     */
    @Override
    public void setPermissoes(Permissoes permissoes) {
        this.permissoes = permissoes;
    }
    
    
}
