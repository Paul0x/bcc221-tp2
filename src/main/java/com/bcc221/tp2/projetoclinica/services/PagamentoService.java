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
public class PagamentoService {

    private List<RegistroPagamento> pagamentos = new ArrayList<>();
    private Boolean isEdicao = false;
    private Integer indexEdicao;

    public PagamentoService() {
        initPagamentos();
    }

    private void initPagamentos() {
        FileService fileService = new FileService();
        try {
            this.setPagamentos(fileService.readPagamentosFile());
        } catch (Exception ex) {
            this.pagamentos = new ArrayList<>();
        }
    }

    public void addPagamento(String descricao, String tipo, LocalDate dtPagamento, LocalDate dtVencimento, Double valorDouble) throws Exception {

        if (descricao.trim().equals("")) {
            throw new Exception("É necessário inserir a descrição.");
        }
        if (dtPagamento == null) {
            throw new Exception("Data de pagamento inválida.");
        }
        if (dtPagamento == null) {
            throw new Exception("Data de vencimento inválida.");
        }
        if (tipo == null) {
            throw new Exception("Tipo inválido.");
        }
        
        RegistroPagamento pagamento = new RegistroPagamento();
        pagamento.setDescricao(descricao);
        pagamento.setTipo(tipo);
        pagamento.setDataPagamento(dtPagamento);
        pagamento.setDataVencimento(dtVencimento);
        BigDecimal valor;
        try {
            valor = new BigDecimal(valorDouble);
        } catch (NumberFormatException ex) {
            throw new Exception("Insira um número válido para o valor.");
        }
        valor = valor.setScale(2, ROUND_HALF_EVEN);
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("Não é possível inserir um valor de consulta menor que zero.");
        }
        pagamento.setValor(valor);
        if (this.getIsEdicao() == false) {
            pagamentos.add(pagamento);
        } else {
            pagamentos.set(this.getIndexEdicao(), pagamento);
        }
    }

    public List<RegistroPagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<RegistroPagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public Boolean getIsEdicao() {
        return isEdicao;
    }

    public void setIsEdicao(Boolean isEdicao) {
        this.isEdicao = isEdicao;
    }

    public Integer getIndexEdicao() {
        return indexEdicao;
    }

    public void setIndexEdicao(Integer indexEdicao) {
        this.indexEdicao = indexEdicao;
    }

}
