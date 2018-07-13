package entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "itemcompra")
@NamedQueries({
    @NamedQuery(name = "Itemcompra.findAll", query = "SELECT i FROM Itemcompra i"),
    @NamedQuery(name = "Itemcompra.findByCodigo", query = "SELECT i FROM Itemcompra i WHERE i.codigo = :codigo"),
    @NamedQuery(name = "Itemcompra.buscarPorCompra", query = "SELECT i FROM Itemcompra i WHERE i.compra = :compra")})
public class Itemcompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "qtde")
    private int qtde;
    @Basic(optional = false)
    @Column(name = "valorTotal")
    private double valorTotal;
    @JoinColumn(name = "compra", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Compra compra;
    @JoinColumn(name = "produtoServico", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Produtoservico produtoservico;

    public Itemcompra() {
    }

    public Itemcompra(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Produtoservico getProdutoservico() {
        return produtoservico;
    }

    public void setProdutoservico(Produtoservico produtoservico) {
        this.produtoservico = produtoservico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Itemcompra)) {
            return false;
        }
        Itemcompra other = (Itemcompra) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Itemcompra[codigo=" + codigo + "]";
    }

}