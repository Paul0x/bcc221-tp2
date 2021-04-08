package com.bcc221.tp2.projetoclinica.services;

import com.bcc221.tp2.projetoclinica.entities.Administrador;
import com.bcc221.tp2.projetoclinica.entities.Especialista;
import com.bcc221.tp2.projetoclinica.entities.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilizada para o carregamento e processamento dos dados do programa,
 * além do armazenamento das informações em memória
 *
 * @author paulo
 */
public class MainService {

    private List<Usuario> usuarios;
    Usuario currentUsuario;

    public MainService() {
        this.initUsuarios();
    }

    private void initUsuarios() {
        this.usuarios = new ArrayList<>();
        Administrador admin = new Administrador();
        admin.setCodigo(1);
        admin.setCpf("121.148.526-95");
        admin.setLogin("admin");
        admin.setEmail("paulof@ufop.edu.br");
        admin.setSenha("admin");
        admin.setNome("Paulo Felipe");
        this.usuarios.add(admin);
        Especialista admin2 = new Especialista();
        admin2.setCodigo(2);
        admin2.setCpf("121.148.526-95");
        admin2.setLogin("admin");
        admin2.setEmail("paulof@ufop.edu.br");
        admin2.setSenha("admin");
        admin2.setNome("João Dentista");
        this.usuarios.add(admin2);
        Especialista admin3 = new Especialista();
        admin3.setCodigo(3);
        admin3.setCpf("121.148.526-95");
        admin3.setLogin("admin");
        admin3.setEmail("paulof@ufop.edu.br");
        admin3.setSenha("admin");
        admin3.setNome("José Odonto");
        this.usuarios.add(admin3);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public boolean login(String login, String senha) {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                this.currentUsuario = usuario;
                return true;
            }
        }
        return false;
    }

    public Usuario getCurrentUsuario() {
        if (this.currentUsuario == null) {
            throw new NullPointerException("Não existe usuário logado.");
        }
        return currentUsuario;
    }

    public void setCurrentUsuario(Usuario currentUsuario) {
        this.currentUsuario = currentUsuario;
    }
    
    public List<Especialista> getEspecialistas() {
        List<Especialista> especialistas = new ArrayList();
        for(Usuario usuario : usuarios) {
            if(usuario.getClass().equals(Especialista.class)) {
                especialistas.add((Especialista) usuario);
            }
        }
        return especialistas;
    }

}
