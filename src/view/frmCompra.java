package view;

import com.toedter.calendar.JDateChooser;
import controller.ControllerCompra;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class frmCompra extends javax.swing.JFrame {

    public frmCompra() {
        initComponents();
        setExtendedState(frmCompra.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    ControllerCompra controllerCompra = new ControllerCompra(frmCompra.this);

    public JTable getTabelaCompra() {
        return tabelaCompra;
    }

    public void setTabelaCompra(JTable tabelaCompra) {
        this.tabelaCompra = tabelaCompra;
    }

    public JTextField getEdtPesquisa() {
        return edtPesquisa;
    }

    public void setEdtPesquisa(JTextField edtPesquisa) {
        this.edtPesquisa = edtPesquisa;
    }

    public JComboBox getComboBoxFornecedor() {
        return comboBoxFornecedor;
    }

    public void setComboBoxFornecedor(JComboBox comboBoxFornecedor) {
        this.comboBoxFornecedor = comboBoxFornecedor;
    }

    public JDateChooser getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(JDateChooser dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public JLabel getLblVencimento() {
        return lblVencimento;
    }

    public void setLblVencimento(JLabel lblVencimento) {
        this.lblVencimento = lblVencimento;
    }

    public JComboBox getComboBoxTipo() {
        return comboBoxTipo;
    }

    public void setComboBoxTipo(JComboBox comboBoxTipo) {
        this.comboBoxTipo = comboBoxTipo;
    }

    public JTextField getEdtCodigo() {
        return edtCodigo;
    }

    public void setEdtCodigo(JTextField edtCodigo) {
        this.edtCodigo = edtCodigo;
    }

    public JDateChooser getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(JDateChooser dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public JTabbedPane getTabulacao() {
        return tabulacao;
    }

    public void setTabulacao(JTabbedPane tabulacao) {
        this.tabulacao = tabulacao;
    }

    public JTable getTabelaItens() {
        return tabelaItens;
    }

    public void setTabelaItens(JTable tabelaItens) {
        this.tabelaItens = tabelaItens;
    }

    public JTextField getEdtPesquisaProduto() {
        return edtPesquisaProduto;
    }

    public void setEdtPesquisaProduto(JTextField edtPesquisaProduto) {
        this.edtPesquisaProduto = edtPesquisaProduto;
    }

    public JFormattedTextField getEdtQtde() {
        return edtQtde;
    }

    public void setEdtQtde(JFormattedTextField edtQtde) {
        this.edtQtde = edtQtde;
    }

    public JDialog getDialogBuscaProduto() {
        return dialogBuscaProduto;
    }

    public void setDialogBuscaProduto(JDialog dialogBuscaProduto) {
        this.dialogBuscaProduto = dialogBuscaProduto;
    }

    public JDialog getDialogQtde() {
        return dialogQtde;
    }

    public void setDialogQtde(JDialog dialogQtde) {
        this.dialogQtde = dialogQtde;
    }

    public JTable getTabelaProduto() {
        return tabelaProduto;
    }

    public void setTabelaProduto(JTable tabelaProduto) {
        this.tabelaProduto = tabelaProduto;
    }

    public JFormattedTextField getEdtValorTotal() {
        return edtValorTotal;
    }

    public void setEdtValorTotal(JFormattedTextField edtValorTotal) {
        this.edtValorTotal = edtValorTotal;
    }

    public JFormattedTextField getEdtValorCusto() {
        return edtValorCusto;
    }

    public void setEdtValorCusto(JFormattedTextField edtValorCusto) {
        this.edtValorCusto = edtValorCusto;
    }

    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogBuscaProduto = new javax.swing.JDialog();
        painelConsulta1 = new javax.swing.JPanel();
        PainelTabela1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        btIncluir = new javax.swing.JButton();
        dialogQtde = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        edtQtde = new javax.swing.JFormattedTextField();
        btConfirma = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        edtValorCusto = new javax.swing.JFormattedTextField();
        tabulacao = new javax.swing.JTabbedPane();
        jPanelConsulta = new javax.swing.JPanel();
        painelConsulta = new javax.swing.JPanel();
        PainelTabela = new javax.swing.JScrollPane();
        tabelaCompra = new javax.swing.JTable();
        edtPesquisa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        btnVisualizarRelatorio = new javax.swing.JButton();
        painelBotoesConsulta = new javax.swing.JPanel();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jPanelDados = new javax.swing.JPanel();
        painelCadastro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblVencimento = new javax.swing.JLabel();
        dataRegistro = new com.toedter.calendar.JDateChooser();
        dataVencimento = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        comboBoxFornecedor = new javax.swing.JComboBox();
        painelBotoesCadastro = new javax.swing.JPanel();
        btnInserirProduto = new javax.swing.JButton();
        btnCancelar2 = new javax.swing.JButton();
        comboBoxTipo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jPanelItensOrcamentoVenda = new javax.swing.JPanel();
        painelTabela = new javax.swing.JPanel();
        PainelConsultaItens = new javax.swing.JScrollPane();
        tabelaItens = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        edtValorTotal = new javax.swing.JFormattedTextField();
        btPesquisarProduto = new javax.swing.JButton();
        btRemoverItem = new javax.swing.JButton();
        painelBotoesCadastro1 = new javax.swing.JPanel();
        btnCancelar1 = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        edtPesquisaProduto = new javax.swing.JTextField();

        dialogBuscaProduto.setTitle("::..Consulta de Produtos e Serviços..::");
        dialogBuscaProduto.setBounds(new java.awt.Rectangle(600, 400, 650, 260));
        dialogBuscaProduto.setModal(true);
        dialogBuscaProduto.setResizable(false);

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        PainelTabela1.setViewportView(tabelaProduto);

        btIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/incluir.png"))); // NOI18N
        btIncluir.setText("Inserir");
        btIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelConsulta1Layout = new javax.swing.GroupLayout(painelConsulta1);
        painelConsulta1.setLayout(painelConsulta1Layout);
        painelConsulta1Layout.setHorizontalGroup(
            painelConsulta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsulta1Layout.createSequentialGroup()
                .addGroup(painelConsulta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelConsulta1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PainelTabela1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE))
                    .addGroup(painelConsulta1Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(btIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painelConsulta1Layout.setVerticalGroup(
            painelConsulta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelConsulta1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelTabela1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout dialogBuscaProdutoLayout = new javax.swing.GroupLayout(dialogBuscaProduto.getContentPane());
        dialogBuscaProduto.getContentPane().setLayout(dialogBuscaProdutoLayout);
        dialogBuscaProdutoLayout.setHorizontalGroup(
            dialogBuscaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(dialogBuscaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dialogBuscaProdutoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painelConsulta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        dialogBuscaProdutoLayout.setVerticalGroup(
            dialogBuscaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
            .addGap(0, 259, Short.MAX_VALUE)
            .addGroup(dialogBuscaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dialogBuscaProdutoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painelConsulta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        dialogQtde.setTitle("::..Consulta de Produtos e Serviços..::");
        dialogQtde.setBounds(new java.awt.Rectangle(600, 400, 465, 150));
        dialogQtde.setModal(true);
        dialogQtde.setResizable(false);

        jLabel2.setText("Qtde:");

        edtQtde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtQtdeActionPerformed(evt);
            }
        });

        btConfirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ok.png"))); // NOI18N
        btConfirma.setText("Confirma");
        btConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmaActionPerformed(evt);
            }
        });

        jLabel4.setText("Valor Custo:");

        edtValorCusto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        edtValorCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtValorCustoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogQtdeLayout = new javax.swing.GroupLayout(dialogQtde.getContentPane());
        dialogQtde.getContentPane().setLayout(dialogQtdeLayout);
        dialogQtdeLayout.setHorizontalGroup(
            dialogQtdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogQtdeLayout.createSequentialGroup()
                .addGroup(dialogQtdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogQtdeLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(btConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogQtdeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dialogQtdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dialogQtdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialogQtdeLayout.setVerticalGroup(
            dialogQtdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogQtdeLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(dialogQtdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogQtdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(edtValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(btConfirma)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("::..Cadastro de Compra..::");
        setAlwaysOnTop(true);

        tabulacao.setEnabled(false);
        tabulacao.setFont(new java.awt.Font("Arial", 3, 12));

        tabelaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        PainelTabela.setViewportView(tabelaCompra);

        jLabel10.setText("Nome do Fornecedor:");

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisar.png"))); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        btnVisualizarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imprimir.png"))); // NOI18N
        btnVisualizarRelatorio.setText("Visualizar Relatório");
        btnVisualizarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelConsultaLayout = new javax.swing.GroupLayout(painelConsulta);
        painelConsulta.setLayout(painelConsultaLayout);
        painelConsultaLayout.setHorizontalGroup(
            painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelConsultaLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVisualizarRelatorio))
                    .addComponent(PainelTabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelConsultaLayout.setVerticalGroup(
            painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edtPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVisualizarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PainelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/database_delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/database_add.png"))); // NOI18N
        btnNovo.setText("Cadastrar Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/database_edit.png"))); // NOI18N
        btnAlterar.setText("Exibir / Alterar Dados");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelBotoesConsultaLayout = new javax.swing.GroupLayout(painelBotoesConsulta);
        painelBotoesConsulta.setLayout(painelBotoesConsultaLayout);
        painelBotoesConsultaLayout.setHorizontalGroup(
            painelBotoesConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesConsultaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelBotoesConsultaLayout.setVerticalGroup(
            painelBotoesConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelBotoesConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnNovo)
                    .addComponent(btnAlterar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelConsultaLayout = new javax.swing.GroupLayout(jPanelConsulta);
        jPanelConsulta.setLayout(jPanelConsultaLayout);
        jPanelConsultaLayout.setHorizontalGroup(
            jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelConsulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelBotoesConsulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelConsultaLayout.setVerticalGroup(
            jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelBotoesConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabulacao.addTab("Consultar Compra", jPanelConsulta);

        jLabel1.setText("Código (Gerado pelo Sistema):");

        edtCodigo.setEditable(false);
        edtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setText("Data do Registro:");

        lblVencimento.setText("Data do Vencimento:");

        jLabel9.setText("Fornecedor:");

        btnInserirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/seta_avançar.png"))); // NOI18N
        btnInserirProduto.setText("Visualizar Itens de Produto");
        btnInserirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirProdutoActionPerformed(evt);
            }
        });

        btnCancelar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancel.png"))); // NOI18N
        btnCancelar2.setText("Cancelar");
        btnCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelBotoesCadastroLayout = new javax.swing.GroupLayout(painelBotoesCadastro);
        painelBotoesCadastro.setLayout(painelBotoesCadastroLayout);
        painelBotoesCadastroLayout.setHorizontalGroup(
            painelBotoesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesCadastroLayout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(btnCancelar2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addGap(223, 223, 223))
            .addGroup(painelBotoesCadastroLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(btnInserirProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addGap(189, 189, 189))
        );
        painelBotoesCadastroLayout.setVerticalGroup(
            painelBotoesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelBotoesCadastroLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(btnInserirProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar2)
                .addContainerGap())
        );

        comboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o tipo de cadastro", "Compra a Vista", "Compra a Prazo" }));
        comboBoxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxTipoItemStateChanged(evt);
            }
        });

        jLabel6.setText("Tipo do Cadastro:");

        javax.swing.GroupLayout painelCadastroLayout = new javax.swing.GroupLayout(painelCadastro);
        painelCadastro.setLayout(painelCadastroLayout);
        painelCadastroLayout.setHorizontalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCadastroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(10, 10, 10)
                                .addComponent(edtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(305, 305, 305))
                            .addComponent(painelBotoesCadastro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(painelCadastroLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(10, 10, 10)
                                .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(10, 10, 10)
                                .addComponent(dataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblVencimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelCadastroLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel9)
                        .addGap(10, 10, 10)
                        .addComponent(comboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painelCadastroLayout.setVerticalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(dataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVencimento)
                    .addComponent(dataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(comboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(painelBotoesCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelDadosLayout = new javax.swing.GroupLayout(jPanelDados);
        jPanelDados.setLayout(jPanelDadosLayout);
        jPanelDadosLayout.setHorizontalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelDadosLayout.setVerticalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tabulacao.addTab("Dados da Compra", jPanelDados);

        tabelaItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaItens.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        PainelConsultaItens.setViewportView(tabelaItens);

        jLabel7.setText("Valor Total:");

        edtValorTotal.setEnabled(false);

        javax.swing.GroupLayout painelTabelaLayout = new javax.swing.GroupLayout(painelTabela);
        painelTabela.setLayout(painelTabelaLayout);
        painelTabelaLayout.setHorizontalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTabelaLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PainelConsultaItens, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelTabelaLayout.setVerticalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelConsultaItens, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edtValorTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btPesquisarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisar.png"))); // NOI18N
        btPesquisarProduto.setText("Escolher Produto");
        btPesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarProdutoActionPerformed(evt);
            }
        });

        btRemoverItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/database_delete.png"))); // NOI18N
        btRemoverItem.setText("Remover Item");
        btRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverItemActionPerformed(evt);
            }
        });

        btnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancel.png"))); // NOI18N
        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        btnGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/database_save.png"))); // NOI18N
        btnGravar.setText("Gravar Registro");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelBotoesCadastro1Layout = new javax.swing.GroupLayout(painelBotoesCadastro1);
        painelBotoesCadastro1.setLayout(painelBotoesCadastro1Layout);
        painelBotoesCadastro1Layout.setHorizontalGroup(
            painelBotoesCadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesCadastro1Layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGravar, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelBotoesCadastro1Layout.setVerticalGroup(
            painelBotoesCadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelBotoesCadastro1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelBotoesCadastro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar1)
                    .addComponent(btnGravar))
                .addContainerGap())
        );

        jLabel12.setText("Descrição:");

        javax.swing.GroupLayout jPanelItensOrcamentoVendaLayout = new javax.swing.GroupLayout(jPanelItensOrcamentoVenda);
        jPanelItensOrcamentoVenda.setLayout(jPanelItensOrcamentoVendaLayout);
        jPanelItensOrcamentoVendaLayout.setHorizontalGroup(
            jPanelItensOrcamentoVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItensOrcamentoVendaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtPesquisaProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanelItensOrcamentoVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelItensOrcamentoVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelItensOrcamentoVendaLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(painelBotoesCadastro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(15, 15, 15)))
        );
        jPanelItensOrcamentoVendaLayout.setVerticalGroup(
            jPanelItensOrcamentoVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItensOrcamentoVendaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelItensOrcamentoVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edtPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisarProduto)
                    .addComponent(jLabel12)
                    .addComponent(btRemoverItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(jPanelItensOrcamentoVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelItensOrcamentoVendaLayout.createSequentialGroup()
                    .addContainerGap(263, Short.MAX_VALUE)
                    .addComponent(painelBotoesCadastro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        tabulacao.addTab("Itens de Produto", jPanelItensOrcamentoVenda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabulacao, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        this.controllerCompra.pesquisarPorParametroOrcamentoVenda();
}//GEN-LAST:event_btPesquisarActionPerformed

    private void btnVisualizarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarRelatorioActionPerformed
        this.controllerCompra.visualizaRelatorio();
}//GEN-LAST:event_btnVisualizarRelatorioActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
             this.controllerCompra.excluirCompra();
}//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
             this.controllerCompra.cadastroNovaCompra();
}//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
             this.controllerCompra.alterarCompra();
}//GEN-LAST:event_btnAlterarActionPerformed

    private void btnInserirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirProdutoActionPerformed
         this.controllerCompra.guadarCadastroCompra();
}//GEN-LAST:event_btnInserirProdutoActionPerformed

    private void btnCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar2ActionPerformed
            this.controllerCompra.cancelarCadastro();
}//GEN-LAST:event_btnCancelar2ActionPerformed

    private void btPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarProdutoActionPerformed
                this.controllerCompra.montarTabelaBuscaProdutoPesquisaPorParamentro();
}//GEN-LAST:event_btPesquisarProdutoActionPerformed

    private void btRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverItemActionPerformed
            this.controllerCompra.removerItem();
}//GEN-LAST:event_btRemoverItemActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
            this.controllerCompra.cancelarCadastro();
}//GEN-LAST:event_btnCancelar1ActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
             this.controllerCompra.gravarCadastro();
}//GEN-LAST:event_btnGravarActionPerformed

    private void comboBoxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxTipoItemStateChanged
        this.controllerCompra.verificarTipoCadastroCompra();
}//GEN-LAST:event_comboBoxTipoItemStateChanged

    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirActionPerformed
        this.controllerCompra.escolherQtde();
}//GEN-LAST:event_btIncluirActionPerformed

    private void edtQtdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtQtdeActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_edtQtdeActionPerformed

    private void btConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmaActionPerformed
        this.controllerCompra.incluirProdutoServico();
}//GEN-LAST:event_btConfirmaActionPerformed

    private void edtValorCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtValorCustoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtValorCustoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmCompra().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane PainelConsultaItens;
    private javax.swing.JScrollPane PainelTabela;
    private javax.swing.JScrollPane PainelTabela1;
    private javax.swing.JButton btConfirma;
    private javax.swing.JButton btIncluir;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btPesquisarProduto;
    private javax.swing.JButton btRemoverItem;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnCancelar2;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnInserirProduto;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnVisualizarRelatorio;
    private javax.swing.JComboBox comboBoxFornecedor;
    private javax.swing.JComboBox comboBoxTipo;
    private com.toedter.calendar.JDateChooser dataRegistro;
    private com.toedter.calendar.JDateChooser dataVencimento;
    private javax.swing.JDialog dialogBuscaProduto;
    private javax.swing.JDialog dialogQtde;
    private javax.swing.JTextField edtCodigo;
    private javax.swing.JTextField edtPesquisa;
    private javax.swing.JTextField edtPesquisaProduto;
    private javax.swing.JFormattedTextField edtQtde;
    private javax.swing.JFormattedTextField edtValorCusto;
    private javax.swing.JFormattedTextField edtValorTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelConsulta;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JPanel jPanelItensOrcamentoVenda;
    private javax.swing.JLabel lblVencimento;
    private javax.swing.JPanel painelBotoesCadastro;
    private javax.swing.JPanel painelBotoesCadastro1;
    private javax.swing.JPanel painelBotoesConsulta;
    private javax.swing.JPanel painelCadastro;
    private javax.swing.JPanel painelConsulta;
    private javax.swing.JPanel painelConsulta1;
    private javax.swing.JPanel painelTabela;
    private javax.swing.JTable tabelaCompra;
    private javax.swing.JTable tabelaItens;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JTabbedPane tabulacao;
    // End of variables declaration//GEN-END:variables
}
