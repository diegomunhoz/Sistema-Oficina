package view;

import controller.ControllerUsuario;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class frmUsuario extends javax.swing.JFrame {

    public frmUsuario() {
        initComponents();
        setExtendedState(frmUsuario.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    ControllerUsuario controllerUsuario = new ControllerUsuario(frmUsuario.this);

    public JTextField getEdtCodigo() {
        return edtCodigo;
    }

    public void setEdtCodigo(JTextField edtCodigo) {
        this.edtCodigo = edtCodigo;
    }

    public JTextField getEdtLogin() {
        return edtLogin;
    }

    public void setEdtLogin(JTextField edtLogin) {
        this.edtLogin = edtLogin;
    }

    public JTextField getEdtNome() {
        return edtNome;
    }

    public void setEdtNome(JTextField edtNome) {
        this.edtNome = edtNome;
    }

    public JTextField getEdtPesquisa() {
        return edtPesquisa;
    }

    public void setEdtPesquisa(JTextField edtPesquisa) {
        this.edtPesquisa = edtPesquisa;
    }

    public JPasswordField getEdtSenha() {
        return edtSenha;
    }

    public void setEdtSenha(JPasswordField edtSenha) {
        this.edtSenha = edtSenha;
    }

    public JTable getTabelaUsuario() {
        return tabelaUsuario;
    }

    public void setTabelaUsuario(JTable tabelaUsuario) {
        this.tabelaUsuario = tabelaUsuario;
    }

    public JTabbedPane getTabulacao() {
        return tabulacao;
    }

    public void setTabulacao(JTabbedPane tabulacao) {
        this.tabulacao = tabulacao;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabulacao = new javax.swing.JTabbedPane();
        jPanelConsulta = new javax.swing.JPanel();
        painelConsulta = new javax.swing.JPanel();
        PainelTabela = new javax.swing.JScrollPane();
        tabelaUsuario = new javax.swing.JTable();
        edtPesquisa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        painelBotoesConsulta = new javax.swing.JPanel();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jPanelDados = new javax.swing.JPanel();
        painelBotoesCadastro = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        painelCadastro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        edtLogin = new javax.swing.JTextField();
        edtSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("::..Cadastro de Usuário..::");
        setAlwaysOnTop(true);

        tabulacao.setEnabled(false);
        tabulacao.setFont(new java.awt.Font("Arial", 3, 12));

        tabelaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaUsuario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        PainelTabela.setViewportView(tabelaUsuario);

        jLabel10.setText("Nome do Usuário:");

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisar.png"))); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelConsultaLayout = new javax.swing.GroupLayout(painelConsulta);
        painelConsulta.setLayout(painelConsultaLayout);
        painelConsultaLayout.setHorizontalGroup(
            painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPesquisar)
                .addContainerGap(263, Short.MAX_VALUE))
            .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelConsultaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PainelTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        painelConsultaLayout.setVerticalGroup(
            painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edtPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(233, Short.MAX_VALUE))
            .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelConsultaLayout.createSequentialGroup()
                    .addContainerGap(34, Short.MAX_VALUE)
                    .addComponent(PainelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
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

        tabulacao.addTab("Consultar Usuário", jPanelConsulta);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/database_save.png"))); // NOI18N
        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelBotoesCadastroLayout = new javax.swing.GroupLayout(painelBotoesCadastro);
        painelBotoesCadastro.setLayout(painelBotoesCadastroLayout);
        painelBotoesCadastroLayout.setHorizontalGroup(
            painelBotoesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesCadastroLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        painelBotoesCadastroLayout.setVerticalGroup(
            painelBotoesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelBotoesCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnCancelar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel1.setText("Código (Gerado pelo Sistema):");

        edtCodigo.setEditable(false);
        edtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setText("Nome:");

        jLabel3.setText("Senha:");

        jLabel4.setText("Login:");

        javax.swing.GroupLayout painelCadastroLayout = new javax.swing.GroupLayout(painelCadastro);
        painelCadastro.setLayout(painelCadastroLayout);
        painelCadastroLayout.setHorizontalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edtCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
                .addContainerGap(119, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCadastroLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                    .addGroup(painelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))
                .addGap(218, 218, 218))
        );
        painelCadastroLayout.setVerticalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edtLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edtSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelDadosLayout = new javax.swing.GroupLayout(jPanelDados);
        jPanelDados.setLayout(jPanelDadosLayout);
        jPanelDadosLayout.setHorizontalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelBotoesCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelCadastro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelDadosLayout.setVerticalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(painelBotoesCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabulacao.addTab("Dados do Usuário", jPanelDados);

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
                .addComponent(tabulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabulacao.getAccessibleContext().setAccessibleName("Consultar Usuário");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        this.controllerUsuario.pesquisarPorParametro();
}//GEN-LAST:event_btPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        this.controllerUsuario.excluirUsuario();
}//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.controllerUsuario.cadastrarNovoUsuario();
}//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        this.controllerUsuario.alterarUsuario();
}//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.controllerUsuario.tabPesquisa();
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        this.controllerUsuario.gravarUsuario();
}//GEN-LAST:event_btnGravarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmUsuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane PainelTabela;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JTextField edtCodigo;
    private javax.swing.JTextField edtLogin;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtPesquisa;
    private javax.swing.JPasswordField edtSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelConsulta;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JPanel painelBotoesCadastro;
    private javax.swing.JPanel painelBotoesConsulta;
    private javax.swing.JPanel painelCadastro;
    private javax.swing.JPanel painelConsulta;
    private javax.swing.JTable tabelaUsuario;
    private javax.swing.JTabbedPane tabulacao;
    // End of variables declaration//GEN-END:variables
}
