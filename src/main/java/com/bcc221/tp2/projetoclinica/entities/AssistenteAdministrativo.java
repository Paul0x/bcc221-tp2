package com.bcc221.tp2.projetoclinica.entities;

import com.bcc221.tp2.projetoclinica.enums.Permissoes;

/**
 * Classe para representar um assistente administrativo
 * @author paulo
 */
public class AssistenteAdministrativo extends Usuario {

    /**
     * Permissões
     */
    public Permissoes permissoes = Permissoes.ASSISTENTE;

    /**
     * Getter de permissões
     * @return 
     */
    @Override
    public Permissoes getPermissoes() {
        return permissoes;
    }

    /**
     * Setter permissões
     * @param permissoes
     */
    @Override
    public void setPermissoes(Permissoes permissoes) {
        this.permissoes = permissoes;
    }

    
    
}
