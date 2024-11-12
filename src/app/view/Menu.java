/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.view;

import app.controler.Catraca;
import app.controler.Estoque;
import app.view.ViewVerificadorEmail;

/**
 *
 * @author manuc
 */
public class Menu extends javax.swing.JFrame {
    
    
    Catraca catraca = new Catraca();
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
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
        titulo = new javax.swing.JLabel();
        gerenciamentoClientes = new javax.swing.JButton();
        gerenciamentoFuncionarios = new javax.swing.JButton();
        estoque = new javax.swing.JButton();
        agenda = new javax.swing.JButton();
        financeiro = new javax.swing.JButton();
        liberarSaida = new javax.swing.JButton();
        liberarEntrada1 = new javax.swing.JButton();
        clientesAtivos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        atualizarClientesPresentes = new javax.swing.JButton();
        loja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        titulo.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        titulo.setForeground(new java.awt.Color(51, 51, 51));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Menu Principal");
        titulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        gerenciamentoClientes.setBackground(new java.awt.Color(51, 51, 51));
        gerenciamentoClientes.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        gerenciamentoClientes.setForeground(new java.awt.Color(204, 204, 204));
        gerenciamentoClientes.setText("Gerenciamento De Clientes");
        gerenciamentoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciamentoClientesActionPerformed(evt);
            }
        });

        gerenciamentoFuncionarios.setBackground(new java.awt.Color(51, 51, 51));
        gerenciamentoFuncionarios.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        gerenciamentoFuncionarios.setForeground(new java.awt.Color(204, 204, 204));
        gerenciamentoFuncionarios.setText("Gerenciamento De Funcionarios");
        gerenciamentoFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciamentoFuncionariosActionPerformed(evt);
            }
        });

        estoque.setBackground(new java.awt.Color(51, 51, 51));
        estoque.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        estoque.setForeground(new java.awt.Color(204, 204, 204));
        estoque.setText("Estoque");
        estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estoqueActionPerformed(evt);
            }
        });

        agenda.setBackground(new java.awt.Color(51, 51, 51));
        agenda.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        agenda.setForeground(new java.awt.Color(204, 204, 204));
        agenda.setText("Agenda");
        agenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendaActionPerformed(evt);
            }
        });

        financeiro.setBackground(new java.awt.Color(51, 51, 51));
        financeiro.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        financeiro.setForeground(new java.awt.Color(204, 204, 204));
        financeiro.setText("Financeiro");
        financeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financeiroActionPerformed(evt);
            }
        });

        liberarSaida.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        liberarSaida.setText("Sair");
        liberarSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liberarSaidaActionPerformed(evt);
            }
        });

        liberarEntrada1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        liberarEntrada1.setText("Entrar");
        liberarEntrada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liberarEntrada1ActionPerformed(evt);
            }
        });

        clientesAtivos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        clientesAtivos.setForeground(new java.awt.Color(51, 51, 51));
        clientesAtivos.setText("0");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Clientes presentes nesse momento:");

        atualizarClientesPresentes.setText("Atualizar");
        atualizarClientesPresentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarClientesPresentesActionPerformed(evt);
            }
        });

        loja.setBackground(new java.awt.Color(51, 51, 51));
        loja.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        loja.setForeground(new java.awt.Color(204, 204, 204));
        loja.setText("Loja");
        loja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lojaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(liberarSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(402, 402, 402)
                .addComponent(liberarEntrada1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(476, 476, 476))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(800, 800, 800)
                        .addComponent(titulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(atualizarClientesPresentes)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(clientesAtivos)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gerenciamentoFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gerenciamentoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(203, 203, 203)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(estoque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(financeiro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(atualizarClientesPresentes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientesAtivos)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addComponent(titulo)
                .addGap(138, 138, 138)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gerenciamentoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(financeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loja, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gerenciamentoFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(liberarEntrada1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(liberarSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(173, 173, 173))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void gerenciamentoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciamentoClientesActionPerformed
            ViewGerenciamentoCliente vgc = new ViewGerenciamentoCliente();
            
            vgc.setVisible(true);
            this.dispose();
            
            
    }//GEN-LAST:event_gerenciamentoClientesActionPerformed

    private void gerenciamentoFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciamentoFuncionariosActionPerformed
        ViewVerificadorEmail vve = new ViewVerificadorEmail(4);
        vve.setVisible(true);
            
    }//GEN-LAST:event_gerenciamentoFuncionariosActionPerformed

    private void estoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estoqueActionPerformed
        ViewEstoque estoque = new ViewEstoque();
        
        estoque.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_estoqueActionPerformed

    private void agendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendaActionPerformed
        ViewAgenda va = new ViewAgenda();
        
        va.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_agendaActionPerformed

    private void financeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_financeiroActionPerformed
       ViewFinanceiro vf = new ViewFinanceiro();
       vf.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_financeiroActionPerformed

    private void liberarSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liberarSaidaActionPerformed
        ViewVerificadorEmail vve = new ViewVerificadorEmail(2);
        vve.setVisible(true);
        
    }//GEN-LAST:event_liberarSaidaActionPerformed

    private void liberarEntrada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liberarEntrada1ActionPerformed
            ViewVerificadorEmail vve = new ViewVerificadorEmail(1);
            vve.setVisible(true);
            
            
    }//GEN-LAST:event_liberarEntrada1ActionPerformed

    private void atualizarClientesPresentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarClientesPresentesActionPerformed
        ViewVerificadorEmail vve = new ViewVerificadorEmail(0);
        int aux = vve.clientesPresentes();
        clientesAtivos.setText(String.valueOf(aux));
    }//GEN-LAST:event_atualizarClientesPresentesActionPerformed

    private void lojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lojaActionPerformed
        ViewLoja vl = new ViewLoja();
        vl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lojaActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agenda;
    private javax.swing.JButton atualizarClientesPresentes;
    private javax.swing.JLabel clientesAtivos;
    private javax.swing.JButton estoque;
    private javax.swing.JButton financeiro;
    private javax.swing.JButton gerenciamentoClientes;
    private javax.swing.JButton gerenciamentoFuncionarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton liberarEntrada1;
    private javax.swing.JButton liberarSaida;
    private javax.swing.JButton loja;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
