/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.view;

import app.controler.Agenda;
import app.model.Agendamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manuc
 */
public class ViewAgenda extends javax.swing.JFrame {

    
    Agenda agenda = new Agenda();
    
    /**
     * Creates new form ViewAgenda
     */
    public ViewAgenda() {
        initComponents();
        addRowToJTable();
    }
    
    
    
    public void addRowToJTable(){
    DefaultTableModel model = (DefaultTableModel)tabelaAgendamentos.getModel();
    
    ArrayList<Agendamento> list = agenda.getListaDeAgendamentos();
    Object rowData[] = new Object[8];
    
        for(int i = 0; i< list.size(); i++){
            rowData[0] = list.get(i).getNomeCliente();
            rowData[1] = list.get(i).getEmailCliente();
            rowData[2] = list.get(i).getInstrutor();
            rowData[3] = list.get(i).getTipoAula();
            rowData[4] = list.get(i).getAssinatura();
            rowData[5] = list.get(i).getDataAgendada();
            rowData[6] = list.get(i).isCofirmada();
            rowData[7] = list.get(i).getId();

            model.addRow(rowData);
        }
    }
    
    
    public void chamarCriarAgendamento(){
        DefaultTableModel model = (DefaultTableModel)tabelaAgendamentos.getModel();
        
        
        agenda.adicionarAgendamento(fieldNomeCliente.getText(),
                fieldEmailCliente.getText(),
                fieldInstrutor.getText(),
                fieldTipoAula.getText(),
                fieldAssinatura.getText(),
                Integer.parseInt(boxDia.getSelectedItem().toString()), 
                Integer.parseInt(boxMes.getSelectedItem().toString()), 
                Integer.parseInt(boxAno .getSelectedItem().toString()), 
                Integer.parseInt(boxHora .getSelectedItem().toString()), 
                Integer.parseInt(boxMinuto .getSelectedItem().toString()));
        
        
                model.addRow(new Object[]{
                fieldNomeCliente.getText(),
                fieldEmailCliente.getText(),
                fieldInstrutor.getText(),
                fieldTipoAula.getText(),
                fieldAssinatura.getText(),
                "horario",
                 "false"       
                });
    }
    
    public void chamarExcluirAgendamento(){
        
    DefaultTableModel model = (DefaultTableModel)tabelaAgendamentos.getModel();
        
            
            int selectedRowIndex = tabelaAgendamentos.getSelectedRow();
            
            int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja mesmo cancelar esse Agendamento?","Confirmação",JOptionPane.YES_NO_OPTION);
            
            if(confirmacao == JOptionPane.YES_OPTION){
                String id = model.getValueAt(selectedRowIndex, 7).toString();
                
                if(agenda.devolverMetade(fieldId.getText())){
                    JOptionPane.showMessageDialog(null, "Irá ser reembolsado metade do valor");
                }

                /*if(agenda.devolverMetade(fieldId.getText())){
                    JOptionPane.showMessageDialog(null, "Devolvendo metade do valor");
                }*/
                model.removeRow(selectedRowIndex);
                agenda.excluirAgendamento(id);
                JOptionPane.showMessageDialog(null, "Agendamento removido com sucesso!");
            } 
            else{
                JOptionPane.showMessageDialog(null, "Exclusão cancelada");
            }
           
        
    }
    
    public void chamarConfirmarAgendamento(){
        DefaultTableModel model = (DefaultTableModel)tabelaAgendamentos.getModel();
        
        int selectedRowIndex = tabelaAgendamentos.getSelectedRow();
        
        agenda.confirmarAgendamento(fieldId.getText());
        
        model.setValueAt(true, selectedRowIndex, 6);
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAgendamentos = new javax.swing.JTable();
        botaoVoltar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        cancelarAgendamento = new javax.swing.JButton();
        criarAgendamento = new javax.swing.JButton();
        confirmarAgendamento = new javax.swing.JButton();
        fieldNomeCliente = new javax.swing.JTextField();
        fieldEmailCliente = new javax.swing.JTextField();
        fieldInstrutor = new javax.swing.JTextField();
        fieldTipoAula = new javax.swing.JTextField();
        fieldAssinatura = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        boxDia = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        boxMes = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        boxAno = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        boxHora = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        boxMinuto = new javax.swing.JComboBox<>();
        fieldId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        tabelaAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do Cliente", "Email Cliente", "Instrutor", "Tipo Aula", "Assinatura", "Data", "Confirmado", "id"
            }
        ));
        tabelaAgendamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAgendamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAgendamentos);

        botaoVoltar.setBackground(new java.awt.Color(255, 0, 0));
        botaoVoltar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        botaoSalvar.setBackground(new java.awt.Color(51, 51, 51));
        botaoSalvar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botaoSalvar.setText("Salvar Alterações");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        cancelarAgendamento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cancelarAgendamento.setText("Cancelar Agendamento");
        cancelarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarAgendamentoActionPerformed(evt);
            }
        });

        criarAgendamento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        criarAgendamento.setText("Criar Agendamento");
        criarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarAgendamentoActionPerformed(evt);
            }
        });

        confirmarAgendamento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        confirmarAgendamento.setText("Confirmar Agendamento");
        confirmarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarAgendamentoActionPerformed(evt);
            }
        });

        fieldNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNomeClienteActionPerformed(evt);
            }
        });

        fieldEmailCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldEmailClienteActionPerformed(evt);
            }
        });

        fieldInstrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldInstrutorActionPerformed(evt);
            }
        });

        fieldTipoAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTipoAulaActionPerformed(evt);
            }
        });

        fieldAssinatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAssinaturaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nome do Cliente");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Email do Cliente");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Instrutor");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Tipo de Aula");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Assinatura");

        boxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        boxDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxDiaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Dia");

        boxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        boxMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMesActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Ano");

        boxAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100" }));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Mes");

        boxHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", " " }));
        boxHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxHoraActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Hora");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Minuto");

        boxMinuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "30", " " }));
        boxMinuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMinutoActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("ID da vaga");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoSalvar)
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(boxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addComponent(fieldNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(191, 191, 191)
                                        .addComponent(fieldEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel1)
                                        .addGap(155, 155, 155)
                                        .addComponent(jLabel2)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fieldInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(13, 13, 13)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(boxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)))
                        .addGap(122, 122, 122)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(boxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(boxMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldTipoAula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(191, 191, 191)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(fieldAssinatura, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel11))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155)
                        .addComponent(criarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(confirmarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)))
                .addGap(108, 108, 108))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldTipoAula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldAssinatura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(boxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(criarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(confirmarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancelarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
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

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed

        Menu telaMenu = new Menu();
            
        telaMenu.setVisible(true);
        this.dispose();    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        agenda.salvarAgendamentosNoArquivo();
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void cancelarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarAgendamentoActionPerformed
        chamarExcluirAgendamento();
    }//GEN-LAST:event_cancelarAgendamentoActionPerformed

    private void criarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarAgendamentoActionPerformed
        chamarCriarAgendamento();
    }//GEN-LAST:event_criarAgendamentoActionPerformed

    private void confirmarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarAgendamentoActionPerformed
        chamarConfirmarAgendamento();
    }//GEN-LAST:event_confirmarAgendamentoActionPerformed

    private void fieldNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNomeClienteActionPerformed

    private void fieldEmailClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldEmailClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldEmailClienteActionPerformed

    private void fieldInstrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldInstrutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldInstrutorActionPerformed

    private void fieldTipoAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTipoAulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTipoAulaActionPerformed

    private void fieldAssinaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAssinaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAssinaturaActionPerformed

    private void boxDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxDiaActionPerformed

    private void boxMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxMesActionPerformed

    private void boxHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxHoraActionPerformed

    private void boxMinutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMinutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxMinutoActionPerformed

    private void tabelaAgendamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAgendamentosMouseClicked
        DefaultTableModel model = (DefaultTableModel)tabelaAgendamentos.getModel();
        int selectedRowIndex = tabelaAgendamentos.getSelectedRow();

        fieldNomeCliente.setText(model.getValueAt(selectedRowIndex, 0).toString());
        fieldEmailCliente.setText(model.getValueAt(selectedRowIndex, 1).toString());
        fieldInstrutor.setText(model.getValueAt(selectedRowIndex, 2).toString());
        fieldTipoAula.setText(model.getValueAt(selectedRowIndex, 3).toString());
        fieldAssinatura.setText(model.getValueAt(selectedRowIndex, 4).toString());
        fieldId.setText(model.getValueAt(selectedRowIndex, 7).toString());
    }//GEN-LAST:event_tabelaAgendamentosMouseClicked

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
            java.util.logging.Logger.getLogger(ViewAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JComboBox<String> boxAno;
    private javax.swing.JComboBox<String> boxDia;
    private javax.swing.JComboBox<String> boxHora;
    private javax.swing.JComboBox<String> boxMes;
    private javax.swing.JComboBox<String> boxMinuto;
    private javax.swing.JButton cancelarAgendamento;
    private javax.swing.JButton confirmarAgendamento;
    private javax.swing.JButton criarAgendamento;
    private javax.swing.JTextField fieldAssinatura;
    private javax.swing.JTextField fieldEmailCliente;
    private javax.swing.JTextField fieldId;
    private javax.swing.JTextField fieldInstrutor;
    private javax.swing.JTextField fieldNomeCliente;
    private javax.swing.JTextField fieldTipoAula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAgendamentos;
    // End of variables declaration//GEN-END:variables
}