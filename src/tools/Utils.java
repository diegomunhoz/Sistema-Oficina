package tools;

import entidade.Itemcompra;
import java.sql.Connection;
import entidade.Itemorcamentovenda;
import entidade.Produtoservico;
import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Utils {

    public static BigDecimal converterReal(double e) {
        return new BigDecimal(e).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static String converterData(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(date);
    }

    public static void diminuirEstoqueOrcamentoVenda(List<Itemorcamentovenda> l, Dao d) {
        List<Produtoservico> listaPS = d.pesquisar("Produtoservico.findAll");
        for (Itemorcamentovenda i : l) {
            for (Produtoservico p : listaPS) {
                if (i.getProdutoservico().equals(p) && p.getTipo().equals("Produto") && i.getProdutoservico().getTipo().equals("Produto")) {
                    p.setQtdeEstoque(p.getQtdeEstoque() - i.getQtde());
                    d.gravar(p);
                }
            }
        }
    }

    public static void aumentarEstoqueOrcamentoVenda(List<Itemorcamentovenda> l, Dao d) {
        List<Produtoservico> listaPS = d.pesquisar("Produtoservico.findAll");
        for (Itemorcamentovenda i : l) {
            for (Produtoservico p : listaPS) {
                if (i.getProdutoservico().equals(p) && p.getTipo().equals("Produto") && i.getProdutoservico().getTipo().equals("Produto")) {
                    p.setQtdeEstoque(p.getQtdeEstoque() + i.getQtde());
                    d.gravar(p);
                }
            }
        }
    }

    public static void aumentarEstoqueCompra(List<Itemcompra> l, Dao d) {
        List<Produtoservico> listaPS = d.pesquisar("Produtoservico.findAll");
        for (Itemcompra i : l) {
            for (Produtoservico p : listaPS) {
                if (i.getProdutoservico().equals(p) && p.getTipo().equals("Produto") && i.getProdutoservico().getTipo().equals("Produto")) {
                    p.setQtdeEstoque(p.getQtdeEstoque() + i.getQtde());
                    d.gravar(p);
                }
            }
        }
    }

    public static void diminuirEstoqueCompra(List<Itemcompra> l, Dao d) {
        List<Produtoservico> listaPS = d.pesquisar("Produtoservico.findAll");
        for (Itemcompra i : l) {
            for (Produtoservico p : listaPS) {
                if (i.getProdutoservico().equals(p) && p.getTipo().equals("Produto") && i.getProdutoservico().getTipo().equals("Produto")) {
                    p.setQtdeEstoque(p.getQtdeEstoque() - i.getQtde());
                    d.gravar(p);
                }
            }
        }
    }

    public static void geraRelatorio(JasperReport jasperReport, HashMap hm) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_spra", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperPrint jp = null;
        try {
            jp = JasperFillManager.fillReport(jasperReport, hm, con);
        } catch (JRException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

        JasperViewer jv = new JasperViewer(jp, false);

        jv.setVisible(true);
    }
}