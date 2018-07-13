package entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;

@Entity
@Table(name = "recebimento")
@NamedQueries({
    @NamedQuery(name = "Recebimento.findAll", query = "SELECT r FROM Recebimento r"),
    @NamedQuery(name = "Recebimento.findByCodigo", query = "SELECT r FROM Recebimento r WHERE r.orcamentovenda = :orcamentovenda")})
public class Recebimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "orcamentoVenda", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Orcamentovenda orcamentovenda;

    public Recebimento() {
    }

    public Recebimento(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Orcamentovenda getOrcamentovenda() {
        return orcamentovenda;
    }

    public void setOrcamentovenda(Orcamentovenda orcamentovenda) {
        this.orcamentovenda = orcamentovenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Recebimento)) {
            return false;
        }
        Recebimento other = (Recebimento) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Recebimento[codigo=" + codigo + "]";
    }
}