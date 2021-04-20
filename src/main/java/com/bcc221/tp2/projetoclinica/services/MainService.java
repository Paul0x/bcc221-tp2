package com.bcc221.tp2.projetoclinica.services;

import com.bcc221.tp2.projetoclinica.entities.Administrador;
import com.bcc221.tp2.projetoclinica.entities.AssistenteAdministrativo;
import com.bcc221.tp2.projetoclinica.entities.Especialista;
import com.bcc221.tp2.projetoclinica.entities.Funcionario;
import com.bcc221.tp2.projetoclinica.entities.RegistroPonto;
import com.bcc221.tp2.projetoclinica.entities.RegistroSalario;
import com.bcc221.tp2.projetoclinica.entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.management.BadAttributeValueExpException;

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

        try {
            FileService fileService = new FileService();
            this.setUsuarios(fileService.readUsuariosFile());
        } catch (Exception ex) {
            this.usuarios = new ArrayList<>();
            Administrador admin = new Administrador();
            admin.setCodigo(1);
            admin.setCpf("121.148.526-95");
            admin.setLogin("admin");
            admin.setEmail("paulof@ufop.edu.br");
            admin.setSenha("admin");
            admin.setNome("Paulo Felipe (f)");
            this.usuarios.add(admin);
            Especialista admin2 = new Especialista();
            admin2.setCodigo(2);
            admin2.setCpf("121.148.526-94");
            admin2.setLogin("ad4min");
            admin2.setEmail("paulof@ufop.edu.br");
            admin2.setSenha("admi3n");
            admin2.setNome("João Dentista");
            this.usuarios.add(admin2);
            Especialista admin3 = new Especialista();
            admin3.setCodigo(3);
            admin3.setCpf("121.148.526-92");
            admin3.setLogin("ad2min");
            admin3.setEmail("paulof@ufop.edu.br");
            admin3.setSenha("ad2min");
            admin3.setNome("José Odonto");

            /*
         * Cria registro de ponto para o funcionario 3
             */
            RegistroPonto pto = new RegistroPonto();
            pto.setDia(2);
            pto.setObservacao("asd123");
            List<RegistroPonto> lP = new ArrayList<>();
            lP.add(pto);
            admin3.getPontoSalario().put(new RegistroSalario(2021, 4), lP);
            this.usuarios.add(admin3);
        }
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
        usuarios.stream().filter(usuario -> (usuario.getClass().equals(Especialista.class))).forEachOrdered(usuario -> {
            especialistas.add((Especialista) usuario);
        });
        return especialistas;
    }

    public List<Funcionario> getFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList();
        usuarios.stream().filter(usuario -> (Funcionario.class.isAssignableFrom(usuario.getClass()))).forEachOrdered(usuario -> {
            funcionarios.add((Funcionario) usuario);
        });
        return funcionarios;
    }

    public void addUsuario(String nome, String email, String cpf, String login, String senha, Integer tipo) throws Exception {
        Usuario usuario;
        switch (tipo) {
            case 0:
                usuario = new Especialista();
                break;
            case 1:
                usuario = new AssistenteAdministrativo();
                break;
            case 2:
                usuario = new Administrador();
                break;
            default:
                usuario = new Usuario();
                break;
        }

        usuario.setCodigo(this.usuarios.size() + 1);
        usuario.setCpf(cpf);
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setLogin(login);
        this.validateUsuario(usuario);
        this.usuarios.add(usuario);

    }

    public void removeUsuario(Integer index) throws Exception {
        if (this.usuarios.get(index).getCpf().equals(this.currentUsuario.getCpf())) {
            throw new Exception("Você não pode remover o usuário logado.");
        }

        this.usuarios.remove(index.intValue());

    }

    private void validateUsuario(Usuario usuario) throws Exception {
        if (usuario.getCpf().trim().equals("") || usuario.getCpf().length() != 14) {
            throw new Exception("Usuário inválido.");
        }
        if (usuario.getEmail().trim().equals("")) {
            throw new Exception("Preencha o campo EMAIL.");
        }
        if (usuario.getNome().trim().equals("")) {
            throw new Exception("Preencha o campo NOME.");
        }
        if (usuario.getSenha().trim().equals("") || usuario.getSenha().length() < 4) {
            throw new Exception("Preencha o campo SENHA com no mínimo 4 digitos.");
        }
        if (usuario.getLogin().trim().equals("")) {
            throw new Exception("Preencha o campo LOGIN.");
        }

        // Valida duplicidade de CPF
        if (this.usuarios.stream().anyMatch(us -> us.getCpf().equals(usuario.getCpf()))) {
            throw new Exception("CPF já está cadastrado.");
        }

        /// Valida duplicidade de LOGIN
        if (this.usuarios.stream().anyMatch(us -> us.getLogin().equals(usuario.getLogin()))) {
            throw new Exception("Login já está cadastrado.");
        }

    }

}
