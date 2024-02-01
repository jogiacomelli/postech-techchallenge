package br.com.postech.techchallenge.core.domain.entity;


public class Pagamento {
    private Long id;
    private String idCobranca;
    private String idtx;
    private Long idPedido;
    public Pagamento(Long id, String idCobranca, String idtx, Long idPedido) {
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
