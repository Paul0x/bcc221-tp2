/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcc221.tp2.projetoclinica.services;

import com.bcc221.tp2.projetoclinica.entities.Especialista;
import com.bcc221.tp2.projetoclinica.entities.Funcionario;
import com.bcc221.tp2.projetoclinica.entities.RegistroAgenda;
import com.bcc221.tp2.projetoclinica.entities.RegistroConsulta;
import com.bcc221.tp2.projetoclinica.entities.RegistroPagamento;
import com.bcc221.tp2.projetoclinica.entities.RegistroPonto;
import com.bcc221.tp2.projetoclinica.entities.RegistroSalario;
import java.io.Serializable;
import java.math.BigDecimal;
import static java.math.BigDecimal.ROUND_HALF_EVEN;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javax.swing.table.TableModel;
import org.apache.commons.lang.SerializationUtils;

/**
 *
 * @author paulo
 */
public class PontoSalarioService {

    private Funcionario currentFuncionario = null;
    private List<Funcionario> funcionarios;
    private Integer currentMes = null;
    private Integer currentAno = null;

    public PontoSalarioService() {
    }

    public Funcionario getCurrentFuncionario() {
        return currentFuncionario;
    }

    public void setCurrentFuncionario(Funcionario currentFuncionario) {
        this.currentFuncionario = currentFuncionario;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Integer getCurrentMes() {
        return currentMes;
    }

    public void setCurrentMes(Integer currentMes) {
        this.currentMes = currentMes;
    }

    public Integer getCurrentAno() {
        return currentAno;
    }

    public void setCurrentAno(Integer currentAno) {
        this.currentAno = currentAno;
    }
    
    public List<String> getCurrentObservacoesPonto(Integer numDias) {
        if(this.currentAno == null || this.currentMes == null || this.currentFuncionario == null) {
            throw new NullPointerException("Dados inválidos para buscar folha de ponto.");
        }
        
        RegistroSalario salario = new RegistroSalario(this.currentAno, this.currentMes);
        List<String> observacoes = Arrays.asList(new String[numDias]);
        if(this.currentFuncionario.getPontoSalario().containsKey(salario)) {
            List<RegistroPonto> folha = this.currentFuncionario.getPontoSalario().get(salario);
            for(RegistroPonto ponto : folha) {
                observacoes.set(ponto.getDia()-1, ponto.getObservacao());
            }
            
        }
        
        return observacoes;
    }
    
    public void addPagamento(Double valor, LocalDate dtPagamento, String observacao) throws Exception{
        if(this.currentFuncionario == null) {
            throw new NullPointerException("Dados inválidos para adicionar pagamento.");
        }
        if(this.currentAno == null || this.currentMes == null) {
            throw new NullPointerException("Selecione um mês/ano para adicionar o pagamento.");
        }
        
        if(valor <= 0) {
            throw new Exception("O valor de pagamento deve ser maior que zero.");
        }
        
        if(dtPagamento == null) {
            throw new Exception("Data de pagamento inválida.");
        }
        
        
        
        RegistroSalario salario = new RegistroSalario(this.currentAno, this.currentMes);
        List<RegistroPonto> folha;
        if(this.currentFuncionario.getPontoSalario().containsKey(salario)) {
            folha = (List<RegistroPonto>) SerializationUtils.clone((Serializable) this.currentFuncionario.getPontoSalario().get(salario));
            this.currentFuncionario.getPontoSalario().remove(salario);
        } else {
            folha = new ArrayList<>();
        }
        salario.setObservacao(observacao);
        salario.setValor(new BigDecimal(valor));
        salario.setDtPagamento(dtPagamento);
        this.currentFuncionario.getPontoSalario().put(salario, folha);        
        
    }
    
    public List<RegistroSalario> getCurrentSalarioList() {
        if(this.currentFuncionario == null) {
            throw new NullPointerException("Dados inválidos para buscar folha de ponto.");
        }       
        
        return new ArrayList<>(this.currentFuncionario.getPontoSalario().keySet());
    }
    
    public void updateFolhaPonto(TableModel modelo) {
        int rowCount = modelo.getRowCount();
        if(this.currentFuncionario == null) {
            throw new NullPointerException("Dados inválidos para atualizar a folha de ponto.");
        }
        if(this.currentAno == null || this.currentMes == null) {
            throw new NullPointerException("Selecione um mês/ano para atualizar a folha de ponto.");
        }
        RegistroSalario salario = new RegistroSalario(this.currentAno, this.currentMes);
        
        List<RegistroPonto> folhaPonto = new ArrayList<>();
        for(int i = 0; i < rowCount; i++) {
            RegistroPonto reg = new RegistroPonto();
            reg.setDia(i+1);
            String observacao = (String) modelo.getValueAt(i, 1);
            reg.setObservacao(observacao);
            folhaPonto.add(reg);
        }
        
        // Verifica se já existe registro do salário com mês/ano, caso não exista, cria um novo registro
        if(!this.currentFuncionario.getPontoSalario().containsKey(salario)) {
            this.currentFuncionario.getPontoSalario().put(salario, folhaPonto);
        } else {
            this.currentFuncionario.getPontoSalario().replace(salario, folhaPonto);
        }
        
    }
    
    
    
    
}
