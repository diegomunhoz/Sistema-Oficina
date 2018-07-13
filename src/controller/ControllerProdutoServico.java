package controller;

import entidade.Produtoservico;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tools.Dao;
import tools.ModeloTabela;
import tools.Utils;
import view.frmProdutoServico;

public class ControllerProdutoServico {

    public ControllerProdutoServico(frmProdutoServico viewProdutoServico) {
        this.viewProdutoServico = viewProdutoServico;
    }
    private Dao dao = new Dao("Sistema_OficinaPU");
    private Produtoservico produtoservico;
    private ModeloTabela tableModel;
    private List<Produtoservico> listaProdutoServico;
    private frmProdutoServico viewProdutoServico;

    private void montarTabela() {
        try {
            List<Object[]> listaTabela = new ArrayList<Object[]>();
            String[] nomeColuna = {"Código", "Descrição", "Valor", "Tipo do Cadastro"};
            for (Produtoservico pse : this.listaProdutoServico) {
                listaTabela.add(new Object[]{pse.getCodigo(), pse.getNome(), Utils.converterReal(pse.getValor()), pse.getTipo()});
            }
            this.tableModel = new ModeloTabela(listaTabela, this.listaProdutoServico, nomeColuna);
            this.viewProdutoServico.getTabelaProdutoServico().setModel(this.tableModel);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum registro de Produto ou Serviço!!!");
        }

    }

    public void tabPesquisa() {
        this.viewProdutoServico.getTabelaProdutoServico().setModel(new DefaultTableModel());
        this.viewProdutoServico.getTabulacao().setSelectedIndex(0);
        this.viewProdutoServico.getEdtPesquisa().setText("");
        this.viewProdutoServico.getComboBoxTipo().setEnabled(true);
    }

    private void tabCadastro() {
        this.viewProdutoServico.getTabulacao().setSelectedIndex(1);
        this.viewProdutoServico.getTabulacao().setEnabledAt(1, true);
    }

    private void preencherCampos() {
        this.produtoservico = (Produtoservico) this.tableModel.getObjectAt(this.viewProdutoServico.getTabelaProdutoServico().getSelectedRow());
        this.viewProdutoServico.getEdtCodigo().setText(this.produtoservico.getCodigo().toString());
        this.viewProdutoServico.getComboBoxTipo().setSelectedItem(this.produtoservico.getTipo().toString());

        this.viewProdutoServico.getEdtDescricao().setText(this.produtoservico.getNome());
        this.viewProdutoServico.getEdtValor().setText(String.valueOf(Utils.converterReal(produtoservico.getValor())).replaceAll("\\.", ","));
        this.viewProdutoServico.getEdtEstoque().setText(String.valueOf(this.produtoservico.getQtdeEstoque()));
        this.viewProdutoServico.getEdtEstoqueMinimo().setText(String.valueOf(this.produtoservico.getQtdeEstoqueMinimo()));
        this.viewProdutoServico.getComboBoxTipo().setEnabled(false);
    }

    private void limparCampos() {
        this.viewProdutoServico.getEdtCodigo().setText("");
        this.viewProdutoServico.getComboBoxTipo().setSelectedItem("Selecione o tipo de cadastro");
        this.viewProdutoServico.getEdtDescricao().setText("");
        this.viewProdutoServico.getEdtValor().setText("");
        this.viewProdutoServico.getEdtEstoque().setText("");
        this.viewProdutoServico.getEdtEstoqueMinimo().setText("");
    }

    public void alterarProdutoServico() {
        try {
            try {
                preencherCampos();
                verificarTipoCadastro();
                tabCadastro();
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É nescessário selecionar um Produto ou Serviço!!!");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Produto ou Serviço!!!");
        }
    }

    public void cadastrarNovoProdutoServico() {
        this.produtoservico = new Produtoservico();
        limparCampos();
        verificarTipoCadastro();
        tabCadastro();
    }

    public void excluirProdutoServico() {
        try {

            try {
                this.produtoservico = (Produtoservico) this.tableModel.getObjectAt(this.viewProdutoServico.getTabelaProdutoServico().getSelectedRow());
                int x = JOptionPane.showConfirmDialog(null, "Confirma em excluir este registro?", "Atenção",
                        JOptionPane.YES_OPTION,
                        JOptionPane.CANCEL_OPTION);
                if ((x == JOptionPane.YES_OPTION)) {
                    String mensagem = this.dao.excluir(this.produtoservico);
                    if (mensagem.equals("1451")) {
                        if (this.produtoservico.getTipo().equals("Serviço")) {
                            JOptionPane.showMessageDialog(null, "Este serviço  possui vendas ou orçamentos e não pode ser excluído!!!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Este produto  possui vendas ou orçamentos ou compras  e não pode ser excluído!!!");
                        }

                    } else {
                        pesquisarPorParametro();
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É nescessário selecionar um Produto ou Serviço!!!");
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Produto ou Serviço!!!");
        }
    }

    public void gravarProdutoServico() {
        if (this.viewProdutoServico.getComboBoxTipo().getSelectedItem().equals("Selecione o tipo de cadastro")) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar o tipo de cadastro!!!");
        } else if (this.viewProdutoServico.getEdtDescricao().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo descrição é de preenchimento Obrigatório!!!");
        } else if (this.viewProdutoServico.getEdtValor().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo valor é de preenchimento Obrigatório!!!");
        } else {
            if (this.viewProdutoServico.getComboBoxTipo().getSelectedItem().equals("Produto")) {
                if (this.viewProdutoServico.getEdtEstoque().getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O campo estoque é de preenchimento Obrigatório!!!");
                } else if (this.viewProdutoServico.getEdtEstoqueMinimo().getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "O campo estoque mínimo é de preenchimento Obrigatório!!!");
                } else {
                    this.produtoservico.setQtdeEstoque(Integer.parseInt(this.viewProdutoServico.getEdtEstoque().getText()));
                    this.produtoservico.setQtdeEstoqueMinimo(Integer.parseInt(this.viewProdutoServico.getEdtEstoqueMinimo().getText()));
                    grava();
                }
            } else {
                this.produtoservico.setQtdeEstoque(Integer.parseInt("0"));
                this.produtoservico.setQtdeEstoqueMinimo(Integer.parseInt("0"));
                grava();
            }
        }
    }

    private void grava() {
        this.produtoservico.setTipo(this.viewProdutoServico.getComboBoxTipo().getSelectedItem().toString());
        this.produtoservico.setNome(this.viewProdutoServico.getEdtDescricao().getText());
        this.produtoservico.setValor(Double.parseDouble(this.viewProdutoServico.getEdtValor().getText().replaceAll(",", ".")));
        this.dao.gravar(this.produtoservico);
        tabPesquisa();
    }

    public void verificarTipoCadastro() {
        if (this.viewProdutoServico.getComboBoxTipo().getSelectedItem().equals("Selecione o tipo de cadastro") || this.viewProdutoServico.getComboBoxTipo().getSelectedItem().equals("Serviço")) {
            this.viewProdutoServico.getEdtEstoque().setVisible(false);
            this.viewProdutoServico.getEdtEstoqueMinimo().setVisible(false);
            this.viewProdutoServico.getLblEstoque().setVisible(false);
            this.viewProdutoServico.getLblEstoqueMinimo().setVisible(false);
        } else {
            this.viewProdutoServico.getEdtEstoque().setVisible(true);
            this.viewProdutoServico.getEdtEstoqueMinimo().setVisible(true);
            this.viewProdutoServico.getLblEstoque().setVisible(true);
            this.viewProdutoServico.getLblEstoqueMinimo().setVisible(true);
        }
    }

    public void pesquisarPorParametro() {
        this.listaProdutoServico = this.dao.pesquisar("Produtoservico.findByNome", new Object[]{"%" + this.viewProdutoServico.getEdtPesquisa().getText().toLowerCase() + "%"});
        montarTabela();
    }
}