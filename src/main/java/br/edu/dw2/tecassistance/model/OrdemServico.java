package br.edu.dw2.tecassistance.model;

import br.edu.dw2.tecassistance.model.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEmissao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFinalizacao;

    @NotNull
    private BigDecimal valor;

    private String observacao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "paymentMethod_id")
    private FormaPagamento formaPagamento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    public OrdemServico(){}

    public OrdemServico(Long id,
                        String descricao,
                        LocalDate dataEmissao,
                        LocalDate dataFinalizacao,
                        BigDecimal valor,
                        String observacao,
                        Cliente cliente,
                        FormaPagamento formaPagamento,
                        StatusEnum status) {
        this.id = id;
        this.descricao = descricao;
        this.dataEmissao = dataEmissao;
        this.dataFinalizacao = dataFinalizacao;
        this.valor = valor;
        this.observacao = observacao;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDate getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDate dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

}
