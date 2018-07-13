package controller;

import entidade.Cliente;
import entidade.Orcamentovenda;
import entidade.Recebimento;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tools.Dao;
import tools.ModeloTabela;
import view.frmContasReceber;

public class ControllerContasReceber {

    public ControllerContasReceber(frmContasReceber viewContasReceber) {
        this.viewContasReceber = viewContasReceber;
    }
    private Dao dao = new Dao("Sistema_OficinaPU");
    private Orcamentovenda orcamentoVenda;
    private ModeloTabela tableModelConsulta;
    private ModeloTabela tableModelRecebimento;
    private List<Orcamentovenda> listaOrcamentoVenda;
    private List<Recebimento> listaRecebimento;
    private List<Cliente> listaCliente;
    private frmContasReceber viewContasReceber;

    public void montarTabelaConsulta() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            List<Object[]> listaTabela = new ArrayList<Object[]>();
            String[] nomeColuna = {"Código", "Tipo Cadastro", "Situação", "Data", "Desconto", "Valor Total", "Valor Receber", "Cliente", "Veiculo"};
            for (Orcamentovenda ovd : this.listaOrcamentoVenda) {
                listaTabela.add(new Object[]{ovd.getCodigo(), ovd.getTipoCadastro(), ovd.getSituacao(), sdf.format(ovd.getData()), ovd.getDesconto(), ovd.getValorTotal(), ovd.getValorReceber()});
            }
            this.tableModelConsulta = new ModeloTabela(listaTabela, this.listaOrcamentoVenda, nomeColuna);
            this.viewContasReceber.getTabelaConsulta().setModel(this.tableModelConsulta);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum registro com esse intervalo de data!");
        }
    }

    public void voltar() {
        this.viewContasReceber.getTabelaConsulta().setModel(new DefaultTableModel());
        this.viewContasReceber.getTabulacao().setSelectedIndex(0);
    }

    public void recebimento() {
        if (orcamentoVenda.getValorReceber() == 0) {
            JOptionPane.showMessageDialog(null, "Esta venda já se encontra paga!");
        } else {
            this.viewContasReceber.getRecebimento().setVisible(true);
        }

    }

    public void visualizarRecebimento() {
        try {
            orcamentoVenda = (Orcamentovenda) this.tableModelConsulta.getObjectAt(this.viewContasReceber.getTabelaConsulta().getSelectedRow());
            montarTabelaRecebimento();
            this.viewContasReceber.getTabulacao().setSelectedIndex(1);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar uma Venda!!!");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar uma Venda!!!");
        }
    }

    public void montarTabelaRecebimento() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            List<Object[]> listaTabela = new ArrayList<Object[]>();
            String[] nomeColuna = {"Código Pagamento", "Valor", "Data"};
            this.listaRecebimento = this.dao.pesquisar("Recebimento.findByCodigo", new Object[]{orcamentoVenda});
            for (Recebimento rcb : this.listaRecebimento) {
                listaTabela.add(new Object[]{rcb.getCodigo(), rcb.getValor(), sdf.format(rcb.getData())});
            }
            this.tableModelRecebimento = new ModeloTabela(listaTabela, this.listaRecebimento, nomeColuna);
            this.viewContasReceber.getTabelaRecebimento().setModel(this.tableModelRecebimento);
        } catch (IndexOutOfBoundsException e) {
            this.viewContasReceber.getTabulacao().setSelectedIndex(1);
        }
    }

    public void pesquisaConsulta() {
        if (this.viewContasReceber.getDcInicio().getDate() == null || this.viewContasReceber.getDcFim().getDate() == null) {
            JOptionPane.showMessageDialog(null, "A data de início e fim deve ser preenchido!");
        } else if (this.viewContasReceber.getDcFim().getDate().before(this.viewContasReceber.getDcInicio().getDate())) {
            JOptionPane.showMessageDialog(null, "A data de início de ser menor ou igual a data de fim!");
        } else {
            try {
                this.listaOrcamentoVenda = this.dao.pesquisar("Orcamentovenda.findByData", new Object[]{this.viewContasReceber.getDcInicio().getDate(), this.viewContasReceber.getDcFim().getDate(), this.listaCliente.get(this.viewContasReceber.getCbCliente().getSelectedIndex())});
                montarTabelaConsulta();
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É necessário selecionar o cliente!");
            }
        }
    }

    public void novoPagamento() {
        if (this.viewContasReceber.getDcDataRecebimento().getDate() == null) {
            JOptionPane.showMessageDialog(null, "É nescessário a data de recebimento!");
        } else if (this.viewContasReceber.getTfValor().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "É nescessário informar o valor recebido!");
        } else if (this.orcamentoVenda.getData().after(this.viewContasReceber.getDcDataRecebimento().getDate())) {
            JOptionPane.showMessageDialog(null, "A data do recebimento deve ser maior que a data do registro!");
        } else {
            Double valorBanco = this.orcamentoVenda.getValorReceber();
            String valor = this.viewContasReceber.getTfValor().getText();
            Double valorNovo = Double.parseDouble(valor.replaceAll(",", "."));
            if (valorNovo > valorBanco) {
                JOptionPane.showMessageDialog(null, "O Valor deve ser menor ou igual que:" + valorBanco);
            } else {
                int x = JOptionPane.showConfirmDialog(null, "Ao fazer o pagamento de: R$ " + valorNovo + " , O cliente ficará devendo: R$ " + (valorBanco - valorNovo) + " , CONFIRMA?", "Atenção",
                        JOptionPane.YES_OPTION,
                        JOptionPane.CANCEL_OPTION);
                if ((x == JOptionPane.YES_OPTION)) {
                    Recebimento recebimento = new Recebimento();
                    recebimento.setData(this.viewContasReceber.getDcDataRecebimento().getDate());
                    recebimento.setValor(Double.parseDouble(this.viewContasReceber.getTfValor().getText().replaceAll(",", ".")));
                    recebimento.setOrcamentovenda(this.orcamentoVenda);
                    this.dao.gravar(recebimento);
                    this.orcamentoVenda.setValorReceber(this.orcamentoVenda.getValorReceber() - valorNovo);
                    if (this.orcamentoVenda.getValorReceber() == 0) {
                        this.orcamentoVenda.setSituacao("Paga");
                    }
                    this.dao.gravar(orcamentoVenda);
                    this.viewContasReceber.getRecebimento().setVisible(false);
                    this.viewContasReceber.getTfValor().setText("");
                    this.viewContasReceber.getDcDataRecebimento().setDate(null);
                    montarTabelaRecebimento();
                } else {
                    this.viewContasReceber.getRecebimento().setVisible(false);
                    this.viewContasReceber.getTfValor().setText("");
                    this.viewContasReceber.getDcDataRecebimento().setDate(null);
                    montarTabelaRecebimento();
                }
            }
        }

    }

    public void removerRecebimento() {
        try {
            Recebimento rec = (Recebimento) this.tableModelRecebimento.getObjectAt(this.viewContasReceber.getTabelaRecebimento().getSelectedRow());
            int x = JOptionPane.showConfirmDialog(null, "Ao fazer a exclusão do pagamento de: R$ " + rec.getValor() + " , O cliente ficará devendo: R$ " + (rec.getValor() + orcamentoVenda.getValorReceber()) + " , CONFIRMA?", "Atenção",
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if ((x == JOptionPane.YES_OPTION)) {
                this.orcamentoVenda.setValorReceber(rec.getValor() + this.orcamentoVenda.getValorReceber());
                if (this.orcamentoVenda.getValorReceber() > 0) {
                    this.orcamentoVenda.setSituacao("Não Paga");
                }
                this.dao.gravar(orcamentoVenda);
                this.dao.excluir(rec);
                montarTabelaRecebimento();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um recebimento!");
        }
    }

    public void montarComboCliente() {
        this.listaCliente = this.dao.pesquisar("Cliente.findAll");
        ((DefaultComboBoxModel) this.viewContasReceber.getCbCliente().getModel()).removeAllElements();
        if (this.listaCliente != null) {
            int i = 0;
            for (Cliente cli : this.listaCliente) {
                this.viewContasReceber.getCbCliente().insertItemAt(cli.getNome(), i);
                i++;
            }
        }
    }
}
