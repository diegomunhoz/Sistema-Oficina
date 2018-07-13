package controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import tools.Utils;
import view.frmEmitirRelatorioVenda;

public class ControllerEmitirRelatorioVenda {

    public ControllerEmitirRelatorioVenda(frmEmitirRelatorioVenda viewEmitirRelatorioVenda) {
        this.viewEmitirRelatorioVenda = viewEmitirRelatorioVenda;
    }
    private frmEmitirRelatorioVenda viewEmitirRelatorioVenda;

    public void gerarRelatório() {
        if (this.viewEmitirRelatorioVenda.getDtInicio().getDate() == null || this.viewEmitirRelatorioVenda.getDtFim().getDate() == null) {
            JOptionPane.showMessageDialog(null, "A data de início e fim deve ser preenchido!");
        } else if (this.viewEmitirRelatorioVenda.getDtInicio().getDate().after(this.viewEmitirRelatorioVenda.getDtFim().getDate())) {
            JOptionPane.showMessageDialog(null, "A data de início de ser menor ou igual a data de fim!");
        } else if (this.viewEmitirRelatorioVenda.getCombOpcao().getSelectedItem().equals("Selecione uma opção")) {
            JOptionPane.showMessageDialog(null, "É nescessário escolher uma opção!");
        } else {
            try {
                String u = "/relatorio/relVenda.jasper";
                InputStream inputStream = getClass().getResourceAsStream(u);
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
                HashMap hm = new HashMap();
                hm.put("SITUACAO", this.viewEmitirRelatorioVenda.getCombOpcao().getSelectedItem());
                hm.put("DT_INICIO", this.viewEmitirRelatorioVenda.getDtInicio().getDate());
                hm.put("DT_FIM", this.viewEmitirRelatorioVenda.getDtFim().getDate());
                Utils.geraRelatorio(jasperReport, hm);
            } catch (JRException ex) {
                Logger.getLogger(ControllerEmitirRelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}