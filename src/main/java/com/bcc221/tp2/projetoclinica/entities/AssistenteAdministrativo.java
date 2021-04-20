/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcc221.tp2.projetoclinica.entities;

import com.bcc221.tp2.projetoclinica.enums.Permissoes;

/**
 *
 * @author paulo
 */
public class AssistenteAdministrativo extends Usuario {

    public Permissoes permissoes = Permissoes.ASSISTENTE;

    @Override
    public Permissoes getPermissoes() {
        return permissoes;
    }

    @Override
    public void setPermissoes(Permissoes permissoes) {
        this.permissoes = permissoes;
    }

    
    
}
