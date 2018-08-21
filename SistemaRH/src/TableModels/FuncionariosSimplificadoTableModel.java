package TableModels;

import DAO.FuncionarioDAO;
import Models.Funcionario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class FuncionariosSimplificadoTableModel extends AbstractTableModel{
    
    private List<Funcionario> funcionarios = new ArrayList();
    private String[] colunas = {"#", "Nome", "Sobrenome", "CPF", "Cargo"};

    @Override
    public int getRowCount() {
        return funcionarios.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return funcionarios.get(rowIndex).getId();
            case 1:
                return funcionarios.get(rowIndex).getNome();
            case 2:
                return funcionarios.get(rowIndex).getSobrenome();
            case 3:
                return funcionarios.get(rowIndex).getCpf();
            case 4:
                return funcionarios.get(rowIndex).getCargo();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    public void listar(){
        FuncionarioDAO dao = new FuncionarioDAO();
        this.funcionarios = dao.listar();
        this.fireTableDataChanged();
    }
    
    public void listarFiltrado(String cpf){
        FuncionarioDAO dao = new FuncionarioDAO();
        this.funcionarios = dao.listarCpf(cpf);
        this.fireTableDataChanged();
    }
    
    
}
