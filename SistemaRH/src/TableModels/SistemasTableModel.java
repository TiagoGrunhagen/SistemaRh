package TableModels;

import DAO.SistemaDAO;
import Models.Sistema;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SistemasTableModel extends AbstractTableModel{
    
    private List<Sistema> sistemas = new ArrayList();
    private String[] colunas = {"#", "Nome"};

    @Override
    public int getRowCount() {
        return sistemas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return sistemas.get(rowIndex).getId();
            case 1:
                return sistemas.get(rowIndex).getNome();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    public void listar(){
        SistemaDAO dao = new SistemaDAO();
        this.sistemas = dao.listar();
        this.fireTableDataChanged();
    }
    
    public void listarFiltrado(String nome){
        SistemaDAO dao = new SistemaDAO();
        this.sistemas = dao.listarFiltrado(nome);
        this.fireTableDataChanged();
    }
}
