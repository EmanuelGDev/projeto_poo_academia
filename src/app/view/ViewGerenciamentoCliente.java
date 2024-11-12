/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.view;

import app.controler.GerenciamentoCliente;
import app.model.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manuc
 */
public class ViewGerenciamentoCliente extends javax.swing.JFrame {
    
    GerenciamentoCliente gc = new GerenciamentoCliente();

    /**
     * Creates new form ViewGerenciamentoCliente
     */
    public ViewGerenciamentoCliente() {
        initComponents();
        addRowToJTable();
    }
    
    public void addRowToJTable(){
    DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
    
    ArrayList<Cliente> list = gc.getListaDeClientes();
    Object rowData[] = new Object[6];
    
        for(int i = 0; i< list.size(); i++){
            
            String aux = list.get(i).getCpf();
            
            rowData[0] = list.get(i).getName();
            rowData[1] = list.get(i).getEmail();
            rowData[2] = aux.substring(0, 4) + "XXXXXX";
            rowData[3] = list.get(i).getCartao();
            rowData[4] = list.get(i).getFone();
            rowData[5] = list.get(i).getEndereco();


            model.addRow(rowData);
        }
    }
    
    public void chamarAdicionarCliente(){
        
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        if(gc.verificarEmail(fieldEmail.getText())){
            
            JOptionPane.showMessageDialog(null, "Já existe um cliente com esse email. Tente outro.");
        } 
        else{
            if(fieldCpf.getText().length() == 11){
                
                model.addRow(new Object[]{
                fieldNome.getText(),
                fieldEmail.getText(),
                fieldCpf.getText(),
                fieldCartao.getText(),
                fieldTelefone.getText(),
                fieldEndereco.getText()
                 
 
                });

                gc.adicionarCliente(
                        fieldNome.getText(), 
                        fieldEmail.getText(),
                        fieldCpf.getText(), 
                        fieldCartao.getText(), 
                        fieldTelefone.getText(), 
                        fieldEndereco.getText()
                        
                );
                
                JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
                
            }else{
                JOptionPane.showMessageDialog(null, "Digite o cpf sem pontos ou traços. O cpf precisa ter no minimo 11 caracteres!");
            }            
        }        
    }
    
    public void chamarRemoverCliente(){
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        try{
            
            int selectedRowIndex = jTable1.getSelectedRow();
            
            int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir esse cliente?","Confirmação",JOptionPane.YES_NO_OPTION);
            
            if(confirmacao == JOptionPane.YES_OPTION){
            String email = model.getValueAt(selectedRowIndex, 1).toString();
            
            gc.excluirCliente(fieldEmail.getText());
            model.removeRow(selectedRowIndex);
            JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
            } 
            else{
                JOptionPane.showMessageDialog(null, "Exclusão cancelada");
            }
           
            
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, "Selecione um cliente para exlcuir");
        }
    }
    
    public void chamarEditarCliente(){
        
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();
        
        if(gc.verificarEmail(fieldEmail.getText())){
            JOptionPane.showMessageDialog(null, "Já existe um cliente com esse email. Tente outro.");
        } 
        else{
            
            if(fieldCpf.getText().length() == 11){            
                
                gc.editarCliente(
                model.getValueAt(selectedRowIndex, 1).toString(),
                fieldNome.getText(),
                fieldEmail.getText(),
                fieldCpf.getText(),
                fieldCartao.getText(),
                fieldTelefone.getText(),
                fieldEndereco.getText()
        
                );


                model.removeRow(selectedRowIndex);
                    model.addRow(new Object[]{            
                        fieldNome.getText(),
                        fieldEmail.getText(),
                        fieldCpf.getText(),
                        fieldCartao.getText(),
                        fieldTelefone.getText(),
                        fieldEndereco.getText() 
                    }
                );
                
                    JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!");
                
            } else{
                JOptionPane.showMessageDialog(null, "Digite o cpf sem pontos ou traços. O cpf precisa ter no minimo 11 caracteres!");
            } 
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        labelNome = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelCpf = new javax.swing.JLabel();
        labelCartao = new javax.swing.JLabel();
        labelTelefone = new javax.swing.JLabel();
        labelEndereco = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        fieldEmail = new javax.swing.JTextField();
        fieldEndereco = new javax.swing.JTextField();
        fieldCpf = new javax.swing.JTextField();
        fieldCartao = new javax.swing.JTextField();
        fieldTelefone = new javax.swing.JTextField();
        adicionarCliente = new javax.swing.JButton();
        editarCliente = new javax.swing.JButton();
        removerCliente = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        salvarAlteracoes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Clientes");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Email", "CPF", "Cartao", "Telefone", "Endereço"
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
        labelNome.setText("NOME ");

        labelEmail.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(51, 51, 51));
        labelEmail.setText("E-MAIL");

        labelCpf.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelCpf.setForeground(new java.awt.Color(51, 51, 51));
        labelCpf.setText("CPF");

        labelCartao.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelCartao.setForeground(new java.awt.Color(51, 51, 51));
        labelCartao.setText("CARTÃO");

        labelTelefone.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelTelefone.setForeground(new java.awt.Color(51, 51, 51));
        labelTelefone.setText("TELEFONE");

        labelEndereco.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelEndereco.setForeground(new java.awt.Color(51, 51, 51));
        labelEndereco.setText("ENDEREÇO");

        fieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNomeActionPerformed(evt);
            }
        });

        fieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldEmailActionPerformed(evt);
            }
        });

        fieldEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldEnderecoActionPerformed(evt);
            }
        });

        fieldCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCpfActionPerformed(evt);
            }
        });

        fieldCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCartaoActionPerformed(evt);
            }
        });

        fieldTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTelefoneActionPerformed(evt);
            }
        });

        adicionarCliente.setBackground(new java.awt.Color(102, 102, 102));
        adicionarCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        adicionarCliente.setForeground(new java.awt.Color(204, 204, 204));
        adicionarCliente.setText("Adicionar Cliente");
        adicionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarClienteActionPerformed(evt);
            }
        });

        editarCliente.setBackground(new java.awt.Color(102, 102, 102));
        editarCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        editarCliente.setForeground(new java.awt.Color(204, 204, 204));
        editarCliente.setText("Editar Cliente");
        editarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarClienteActionPerformed(evt);
            }
        });

        removerCliente.setBackground(new java.awt.Color(102, 102, 102));
        removerCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        removerCliente.setForeground(new java.awt.Color(204, 204, 204));
        removerCliente.setText("Remover Cliente");
        removerCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerClienteActionPerformed(evt);
            }
        });

        voltar.setBackground(new java.awt.Color(255, 51, 51));
        voltar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        voltar.setForeground(new java.awt.Color(204, 204, 204));
        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        salvarAlteracoes.setBackground(new java.awt.Color(51, 51, 51));
        salvarAlteracoes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        salvarAlteracoes.setForeground(new java.awt.Color(204, 204, 204));
        salvarAlteracoes.setText("Salvar Alterações");
        salvarAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarAlteracoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(labelNome))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(labelEmail)
                                .addGap(129, 129, 129)
                                .addComponent(labelCpf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelCartao)
                                .addGap(103, 103, 103)
                                .addComponent(labelTelefone))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(editarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                        .addComponent(fieldCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(89, 89, 89)
                                        .addComponent(fieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(adicionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(550, 550, 550)))
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEndereco)
                    .addComponent(fieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(voltar)
                .addGap(396, 396, 396)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salvarAlteracoes)
                .addGap(53, 53, 53))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(removerCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(salvarAlteracoes))
                    .addComponent(voltar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(labelEmail)
                    .addComponent(labelCpf)
                    .addComponent(labelCartao)
                    .addComponent(labelTelefone)
                    .addComponent(labelEndereco))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removerCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adicionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCartaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCartaoActionPerformed

    private void fieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNomeActionPerformed

    private void fieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldEmailActionPerformed

    private void fieldCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCpfActionPerformed

    private void fieldTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTelefoneActionPerformed

    private void fieldEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldEnderecoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();

        fieldNome.setText(model.getValueAt(selectedRowIndex, 0).toString());
        fieldEmail.setText(model.getValueAt(selectedRowIndex, 1).toString());
        fieldCpf.setText(model.getValueAt(selectedRowIndex, 2).toString());
        fieldCartao.setText(model.getValueAt(selectedRowIndex, 3).toString());
        fieldTelefone.setText(model.getValueAt(selectedRowIndex, 4).toString());
        fieldEndereco.setText(model.getValueAt(selectedRowIndex, 5).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void adicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarClienteActionPerformed
        chamarAdicionarCliente();
    }//GEN-LAST:event_adicionarClienteActionPerformed

    private void editarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarClienteActionPerformed
        chamarEditarCliente();
    }//GEN-LAST:event_editarClienteActionPerformed

    private void removerClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerClienteActionPerformed
        chamarRemoverCliente();
    }//GEN-LAST:event_removerClienteActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        Menu telaMenu = new Menu();
            
            telaMenu.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void salvarAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarAlteracoesActionPerformed
        gc.salvarClientesNoArquivo();
    }//GEN-LAST:event_salvarAlteracoesActionPerformed

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
            java.util.logging.Logger.getLogger(ViewGerenciamentoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewGerenciamentoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewGerenciamentoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewGerenciamentoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewGerenciamentoCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarCliente;
    private javax.swing.JButton editarCliente;
    private javax.swing.JTextField fieldCartao;
    private javax.swing.JTextField fieldCpf;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldEndereco;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JTextField fieldTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelCartao;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JButton removerCliente;
    private javax.swing.JButton salvarAlteracoes;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
