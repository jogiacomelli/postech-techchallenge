package br.com.postech.techchallenge.domain.model;


import java.math.BigDecimal;

public class Combo {
    private Long id;
    private Produto lanche;
    private Produto acompanhamento;
    private Produto bebida;
    private Produto sobremesa;
    private Integer quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;

    public Combo(Long id, Produto lanche, Produto acompanhamento, Produto bebida, Produto sobremesa,
                 Integer quantidade) {
        this.id = id;
        this.lanche = lanche;
        this.acompanhamento = acompanhamento;
        this.bebida = bebida;
        this.sobremesa = sobremesa;
        this.quantidade = quantidade;
        this.valorUnitario = calcularValorUnitario();
        this.valorTotal = this.valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    public Combo() {
    }

    private BigDecimal calcularValorUnitario() {
        BigDecimal valorLanche = (lanche != null) ? lanche.getPreco() : BigDecimal.ZERO;
        BigDecimal valorAcompanhamento = (acompanhamento != null) ? acompanhamento.getPreco() : BigDecimal.ZERO;
        BigDecimal valorBebida = (bebida != null) ? bebida.getPreco() : BigDecimal.ZERO;
        BigDecimal valorSobremesa = (sobremesa != null) ? sobremesa.getPreco() : BigDecimal.ZERO;

        return valorLanche.add(valorAcompanhamento).add(valorBebida).add(valorSobremesa);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getLanche() {
        return lanche;
    }

    public void setLanche(Produto lanche) {
        this.lanche = lanche;
    }

    public Produto getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(Produto acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public Produto getBebida() {
        return bebida;
    }

    public void setBebida(Produto bebida) {
        this.bebida = bebida;
    }

    public Produto getSobremesa() {
        return sobremesa;
    }

    public void setSobremesa(Produto sobremesa) {
        this.sobremesa = sobremesa;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        this.valorUnitario = calcularValorUnitario();
        this.valorTotal = this.valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

}
