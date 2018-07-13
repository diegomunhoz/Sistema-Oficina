package entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.eclipse.persistence.annotations.PrivateOwned;

@Entity
@Table(name = "compra")
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByNomeFornecedor", query = "SELECT c FROM Compra c WHERE lower (c.fornecedor.nome)  like :nome ORDER BY c.data"),
    @NamedQuery(name = "Compra.findByCodigo", query = "SELECT c FROM Compra c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Compra.findByData", query = "SELECT c FROM Compra c WHERE c.tipoCadastro = 'Compra a Prazo' AND (:dataIni <= c.data AND :dataFim >= c.data) AND c.fornecedor = :fornecedor")})
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "tipoCadastro")
    private String tipoCadastro;
    @Basic(optional = false)
    @Column(name = "valorTotal")
    private double valorTotal;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "dataVencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Basic(optional = false)
    @Column(name = "situacao")
    private String situacao;
    @JoinColumn(name = "fornecedor", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Fornecedor fornecedor;
    @PrivateOwned
    @OneToMany(mappedBy = "compra")
    private List<Itemcompra> itemcompraList;

    public Compra() {
    }

    public String getTipoCadastro() {
        return tipoCadastro;
    }

    public void setTipoCadastro(String tipoCadastro) {
        this.tipoCadastro = tipoCadastro;
    }

    public List<Itemcompra> getItemcompraList() {
        return itemcompraList;
    }

    public void setItemcompraList(List<Itemcompra> itemcompraList) {
        this.itemcompraList = itemcompraList;
    }

    public Compra(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Compra[codigo=" + codigo + "]";
    }
}