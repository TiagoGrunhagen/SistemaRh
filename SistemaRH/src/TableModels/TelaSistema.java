/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import Models.Sistema;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;

/**
 *
 * @author gabri
 */
public class TelaSistema extends AbstractTableModel{
        private String[] colunas=new String[]{"Nome Sistema"};

    private List<Sistema> lista=new ArrayList();

    
    public TelaSistema(List<Sistema> lista){
        this.lista=lista;
    }

    public TelaSistema(){
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
        //if(column==0)
            //return false;
        //return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sistema customer = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return customer.getNome();//if column 0 (code)
                 default : return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
           try {
            Sistema customer = lista.get(row);
            switch (col) {
                case 0:
                    customer.setNome((String) value); //if column 0 (code)
                default:
            }
            this.fireTableCellUpdated(row, col);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    public boolean removeContato(Sistema customer) {
        int linha = this.lista.indexOf(customer);
        boolean result = this.lista.remove(customer);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

    public void adicionaSistema(Sistema customer) {
        this.lista.add(customer);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    public void setListaSistema(List<Sistema> funcionarios) {
        this.lista = funcionarios;
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

    public Sistema getSistema(int linha){
        return lista.get(linha);
    }
    
}


