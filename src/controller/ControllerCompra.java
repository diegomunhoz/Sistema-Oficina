package controller;

import entidade.Compra;
import entidade.Fornecedor;
import entidade.Itemcompra;
import entidade.Produtoservico;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import tools.Utils;
import tools.Dao;
import tools.ModeloTabela;
import view.frmCompra;

public class ControllerCompra {

    public ControllerCompra(frmCompra viewCompra) {
        this.viewCompra = viewCompra;
    }
    private Dao dao = new Dao("Sistema_OficinaPU");
    private List<Fornecedor> listaFornecedor;
    private List<Compra> listaCompra;
    private Compra compra;
    private List<Produtoservico> listaProdutoServico;
    private Produtoservico produtoservico;
    private ModeloTabela tableModelCompra;
    private ModeloTabela tableModelBuscaProduto;
    private ModeloTabela tableModelItem;
    private frmCompra viewCompra;

    private void montarTabelaCompra() {
        try {
            List<Object[]> listaTabela = new ArrayList<Object[]>();
            String[] nomeColuna = {"Nome do fornecedor", "Valor Total", "Situação", "Tipo de Cadastro", "Data do Registro"};
            for (Compra c : this.listaCompra) {
                listaTabela.add(new Object[]{c.getFornecedor().getNome(), Utils.converterReal(c.getValorTotal()), c.getSituacao(), c.getTipoCadastro(), Utils.converterData(c.getData())});
            }
            this.tableModelCompra = new ModeloTabela(listaTabela, this.listaCompra, nomeColuna);
            this.viewCompra.getTabelaCompra().setModel(this.tableModelCompra);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum registro de Compra!!!");
        }
    }

    public void montarTabelaBuscaProdutoPesquisaPorParamentro() {
        try {
            this.listaProdutoServico = this.dao.pesquisar("Produtoservico.findByNomeCompra", new Object[]{"%" + this.viewCompra.getEdtPesquisaProduto().getText().toLowerCase() + "%"});
            List<Object[]> listaTabela = new ArrayList<Object[]>();
            String[] nomeColuna = {"Código", "Descrição", "Valor", "Estoque"};
            for (Produtoservico pse : this.listaProdutoServico) {
                listaTabela.add(new Object[]{pse.getCodigo(), pse.getNome(), Utils.converterReal(pse.getValor()), pse.getQtdeEstoque()});
            }
            this.tableModelBuscaProduto = new ModeloTabela(listaTabela, this.listaProdutoServico, nomeColuna);
            this.viewCompra.getTabelaProduto().setModel(this.tableModelBuscaProduto);
            this.viewCompra.getDialogBuscaProduto().setVisible(true);
            this.viewCompra.getEdtQtde().requestFocus();
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum registro de Produto!!!");
        }
    }

    public void pesquisarPorParametroOrcamentoVenda() {
        this.listaCompra = this.dao.pesquisar("Compra.findByNomeFornecedor", new Object[]{"%" + this.viewCompra.getEdtPesquisa().getText().toLowerCase() + "%"});
        montarTabelaCompra();
    }

    private void montarTabelaItemProduto() {
        if (!this.compra.getItemcompraList().isEmpty()) {
            List<Object[]> listaTabela = new ArrayList<Object[]>();
            String[] nomeColuna = {"Descrição", "Valor Unitário", "Qtde", "Valor Total"};
            for (Itemcompra ic : this.compra.getItemcompraList()) {
                listaTabela.add(new Object[]{ic.getProdutoservico().getNome(), Utils.converterReal(ic.getValorTotal() / ic.getQtde()), ic.getQtde(), Utils.converterReal(ic.getValorTotal())});
            }
            this.tableModelItem = new ModeloTabela(listaTabela, this.compra.getItemcompraList(), nomeColuna);
            this.viewCompra.getTabelaItens().setModel(this.tableModelItem);
        } else {
            this.viewCompra.getTabelaItens().setModel(new DefaultTableModel());
        }
    }

    private void montarComboFornecedor() {
        this.listaFornecedor = this.dao.pesquisar("Fornecedor.findAll");
        ((DefaultComboBoxModel) this.viewCompra.getComboBoxFornecedor().getModel()).removeAllElements();
        if (this.listaFornecedor != null) {
            int i = 0;
            for (Fornecedor forn : this.listaFornecedor) {
                this.viewCompra.getComboBoxFornecedor().insertItemAt(forn.getNome(), i);
                i++;
            }
        }
    }

    public void verificarTipoCadastroCompra() {
        if (this.viewCompra.getComboBoxTipo().getSelectedItem().equals("Compra a Vista")) {
            this.viewCompra.getLblVencimento().setVisible(false);
            this.viewCompra.getDataVencimento().setVisible(false);
            this.viewCompra.getDataVencimento().setDate(null);
        } else if (this.viewCompra.getComboBoxTipo().getSelectedItem().equals("Compra a Prazo")) {
            this.viewCompra.getLblVencimento().setVisible(true);
            this.viewCompra.getDataVencimento().setVisible(true);
            if (this.viewCompra.getEdtCodigo().getText().equals("")) {
                Calendar c = new GregorianCalendar();
                c.setTime(this.viewCompra.getDataRegistro().getDate());
                c.add(Calendar.DAY_OF_MONTH, 30);
                Date date = new Date();
                date = c.getTime();
                this.viewCompra.getDataVencimento().setDate(date);
            }
        } else if (this.viewCompra.getComboBoxTipo().getSelectedItem().equals("Selecione o tipo de cadastro")) {
            this.viewCompra.getLblVencimento().setVisible(false);
            this.viewCompra.getDataVencimento().setVisible(false);
        }
    }

    public void escolherQtde() {
        try {
            this.produtoservico = (Produtoservico) this.tableModelBuscaProduto.getObjectAt(this.viewCompra.getTabelaProduto().getSelectedRow());
            this.viewCompra.getEdtValorCusto().setText("0,00");
            this.viewCompra.getDialogQtde().setVisible(true);
            limparCamposConsultaProduto();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Produto!!!");
        }
    }

    public void tabPesquisaOrcamentoVenda() {
        this.viewCompra.getTabelaCompra().setModel(new DefaultTableModel());
        this.compra = null;
        this.viewCompra.getTabulacao().setSelectedIndex(0);
    }

    private void tabCadastroCompra() {
        this.viewCompra.getTabulacao().setSelectedIndex(1);
    }

    private void tabCadastroProdutoServico() {
        montarTabelaItemProduto();
        this.viewCompra.getTabulacao().setSelectedIndex(2);
    }

    private void preencherCampos() {
        montarComboFornecedor();
        this.compra = (Compra) this.tableModelCompra.getObjectAt(this.viewCompra.getTabelaCompra().getSelectedRow());
        this.viewCompra.getEdtCodigo().setText(this.compra.getCodigo().toString());
        this.viewCompra.getComboBoxTipo().setSelectedItem(this.compra.getTipoCadastro());
        this.viewCompra.getDataRegistro().setDate(this.compra.getData());
        this.viewCompra.getDataVencimento().setDate(this.compra.getDataVencimento());
        this.viewCompra.getComboBoxFornecedor().setSelectedItem(this.compra.getFornecedor().getNome());
        this.compra.setItemcompraList(this.dao.pesquisar("Itemcompra.buscarPorCompra", new Object[]{this.compra}));
    }

    private void limparCamposConsultaProduto() {
        this.viewCompra.getEdtQtde().setText("");
        this.viewCompra.getEdtValorCusto().setText("");
        this.viewCompra.getEdtPesquisaProduto().setText("");
    }

    public void alterarCompra() {
        try {
            try {
                preencherCampos();
                verificarTipoCadastroCompra();
                Utils.diminuirEstoqueCompra(this.compra.getItemcompraList(), this.dao);
                tabCadastroCompra();
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É nescessário selecionar uma Compra!!!");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar uma Compra!!!");
        }
    }

    public void cadastroNovaCompra() {
        this.viewCompra.getEdtCodigo().setText("");
        this.viewCompra.getComboBoxTipo().setEnabled(true);
        this.compra = new Compra();
        this.compra.setItemcompraList(new ArrayList<Itemcompra>());
        this.viewCompra.getDataRegistro().setDate(new Date(System.currentTimeMillis()));
        verificarTipoCadastroCompra();
        tabCadastroCompra();
        montarComboFornecedor();
    }

    public void excluirCompra() {
        try {
            try {
                this.compra = (Compra) this.tableModelCompra.getObjectAt(this.viewCompra.getTabelaCompra().getSelectedRow());
                List<Itemcompra> l = new ArrayList<Itemcompra>(this.compra.getItemcompraList());
                int x = JOptionPane.showConfirmDialog(null, "Confirma em excluir este registro?", "Atenção",
                        JOptionPane.YES_OPTION,
                        JOptionPane.CANCEL_OPTION);
                if ((x == JOptionPane.YES_OPTION)) {
                    this.dao.excluir(this.compra);
                    Utils.diminuirEstoqueCompra(l, this.dao);
                    pesquisarPorParametroOrcamentoVenda();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É nescessário selecionar uma Compra!!!");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar uma Compra!!!");
        }
    }

    public void guadarCadastroCompra() {
        if (this.viewCompra.getComboBoxTipo().getSelectedItem().equals("Selecione o tipo de cadastro")) {
            JOptionPane.showMessageDialog(null, "O campo Tipo de Cadastro é de preenchimento Obrigatório!!!");
        } else if (this.viewCompra.getDataRegistro().getDate() == null) {
            JOptionPane.showMessageDialog(null, "O campo Data do Registro é de preenchimento Obrigatório!!!");
        } else if (this.viewCompra.getComboBoxTipo().getSelectedItem().equals("Compra a Prazo") && this.viewCompra.getDataVencimento().getDate() == null) {
            JOptionPane.showMessageDialog(null, "O campo Data de Vencimento é de preenchimento Obrigatório!!!");
        } else if (this.viewCompra.getComboBoxTipo().getSelectedItem().equals("Compra a Prazo") && this.viewCompra.getDataRegistro().getDate().after(this.viewCompra.getDataVencimento().getDate())) {
            JOptionPane.showMessageDialog(null, "O campo Data de Vencimento deve ser maior ou igual a Data do Registro!!!");
        } else if (this.viewCompra.getComboBoxFornecedor().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "O campo Fornecedor é de preenchimento Obrigatório!!!");
        } else {
            this.compra.setTipoCadastro(this.viewCompra.getComboBoxTipo().getSelectedItem().toString());
            this.compra.setSituacao(definiSituação(this.compra));
            this.compra.setData(this.viewCompra.getDataRegistro().getDate());
            this.compra.setDataVencimento(this.viewCompra.getDataVencimento().getDate());
            if (this.compra.getCodigo() == null) {
                this.compra.setValorTotal(Double.parseDouble("0"));
            }
            this.viewCompra.getEdtValorTotal().setText(Utils.converterReal(this.compra.getValorTotal()).toString());
            this.compra.setFornecedor(this.listaFornecedor.get(this.viewCompra.getComboBoxFornecedor().getSelectedIndex()));
            tabCadastroProdutoServico();
        }
    }

    private String definiSituação(Compra c) {
        if (c.getTipoCadastro().equals("Compra a Vista")) {
            return "Paga";
        } else {
            return "Não Paga";
        }
    }

    public boolean itemExistente() {
        boolean nao = true;
        if (!this.compra.getItemcompraList().isEmpty()) {
            for (Itemcompra i : this.compra.getItemcompraList()) {
                if (i.getProdutoservico().equals(this.produtoservico)
                        && this.produtoservico.getTipo().equals("Produto")) {
                    JOptionPane.showMessageDialog(null, "Produto já adicionado!!!");
                    nao = false;
                }
            }
        }
        return nao;
    }

    public void addItem(int qtde, Double valor) {
        Itemcompra i = new Itemcompra();
        i.setCompra(this.compra);
        i.setProdutoservico(produtoservico);
        i.setQtde(qtde);
        i.setValorTotal(valor * i.getQtde());
        this.compra.setValorTotal(Utils.converterReal(this.compra.getValorTotal() + i.getValorTotal()).doubleValue());
        this.viewCompra.getEdtValorTotal().setText(Utils.converterReal(this.compra.getValorTotal()).toString());
        this.compra.getItemcompraList().add(i);
    }

    public void incluirProdutoServico() {
        try {
            int quantidade = Integer.parseInt(this.viewCompra.getEdtQtde().getText());
            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(null, "O campo Qtde deve ser maior que 0!!!");
            } else if (this.viewCompra.getEdtValorCusto().getText() == null ? "" == null : this.viewCompra.getEdtValorCusto().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "O campo Valor de Custo é de preenchimento Obrigatório!!!");
            } else {
                Double vlrCusto = Double.parseDouble(this.viewCompra.getEdtValorCusto().getText().replaceAll(",", "."));
                if (vlrCusto <= 0) {
                    JOptionPane.showMessageDialog(null, "O campo Valor de Custo deve ser maior que 0!!!");
                } else {
                    this.produtoservico = (Produtoservico) this.tableModelBuscaProduto.getObjectAt(this.viewCompra.getTabelaProduto().getSelectedRow());
                    if (itemExistente()) {
                        addItem(quantidade, vlrCusto);
                        montarTabelaItemProduto();
                        this.viewCompra.getDialogQtde().setVisible(false);
                        this.viewCompra.getDialogBuscaProduto().setVisible(false);
                    }
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O campo Qtde é de preenchimento Obrigatório!!!");
        }
    }

    @SuppressWarnings("element-type-mismatch")
    public void removerItem() {
        if (this.viewCompra.getTabelaItens().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Produto!!!");
        } else {
            int x = JOptionPane.showConfirmDialog(null, "Deseja remover esse Item?", "Atenção",
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if ((x == JOptionPane.YES_OPTION)) {
                Itemcompra i = (Itemcompra) this.tableModelItem.getObjectAt(this.viewCompra.getTabelaItens().getSelectedRow());
                this.compra.setValorTotal(Utils.converterReal(this.compra.getValorTotal() - i.getValorTotal()).doubleValue());
                this.viewCompra.getEdtValorTotal().setText(Utils.converterReal(this.compra.getValorTotal()).toString());
                this.compra.getItemcompraList().remove(
                        this.viewCompra.getTabelaItens().getSelectedRow());
                montarTabelaItemProduto();
            }
        }
    }

    public void gravarCadastro() {
        if (this.compra.getItemcompraList().isEmpty()) {
            JOptionPane.showMessageDialog(null, "É nescessário pelo menos um Produto para realizar o Registro!!!");
        } else {
            finalizarCadastro();
        }
    }

    public void finalizarCadastro() {
        int x = JOptionPane.showConfirmDialog(null, "Confirma em gravar esse Registro?", "Aplicação",
                JOptionPane.YES_OPTION,
                JOptionPane.NO_OPTION);
        if ((x == JOptionPane.YES_OPTION)) {
            Utils.aumentarEstoqueCompra(this.compra.getItemcompraList(), this.dao);
            JOptionPane.showMessageDialog(null, this.dao.gravar(this.compra));
            tabPesquisaOrcamentoVenda();
        }
    }

    public void visualizaRelatorio() {
        try {
            try {
                this.compra = (Compra) this.tableModelCompra.getObjectAt(this.viewCompra.getTabelaCompra().getSelectedRow());
                String u = "/relatorio/relCompra.jasper";
                InputStream inputStream = getClass().getResourceAsStream(u);
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
                HashMap hm = new HashMap();
                hm.put("CODIGO", this.compra.getCodigo().toString());
                Utils.geraRelatorio(jasperReport, hm);
            } catch (JRException ex) {
                Logger.getLogger(ControllerCompra.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "É nescessário selecionar uma Compra!!!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar uma Compra!!!");
        }
    }

    public void cancelarCadastro() {
        int x = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar?", "Atenção",
                JOptionPane.YES_OPTION,
                JOptionPane.CANCEL_OPTION);
        if ((x == JOptionPane.YES_OPTION)) {
            if (!this.viewCompra.getEdtCodigo().getText().equals("")) {
                Utils.aumentarEstoqueCompra(this.compra.getItemcompraList(), this.dao);
            }
            tabPesquisaOrcamentoVenda();
        }
    }
}
