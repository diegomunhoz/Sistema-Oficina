package entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "produtoservico")
@NamedQueries({
    @NamedQuery(name = "Produtoservico.findAll", query = "SELECT p FROM Produtoservico p"),
    @NamedQuery(name = "Produtoservico.findByCodigo", query = "SELECT p FROM Produtoservico p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Produtoservico.findByNome", query = "SELECT p FROM Produtoservico p WHERE lower (p.nome) like :nome"),
    @NamedQuery(name = "Produtoservico.findByNomeVenda", query = "SELECT p FROM Produtoservico p WHERE lower (p.nome) like :nome"),
    @NamedQuery(name = "Produtoservico.findByNomeCompra", query = "SELECT p FROM Produtoservico p WHERE lower (p.nome) like :nome AND p.tipo <> 'Serviço'")})
public class Produtoservico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "qtdeEstoque")
    private int qtdeEstoque;
    @Basic(optional = false)
    @Column(name = "qtdeEstoqueMinimo")
    private int qtdeEstoqueMinimo;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoservico")
//   private List<Itemorcamentovenda> itemorcamentovendaList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoservico")
//    private List<Itemcompra> itemcompraList;

    public Produtoservico() {
    }

    public Produtoservico(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public int getQtdeEstoqueMinimo() {
        return qtdeEstoqueMinimo;
    }

    public void setQtdeEstoqueMinimo(int qtdeEstoqueMinimo) {
        this.qtdeEstoqueMinimo = qtdeEstoqueMinimo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Produtoservico)) {
            return false;
        }
        Produtoservico other = (Produtoservico) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Produtoservico[codigo=" + codigo + "]";
    }
}