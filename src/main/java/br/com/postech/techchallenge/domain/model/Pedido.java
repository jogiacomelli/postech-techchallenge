package br.com.postech.techchallenge.domain.model;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.postech.techchallenge.domain.enums.StatusPedido;

public class Pedido {
    private Long id;
    private Long idCliente;
    private List<Combo> combos;
    private BigDecimal valorTotal;
    private StatusPedido status;
    private boolean pago = false;
    private Date dataCadastro;
    private Date dataAlteracao;
    public Pedido(Long id, Long idCliente, List<Combo> combos, BigDecimal valorTotal, StatusPedido status, boolean pago, Date dataCadastro, Date dataAlteracao) {
        this.id = id;
        this.idCliente = idCliente;
        this.combos = combos;
        this.valorTotal = valorTotal;
        this.status = status;
        this.pago = pago;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
    }

    public Pedido() {
    }

    private BigDecimal calcularValorTotal() {
        return combos.stream()
                .map(Combo::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<Combo> getCombos() {
        return combos;
    }

    public void setCombos(List<Combo> combos) {
        this.combos = combos;
        this.valorTotal = calcularValorTotal();
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }



}
