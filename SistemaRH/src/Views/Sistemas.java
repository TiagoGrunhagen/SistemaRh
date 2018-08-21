/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAO.AcessoDAO;
import DAO.SistemaDAO;
import Models.Acesso;
import Models.Funcionario;
import Models.Sistema;
import TableModels.AcessosTableModel;
import TableModels.FuncionariosSimplificadoTableModel;
import TableModels.SistemasTableModel;
import TableModels.TelaSistema;
import TableModels.TelaSistemaAutorização;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author admindpp
 */
public class Sistemas extends javax.swing.JFrame {

    TelaSistema TelaSistema = new TelaSistema();
    TelaSistemaAutorização Tela = new TelaSistemaAutorização();
    SistemasTableModel sistemasTableModel = new SistemasTableModel();
    AcessosTableModel acessosTableModel = new AcessosTableModel();
    SistemasTableModel autorizarSistemasTableModel = new SistemasTableModel();
    FuncionariosSimplificadoTableModel funcionariosSimplificadoTableModel = new FuncionariosSimplificadoTableModel();
 
    public Sistemas() {
       initComponents();
        tableSistemas.setModel(sistemasTableModel);
        autorizarSistemaTable.setModel(autorizarSistemasTableModel);
        autorizarFuncionarioTable.setModel(funcionariosSimplificadoTableModel);
        acessosTable.setModel(acessosTableModel);
        acessosTableModel.listar();
        sistemasTableModel.listar();
        autorizarSistemasTableModel.listar();
        funcionariosSimplificadoTableModel.listar();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        Sistema = new javax.swing.JTabbedPane();
        CriarSistema = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NomeSistema = new javax.swing.JTextField();
        Criar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSistemas = new javax.swing.JTable();
        btnExcluir = new javax.swing.JToggleButton();
        btnAtualizarSistema = new javax.swing.JToggleButton();
        btnAtualizarSistema1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inputCpfFuncionario = new javax.swing.JTextField();
        BuscarNoSistema = new javax.swing.JToggleButton();
        Adicionar = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        inputNomeSistema = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        autorizarSistemaTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        autorizarFuncionarioTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        acessosTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        Adicionar1 = new javax.swing.JToggleButton();
        Adicionar2 = new javax.swing.JToggleButton();
        Adicionar3 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Sistemas");

        jLabel2.setText("Nome do Sistema");

        NomeSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeSistemaActionPerformed(evt);
            }
        });

        Criar.setText("Criar");
        Criar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarActionPerformed(evt);
            }
        });

        tableSistemas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableSistemas);

        btnExcluir.setBackground(new java.awt.Color(255, 153, 153));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizarSistema.setText("Atualizar");
        btnAtualizarSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarSistemaActionPerformed(evt);
            }
        });

        btnAtualizarSistema1.setText("Recarregar Tabela");
        btnAtualizarSistema1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarSistema1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CriarSistemaLayout = new javax.swing.GroupLayout(CriarSistema);
        CriarSistema.setLayout(CriarSistemaLayout);
        CriarSistemaLayout.setHorizontalGroup(
            CriarSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CriarSistemaLayout.createSequentialGroup()
                .addGroup(CriarSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CriarSistemaLayout.createSequentialGroup()
                        .addGroup(CriarSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CriarSistemaLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel1)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CriarSistemaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29)))
                        .addGroup(CriarSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CriarSistemaLayout.createSequentialGroup()
                                .addGroup(CriarSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Criar)
                                    .addComponent(NomeSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 118, Short.MAX_VALUE))
                            .addComponent(btnAtualizarSistema, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(CriarSistemaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(CriarSistemaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAtualizarSistema1))
        );
        CriarSistemaLayout.setVerticalGroup(
            CriarSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CriarSistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CriarSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnAtualizarSistema))
                .addGap(34, 34, 34)
                .addGroup(CriarSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NomeSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Criar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(CriarSistemaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnAtualizarSistema1))
        );

        Sistema.addTab("Criar Sistema", CriarSistema);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Validação de Funcionario no Sistema");

        jLabel6.setText("CPF do Funcionario");

        inputCpfFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCpfFuncionarioActionPerformed(evt);
            }
        });

        BuscarNoSistema.setText("Buscar");
        BuscarNoSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarNoSistemaActionPerformed(evt);
            }
        });

        Adicionar.setText("Buscar");
        Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarActionPerformed(evt);
            }
        });

        jLabel5.setText("Nome do sistema");

        inputNomeSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNomeSistemaActionPerformed(evt);
            }
        });

        autorizarSistemaTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(autorizarSistemaTable);

        autorizarFuncionarioTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(autorizarFuncionarioTable);

        acessosTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(acessosTable);

        jLabel7.setText("Acessos Ativos");

        Adicionar1.setText("Remover Selecionada");
        Adicionar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Adicionar1ActionPerformed(evt);
            }
        });

        Adicionar2.setText("Adicionar");
        Adicionar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Adicionar2ActionPerformed(evt);
            }
        });

        Adicionar3.setText("Atualizar");
        Adicionar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Adicionar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(inputNomeSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Adicionar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputCpfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BuscarNoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Adicionar2)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Adicionar3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Adicionar1)))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(487, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Adicionar1)
                        .addComponent(Adicionar3))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputCpfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarNoSistema)
                            .addComponent(jLabel6))
                        .addGap(121, 121, 121)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Adicionar)
                            .addComponent(inputNomeSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(Adicionar2))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(125, 125, 125)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(210, Short.MAX_VALUE)))
        );

        Sistema.addTab("Acessos", jPanel1);

        jDesktopPane1.setLayer(Sistema, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Sistema, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(Sistema)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NomeSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeSistemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeSistemaActionPerformed

    private void CriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarActionPerformed
        Sistema sistema = new Sistema(NomeSistema.getText());
        SistemaDAO dao = new SistemaDAO();
        if (dao.inserir(sistema)){
            JOptionPane.showMessageDialog(null, "Sistema Inserido");
        }
        sistemasTableModel.listar();
        NomeSistema.setText("");
    }//GEN-LAST:event_CriarActionPerformed

    private void inputCpfFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCpfFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCpfFuncionarioActionPerformed

    private void inputNomeSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNomeSistemaActionPerformed

    }//GEN-LAST:event_inputNomeSistemaActionPerformed

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
        autorizarSistemasTableModel.listarFiltrado("%"+inputNomeSistema.getText()+"%");
    }//GEN-LAST:event_AdicionarActionPerformed

    private void BuscarNoSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarNoSistemaActionPerformed
        funcionariosSimplificadoTableModel.listarFiltrado("%"+inputCpfFuncionario.getText()+"%");
    }//GEN-LAST:event_BuscarNoSistemaActionPerformed

    private void Adicionar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Adicionar2ActionPerformed
        if (autorizarFuncionarioTable.getSelectedRow() == -1 || autorizarSistemaTable.getSelectedRow() == -1){
            return;
        }
        for (int i: autorizarFuncionarioTable.getSelectedRows()){
            Funcionario funcionario = new Funcionario();
            funcionario.setId((Integer) autorizarFuncionarioTable.getValueAt(i, 0));
            for (int j: autorizarSistemaTable.getSelectedRows()){
                Sistema sistema = new Sistema();
                sistema.setId((Integer) autorizarSistemaTable.getValueAt(j, 0));
                AcessoDAO dao = new AcessoDAO();
                dao.autorizar(funcionario, sistema);
            }
        }
        acessosTableModel.listar();
        JOptionPane.showMessageDialog(null, "Acessos liberados!");
    }//GEN-LAST:event_Adicionar2ActionPerformed

    private void Adicionar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Adicionar1ActionPerformed
        boolean success = false;
        for (int i: acessosTable.getSelectedRows()){
            Acesso acesso = new Acesso();
            acesso.setId((Integer) acessosTable.getValueAt(i, 0));
            AcessoDAO dao = new AcessoDAO();
            dao.desautorizar(acesso);
            success = true;
        }
        acessosTableModel.listar();
        if (success){
            JOptionPane.showMessageDialog(null, "Acessos revogados!");
        }
    }//GEN-LAST:event_Adicionar1ActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tableSistemas.getSelectedRow() != -1){
            int dialogResult = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse sistema?");
            if (dialogResult != 0){
                return;
            }
            Sistema sistema = new Sistema();
            sistema.setId((int) tableSistemas.getValueAt(tableSistemas.getSelectedRow(), 0));
            SistemaDAO dao = new SistemaDAO();
            if (dao.deletar(sistema)){
                JOptionPane.showMessageDialog(null, "Sistema excluido!");
                sistemasTableModel.listar();
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void Adicionar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Adicionar3ActionPerformed
        acessosTableModel.listar();
    }//GEN-LAST:event_Adicionar3ActionPerformed

    private void btnAtualizarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarSistemaActionPerformed
        if (tableSistemas.getSelectedRow() != -1){
            Sistema sistema = new Sistema();
            sistema.setId((int) tableSistemas.getValueAt(tableSistemas.getSelectedRow(), 0));
            sistema.setNome((String) tableSistemas.getValueAt(tableSistemas.getSelectedRow(), 1));
            AtualizarSistema telaAtualizarSistema = new AtualizarSistema(sistema);
            telaAtualizarSistema.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            telaAtualizarSistema.setVisible(true);
        }
    }//GEN-LAST:event_btnAtualizarSistemaActionPerformed

    private void btnAtualizarSistema1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarSistema1ActionPerformed
        sistemasTableModel.listar();
    }//GEN-LAST:event_btnAtualizarSistema1ActionPerformed

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
            java.util.logging.Logger.getLogger(Sistemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistemas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Adicionar;
    private javax.swing.JToggleButton Adicionar1;
    private javax.swing.JToggleButton Adicionar2;
    private javax.swing.JToggleButton Adicionar3;
    private javax.swing.JToggleButton BuscarNoSistema;
    private javax.swing.JToggleButton Criar;
    private javax.swing.JPanel CriarSistema;
    private javax.swing.JTextField NomeSistema;
    private javax.swing.JTabbedPane Sistema;
    private javax.swing.JTable acessosTable;
    private javax.swing.JTable autorizarFuncionarioTable;
    private javax.swing.JTable autorizarSistemaTable;
    private javax.swing.JToggleButton btnAtualizarSistema;
    private javax.swing.JToggleButton btnAtualizarSistema1;
    private javax.swing.JToggleButton btnExcluir;
    private javax.swing.JTextField inputCpfFuncionario;
    private javax.swing.JTextField inputNomeSistema;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tableSistemas;
    // End of variables declaration//GEN-END:variables
}
