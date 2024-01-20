package br.com.postech.techchallenge.external.infrastructure.dataBaseEntities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAGAMENTO")
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "de_id_cobranca")
    private String idCobranca;

    @Column(name = "de_idtx")
    private String idtx;

    @Column(name = "id_pedido")
    private Long idPedido;

    public PagamentoEntity(){}

    public PagamentoEntity(Long id, String idCobranca, String idtx, Long idPedido) {
        this.id = id;
        this.idCobranca = idCobranca;
        this.idtx = idtx;
        this.idPedido = idPedido;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIdCobranca() {
        return idCobranca;
    }
    public void setIdCobranca(String idCobranca) {
        this.idCobranca = idCobranca;
    }
    public String getIdtx() {
        return idtx;
    }
    public void setIdtx(String idtx) {
        this.idtx = idtx;
    }
    public Long getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }


}
