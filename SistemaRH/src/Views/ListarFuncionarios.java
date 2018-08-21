/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAO.AnalistaDAO;
import DAO.DiretorDAO;
import DAO.FuncionarioDAO;
import DAO.GerenteDAO;
import DAO.LimpezaDAO;
import DAO.ProgramadorDAO;
import Models.Analista;
import Models.Diretor;
import Models.Funcionario;
import Models.Gerente;
import Models.Limpeza;
import Models.Programador;
import TableModels.ListaFuncionariosTableModel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author Jhonny
 */
public class ListarFuncionarios extends javax.swing.JFrame {

    ListaFuncionariosTableModel tableModel = new ListaFuncionariosTableModel();
    
    public ListarFuncionarios() {
        initComponents();
        tableFuncionarios.setModel(tableModel);
        tableModel.listar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableFuncionarios = new javax.swing.JTable();
        btnOrdenar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        comboOrdenacao = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JButton();
        comboCampo = new javax.swing.JComboBox<>();
        inputFiltro = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));

        tableFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableFuncionarios);

        btnOrdenar.setText("APLICAR ORDENAÇÃO");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNovo.setText("INSERIR");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        comboOrdenacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Salário Decrescente" }));
        comboOrdenacao.setToolTipText("");

        btnFiltrar.setText("APLICAR FILTRO");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        comboCampo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Nome", "Sobrenome", "RG", "CPF", "Cargo" }));

        btnAtualizar.setText("ATUALIZAR LISTA");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAtualizar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOrdenar)
                            .addComponent(comboOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFiltrar)
                            .addComponent(inputFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        if (comboCampo.getSelectedItem() == "Nenhum"){
            tableModel.listar();
        } else if (comboCampo.getSelectedItem() != "") {
            tableModel.listarFiltrado((String) comboCampo.getSelectedItem(), "%"+inputFiltro.getText()+"%");
        }
        
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        NovoFuncionario telaNovoFuncionario = new NovoFuncionario();
        telaNovoFuncionario.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        telaNovoFuncionario.setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tableFuncionarios.getSelectedRow() != -1){
            int dialogResult = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse funcionário?");
            if (dialogResult != 0){
                return;
            }
            if((tableFuncionarios.getValueAt(tableFuncionarios.getSelectedRow(), 7)).equals("Limpeza")){
                Limpeza limpeza = new Limpeza();
                LimpezaDAO dao = new LimpezaDAO();
                limpeza.setId((int) tableFuncionarios.getValueAt(tableFuncionarios.getSelectedRow(), 0));
                if (dao.deletar(limpeza)){
                    JOptionPane.showMessageDialog(null, "Funcionario excluido");
                }
                tableModel.listar();
            } else if((tableFuncionarios.getValueAt(tableFuncionarios.getSelectedRow(), 7)).equals("Programador")){
                Programador programador = new Programador();
                ProgramadorDAO dao = new ProgramadorDAO();
                programador.setId((int) tableFuncionarios.getValueAt(tableFuncionarios.getSelectedRow(), 0));
                if (dao.deletar(programador)){
                    JOptionPane.showMessageDialog(null, "Funcionario excluido");
                }
                tableModel.listar();
            } else if((tableFuncionarios.getValueAt(tableFuncionarios.getSelectedRow(), 7)).equals("Analista")){
                Analista analista = new Analista();
                AnalistaDAO dao = new AnalistaDAO();
                analista.setId((int) tableFuncionarios.getValueAt(tableFuncionarios.getSelectedRow(), 0));
                if (dao.deletar(analista)){
                    JOptionPane.showMessageDialog(null, "Funcionario excluido");
                }
                tableModel.listar();
            } else if((tableFuncionarios.getValueAt(tableFuncionarios.getSelectedRow(), 7)).equals("Gerente")){
                Gerente gerente = new Gerente();
                GerenteDAO dao = new GerenteDAO();
                gerente.setId((int) tableFuncionarios.getValueAt(tableFuncionarios.getSelectedRow(), 0));
                gerente.setCargoId(dao.getCargoId(gerente));
                if (dao.deletar(gerente)){
                    JOptionPane.showMessageDialog(null, "Funcionario excluido");
                }
                tableModel.listar();
            } else if((tableFuncionarios.getValueAt(tableFuncionarios.getSelectedRow(), 7)).equals("Diretor")){
                Diretor diretor = new Diretor();
                DiretorDAO dao = new DiretorDAO();
                diretor.setId((int) tableFuncionarios.getValueAt(tableFuncionarios.getSelectedRow(), 0));
                diretor.setCargoId(dao.getCargoId(diretor));
                if (dao.deletar(diretor)){
                    JOptionPane.showMessageDialog(null, "Funcionario excluido");
                }
                tableModel.listar();
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        inputFiltro.setText("");
        tableModel.listar();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tableFuncionarios.getSelectedRow() != -1){
            FuncionarioDAO dao = new FuncionarioDAO();
            int id = (int) tableFuncionarios.getValueAt(tableFuncionarios.getSelectedRow(), 0);
            Funcionario funcionario = dao.buscaFuncionario(id);
            EditaFuncionario telaEditaFuncionario = new EditaFuncionario(funcionario);
            telaEditaFuncionario.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            telaEditaFuncionario.setVisible(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        if (comboOrdenacao.getSelectedItem() == "Nenhum"){
            tableModel.listar();
        } else if (comboCampo.getSelectedItem() != "") {
            tableModel.listarOrdenado();
        }
    }//GEN-LAST:event_btnOrdenarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListarFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JComboBox<String> comboCampo;
    private javax.swing.JComboBox<String> comboOrdenacao;
    private javax.swing.JTextField inputFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableFuncionarios;
    // End of variables declaration//GEN-END:variables
}