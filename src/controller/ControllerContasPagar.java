package controller;

import entidade.Compra;
import entidade.Fornecedor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import tools.Dao;
import tools.ModeloTabela;
import view.frmContasPagar;

public class ControllerContasPagar {

    public ControllerContasPagar(frmContasPagar viewContasPagar) {
        this.viewContasPagar = viewContasPagar;
    }
    private Dao dao = new Dao("Sistema_OficinaPU");
    private Compra compra;
    private ModeloTabela tableModel;
    private List<Compra> listaCompras;
    private List<Fornecedor> listaFornecedor;
    private frmContasPagar viewContasPagar;
    private ControllerCompra controllerCompra;

    public void montarTabela() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            List<Object[]> listaTabela = new ArrayList<Object[]>();
            String[] nomeColuna = {"Código", "Valor Total", "Data", "Data Vencimento", "Situação", "Fornecedor"};
            for (Compra cmp : this.listaCompras) {
                listaTabela.add(new Object[]{cmp.getCodigo(), cmp.getValorTotal(), sdf.format(cmp.getData()), sdf.format(cmp.getDataVencimento()), cmp.getSituacao(), cmp.getFornecedor().getNome()});
            }
            this.tableModel = new ModeloTabela(listaTabela, this.listaCompras, nomeColuna);
            this.viewContasPagar.getTabelaContasPagar().setModel(this.tableModel);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum registro com esse intervalo de data!");
        }
    }

    public void pesquisa() {
        if (this.viewContasPagar.getDcInicio().getDate() == null || this.viewContasPagar.getDcFim().getDate() == null) {
            JOptionPane.showMessageDialog(null, "A data de início e fim deve ser preenchido!");
        } else if (this.viewContasPagar.getDcFim().getDate().before(this.viewContasPagar.getDcInicio().getDate())) {
            JOptionPane.showMessageDialog(null, "A data de início de ser menor ou igual a data de fim!");
        } else {
            try {
                this.listaCompras = this.dao.pesquisar("Compra.findByData", new Object[]{this.listaFornecedor.get(this.viewContasPagar.getCbFornecedor().getSelectedIndex()), this.viewContasPagar.getDcInicio().getDate(), this.viewContasPagar.getDcFim().getDate()});
                montarTabela();
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É necessário selecionar um fornecedor!");
            }
        }
    }

    public void montarComboFornecedor() {
        this.listaFornecedor = this.dao.pesquisar("Fornecedor.findAll");
        ((DefaultComboBoxModel) this.viewContasPagar.getCbFornecedor().getModel()).removeAllElements();
        if (this.listaFornecedor != null) {
            int i = 0;
            for (Fornecedor forn : this.listaFornecedor) {
                this.viewContasPagar.getCbFornecedor().insertItemAt(forn.getNome(), i);
                i++;
            }
        }
    }

    public void pagarConta() {
        try {
            try {
                compra = (Compra) this.tableModel.getObjectAt(this.viewContasPagar.getTabelaContasPagar().getSelectedRow());
                int x = JOptionPane.showConfirmDialog(null, "Confirma trocar situação para PAGA?", "Atenção",
                        JOptionPane.YES_OPTION,
                        JOptionPane.CANCEL_OPTION);
                if ((x == JOptionPane.YES_OPTION)) {
                    compra.setSituacao("Paga");
                    dao.gravar(compra);
                    montarTabela();
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É necessário selecionar um Fornecedor!!!");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um Fornecedor!!!");
        }
    }

    public void naoPagarConta() {
        try {
            try {
                compra = (Compra) this.tableModel.getObjectAt(this.viewContasPagar.getTabelaContasPagar().getSelectedRow());
                int x = JOptionPane.showConfirmDialog(null, "Confirma trocar situação para NÃO PAGA?", "Atenção",
                        JOptionPane.YES_OPTION,
                        JOptionPane.CANCEL_OPTION);
                if ((x == JOptionPane.YES_OPTION)) {
                    compra.setSituacao("Não Paga"); // hum dia o Diego deixou este processo com a plavra a sem o tio do Não kkkkkk
                    dao.gravar(compra);
                    montarTabela();
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É necessário selecionar um Fornecedor!!!");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um Fornecedor!!!");
        }
    }
}
