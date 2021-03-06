package controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import tools.Utils;

public class ControllerEmitirRelatorioContasReceber {

    public void gerarRelatorio() {
        try {
            String u = "/relatorio/relConsReceber.jasper";
            InputStream inputStream = getClass().getResourceAsStream(u);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
            HashMap hm = new HashMap();
            Utils.geraRelatorio(jasperReport, hm);
        } catch (JRException ex) {
            Logger.getLogger(ControllerEmitirRelatorioContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
