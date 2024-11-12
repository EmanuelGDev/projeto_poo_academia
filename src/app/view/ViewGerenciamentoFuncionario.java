/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.view;

import app.model.Funcionario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import app.controler.GerenciamentoFuncionario;
import javax.swing.JOptionPane;

/**
 *
 * @author manuc
 */
public class ViewGerenciamentoFuncionario extends javax.swing.JFrame {

    GerenciamentoFuncionario gf = new GerenciamentoFuncionario();
    
    /**
     * Creates new form GerenciamentoFuncionario
     */
    public ViewGerenciamentoFuncionario() {
        initComponents();
        addRowToJTable();
    }
    
    private void addRowToJTable(){
    DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
    
    ArrayList<Funcionario> list = gf.getListaDeFuncionarios();
    Object rowData[] = new Object[5];
    
        for(int i = 0; i< list.size(); i++){
            
            String aux = list.get(i).getCpf();
            
            rowData[0] = list.get(i).getName();
            rowData[1] = aux.substring(0, 4) + "XXXXXX";
            rowData[2] = list.get(i).getEmail();
            rowData[3] = list.get(i).getPassword();
            rowData[4] = list.get(i).getPosition();

            model.addRow(rowData);
        }
    }
    
    
    private void chamarAdicionarFuncionario(){
        
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        if(gf.verificarEmail(String.valueOf(fieldEmail.getText()))){
            
            JOptionPane.showMessageDialog(null, "Já existe um funcionario com esse email. Tente outro.");
        } 
        else{
            if(fieldCpf.getText().length() == 11){
                
                model.addRow(new Object[]{
                fieldNome.getText(),
                fieldCpf.getText(),
                fieldEmail.getText(), 
                "*".repeat(fieldSenha.getText().length()),
                fieldCargo.getText() 
                });

                gf.adicionarFuncionario(
                        fieldNome.getText(),
                        fieldCpf.getText(),
                        fieldEmail.getText(),
                        fieldSenha.getText(),
                        fieldCargo.getText() 
                        
                );
                
                JOptionPane.showMessageDialog(null, "Funcionario adicionado com sucesso!");
                
            }else{
                JOptionPane.showMessageDialog(null, "Digite o cpf sem pontos ou traços. O cpf precisa ter no minimo 11 caracteres!");
            }            
        }        
    }
     
    private void chamarEditarFuncionario(){
         
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();
        
        if(gf.verificarEmail(fieldEmail.getText())){
            JOptionPane.showMessageDialog(null, "Já existe um funcionario com esse email. Tente outro.");
        } 
        else{
            
            if(fieldCpf.getText().length() == 11){            
                
                gf.editarFuncionario(
                model.getValueAt(selectedRowIndex, 1).toString(),
                fieldNome.getText(),        
                fieldCpf.getText(), 
                fieldEmail.getText(),
                fieldSenha.getText(),       
                fieldCargo.getText()        
                );


                model.removeRow(selectedRowIndex);
                model.addRow(new Object[]{            
                    fieldNome.getText(),        
                    fieldCpf.getText(), 
                    fieldEmail.getText(),
                    fieldSenha.getText(),       
                    fieldCargo.getText() });
                
                    JOptionPane.showMessageDialog(null, "Funcionario editado com sucesso!");
                
            } else{
                JOptionPane.showMessageDialog(null, "Digite o cpf sem pontos ou traços. O cpf precisa ter no minimo 11 caracteres!");
            } 
        }
        
         
     }
    
    
    private void chamarRemoverFuncionario(){
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        try{
            
            int selectedRowIndex = jTable1.getSelectedRow();
            
            int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir esse funcionario?","Confirmação",JOptionPane.YES_NO_OPTION);
            
            if(confirmacao == JOptionPane.YES_OPTION){
            String email = model.getValueAt(selectedRowIndex, 1).toString();
            
            gf.excluirFuncionario(fieldEmail.getText());
            model.removeRow(selectedRowIndex);
            JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso!");
            } 
            else{
                JOptionPane.showMessageDialog(null, "Exclusão cancelada");
            }
           
            
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, "Selecione um funcionario para exlcuir");
        }}
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        labelNome = new javax.swing.JLabel();
        labelCpf = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        fieldCpf = new javax.swing.JTextField();
        fieldEmail = new javax.swing.JTextField();
        fieldCargo = new javax.swing.JTextField();
        adicionarFuncionario = new javax.swing.JButton();
        editarFuncionario = new javax.swing.JButton();
        removerFuncionario = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        salvarAlteracoes = new javax.swing.JButton();
        fieldSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 800));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Email", "Senha", "Cargo"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        labelNome.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelNome.setForeground(new java.awt.Color(51, 51, 51));
        labelNome.setText("NOME");

        labelCpf.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelCpf.setForeground(new java.awt.Color(51, 51, 51));
        labelCpf.setText("CPF");

        labelEmail.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(51, 51, 51));
        labelEmail.setText("E-MAIL");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("SENHA");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("CARGO");

        fieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNomeActionPerformed(evt);
            }
        });

        fieldCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCpfActionPerformed(evt);
            }
        });

        fieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldEmailActionPerformed(evt);
            }
        });

        fieldCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCargoActionPerformed(evt);
            }
        });

        adicionarFuncionario.setBackground(new java.awt.Color(153, 153, 153));
        adicionarFuncionario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        adicionarFuncionario.setForeground(new java.awt.Color(51, 51, 51));
        adicionarFuncionario.setText("Adicionar Funcionario");
        adicionarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarFuncionarioActionPerformed(evt);
            }
        });

        editarFuncionario.setBackground(new java.awt.Color(153, 153, 153));
        editarFuncionario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        editarFuncionario.setForeground(new java.awt.Color(51, 51, 51));
        editarFuncionario.setText("Editar Funcionario");
        editarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarFuncionarioActionPerformed(evt);
            }
        });

        removerFuncionario.setBackground(new java.awt.Color(153, 153, 153));
        removerFuncionario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        removerFuncionario.setForeground(new java.awt.Color(51, 51, 51));
        removerFuncionario.setText("Remover Funcionario");
        removerFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerFuncionarioActionPerformed(evt);
            }
        });

        voltar.setBackground(new java.awt.Color(255, 51, 51));
        voltar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        salvarAlteracoes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        salvarAlteracoes.setText("Salvar Alterações");
        salvarAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarAlteracoesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Funcionarios");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setText("Alterar Senha de Administrador");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adicionarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(labelNome))
                            .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(labelCpf)
                                .addGap(166, 166, 166)
                                .addComponent(labelEmail))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(fieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(307, 307, 307)
                                .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(254, 254, 254))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(50, 50, 50))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(voltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(216, 216, 216)
                .addComponent(salvarAlteracoes)
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(fieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(editarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(83, 83, 83)
                            .addComponent(removerFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(salvarAlteracoes)
                    .addComponent(voltar))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(labelCpf)
                    .addComponent(labelEmail)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adicionarFuncionario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(removerFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNomeActionPerformed

    private void fieldCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCpfActionPerformed

    private void fieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldEmailActionPerformed

    private void fieldCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCargoActionPerformed

    private void adicionarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarFuncionarioActionPerformed
        chamarAdicionarFuncionario();
    }//GEN-LAST:event_adicionarFuncionarioActionPerformed

    private void editarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarFuncionarioActionPerformed
        chamarEditarFuncionario();
    }//GEN-LAST:event_editarFuncionarioActionPerformed

    private void removerFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerFuncionarioActionPerformed
        chamarRemoverFuncionario();
    }//GEN-LAST:event_removerFuncionarioActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed

            this.dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();

        fieldNome.setText(model.getValueAt(selectedRowIndex, 0).toString());
        fieldCpf.setText(model.getValueAt(selectedRowIndex, 1).toString()); 
        fieldEmail.setText(model.getValueAt(selectedRowIndex, 2).toString());
        fieldSenha.setText(model.getValueAt(selectedRowIndex, 3).toString());
        fieldCargo.setText(model.getValueAt(selectedRowIndex, 4).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void salvarAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarAlteracoesActionPerformed
        gf.salvarFuncionariosNoArquivo();
        JOptionPane.showMessageDialog(null, "As alterações foram salvas");
    }//GEN-LAST:event_salvarAlteracoesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ViewSenhaAdm vsa = new ViewSenhaAdm();
        vsa.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciamentoFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewGerenciamentoFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarFuncionario;
    private javax.swing.JButton editarFuncionario;
    private javax.swing.JTextField fieldCargo;
    private javax.swing.JTextField fieldCpf;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JPasswordField fieldSenha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelNome;
    private javax.swing.JButton removerFuncionario;
    private javax.swing.JButton salvarAlteracoes;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
