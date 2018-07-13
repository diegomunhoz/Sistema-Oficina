package controller;

import entidade.Cliente;
import entidade.Itemorcamentovenda;
import entidade.Orcamentovenda;
import entidade.Produtoservico;
import entidade.Veiculo;
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
import view.frmOrcamentoVenda;

public class ControllerOrcamentoVenda {

    public ControllerOrcamentoVenda(frmOrcamentoVenda viewOrcamentoVenda) {
        this.viewOrcamentoVenda = viewOrcamentoVenda;
    }
    private Dao dao = new Dao("Sistema_OficinaPU");
    private List<Cliente> listaCliente;
    private List<Orcamentovenda> listaOrcamentoVenda;
    private Orcamentovenda orcamentoVenda;
    private List<Produtoservico> listaProdutoServico;
    private Produtoservico produtoservico;
    private List<Veiculo> listaVeiculo;
    private ModeloTabela tableModelOrcamentoVenda;
    private ModeloTabela tableModelBuscaProduto;
    private ModeloTabela tableModelItem;
    private frmOrcamentoVenda viewOrcamentoVenda;
    private String situacaoAntiga = "";

    private void montarTabelaOrcamentoVenda() {
        try {
            List<Object[]> listaTabela = new ArrayList<Object[]>();
            String[] nomeColuna = {"Nome do cliente", "Valor Total", "Situação", "Tipo do Cadastro", "Data do Registro"};
            for (Orcamentovenda ove : this.listaOrcamentoVenda) {
                listaTabela.add(new Object[]{ove.getCliente().getNome(), Utils.converterReal(ove.getValorTotal()), ove.getSituacao(), ove.getTipoCadastro(), Utils.converterData(ove.getData())});
            }
            this.tableModelOrcamentoVenda = new ModeloTabela(listaTabela, this.listaOrcamentoVenda, nomeColuna);
            this.viewOrcamentoVenda.getTabelaOrcamentoVenda().setModel(this.tableModelOrcamentoVenda);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum registro de Orçamento ou Venda!!!");
        }
    }

    public void montarTabelaBuscaProdutoServicoPesquisaPorParamentro() {
        try {
            this.listaProdutoServico = this.dao.pesquisar("Produtoservico.findByNomeVenda", new Object[]{"%" + this.viewOrcamentoVenda.getEdtPesquisaProduto().getText().toLowerCase() + "%"});
            List<Object[]> listaTabela = new ArrayList<Object[]>();
            String[] nomeColuna = {"Código", "Descrição", "Valor", "Estoque", "Tipo"};
            for (Produtoservico pse : this.listaProdutoServico) {
                if (pse.getTipo().equals("Serviço")) {
                    listaTabela.add(new Object[]{pse.getCodigo(), pse.getNome(), Utils.converterReal(pse.getValor()), "-", pse.getTipo()});
                } else {
                    listaTabela.add(new Object[]{pse.getCodigo(), pse.getNome(), Utils.converterReal(pse.getValor()), pse.getQtdeEstoque(), pse.getTipo()});
                }
            }
            this.tableModelBuscaProduto = new ModeloTabela(listaTabela, this.listaProdutoServico, nomeColuna);
            this.viewOrcamentoVenda.getTabelaProdutoServico().setModel(this.tableModelBuscaProduto);
            this.viewOrcamentoVenda.getDialogBuscaProduto().setVisible(true);
            this.viewOrcamentoVenda.getEdtQtde().requestFocus();
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum registro de Produto ou Serviço!!!");
        }
    }

    public void pesquisarPorParametroOrcamentoVenda() {
        this.listaOrcamentoVenda = this.dao.pesquisar("Orcamentovenda.findByNomeCliente", new Object[]{"%" + this.viewOrcamentoVenda.getEdtPesquisa().getText().toLowerCase() + "%"});
        montarTabelaOrcamentoVenda();
    }

    private void montarTabelaItemProdutoServico() {
        if (!this.orcamentoVenda.getItemorcamentovendaList().isEmpty()) {
            List<Object[]> listaTabela = new ArrayList<Object[]>();
            String[] nomeColuna = {"Descrição", "Valor Unitário", "Qtde", "Valor Total", "Tipo"};
            for (Itemorcamentovenda iov : this.orcamentoVenda.getItemorcamentovendaList()) {
                listaTabela.add(new Object[]{iov.getProdutoservico().getNome(), Utils.converterReal(iov.getValorTotal() / iov.getQtde()), iov.getQtde(), Utils.converterReal(iov.getValorTotal()), iov.getProdutoservico().getTipo()});
            }
            this.tableModelItem = new ModeloTabela(listaTabela, this.orcamentoVenda.getItemorcamentovendaList(), nomeColuna);
            this.viewOrcamentoVenda.getTabelaItensOrcamentoVenda().setModel(this.tableModelItem);
        } else {
            this.viewOrcamentoVenda.getTabelaItensOrcamentoVenda().setModel(new DefaultTableModel());
        }
    }

    private void montarComboCliente() {
        this.listaCliente = this.dao.pesquisar("Cliente.findAll");
        ((DefaultComboBoxModel) this.viewOrcamentoVenda.getComboBoxCliente().getModel()).removeAllElements();
        if (this.listaCliente != null) {
            int i = 0;
            for (Cliente clie : this.listaCliente) {
                this.viewOrcamentoVenda.getComboBoxCliente().insertItemAt(clie.getNome(), i);
                i++;
            }
        }
    }

    private void montarComboVeiculo() {
        this.listaVeiculo = this.dao.pesquisar("Veiculo.findAll");
        ((DefaultComboBoxModel) this.viewOrcamentoVenda.getComboBoxVeiculo().getModel()).removeAllElements();
        if (this.listaCliente != null) {
            int i = 0;
            for (Veiculo vei : this.listaVeiculo) {
                this.viewOrcamentoVenda.getComboBoxVeiculo().insertItemAt(vei.getMarca(), i);
                i++;
            }
        }
    }

    public void verificarTipoCadastroOrcamentoVenda() {
        if (this.viewOrcamentoVenda.getComboBoxTipo().getSelectedItem().equals("Venda a Vista")) {
            this.viewOrcamentoVenda.getLblVencimento().setVisible(false);
            this.viewOrcamentoVenda.getDataVencimento().setVisible(false);
            this.viewOrcamentoVenda.getDataVencimento().setDate(null);
        } else if (this.viewOrcamentoVenda.getComboBoxTipo().getSelectedItem().equals("Venda a Prazo")) {
            this.viewOrcamentoVenda.getLblVencimento().setVisible(true);
            this.viewOrcamentoVenda.getDataVencimento().setVisible(true);
            if (this.viewOrcamentoVenda.getEdtCodigo().getText().equals("")) {
                Calendar c = new GregorianCalendar();
                c.setTime(this.viewOrcamentoVenda.getDataRegistro().getDate());
                c.add(Calendar.DAY_OF_MONTH, 30);
                Date date = new Date();
                date = c.getTime();
                this.viewOrcamentoVenda.getDataVencimento().setDate(date);
            }
        } else if (this.viewOrcamentoVenda.getComboBoxTipo().getSelectedItem().equals("Orçamento")
                || this.viewOrcamentoVenda.getComboBoxTipo().getSelectedItem().equals("Selecione o tipo de cadastro")) {
            this.viewOrcamentoVenda.getLblVencimento().setVisible(false);
            this.viewOrcamentoVenda.getDataVencimento().setVisible(false);
        }
    }

    public void verificarTipoCadastroProdutoServico() {
        try {
            this.produtoservico = (Produtoservico) this.tableModelBuscaProduto.getObjectAt(this.viewOrcamentoVenda.getTabelaProdutoServico().getSelectedRow());
            if (produtoservico.getTipo().equals("Produto")) {
                this.viewOrcamentoVenda.getLblVeiculo().setVisible(false);
                this.viewOrcamentoVenda.getComboBoxVeiculo().setVisible(false);
                this.viewOrcamentoVenda.getDialogQtde().setVisible(true);
            } else {
                this.viewOrcamentoVenda.getLblVeiculo().setVisible(true);
                this.viewOrcamentoVenda.getComboBoxVeiculo().setVisible(true);
                montarComboVeiculo();
                this.viewOrcamentoVenda.getDialogQtde().setVisible(true);
            }
            limparCamposConsultaProduto();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Produto ou Serviço!!!");
        }

    }

    public void tabPesquisaOrcamentoVenda() {
        this.viewOrcamentoVenda.getTabelaOrcamentoVenda().setModel(new DefaultTableModel());
        this.orcamentoVenda = null;
        this.viewOrcamentoVenda.getTabulacao().setSelectedIndex(0);
    }

    private void tabCadastroOrcamentoVenda() {
        this.viewOrcamentoVenda.getTabulacao().setSelectedIndex(1);
    }

    private void tabCadastroProdutoServico() {
        montarTabelaItemProdutoServico();
        this.viewOrcamentoVenda.getTabulacao().setSelectedIndex(2);
    }

    private void preencherCampos() {
        montarComboCliente();
        this.orcamentoVenda = (Orcamentovenda) this.tableModelOrcamentoVenda.getObjectAt(this.viewOrcamentoVenda.getTabelaOrcamentoVenda().getSelectedRow());
        this.viewOrcamentoVenda.getEdtCodigo().setText(this.orcamentoVenda.getCodigo().toString());
        this.viewOrcamentoVenda.getComboBoxTipo().setSelectedItem(this.orcamentoVenda.getTipoCadastro());
        this.viewOrcamentoVenda.getDataRegistro().setDate(this.orcamentoVenda.getData());
        this.viewOrcamentoVenda.getDataVencimento().setDate(this.orcamentoVenda.getDataVencimento());
        this.viewOrcamentoVenda.getComboBoxCliente().setSelectedItem(this.orcamentoVenda.getCliente().getNome());
        this.viewOrcamentoVenda.getEdtDesconto().setText(String.valueOf(this.orcamentoVenda.getDesconto()).replaceAll("\\.", ","));
        this.orcamentoVenda.setItemorcamentovendaList(this.dao.pesquisar("Itemorcamentovenda.buscarPorOrcamentoVenda", new Object[]{this.orcamentoVenda}));
        this.situacaoAntiga = this.orcamentoVenda.getTipoCadastro();
    }

    private void limparCamposConsultaProduto() {
        this.viewOrcamentoVenda.getEdtQtde().setText("");
        this.viewOrcamentoVenda.getEdtPesquisaProduto().setText("");
    }

    public void alterarOrcamentoVenda() {
        try {
            try {
                preencherCampos();
                verificarTipoCadastroOrcamentoVenda();
                if (this.orcamentoVenda.getRecebimentoList().isEmpty()) {
                    if (!this.orcamentoVenda.getTipoCadastro().equals("Orçamento")) {
                        this.viewOrcamentoVenda.getComboBoxTipo().setEnabled(false);
                    } else {
                        this.viewOrcamentoVenda.getComboBoxTipo().setEnabled(true);
                    }
                    tabCadastroOrcamentoVenda();
                    if (!this.situacaoAntiga.equals("Orçamento")) {
                        Utils.aumentarEstoqueOrcamentoVenda(this.orcamentoVenda.getItemorcamentovendaList(), this.dao);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Esta venda não pode ser alterada pois a mesma já possui recebimentos!!!");
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É nescessário selecionar um Orçamento ou Venda!!!");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Orçamento ou Venda!!!");
        }
    }

    public void cadastroNovoOrcamentoVenda() {
        this.viewOrcamentoVenda.getEdtCodigo().setText("");
        this.viewOrcamentoVenda.getComboBoxTipo().setEnabled(true);
        this.orcamentoVenda = new Orcamentovenda();
        this.orcamentoVenda.setItemorcamentovendaList(new ArrayList<Itemorcamentovenda>());
        this.viewOrcamentoVenda.getDataRegistro().setDate(new Date(System.currentTimeMillis()));
        verificarTipoCadastroOrcamentoVenda();
        tabCadastroOrcamentoVenda();
        montarComboCliente();
    }

    public void excluirOrcamentoVenda() {
        try {
            try {
                this.orcamentoVenda = (Orcamentovenda) this.tableModelOrcamentoVenda.getObjectAt(this.viewOrcamentoVenda.getTabelaOrcamentoVenda().getSelectedRow());
                List<Itemorcamentovenda> l = new ArrayList<Itemorcamentovenda>(this.orcamentoVenda.getItemorcamentovendaList());
                String s = this.orcamentoVenda.getTipoCadastro();
                int x = JOptionPane.showConfirmDialog(null, "Confirma em excluir este registro?", "Atenção",
                        JOptionPane.YES_OPTION,
                        JOptionPane.CANCEL_OPTION);
                if ((x == JOptionPane.YES_OPTION)) {
                    String mensagem = this.dao.excluir(this.orcamentoVenda);
                    if (mensagem.equals("1451")) {
                        JOptionPane.showMessageDialog(null, "Este Venda  possui recebimentos parciais  e não pode ser excluído!!!");
                    } else {
                        if (!s.equals("Orçamento")) {
                            Utils.aumentarEstoqueOrcamentoVenda(l, this.dao);
                        }
                        pesquisarPorParametroOrcamentoVenda();
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "É nescessário selecionar um Orçamento ou Venda!!!");
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Orçamento ou Venda!!!");
        }
    }

    public void guadarCadastroOrcamentoVenda() {
        if (this.viewOrcamentoVenda.getComboBoxTipo().getSelectedItem().equals("Selecione o tipo de cadastro")) {
            JOptionPane.showMessageDialog(null, "O campo Tipo de Cadastro é de preenchimento Obrigatório!!!");
        } else if (this.viewOrcamentoVenda.getDataRegistro().getDate() == null) {
            JOptionPane.showMessageDialog(null, "O campo Data do Registro é de preenchimento Obrigatório!!!");
        } else if (this.viewOrcamentoVenda.getComboBoxTipo().getSelectedItem().equals("Venda a Prazo") && this.viewOrcamentoVenda.getDataVencimento().getDate() == null) {
            JOptionPane.showMessageDialog(null, "O campo Data de Vencimento é de preenchimento Obrigatório!!!");
        } else if (this.viewOrcamentoVenda.getComboBoxTipo().getSelectedItem().equals("Venda a Prazo") && this.viewOrcamentoVenda.getDataRegistro().getDate().after(this.viewOrcamentoVenda.getDataVencimento().getDate())) {
            JOptionPane.showMessageDialog(null, "O campo Data de Vencimento deve ser maior ou igual a Data do Registro!!!");
        } else if (this.viewOrcamentoVenda.getComboBoxCliente().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "O campo Cliente é de preenchimento Obrigatório!!!");
        } else {
            if (this.viewOrcamentoVenda.getComboBoxTipo().getSelectedItem().equals("Venda a Prazo")) {
                if (verificaDebitoCliente()) {
                    JOptionPane.showMessageDialog(null, "Cliente com Débitos!!!");
                }
            }
            this.orcamentoVenda.setTipoCadastro(this.viewOrcamentoVenda.getComboBoxTipo().getSelectedItem().toString());
            this.orcamentoVenda.setSituacao(definiSituação(this.orcamentoVenda));
            this.orcamentoVenda.setData(this.viewOrcamentoVenda.getDataRegistro().getDate());
            this.orcamentoVenda.setDataVencimento(this.viewOrcamentoVenda.getDataVencimento().getDate());
            if (this.orcamentoVenda.getCodigo() == null) {
                this.orcamentoVenda.setDesconto(Double.parseDouble("0"));
                this.orcamentoVenda.setValorTotal(Double.parseDouble("0"));
                this.orcamentoVenda.setValorReceber(Double.parseDouble("0"));
                this.viewOrcamentoVenda.getEdtDesconto().setText(String.valueOf(this.orcamentoVenda.getDesconto()).replaceAll("\\.", ","));
            }
            this.viewOrcamentoVenda.getEdtValorTotal().setText(Utils.converterReal(this.orcamentoVenda.getValorTotal()).toString());
            this.orcamentoVenda.setCliente(this.listaCliente.get(this.viewOrcamentoVenda.getComboBoxCliente().getSelectedIndex()));
            tabCadastroProdutoServico();
        }
    }

    public boolean verificaDebitoCliente() {
        if (this.dao.pesquisar("Orcamentovenda.verificaDebitoCliente",
                new Object[]{this.listaCliente.get(this.viewOrcamentoVenda.getComboBoxCliente().getSelectedIndex()),
                    new Date(System.currentTimeMillis())}).isEmpty()) {
            return false;
        }
        return true;
    }

    private String definiSituação(Orcamentovenda o) {
        if (o.getTipoCadastro().equals("Venda a Vista")) {
            return "Paga";
        } else if (o.getTipoCadastro().equals("Venda a Prazo")) {
            return "Não Paga";
        }
        return "-";
    }

    public boolean isValidoEstoque(int qtde) {
        if (this.produtoservico.getQtdeEstoque() < qtde
                && this.produtoservico.getTipo().equals("Produto")
                && !this.orcamentoVenda.getTipoCadastro().equals("Orçamento")) {
            JOptionPane.showMessageDialog(null, "Quantidade insuficiente para a Venda!!!");
            return false;
        }
        return true;
    }

    public boolean itemExistente() {
        boolean nao = true;
        if (!this.orcamentoVenda.getItemorcamentovendaList().isEmpty()) {
            for (Itemorcamentovenda i : this.orcamentoVenda.getItemorcamentovendaList()) {
                if (i.getProdutoservico().equals(this.produtoservico)
                        && this.produtoservico.getTipo().equals("Produto")) {
                    JOptionPane.showMessageDialog(null, "Produto já adicionado!!!");
                    nao = false;
                }
            }
        }
        return nao;
    }

    public void addItem(int qtde) {
        Itemorcamentovenda i = new Itemorcamentovenda();
        i.setOrcamentovenda(this.orcamentoVenda);
        i.setProdutoservico(produtoservico);
        i.setQtde(qtde);
        if (this.produtoservico.getTipo().equals("Produto")) {
            i.setVeiculo(null);
        } else if (this.viewOrcamentoVenda.getComboBoxVeiculo().getSelectedItem() != null) {
            i.setVeiculo(this.listaVeiculo.get(this.viewOrcamentoVenda.getComboBoxVeiculo().getSelectedIndex()));
        }
        i.setValorTotal(produtoservico.getValor() * i.getQtde());
        this.orcamentoVenda.setValorTotal(Utils.converterReal(this.orcamentoVenda.getValorTotal() + i.getValorTotal()).doubleValue());
        this.viewOrcamentoVenda.getEdtValorTotal().setText(Utils.converterReal(this.orcamentoVenda.getValorTotal()).toString());
        this.orcamentoVenda.getItemorcamentovendaList().add(i);
    }

    public void incluirProdutoServico() {
        try {
            int quantidade = Integer.parseInt(this.viewOrcamentoVenda.getEdtQtde().getText());
            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(null, "O campo Qtde deve ser maior que 0!!!");
            } else {
                this.produtoservico = (Produtoservico) this.tableModelBuscaProduto.getObjectAt(this.viewOrcamentoVenda.getTabelaProdutoServico().getSelectedRow());
                if (itemExistente()) {
                    if (isValidoEstoque(quantidade)) {
                        addItem(quantidade);
                        montarTabelaItemProdutoServico();
                        this.viewOrcamentoVenda.getDialogQtde().setVisible(false);
                        this.viewOrcamentoVenda.getDialogBuscaProduto().setVisible(false);
                    }
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O campo Qtde é de preenchimento Obrigatório!!!");
        }
    }

    @SuppressWarnings("element-type-mismatch")
    public void removerItem() {
        if (this.viewOrcamentoVenda.getTabelaItensOrcamentoVenda().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Produto ou Serviço!!!");
        } else {
            int x = JOptionPane.showConfirmDialog(null, "Deseja remover esse Item?", "Atenção",
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if ((x == JOptionPane.YES_OPTION)) {
                Itemorcamentovenda i = (Itemorcamentovenda) this.tableModelItem.getObjectAt(this.viewOrcamentoVenda.getTabelaItensOrcamentoVenda().getSelectedRow());
                this.orcamentoVenda.setValorTotal(Utils.converterReal(this.orcamentoVenda.getValorTotal() - i.getValorTotal()).doubleValue());
                this.viewOrcamentoVenda.getEdtValorTotal().setText(Utils.converterReal(this.orcamentoVenda.getValorTotal()).toString());
                this.orcamentoVenda.getItemorcamentovendaList().remove(
                        this.viewOrcamentoVenda.getTabelaItensOrcamentoVenda().getSelectedRow());
                montarTabelaItemProdutoServico();
            }
        }
    }

    public void gravarCadastro() {
        if (this.orcamentoVenda.getItemorcamentovendaList().isEmpty()) {
            JOptionPane.showMessageDialog(null, "É nescessário pelo menos um Produto ou Serviço para realizar o Registro!!!");
        } else {
            this.orcamentoVenda.setDesconto(Double.parseDouble(this.viewOrcamentoVenda.getEdtDesconto().getText().replaceAll(",", ".")));
            finalizarCadastro();
        }
    }

    private void calculaDesconto() {
        this.orcamentoVenda.setValorReceber(((this.orcamentoVenda.getValorTotal()) - this.orcamentoVenda.getValorTotal() * this.orcamentoVenda.getDesconto() / 100));
    }

    public void finalizarCadastro() {
        int x = JOptionPane.showConfirmDialog(null, "Confirma em gravar esse Registro?", "Aplicação",
                JOptionPane.YES_OPTION,
                JOptionPane.NO_OPTION);
        if ((x == JOptionPane.YES_OPTION)) {
            if (!this.viewOrcamentoVenda.getComboBoxTipo().getSelectedItem().equals("Orçamento")
                    && this.viewOrcamentoVenda.getEdtCodigo().getText().equals("")) {
                Utils.diminuirEstoqueOrcamentoVenda(this.orcamentoVenda.getItemorcamentovendaList(), this.dao);
                calculaDesconto();
                JOptionPane.showMessageDialog(null, this.dao.gravar(this.orcamentoVenda));
                tabPesquisaOrcamentoVenda();
            } else if (this.situacaoAntiga.equals("Orçamento") && !this.viewOrcamentoVenda.getComboBoxTipo().getSelectedItem().equals("Orçamento")) {
                if (verificaEstoqueAlterarOV()) {
                    Utils.diminuirEstoqueOrcamentoVenda(this.orcamentoVenda.getItemorcamentovendaList(), this.dao);
                    calculaDesconto();
                    JOptionPane.showMessageDialog(null, this.dao.gravar(this.orcamentoVenda));
                    tabPesquisaOrcamentoVenda();
                }
            } else if (!this.viewOrcamentoVenda.getComboBoxTipo().getSelectedItem().equals("Orçamento")
                    && !this.viewOrcamentoVenda.getEdtCodigo().getText().equals("")) {
                Utils.diminuirEstoqueOrcamentoVenda(this.orcamentoVenda.getItemorcamentovendaList(), this.dao);
                calculaDesconto();
                JOptionPane.showMessageDialog(null, this.dao.gravar(this.orcamentoVenda));
                tabPesquisaOrcamentoVenda();
            } else {
                calculaDesconto();
                JOptionPane.showMessageDialog(null, this.dao.gravar(this.orcamentoVenda));
                tabPesquisaOrcamentoVenda();
            }
        }
    }

    public void visualizaRelatorio() {
        try {
            try {
                this.orcamentoVenda = (Orcamentovenda) this.tableModelOrcamentoVenda.getObjectAt(this.viewOrcamentoVenda.getTabelaOrcamentoVenda().getSelectedRow());
                String u = "/relatorio/relOrcamentoVenda.jasper";
                InputStream inputStream = getClass().getResourceAsStream(u);
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
                HashMap hm = new HashMap();
                hm.put("CODIGO", this.orcamentoVenda.getCodigo().toString());
                Utils.geraRelatorio(jasperReport, hm);
            } catch (JRException ex) {
                Logger.getLogger(ControllerOrcamentoVenda.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "É nescessário selecionar um Orçamento ou Venda!!!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "É nescessário selecionar um Orçamento ou Venda!!!");
        }
    }

    public boolean verificaEstoqueAlterarOV() {
        boolean aux = true;
        List<Produtoservico> ps = this.dao.pesquisar("Produtoservico.findAll");
        for (Itemorcamentovenda i : this.orcamentoVenda.getItemorcamentovendaList()) {
            for (Produtoservico p : ps) {
                if (i.getProdutoservico().equals(p) && p.getTipo().equals("Produto")
                        && i.getProdutoservico().getTipo().equals("Produto") && i.getQtde() > p.getQtdeEstoque()) {
                    JOptionPane.showMessageDialog(null, "Quantidade insuficiente para a Venda do produto  " + p.getNome() + "!!!");
                    aux = false;
                }
            }
        }
        return aux;
    }

    public void cancelarCadastro() {
        int x = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar?", "Atenção",
                JOptionPane.YES_OPTION,
                JOptionPane.CANCEL_OPTION);
        if ((x == JOptionPane.YES_OPTION)) {
            if (!situacaoAntiga.equals("Orçamento") && !this.viewOrcamentoVenda.getEdtCodigo().getText().equals("")) {
                Utils.diminuirEstoqueOrcamentoVenda(this.orcamentoVenda.getItemorcamentovendaList(), this.dao);
            }
            tabPesquisaOrcamentoVenda();
        }
    }
}