package TableModels;

import DAO.AcessoDAO;
import Models.Acesso;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AcessosTableModel extends AbstractTableModel{

    private List<Acesso> acessos = new ArrayList();
    private String[] colunas = {"#", "Funcionario", "Sistema"};

    @Override
    public int getRowCount() {
        return acessos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return acessos.get(rowIndex).getId();
            case 1:
                return acessos.get(rowIndex).getFuncionario().getNome();
            case 2:
                return acessos.get(rowIndex).getSistema().getNome();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    public void listar(){
        AcessoDAO dao = new AcessoDAO();
        this.acessos = dao.listar();
        this.fireTableDataChanged();
    }
    
}
