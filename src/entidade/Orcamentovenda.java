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
@Table(name = "orcamentovenda")
@NamedQueries({
    @NamedQuery(name = "Orcamentovenda.findByNomeCliente", query = "SELECT o FROM Orcamentovenda o WHERE lower (o.cliente.nome)  like :nome ORDER BY o.data"),
    @NamedQuery(name = "Orcamentovenda.findByCodigo", query = "SELECT o FROM Orcamentovenda o WHERE o.codigo = :codigo"),
    @NamedQuery(name = "Orcamentovenda.findByData", query = "SELECT o FROM Orcamentovenda o WHERE o.tipoCadastro = 'Venda a Prazo' AND (:dataIni <= o.data AND :dataFim >= o.data) AND o.cliente = :cliente"),
    @NamedQuery(name = "Orcamentovenda.verificaDebitoCliente", query = "SELECT o FROM Orcamentovenda o WHERE o.cliente = :cliente AND o.dataVencimento < :dataHoje AND o.situacao = 'Não Paga'")})
public class Orcamentovenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "tipoCadastro")
    private String tipoCadastro;
    @Column(name = "situacao")
    private String situacao;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "dataVencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Basic(optional = false)
    @Column(name = "desconto")
    private Double desconto;
    @Basic(optional = false)
    @Column(name = "valorTotal")
    private Double valorTotal;
    @Column(name = "valorReceber")
    private Double valorReceber;
    @JoinColumn(name = "cliente", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Cliente cliente;
    @PrivateOwned
    @OneToMany(mappedBy = "orcamentovenda")
    private List<Itemorcamentovenda> itemorcamentovendaList;
    @OneToMany(mappedBy = "orcamentovenda")
    private List<Recebimento> recebimentoList;

    public Orcamentovenda() {
    }

    public List<Recebimento> getRecebimentoList() {
        return recebimentoList;
    }

    public void setRecebimentoList(List<Recebimento> recebimentoList) {
        this.recebimentoList = recebimentoList;
    }

    public List<Itemorcamentovenda> getItemorcamentovendaList() {
        return itemorcamentovendaList;
    }

    public void setItemorcamentovendaList(List<Itemorcamentovenda> itemorcamentovendaList) {
        this.itemorcamentovendaList = itemorcamentovendaList;
    }

    public Orcamentovenda(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipoCadastro() {
        return tipoCadastro;
    }

    public void setTipoCadastro(String tipoCadastro) {
        this.tipoCadastro = tipoCadastro;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
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

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getValorReceber() {
        return valorReceber;
    }

    public void setValorReceber(Double valorReceber) {
        this.valorReceber = valorReceber;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Orcamentovenda)) {
            return false;
        }
        Orcamentovenda other = (Orcamentovenda) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Orcamentovenda[codigo=" + codigo + "]";
    }
}