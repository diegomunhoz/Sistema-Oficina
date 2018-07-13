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
@Table(name = "itemorcamentovenda")
@NamedQueries({
    @NamedQuery(name = "Itemorcamentovenda.findAll", query = "SELECT i FROM Itemorcamentovenda i"),
    @NamedQuery(name = "Itemorcamentovenda.buscarPorOrcamentoVenda", query = "SELECT i FROM Itemorcamentovenda i WHERE i.orcamentovenda = :orcamentovenda")})
public class Itemorcamentovenda implements Serializable {

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
    @JoinColumn(name = "produtoServico", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Produtoservico produtoservico;
    @JoinColumn(name = "orcamentoVenda", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Orcamentovenda orcamentovenda;
    @JoinColumn(name = "veiculo", referencedColumnName = "codigo")
    @ManyToOne
    private Veiculo veiculo;

    public Itemorcamentovenda() {
    }

    public Itemorcamentovenda(Integer codigo) {
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

    public Produtoservico getProdutoservico() {
        return produtoservico;
    }

    public void setProdutoservico(Produtoservico produtoservico) {
        this.produtoservico = produtoservico;
    }

    public Orcamentovenda getOrcamentovenda() {
        return orcamentovenda;
    }

    public void setOrcamentovenda(Orcamentovenda orcamentovenda) {
        this.orcamentovenda = orcamentovenda;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Itemorcamentovenda)) {
            return false;
        }
        Itemorcamentovenda other = (Itemorcamentovenda) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Itemorcamentovenda[codigo=" + codigo + "]";
    }
}