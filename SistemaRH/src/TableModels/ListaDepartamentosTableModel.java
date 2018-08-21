package TableModels;

import DAO.DepartamentoDAO;
import Models.Departamento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ListaDepartamentosTableModel extends AbstractTableModel{
    
    private List<Departamento> departamentos = new ArrayList();
    private String[] colunas = {"#", "Nome"};

    @Override
    public int getRowCount() {
        return departamentos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return departamentos.get(rowIndex).getId();
            case 1:
                return departamentos.get(rowIndex).getNome();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    public void listar(){
        DepartamentoDAO dao = new DepartamentoDAO();
        this.departamentos = dao.listar();
        this.fireTableDataChanged();
    }
    
    public Departamento buscaDepartamento(int rowIndex){
        int id = (int) this.getValueAt(rowIndex, 0);
        String nome = (String) this.getValueAt(rowIndex, 1);
        Departamento departamento = new Departamento(id, nome);
        return departamento;
    }

}
