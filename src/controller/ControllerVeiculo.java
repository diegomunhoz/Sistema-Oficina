package controller;

import entidade.Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tools.Dao;
import tools.ModeloTabela;
import view.frmVeiculo;

public class ControllerVeiculo {

    public ControllerVeiculo(frmVeiculo viewVeiculo) {
        this.viewVeiculo = viewVeiculo;
    }
    private Dao dao = new Dao("Sistema_OficinaPU");
    private ModeloTabela tableModel;
    private List<Veiculo> listaVeiculo;
    private frmVeiculo viewVeiculo;
    private Veiculo veiculo;

    private void montarTabela() {
        try {
            List<Object[]> listaTabela = new ArrayList<Object[]>();
            String[] nomeColuna = {"Código", "Placa", "Marca", "Ano"};
            for (Veiculo vei : this.listaVeiculo) {
                listaTabela.add(new Object[]{vei.getCodigo(), vei.getPlaca(), vei.getMarca(), vei.getAno()});
            }
            this.tableModel = new ModeloTabela(listaTabela, this.listaVeiculo, nomeColuna);
            this.viewVeiculo.getTabelaVeiculo().setModel(this.tableModel);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum registro de Veículo!!!");
        }

    }

    public void tabPesquisa() {
        this.viewVeiculo.getTabelaVeiculo().setModel(new DefaultTableModel());
        this.viewVeiculo.getTabulacao().setSelectedIndex(0);
        this.viewVeiculo.getEdtPesquisa().setText("");
    }

    private void tabCadastro() {
        this.viewVeiculo.getTabulacao().setSelectedIndex(1);
        this.viewVeiculo.getTabulacao().setEnabledAt(1, true);
    }

    private void preencherCampos() {
        this.veiculo = (Veiculo) this.tableModel.getObjectAt(this.viewVeiculo.getTabelaVeiculo().getSelectedRow());
        this.viewVeiculo.getEdtCodigo().setText(this.veiculo.getCodigo().toString());
        this.viewVeiculo.getEdtAno().setText(this.veiculo.getAno());
        this.viewVeiculo.getEdtChassi().setText(this.veiculo.getChassi());
        this.viewVeiculo.getEdtCor().setText(this.veiculo.getCor());
        this.viewVeiculo.getEdtMarca().setText(this.veiculo.getMarca());
        this.viewVeiculo.getEdtModelo().setText(this.veiculo.getModelo());
        this.viewVeiculo.getEdtObservacao().setText(this.veiculo.getObservacao());
        this.viewVeiculo.getEdtPlaca().setText(this.veiculo.getPlaca());
    }

    private void limparCampos() {
        this.viewVeiculo.getEdtCodigo().setText("");
        this.viewVeiculo.getEdtAno().setText("");
        this.viewVeiculo.getEdtChassi().setText("");
        this.viewVeiculo.getEdtCor().setText("");
        this.viewVeiculo.getEdtMarca().setText("");
        this.viewVeiculo.getEdtModelo().setText("");
        this.viewVeiculo.getEdtObservacao().setText("");
        this.viewVeiculo.getEdtPlaca().setText("");
    }

    public void alterarVeiculo() {
        try {
            try {
                preencherCampos();
                tabCadastro();
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É nescessário selecionar um Veículo!!!");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Veículo!!!");
        }
    }

    public void cadastrarNovoVeiculo() {
        this.veiculo = new Veiculo();
        limparCampos();
        tabCadastro();
    }

    public void excluirVeiculo() {
        try {
            try {
                this.veiculo = (Veiculo) this.tableModel.getObjectAt(this.viewVeiculo.getTabelaVeiculo().getSelectedRow());
                int x = JOptionPane.showConfirmDialog(null, "Confirma em excluir este registro?", "Atenção",
                        JOptionPane.YES_OPTION,
                        JOptionPane.CANCEL_OPTION);
                if ((x == JOptionPane.YES_OPTION)) {
                    String mensagem = this.dao.excluir(this.veiculo);
                    if (mensagem.equals("1451")) {
                        JOptionPane.showMessageDialog(null, "Este veículo  possui vendas ou orçamentos  e não pode ser excluído!!!");
                    } else {
                        pesquisarPorParametro();
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É nescessário selecionar um Veículo!!!");
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Veículo!!!");
        }
    }

    public void gravarVeiculo() {
        if (this.viewVeiculo.getEdtPlaca().getText().equals("   -    ")) {
            JOptionPane.showMessageDialog(null, "O campo placa é de preenchimento Obrigatório!!!");
        } else if (this.viewVeiculo.getEdtMarca().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo marca é de preenchimento Obrigatório!!!");
        } else if (this.viewVeiculo.getEdtModelo().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo modelo é de preenchimento Obrigatório!!!");
        } else if (this.viewVeiculo.getEdtAno().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo ano é de preenchimento Obrigatório!!!");
        } else {
            this.veiculo.setPlaca(this.viewVeiculo.getEdtPlaca().getText());
            this.veiculo.setAno(this.viewVeiculo.getEdtAno().getText());
            this.veiculo.setChassi(this.viewVeiculo.getEdtChassi().getText());
            this.veiculo.setCor(this.viewVeiculo.getEdtCor().getText());
            this.veiculo.setMarca(this.viewVeiculo.getEdtMarca().getText());
            this.veiculo.setModelo(this.viewVeiculo.getEdtModelo().getText());
            this.veiculo.setObservacao(this.viewVeiculo.getEdtObservacao().getText());
            if (this.veiculo.getAno().length() > 4) {
                JOptionPane.showMessageDialog(null, "O campo ano deve ser no máximo 4 caracteres!!!");
            } else {
                if (!validarPlaca()) {
                    this.dao.gravar(this.veiculo);
                    tabPesquisa();
                } else {
                    JOptionPane.showMessageDialog(null, "Já existe um veículo cadastrado com esta placa!!");
                }
            }
        }
    }

    public void pesquisarPorParametro() {
        this.listaVeiculo = this.dao.pesquisar("Veiculo.findByPlaca", new Object[]{"%" + this.viewVeiculo.getEdtPesquisa().getText().toLowerCase() + "%"});
        montarTabela();
    }

    private boolean validarPlaca() {
        this.listaVeiculo = this.dao.pesquisar("Veiculo.findAll");
        int aux = 0;
        if (this.viewVeiculo.getEdtCodigo().getText().equals("")) {
            for (Veiculo vei : this.listaVeiculo) {
                if (vei.getPlaca().equals(this.viewVeiculo.getEdtPlaca().getText())) {
                    aux = 1;
                }
            }
        } else {
            for (Veiculo vei : this.listaVeiculo) {
                if (vei.getPlaca().equals(this.viewVeiculo.getEdtPlaca().getText()) && !this.viewVeiculo.getEdtCodigo().getText().equals(vei.getCodigo().toString())) {
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