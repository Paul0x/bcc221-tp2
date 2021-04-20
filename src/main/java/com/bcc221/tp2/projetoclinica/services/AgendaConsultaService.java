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
import java.util.Comparator;
import java.util.List;

/**
 * Serviço contendo as regras de negócios relácionadas a agenda e pagamento de consultas.
 * @author paulo
 */
public class AgendaConsultaService {

    private Especialista currentEspecialista = null;
    private List<Especialista> especialistas;
    private Boolean isEdicaoAgenda = false;
    private Boolean isEdicaoConsulta = false;
    private Integer indexEdicaoAgenda;
    private Integer indexEdicaoConsulta;

    /**
     * Construtor
     */
    public AgendaConsultaService() {
    }

    /**
     * Getter do especialista atual
     * @return
     */
    public Especialista getCurrentEspecialista() {
        return currentEspecialista;
    }

    /**
     * Setter do especialista atual
     * @param currentEspecialista
     */
    public void setCurrentEspecialista(Especialista currentEspecialista) {
        this.currentEspecialista = currentEspecialista;
    }

    /**
     * Retorna lista de especialistas
     * @return
     */
    public List<Especialista> getEspecialistas() {
        return especialistas;
    }

    /**
     * Atribui lista de especialistas
     * @param especialistas
     */
    public void setEspecialistas(List<Especialista> especialistas) {
        this.especialistas = especialistas;
    }

    /**
     * Retorna se a agenda está em modo de edição
     * @return
     */
    public Boolean getIsEdicaoAgenda() {
        return isEdicaoAgenda;
    }

    /**
     * Indica se a agenda está em modo de edição
     * @param isEdicaoAgenda
     */
    public void setIsEdicaoAgenda(Boolean isEdicaoAgenda) {
        this.isEdicaoAgenda = isEdicaoAgenda;
    }

    /**
     * Retorna se a consulta está em modo de edição
     * @return
     */
    public Boolean getIsEdicaoConsulta() {
        return isEdicaoConsulta;
    }

    /**
     * Indica se a consulta está em modo de edição
     * @param isEdicaoConsulta
     */
    public void setIsEdicaoConsulta(Boolean isEdicaoConsulta) {
        this.isEdicaoConsulta = isEdicaoConsulta;
    }

    /**
     * Retorna o índice que está sendo editado na agenda
     * @return
     */
    public Integer getIndexEdicaoAgenda() {
        return indexEdicaoAgenda;
    }

    /**
     * Atribui o índice para ser editado na agenda
     * @param indexEdicaoAgenda
     */
    public void setIndexEdicaoAgenda(Integer indexEdicaoAgenda) {
        this.indexEdicaoAgenda = indexEdicaoAgenda;
    }

    /**
     * Retorna o índice que está sendo editado na consulta
     * @return
     */
    public Integer getIndexEdicaoConsulta() {
        return indexEdicaoConsulta;
    }

    /**
     * Atribui o índice que está sendo editado na consulta
     * @param indexEdicaoConsulta
     */
    public void setIndexEdicaoConsulta(Integer indexEdicaoConsulta) {
        this.indexEdicaoConsulta = indexEdicaoConsulta;
    }

    /**
     * Adiciona um novo rregistro na agenda
     * @param data
     * @param hora
     * @param cliente
     * @param descricao
     * @throws Exception
     */
    public void addRegistroAgenda(LocalDate data, LocalTime hora, String cliente, String descricao) throws Exception {
        // Validações 
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

        // Gera novo objeto e atribui os campos
        RegistroAgenda registro = new RegistroAgenda();
        registro.setCodigo(this.getCurrentEspecialista().getAgenda().size() + 1);
        registro.setData(data);
        registro.setHora(hora);
        registro.setDescricao(cliente + " - " + descricao);

        // Verifica se está criando um novo registro ou editando
        if (!this.getIsEdicaoAgenda()) {
            this.currentEspecialista.getAgenda().add(registro);
        } else {
            this.currentEspecialista.getAgenda().set(this.indexEdicaoAgenda, registro);
        }
        
        // Ordena a agenda baseado no tempo
        this.currentEspecialista.getAgenda().sort(Comparator.comparing(RegistroAgenda::getDateTime));

    }

    /**
     * Verifica se já existe registro da agenda na mesma hora
     * OBS: Caso seja no modo de edição, verifica se o ítem na mesma hora não é o ítem editado
     * @param data
     * @param hora
     * @return
     */
    public Boolean validaDataAgenda(LocalDate data, LocalTime hora) {
        LocalDateTime dtTime = LocalDateTime.of(data, hora);
        return this.currentEspecialista.getAgenda().stream().anyMatch(
                r -> r.getDateTime().equals(dtTime) 
                        && (this.getIsEdicaoAgenda() == false || !r.getDateTime().equals(this.currentEspecialista.getAgenda().get(this.getIndexEdicaoAgenda()).getDateTime())
                                ));
    }

    /**
     * Adiciona novo registro de consulta
     * @param cliente
     * @param valorDouble
     * @throws Exception
     */
    public void addRegistroConsulta(String cliente, Double valorDouble) throws Exception {
        BigDecimal valor;
        
        // Validações
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

        // Altera escala do valor
        valor = valor.setScale(2, ROUND_HALF_EVEN);
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("Não é possível inserir um valor de consulta menor que zero.");
        }

        // Gera novo registro de consulta
        RegistroConsulta registro = new RegistroConsulta();
        registro.setCodigo(this.getCurrentEspecialista().getConsultas().size() + 1);
        registro.setCliente(cliente);
        registro.setData(LocalDate.now());
        registro.setValor(valor);

        // Verifica se está adicionando novo registro ou editando
        if (!this.getIsEdicaoConsulta()) {
            this.currentEspecialista.getConsultas().add(registro);
        } else {
            this.currentEspecialista.getConsultas().set(this.getIndexEdicaoConsulta(), registro);
        }
    }

}
