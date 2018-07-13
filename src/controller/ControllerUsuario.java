package controller;

import entidade.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tools.Dao;
import tools.ModeloTabela;
import view.frmUsuario;

public class ControllerUsuario {

    public ControllerUsuario(frmUsuario viewUsuario) {
        this.viewUsuario = viewUsuario;
    }
    private Dao dao = new Dao("Sistema_OficinaPU");
    private Usuario usuario;
    private ModeloTabela tableModel;
    private List<Usuario> listaUsuario;
    private frmUsuario viewUsuario;

    private void montarTabela() {
        try {
            List<Object[]> listaTabela = new ArrayList<Object[]>();
            String[] nomeColuna = {"Código", "Nome", "Login"};
            for (Usuario usu : this.listaUsuario) {
                listaTabela.add(new Object[]{usu.getCodigo(), usu.getNome(), usu.getLogin()});
            }
            this.tableModel = new ModeloTabela(listaTabela, this.listaUsuario, nomeColuna);
            this.viewUsuario.getTabelaUsuario().setModel(this.tableModel);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum registro de Usuário!!!");
        }

    }

    public void tabPesquisa() {
        this.viewUsuario.getTabelaUsuario().setModel(new DefaultTableModel());
        this.viewUsuario.getTabulacao().setSelectedIndex(0);
        this.viewUsuario.getEdtPesquisa().setText("");
    }

    private void tabCadastro() {
        this.viewUsuario.getTabulacao().setSelectedIndex(1);
        this.viewUsuario.getTabulacao().setEnabledAt(1, true);
    }

    private void preencherCampos() {
        this.usuario = (Usuario) this.tableModel.getObjectAt(this.viewUsuario.getTabelaUsuario().getSelectedRow());
        this.viewUsuario.getEdtCodigo().setText(this.usuario.getCodigo().toString());
        this.viewUsuario.getEdtNome().setText(this.usuario.getNome());
        this.viewUsuario.getEdtLogin().setText(this.usuario.getLogin());
        this.viewUsuario.getEdtSenha().setText(this.usuario.getSenha());
    }

    private void limparCampos() {
        this.viewUsuario.getEdtCodigo().setText("");
        this.viewUsuario.getEdtNome().setText("");
        this.viewUsuario.getEdtLogin().setText("");
        this.viewUsuario.getEdtSenha().setText("");
    }

    public void alterarUsuario() {
        try {
            try {
                preencherCampos();
                tabCadastro();
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É nescessário selecionar um Usuário!!!");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Usuário!!!");
        }
    }

    public void cadastrarNovoUsuario() {
        this.usuario = new Usuario();
        limparCampos();
        tabCadastro();
    }

    public void excluirUsuario() {
        try {

            try {
                this.usuario = (Usuario) this.tableModel.getObjectAt(this.viewUsuario.getTabelaUsuario().getSelectedRow());
                int x = JOptionPane.showConfirmDialog(null, "Confirma em excluir este registro?", "Atenção",
                        JOptionPane.YES_OPTION,
                        JOptionPane.CANCEL_OPTION);
                if ((x == JOptionPane.YES_OPTION)) {
                    String mensagem = this.dao.excluir(this.usuario);
                    if (mensagem.equals("1451")) {
                        /*
                         * Caso estiver que relacionar o usuário com algo!! Como: Venda, Compra, ect.
                         */
                    } else {
                        pesquisarPorParametro();
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É nescessário selecionar um Usuário!!!");
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Usuário!!!");
        }
    }

    public void gravarUsuario() {
        if (this.viewUsuario.getEdtNome().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo nome é de preenchimento Obrigatório!!!");
        } else if (this.viewUsuario.getEdtLogin().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo senha é de preenchimento Obrigatório!!!");
        } else if (this.viewUsuario.getEdtSenha().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo senha é de preenchimento Obrigatório!!!");
        } else {
            this.usuario.setNome(this.viewUsuario.getEdtNome().getText());
            this.usuario.setLogin(this.viewUsuario.getEdtLogin().getText());
            this.usuario.setSenha(this.viewUsuario.getEdtSenha().getText());
            if (this.usuario.getLogin().length() > 10) {
                JOptionPane.showMessageDialog(null, "O campo login deve ser no máximo 10 caracteres!!!");
            } else if (this.usuario.getSenha().length() > 10) {
                JOptionPane.showMessageDialog(null, "O campo senha deve ser no máximo 8 caracteres!!!");
            } else {
                if (!validarLogin()) {
                    this.dao.gravar(this.usuario);
                    tabPesquisa();
                } else {
                    JOptionPane.showMessageDialog(null, "Já existe um usuário usando este identificador!!");
                }
            }
        }
    }

    public void pesquisarPorParametro() {
        this.listaUsuario = this.dao.pesquisar("Usuario.findByNome", new Object[]{"%" + this.viewUsuario.getEdtPesquisa().getText().toLowerCase() + "%"});
        montarTabela();
    }

    private boolean validarLogin() {
        this.listaUsuario = this.dao.pesquisar("Usuario.findAll");
        int aux = 0;
        if (this.viewUsuario.getEdtCodigo().getText().equals("")) {
            for (Usuario usu : this.listaUsuario) {
                if (usu.getLogin().equals(this.viewUsuario.getEdtLogin().getText())) {
                    aux = 1;
                }
            }
        } else {
            for (Usuario usu : this.listaUsuario) {
                if (usu.getLogin().equals(this.viewUsuario.getEdtLogin().getText()) && !this.viewUsuario.getEdtCodigo().getText().equals(usu.getCodigo().toString())) {
                    aux = 1;
                }
            }
        }
        if (aux == 1) {
            return true;
        } else {
            return false;
        }
    }
}