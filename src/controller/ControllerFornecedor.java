package controller;

import entidade.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tools.Dao;
import tools.ModeloTabela;
import view.frmFornecedor;

public class ControllerFornecedor {

    public ControllerFornecedor(frmFornecedor viewFornecedor) {
        this.viewFornecedor = viewFornecedor;
    }
    private Dao dao = new Dao("Sistema_OficinaPU");
    private Fornecedor fornecedor;
    private ModeloTabela tableModel;
    private List<Fornecedor> listaFornecedor;
    private frmFornecedor viewFornecedor;

    private void montarTabela() {
        try {
            List<Object[]> listaTabela = new ArrayList<Object[]>();
            String[] nomeColuna = {"Código", "Nome", "Telefone"};
            for (Fornecedor forn : this.listaFornecedor) {
                listaTabela.add(new Object[]{forn.getCodigo(), forn.getNome(), forn.getTelefone()});
            }
            this.tableModel = new ModeloTabela(listaTabela, this.listaFornecedor, nomeColuna);
            this.viewFornecedor.getTabelaFornecedor().setModel(this.tableModel);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum registro de Fornecedor!!!");
        }

    }

    public void tabPesquisa() {
        this.viewFornecedor.getTabelaFornecedor().setModel(new DefaultTableModel());
        this.viewFornecedor.getTabulacao().setSelectedIndex(0);
        this.viewFornecedor.getEdtPesquisa().setText("");
    }

    private void tabCadastro() {
        this.viewFornecedor.getTabulacao().setSelectedIndex(1);
    }

    private void preencherCampos() {
        this.fornecedor = (Fornecedor) this.tableModel.getObjectAt(this.viewFornecedor.getTabelaFornecedor().getSelectedRow());
        this.viewFornecedor.getEdtCodigo().setText(this.fornecedor.getCodigo().toString());
        this.viewFornecedor.getEdtNome().setText(this.fornecedor.getNome());
        this.viewFornecedor.getEdtCnpj().setText(this.fornecedor.getCnpj());
        this.viewFornecedor.getEdtEndereco().setText(this.fornecedor.getEndereco());
        this.viewFornecedor.getEdtCidade().setText(this.fornecedor.getCidade());
        this.viewFornecedor.getComboBoxUF().setSelectedItem(this.fornecedor.getNome());
        this.viewFornecedor.getEdtFone().setText(this.fornecedor.getTelefone());
    }

    private void limparCampos() {
        this.viewFornecedor.getEdtCodigo().setText("");
        this.viewFornecedor.getEdtNome().setText("");
        this.viewFornecedor.getEdtCnpj().setText("");
        this.viewFornecedor.getEdtEndereco().setText("");
        this.viewFornecedor.getEdtCidade().setText("");
        this.viewFornecedor.getComboBoxUF().setSelectedItem(0);
        this.viewFornecedor.getEdtFone().setText("");
    }

    public void alterarFornecedor() {
        try {
            try {
                preencherCampos();
                tabCadastro();
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É nescessário selecionar um Fornecedor!!!");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Fornecedor!!!");
        }
    }

    public void cadastrarNovoFornecedor() {
        this.fornecedor = new Fornecedor();
        limparCampos();
        tabCadastro();
    }

    public void excluirFornecedor() {
        try {
            try {
                this.fornecedor = (Fornecedor) this.tableModel.getObjectAt(this.viewFornecedor.getTabelaFornecedor().getSelectedRow());
                int x = JOptionPane.showConfirmDialog(null, "Confirma em excluir este registro?", "Atenção",
                        JOptionPane.YES_OPTION,
                        JOptionPane.CANCEL_OPTION);
                if ((x == JOptionPane.YES_OPTION)) {
                    String mensagem = this.dao.excluir(this.fornecedor);
                    if (mensagem.equals("1451")) {
                        JOptionPane.showMessageDialog(null, "Este fornecedor possui compras e não pode ser excluído!!!");
                    } else {
                        pesquisarPorParametro();
                    }
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É nescessário selecionar um Fornecedor!!!");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Fornecedor!!!");
        }
    }

    public void gravarFornecedor() {
        if (this.viewFornecedor.getEdtNome().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo nome é de preenchimento Obrigatório!!!");
        } else if (this.viewFornecedor.getEdtFone().getText().equals("(  )    -    ")) {
            JOptionPane.showMessageDialog(null, "O campo telefone é de preenchimento Obrigatório!!!");
        } else {
            this.fornecedor.setCidade(this.viewFornecedor.getEdtCidade().getText());
            this.fornecedor.setCnpj(this.viewFornecedor.getEdtCnpj().getText());
            this.fornecedor.setEndereco(this.viewFornecedor.getEdtEndereco().getText());
            this.fornecedor.setNome(this.viewFornecedor.getEdtNome().getText());
            this.fornecedor.setTelefone(this.viewFornecedor.getEdtFone().getText());
            this.fornecedor.setUf(this.viewFornecedor.getComboBoxUF().getSelectedItem().toString());
            this.dao.gravar(this.fornecedor);
            tabPesquisa();
        }
    }

    public void pesquisarPorParametro() {
        this.listaFornecedor = this.dao.pesquisar("Fornecedor.findByNome", new Object[]{"%" + this.viewFornecedor.getEdtPesquisa().getText().toLowerCase() + "%"});
        montarTabela();
    }
}