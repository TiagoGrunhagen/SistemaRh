
package TableModels;

import Models.Sistema;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.Set;


public class TelaSistemaAutorização  extends AbstractTableModel{
        private String[] colunas=new String[]{"Nome Sistema", "Nome Funcionario", "CPF Funcionario"};

    private List<Models.Sistema> lista=new ArrayList();
    private List<Models.Funcionario> listar = new ArrayList();

    
    public TelaSistemaAutorização(List<Models.Sistema> lista, List<Models.Funcionario> listar){
        this.lista=lista;
        this.listar = listar;
     }

    public TelaSistemaAutorização(){
    }


    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
       
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Models.Sistema customer = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return customer.getNome();//if column 0 (code)
                 default : return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
           try {
            Models.Sistema customer = lista.get(row);
            Models.Funcionario list = listar.get(row);
            switch (col) {
                case 0:
                    customer.setNome((String) value); //if column 0 (code)
                    break;
                case 1:
                    list.setNome((String) value);
                    break;
                case 2:
                    list.setCpf((String) value);
                default:
            }
            this.fireTableCellUpdated(row, col);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    public boolean removeSistema(Models.Sistema customer) {
        int linha = this.lista.indexOf(customer);
        boolean result = this.lista.remove(customer);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

    public void adicionaSistema(Models.Sistema customer) {
        this.lista.add(customer);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    public void setListaSistema(List<Models.Sistema> sistema) {
        this.lista = sistema;
        this.fireTableDataChanged();
        //this.fireTableRowsInserted(0,contatos.size()-1);//update JTable
    }

    public void limpaTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }

    public Models.Sistema getSistema(int linha){
        return lista.get(linha);
    }
    
}

