package controller;

import entidade.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tools.Dao;
import tools.ModeloTabela;
import view.frmCliente;

public class ControllerCliente {

    public ControllerCliente(frmCliente viewCliente) {
        this.viewCliente = viewCliente;

    }
    private Dao dao = new Dao("Sistema_OficinaPU");
    private Cliente cliente;
    private ModeloTabela tableModel;
    private List<Cliente> listaCliente;
    private frmCliente viewCliente;

    private void montarTabela() {
        try {
            List<Object[]> listaTabela = new ArrayList<Object[]>();
            String[] nomeColuna = {"Código", "Nome", "Telefone"};
            for (Cliente cli : this.listaCliente) {
                listaTabela.add(new Object[]{cli.getCodigo(), cli.getNome(), cli.getTelefone()});
            }
            this.tableModel = new ModeloTabela(listaTabela, this.listaCliente, nomeColuna);
            this.viewCliente.getTabelaCliente().setModel(this.tableModel);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum registro de Cliente!!!");
        }
    }

    public void tabPesquisa() {
        this.viewCliente.getTabelaCliente().setModel(new DefaultTableModel());
        this.viewCliente.getTabulacao().setSelectedIndex(0);
        this.viewCliente.getEdtPesquisa().setText("");
    }

    private void tabCadastro() {
        this.viewCliente.getTabulacao().setSelectedIndex(1);
    }

    private void preencherCampos() {
        this.cliente = (Cliente) this.tableModel.getObjectAt(this.viewCliente.getTabelaCliente().getSelectedRow());
        this.viewCliente.getEdtCodigo().setText(this.cliente.getCodigo().toString());
        this.viewCliente.getEdtNome().setText(this.cliente.getNome());
        this.viewCliente.getEdtCpf().setText(this.cliente.getCpf());
        this.viewCliente.getEdtRg().setText(this.cliente.getRg());
        this.viewCliente.getEdtEndereco().setText(this.cliente.getEndereco());
        this.viewCliente.getEdtCidade().setText(this.cliente.getCidade());
        this.viewCliente.getComboBoxUF().setSelectedItem(this.cliente.getNome());
        this.viewCliente.getEdtFone().setText(this.cliente.getTelefone());
        this.viewCliente.getEdtDateNasc().setDate(this.cliente.getDataNascimento());
        this.viewCliente.getComboBoxSexo().setSelectedItem(this.cliente.getSexo());
    }

    private void limparCampos() {
        this.viewCliente.getEdtCodigo().setText("");
        this.viewCliente.getEdtNome().setText("");
        this.viewCliente.getEdtCpf().setText("");
        this.viewCliente.getEdtRg().setText("");
        this.viewCliente.getEdtEndereco().setText("");
        this.viewCliente.getEdtCidade().setText("");
        this.viewCliente.getComboBoxUF().setSelectedItem(0);
        this.viewCliente.getEdtFone().setText("");
        this.viewCliente.getEdtDateNasc().setDate(null);
        this.viewCliente.getComboBoxSexo().setSelectedItem(0);
    }

    public void alterarCliente() {
        try {
            try {
                preencherCampos();
                tabCadastro();
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É nescessário selecionar um Cliente!!!");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Cliente!!!");
        }
    }

    public void cadastrarNovoCliente() {
        this.cliente = new Cliente();
        limparCampos();
        tabCadastro();
    }

    public void excluirCliente() {
        try {
            try {
                this.cliente = (Cliente) this.tableModel.getObjectAt(this.viewCliente.getTabelaCliente().getSelectedRow());
                int x = JOptionPane.showConfirmDialog(null, "Confirma em excluir este registro?", "Atenção",
                        JOptionPane.YES_OPTION,
                        JOptionPane.CANCEL_OPTION);
                if ((x == JOptionPane.YES_OPTION)) {
                    String mensagem = this.dao.excluir(this.cliente);
                    if (mensagem.equals("1451")) {
                        JOptionPane.showMessageDialog(null, "Este cliente possui vendas ou orçamentos e não pode ser excluído!!!");
                    } else {
                        pesquisarPorParametro();
                    }
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É nescessário selecionar um Cliente!!!");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Cliente!!!");
        }

    }

    public void gravarCliente() {
        if (this.viewCliente.getEdtNome().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo nome é de preenchimento Obrigatório!!!");
        } else if (this.viewCliente.getEdtEndereco().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo endereço é de preenchimento Obrigatório!!!");
        } else {
            this.cliente.setCidade(this.viewCliente.getEdtCidade().getText());
            this.cliente.setCpf(this.viewCliente.getEdtCpf().getText());
            this.cliente.setRg(this.viewCliente.getEdtRg().getText());
            this.cliente.setDataNascimento(this.viewCliente.getEdtDateNasc().getDate());
            this.cliente.setEndereco(this.viewCliente.getEdtEndereco().getText());
            this.cliente.setNome(this.viewCliente.getEdtNome().getText());
            this.cliente.setSexo(this.viewCliente.getComboBoxSexo().getSelectedItem().toString());
            this.cliente.setTelefone(this.viewCliente.getEdtFone().getText());
            this.cliente.setUf(this.viewCliente.getComboBoxUF().getSelectedItem().toString());
            this.dao.gravar(this.cliente);
            tabPesquisa();
        }
    }

    public void pesquisarPorParametro() {
        this.listaCliente = this.dao.pesquisar("Cliente.findByNome", new Object[]{"%" + this.viewCliente.getEdtPesquisa().getText().toLowerCase() + "%"});
        montarTabela();
    }
}
