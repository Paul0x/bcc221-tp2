/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcc221.tp2.projetoclinica.services;

import com.bcc221.tp2.projetoclinica.entities.Especialista;
import com.bcc221.tp2.projetoclinica.entities.RegistroAgenda;
import com.bcc221.tp2.projetoclinica.entities.RegistroConsulta;
import java.math.BigDecimal;
import static java.math.BigDecimal.ROUND_HALF_EVEN;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author paulo
 */
public class AgendaConsultaService {

    private Especialista currentEspecialista = null;
    private List<Especialista> especialistas;

    public AgendaConsultaService() {
    }

    public Especialista getCurrentEspecialista() {
        return currentEspecialista;
    }

    public void setCurrentEspecialista(Especialista currentEspecialista) {
        this.currentEspecialista = currentEspecialista;
    }

    public List<Especialista> getEspecialistas() {
        return especialistas;
    }

    public void setEspecialistas(List<Especialista> especialistas) {
        this.especialistas = especialistas;
    }

    public void addRegistroAgenda(LocalDate data, LocalTime hora, String cliente, String descricao) throws Exception {
        if (this.getCurrentEspecialista() == null) {
            throw new NullPointerException("Especialista não selecionado.");
        }

        if (hora == null || data == null) {
            throw new Exception("Insira uma data e hora válidos.");
        }
        if (cliente.trim().equals("")) {
            throw new Exception("O campo cliente é obrigatório.");
        }

        if (validaDataAgenda(data, hora)) {
            throw new Exception("Já existe um registro na agenda para este horário.");
        }

        RegistroAgenda registro = new RegistroAgenda();
        registro.setCodigo(this.getCurrentEspecialista().getAgenda().size() + 1);
        registro.setData(data);
        registro.setHora(hora);
        registro.setDescricao(cliente + " - " + descricao);

        // TODO: Ordenar agenda por data
        this.currentEspecialista.getAgenda().add(registro);

    }

    public Boolean validaDataAgenda(LocalDate data, LocalTime hora) {
        LocalDateTime dtTime = LocalDateTime.of(data, hora);
        return this.currentEspecialista.getAgenda().stream().anyMatch(
                r -> LocalDateTime.of(r.getData(), r.getHora()).equals(dtTime)
        );
    }

    public void addRegistroConsulta(String cliente, Double valorDouble) throws Exception {
        BigDecimal valor;
        if (this.getCurrentEspecialista() == null) {
            throw new NullPointerException("Especialista não selecionado.");
        }

        if (cliente.trim().equals("")) {
            throw new Exception("O campo cliente é obrigatório.");
        }
        
        try {
            valor = new BigDecimal(valorDouble);
        } catch (NumberFormatException ex) {
            throw new Exception("Insira um número válido para o valor.");
        }
        
        valor = valor.setScale(2, ROUND_HALF_EVEN);        
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("Não é possível inserir um valor de consulta menor que zero.");
        }

        RegistroConsulta registro = new RegistroConsulta();
        registro.setCodigo(this.getCurrentEspecialista().getConsultas().size() + 1);
        registro.setCliente(cliente);
        registro.setData(LocalDate.now());
        registro.setValor(valor);

        // TODO: Ordenar agenda por data
        this.currentEspecialista.getConsultas().add(registro);

    }

}
