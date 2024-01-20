package br.com.postech.techchallenge.external.infrastructure.dataBaseEntities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.postech.techchallenge.domain.enums.StatusPedido;

@Entity
@Table(name = "PEDIDO")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    private List<ComboEntity> combos;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @Column(name = "pago", nullable = false)
    private boolean pago;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_cadastro", updatable = false)
    private Date dataCadastro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_alteracao", updatable = true)
    private Date dataAlteracao;

    public PedidoEntity(Long id, Long idCliente, List<ComboEntity> combos, BigDecimal valorTotal, StatusPedido status, boolean pago, Date dataCadastro, Date dataAlteracao) {
        this.id = id;
        this.idCliente = idCliente;
        this.combos = combos;
        this.valorTotal = valorTotal;
        this.status = status;
        this.pago = pago;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
    }

    public PedidoEntity(){
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

    public List<ComboEntity> getCombos() {
        return combos;
    }

    public void setCombos(List<ComboEntity> combos) {
        this.combos = combos;
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

    @PrePersist
    @PreUpdate
    private void calcularValorTotal() {
        if (combos != null) {
            valorTotal = combos.stream()
                    .map(ComboEntity::getValorTotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
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
