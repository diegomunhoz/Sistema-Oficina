package tools;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 * Classe genérica responsável para preencher um JTable
 */

public  class ModeloTabela extends AbstractTableModel {

    private List<Object[]> listaValorTabela;
    private List<Object>  listaObjeto;
    private String[] nomeColuna;

    public ModeloTabela(List<Object[]> listaValorTabela, List  listaObjeto, String[] nomeColuna) {
        this.listaObjeto = listaObjeto;
        this.listaValorTabela = listaValorTabela;
        this.nomeColuna = nomeColuna;
    }

    public int getRowCount() {
        return this.listaValorTabela.size();
    }

    public int getColumnCount(){
        try {
            return this.listaValorTabela.get(0).length;
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Não há registro para ser exibido!!!");
            return 0;
        }
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.listaValorTabela.get(rowIndex)[columnIndex];
    }

    public Object  getObjectAt(int linhaSelecionada) {
        return this.listaObjeto.get(linhaSelecionada);
    }

    @Override
    public String getColumnName(int coluna) {
        return this.nomeColuna[coluna];
    }
}
