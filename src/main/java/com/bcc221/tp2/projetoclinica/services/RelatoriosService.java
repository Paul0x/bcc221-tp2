/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcc221.tp2.projetoclinica.services;

import com.bcc221.tp2.projetoclinica.entities.Especialista;
import com.bcc221.tp2.projetoclinica.entities.Funcionario;
import com.bcc221.tp2.projetoclinica.entities.RegistroConsulta;
import com.bcc221.tp2.projetoclinica.entities.RegistroPagamento;
import com.bcc221.tp2.projetoclinica.entities.RegistroSalario;
import com.bcc221.tp2.projetoclinica.entities.Usuario;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author paulo
 */
public class RelatoriosService {

    public List<String[]> gerarRelatorioPagamento(List<RegistroPagamento> pagamentosFull, LocalDate dtInicio, LocalDate dtFim) {
        List<String[]> pagamentos = new ArrayList<>();
        
        pagamentosFull.stream().filter(pagamento -> (pagamento.getDataPagamento().isAfter(dtInicio) && pagamento.getDataPagamento().isBefore(dtFim))).forEachOrdered(pagamento -> {
            String[] arr = {pagamento.getDataPagamento().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")), pagamento.getDescricao(), "R$ " + pagamento.getValor().toString(), pagamento.getTipo()};
            pagamentos.add(arr);
        });

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
        pagamentos.sort(Comparator.comparing(str -> LocalDate.parse(str[0], formatter)));
        return pagamentos;

    }

    public List<String[]> gerarRelatorioConsultas(List<Especialista> especialistas, LocalDate dtInicio, LocalDate dtFim) {
        List<String[]> consultas = new ArrayList<>();

        especialistas.forEach(esp -> {
            for (RegistroConsulta consulta : esp.getConsultas()) {
                if (consulta.getData().isAfter(dtInicio) && consulta.getData().isBefore(dtFim)) {
                    String[] arr = {consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")), consulta.getCliente(), "R$ " + consulta.getValor().toString(), esp.getNome()};
                    consultas.add(arr);
                }
            }
        });
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
        consultas.sort(Comparator.comparing(str -> LocalDate.parse(str[0], formatter)));

        return consultas;

    }

    public List<String[]> gerarRelatorioSalarios(List<Funcionario> funcionarios, LocalDate dtInicio, LocalDate dtFim) {
        List<String[]> salarios = new ArrayList<>();

        funcionarios.forEach(func -> {
            for (RegistroSalario salario : func.getPontoSalario().keySet()) {
                if (LocalDate.of(salario.getAno(), salario.getMes(), 1).isAfter(dtInicio) && LocalDate.of(salario.getAno(), salario.getMes(), 1).isBefore(dtFim)) {
                    if (salario.getValor() != null) {
                        String[] arr = {salario.getMes() + "/" + salario.getAno(), func.getNome(), "R$" + salario.getValor().toString()};
                        salarios.add(arr);
                    }
                }
            }
        });
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/yyyy");
        salarios.sort(Comparator.comparing(str -> YearMonth.parse(str[0], formatter)));

        return salarios;

    }

}
