package view;

import com.toedter.calendar.JDateChooser;
import controller.ControllerEmitirRelatorioVenda;
import javax.swing.JComboBox;

public class frmEmitirRelatorioVenda extends javax.swing.JFrame {

    public frmEmitirRelatorioVenda() {
        initComponents();
        setExtendedState(frmFornecedor.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    ControllerEmitirRelatorioVenda controllerEmitirRelatorioVenda = new ControllerEmitirRelatorioVenda(frmEmitirRelatorioVenda.this);

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDado = new javax.swing.JPanel();
        btnVisualizarRelatorio1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dtInicio = new com.toedter.calendar.JDateChooser();
        dtFim = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        combOpcao = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("::..Emitir Relatório de Venda..::");

        btnVisualizarRelatorio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imprimir.png"))); // NOI18N
        btnVisualizarRelatorio1.setText("Visualizar Relatório");
        btnVisualizarRelatorio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarRelatorio1ActionPerformed(evt);
            }
        });

        jLabel1.setText("De:");

        jLabel2.setText("Até:");

        jLabel3.setText("Situação:");

        combOpcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione uma opção", "Paga", "Não Paga" }));

        javax.swing.GroupLayout panelDadoLayout = new javax.swing.GroupLayout(panelDado);
        panelDado.setLayout(panelDadoLayout);
        panelDadoLayout.setHorizontalGroup(
            panelDadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVisualizarRelatorio1)
                    .addGroup(panelDadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(combOpcao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dtFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dtInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                .addGap(276, 276, 276))
        );
        panelDadoLayout.setVerticalGroup(
            panelDadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(dtFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadoLayout.createSequentialGroup()
                        .addComponent(combOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVisualizarRelatorio1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDado, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JComboBox getCombOpcao() {
        return combOpcao;
    }

    public void setCombOpcao(JComboBox combOpcao) {
        this.combOpcao = combOpcao;
    }

    public JDateChooser getDtFim() {
        return dtFim;
    }

    public void setDtFim(JDateChooser dtFim) {
        this.dtFim = dtFim;
    }

    public JDateChooser getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(JDateChooser dtInicio) {
        this.dtInicio = dtInicio;
    }

    private void btnVisualizarRelatorio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarRelatorio1ActionPerformed
        this.controllerEmitirRelatorioVenda.gerarRelatório();
}//GEN-LAST:event_btnVisualizarRelatorio1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmEmitirRelatorioVenda().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVisualizarRelatorio1;
    private javax.swing.JComboBox combOpcao;
    private com.toedter.calendar.JDateChooser dtFim;
    private com.toedter.calendar.JDateChooser dtInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panelDado;
    // End of variables declaration//GEN-END:variables
}
