package TableModels;

import DAO.FuncionarioDAO;
import Models.Funcionario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ListaFuncionariosTableModel extends AbstractTableModel{
    
    private List<Funcionario> funcionarios = new ArrayList();
    private String[] colunas = {"#", "Nome", "Sobrenome", "RG", "CPF", "Salario", "Nivel", "Cargo", "Departamento"};

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
                return funcionarios.get(rowIndex).getRg();
            case 4:
                return funcionarios.get(rowIndex).getCpf();
            case 5:
                return funcionarios.get(rowIndex).getSalario();
            case 6:
                return funcionarios.get(rowIndex).getNivel();
            case 7:
                return funcionarios.get(rowIndex).getCargo();
            case 8:
                return funcionarios.get(rowIndex).getDepartamento().getNome();
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
    
    public void listarOrdenado(){
        FuncionarioDAO dao = new FuncionarioDAO();
        this.funcionarios = dao.listar();
        Collections.sort(funcionarios);
        this.fireTableDataChanged();
    }
    
    public void listarFiltrado(String campo, String filtro){
        FuncionarioDAO dao = new FuncionarioDAO();
        this.funcionarios = dao.listarFiltrado(campo, filtro);
        this.fireTableDataChanged();
    }

}
