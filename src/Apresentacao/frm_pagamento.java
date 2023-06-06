/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import Dados.vpago;
import Dados.vprodutos;
import Dados.vquartos;
import Logica.fconsumo;
import Logica.fpago;
import Logica.fprodutos;
import Logica.fquartos;
import Dados.vquartos;
import Dados.vreservas;
import Logica.conexao;
import Logica.freserva;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.put;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author filin
 */
public class frm_pagamento extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form frm_produtos
     */
    public frm_pagamento() {
        initComponents();
         desativar();
        mostrar(id_reserva);
        txt_id_reserva.setText(id_reserva);
        txt_nome_cliente.setText(cliente);
        txt_quarto.setText(quarto);
        txt_id_quarto.setText(id_quarto);
        txt_total_reserva.setText(Double.toString(total_reserva));
        
        fconsumo func = new fconsumo();
        func.mostrar(id_reserva);
        txt_total_pagamento.setText(Double.toString(total_reserva + func.totalconsumo));
       
    }
    
    
    private String acao="salvar";
    
    public static String id_reserva;
    public static String cliente;
    public static String id_quarto;
    public static String quarto;
    public static Double total_reserva;
    
    
    void ocultar_coluna(){
        TB_lista.getColumnModel().getColumn(0).setMaxWidth(0);
        TB_lista.getColumnModel().getColumn(0).setMinWidth(0);
        TB_lista.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        TB_lista.getColumnModel().getColumn(1).setMaxWidth(0);
        TB_lista.getColumnModel().getColumn(1).setMinWidth(0);
        TB_lista.getColumnModel().getColumn(1).setPreferredWidth(0);
    }
    
    void ocultar_coluna_consumo(){
        TB_lista_consumo.getColumnModel().getColumn(0).setMaxWidth(0);
        TB_lista_consumo.getColumnModel().getColumn(0).setMinWidth(0);
        TB_lista_consumo.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        TB_lista_consumo.getColumnModel().getColumn(1).setMaxWidth(0);
        TB_lista_consumo.getColumnModel().getColumn(1).setMinWidth(0);
        TB_lista_consumo.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        TB_lista_consumo.getColumnModel().getColumn(2).setMaxWidth(0);
        TB_lista_consumo.getColumnModel().getColumn(2).setMinWidth(0);
        TB_lista_consumo.getColumnModel().getColumn(2).setPreferredWidth(0);
    }
    
    void desativar(){
        txt_id_pagamento.setVisible(false);
        txt_id_reserva.setVisible(false);
        txt_id_quarto.setVisible(false);
        
        CB_tipo_comprovante.setEnabled(false);
        txt_nome_cliente.setEnabled(false);
        txt_quarto.setEnabled(false);
        txt_taxa.setEnabled(false);
        txt_total_pagamento.setEnabled(false);
        txt_total_reserva.setEnabled(false);
        txt_num_comprovante.setEnabled(false);
        txt_data_emissao.setEnabled(false);
        txt_data_pagamento.setEnabled(false);
        
        btn_salvar.setVisible(false);
        btn_cancelar.setVisible(false);
          
        
        txt_num_comprovante.setText("");
        
    }
    
    void ativar(){
        txt_id_pagamento.setVisible(false);
        txt_id_reserva.setVisible(false);
        txt_id_quarto.setVisible(false);
        
        CB_tipo_comprovante.setEnabled(true);
        txt_nome_cliente.setEnabled(false);
        txt_quarto.setEnabled(false);
        txt_taxa.setEnabled(true);
        txt_total_pagamento.setEnabled(false);
        txt_total_reserva.setEnabled(false);
        txt_num_comprovante.setEnabled(true);
        txt_data_emissao.setEnabled(true);
        txt_data_pagamento.setEnabled(true);
        
        
        btn_salvar.setVisible(true);        
        btn_cancelar.setVisible(true);
          
        
        txt_num_comprovante.setText("");
    }
    
    void mostrar (String buscar){
        
        try{
            DefaultTableModel modelo;
            fpago func=new fpago();
            modelo = func.mostrar(buscar);
            TB_lista.setModel(modelo);
            ocultar_coluna();
            LB_registros.setText("Total Registros " + Integer.toString(func.totalregistros) );
            
             //Mostrar os dados dos consumos
            fconsumo func2 = new fconsumo();
            modelo= func2.mostrar(buscar);
            TB_lista_consumo.setModel(modelo);
            ocultar_coluna_consumo();
            
            LB_registros_consumos.setText("Total Consumos " + func2.totalregistros);
            LB_total_consumo.setText("Consumo Total: R$ " + func2.totalconsumo );
            
            
            
            
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
    }
    
    void limpar() {
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_nome_cliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CB_tipo_comprovante = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_num_comprovante = new javax.swing.JTextField();
        btn_novo = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        txt_id_pagamento = new javax.swing.JTextField();
        txt_id_reserva = new javax.swing.JTextField();
        txt_id_quarto = new javax.swing.JTextField();
        txt_quarto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_taxa = new javax.swing.JTextField();
        txt_total_pagamento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_total_reserva = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_data_emissao = new com.toedter.calendar.JDateChooser();
        txt_data_pagamento = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TB_lista_consumo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TB_lista = new javax.swing.JTable();
        btn_sair = new javax.swing.JButton();
        btn_apagar = new javax.swing.JButton();
        LB_registros = new javax.swing.JLabel();
        btn_nota = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        LB_registros_consumos = new javax.swing.JLabel();
        LB_total_consumo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 102, 51));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setForeground(new java.awt.Color(0, 0, 255));
        setTitle("Cadastro de Pagamentos");
        setAutoscrolls(true);
        setDoubleBuffered(true);
        setFocusTraversalPolicyProvider(true);
        setInheritsPopupMenu(true);
        setOpaque(true);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jPanel1.setBackground(new java.awt.Color(255, 102, 51));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Cadastro de Pagamentos");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Cliente");

        txt_nome_cliente.setBackground(new java.awt.Color(204, 204, 204));
        txt_nome_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nome_clienteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tipo Comprovante");

        CB_tipo_comprovante.setBackground(new java.awt.Color(204, 204, 204));
        CB_tipo_comprovante.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CB_tipo_comprovante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOTA", "FATURA", "TICKET", "OUTRO" }));
        CB_tipo_comprovante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_tipo_comprovanteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("N° Quarto");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("N° Comp");

        txt_num_comprovante.setBackground(new java.awt.Color(204, 204, 204));
        txt_num_comprovante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_num_comprovanteActionPerformed(evt);
            }
        });

        btn_novo.setBackground(new java.awt.Color(0, 0, 255));
        btn_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/images/icones/novo.GIF"))); // NOI18N
        btn_novo.setText("Novo");
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        btn_salvar.setBackground(new java.awt.Color(0, 0, 255));
        btn_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/images/icones/salvar.png"))); // NOI18N
        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_cancelar.setBackground(new java.awt.Color(0, 0, 255));
        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/images/icones/cancelar.png"))); // NOI18N
        btn_cancelar.setText("Limpar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        txt_quarto.setBackground(new java.awt.Color(204, 204, 204));
        txt_quarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quartoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Taxa");

        txt_taxa.setBackground(new java.awt.Color(204, 204, 204));
        txt_taxa.setText("0");
        txt_taxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_taxaActionPerformed(evt);
            }
        });

        txt_total_pagamento.setBackground(new java.awt.Color(204, 204, 204));
        txt_total_pagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_pagamentoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Total Pgto");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Total Reserva");

        txt_total_reserva.setBackground(new java.awt.Color(204, 204, 204));
        txt_total_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_reservaActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Data Emissão");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Data Pgto");

        txt_data_emissao.setBackground(new java.awt.Color(204, 204, 204));

        txt_data_pagamento.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_id_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_id_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_id_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CB_tipo_comprovante, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_num_comprovante, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_data_pagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_data_emissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_taxa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_total_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_total_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_id_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_total_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CB_tipo_comprovante, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_num_comprovante, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_taxa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_total_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_data_emissao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(txt_data_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        jPanel3.setBackground(new java.awt.Color(255, 102, 51));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Lista de Consumos");

        TB_lista_consumo.setBackground(new java.awt.Color(204, 204, 204));
        TB_lista_consumo.setModel(new javax.swing.table.DefaultTableModel(
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
        TB_lista_consumo.setSelectionForeground(new java.awt.Color(102, 255, 51));
        TB_lista_consumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_lista_consumoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TB_lista_consumo);

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Lista de Pagamentos");

        TB_lista.setBackground(new java.awt.Color(204, 204, 204));
        TB_lista.setModel(new javax.swing.table.DefaultTableModel(
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
        TB_lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_listaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TB_lista);

        btn_sair.setBackground(new java.awt.Color(0, 0, 255));
        btn_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/images/icones/cancelar.png"))); // NOI18N
        btn_sair.setText("Sair");
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });

        btn_apagar.setBackground(new java.awt.Color(0, 0, 255));
        btn_apagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/images/icones/salvar.png"))); // NOI18N
        btn_apagar.setText("Apagar");
        btn_apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_apagarActionPerformed(evt);
            }
        });

        LB_registros.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LB_registros.setText("Registros");

        btn_nota.setBackground(new java.awt.Color(51, 255, 51));
        btn_nota.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_nota.setText("NOTA ");
        btn_nota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_notaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel10)
                        .addGap(93, 93, 93)
                        .addComponent(btn_apagar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LB_registros, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(btn_apagar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LB_registros, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );

        LB_registros_consumos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LB_registros_consumos.setText("Registros");

        LB_total_consumo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LB_total_consumo.setText("Total R$");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LB_total_consumo)
                .addGap(65, 65, 65)
                .addComponent(LB_registros_consumos)
                .addGap(66, 66, 66))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_registros_consumos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LB_total_consumo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nome_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nome_clienteActionPerformed
        txt_nome_cliente.transferFocus();
    }//GEN-LAST:event_txt_nome_clienteActionPerformed

    private void CB_tipo_comprovanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_tipo_comprovanteActionPerformed
        CB_tipo_comprovante.transferFocus();
    }//GEN-LAST:event_CB_tipo_comprovanteActionPerformed

    private void txt_num_comprovanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_num_comprovanteActionPerformed
        txt_num_comprovante.transferFocus();
    }//GEN-LAST:event_txt_num_comprovanteActionPerformed

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        ativar();
        btn_salvar.setText("Salvar");
        acao="salvar";
        
    }//GEN-LAST:event_btn_novoActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
       if (txt_nome_cliente.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "Insira o nome do cliente");
            txt_nome_cliente.requestFocus();
            return;
        }

       
        vpago dts = new vpago();
        fpago func = new fpago();

        dts.setId_reservas(Integer.parseInt(txt_id_reserva.getText()));
        dts.setNum_comprovante(txt_num_comprovante.getText());
        dts.setTaxa(Double.parseDouble(txt_taxa.getText()));
        dts.setTotal_pagamento(Double.parseDouble(txt_total_pagamento.getText()));
       
        
        Calendar cal;
        int d,m,a;
        
        cal=txt_data_pagamento.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        
        dts.setData_pagamento(new Date (a,m,d));
        
        
        cal=txt_data_emissao.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        
        dts.setData_emissao(new Date (a,m,d));
        

        int selecionado = CB_tipo_comprovante.getSelectedIndex();
        dts.setTipo_comprovante((String) CB_tipo_comprovante.getItemAt(selecionado));

        

        if(acao.equals("salvar")){
            if(func.inserir(dts)){
                JOptionPane.showMessageDialog(rootPane, "O pagamento foi registrado com sucesso!");
                mostrar(id_reserva);
                desativar();
                
                 //Desocupar o quarto
                fquartos func2 = new fquartos();
                vquartos dts2 = new vquartos();                
                dts2.setIdquartos(Integer.parseInt(txt_id_quarto.getText()));
                func2.desocupar(dts2);
                
                //Cancelar ou Pagar a reserva
                
                freserva func3 = new freserva();
                vreservas dts3 = new vreservas();                
                dts3.setId_reserva(Integer.parseInt(txt_id_reserva.getText()));
                func3.pagar(dts3);
                
            }
        }
        
        else if(acao.equals("editar")){
            dts.setId_pagamentos(Integer.parseInt(txt_id_pagamento.getText()));

            if(func.editar(dts)){
                JOptionPane.showMessageDialog(rootPane, "O pagamento foi editado com sucesso!");
                mostrar(id_reserva);
                desativar();
            }
        }
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        limpar();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void TB_listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_listaMouseClicked
       
        btn_salvar.setText("Editar");
        ativar();
        btn_apagar.setEnabled(true);
        acao="editar";
        int linha = TB_lista.rowAtPoint(evt.getPoint());

        txt_id_pagamento.setText(TB_lista.getValueAt(linha, 0).toString());
        txt_id_reserva.setText(TB_lista.getValueAt(linha, 1).toString());
        CB_tipo_comprovante.setSelectedItem(TB_lista.getValueAt(linha, 2).toString());
        txt_num_comprovante.setText(TB_lista.getValueAt(linha, 3).toString());
        txt_taxa.setText(TB_lista.getValueAt(linha, 4).toString());
        txt_total_pagamento.setText(TB_lista.getValueAt(linha, 5).toString());
        txt_data_emissao.setDate(Date.valueOf(TB_lista.getValueAt(linha, 6).toString()));
        txt_data_pagamento.setDate(Date.valueOf(TB_lista.getValueAt(linha, 7).toString()));
      
    }//GEN-LAST:event_TB_listaMouseClicked

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_apagarActionPerformed
        if(!txt_id_pagamento.getText().equals("")){
            int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este registro", "Exluir", 2);
            if (confirmacao == 0){
                 vpago dts = new vpago();
                 fpago func = new fpago();
                dts.setId_pagamentos(Integer.parseInt(txt_id_pagamento.getText()));
                func.deletar(dts);
                mostrar(id_reserva);
                desativar();
            }
        }
    }//GEN-LAST:event_btn_apagarActionPerformed

    private void TB_lista_consumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_lista_consumoMouseClicked
         // TODO add your handling code here:
    }//GEN-LAST:event_TB_lista_consumoMouseClicked

    private void txt_quartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quartoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quartoActionPerformed

    private void txt_taxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_taxaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_taxaActionPerformed

    private void txt_total_pagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_pagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_pagamentoActionPerformed

    private void txt_total_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_reservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_reservaActionPerformed

        private Connection connection=new conexao().conectar();

    
    private void btn_notaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_notaActionPerformed
       if(!txt_id_pagamento.getText().equals("")){ 
        Map p=new HashMap();
         p.put("id_pagamento", txt_id_pagamento.getText());
      JasperReport relatorio;
      JasperPrint impressao;
      
      try{
          relatorio = JasperCompileManager.compileReport(new File("").getAbsolutePath()+
          "/src/Relatorios/rel_nota_fiscal.jrxml");
          impressao = JasperFillManager.fillReport(relatorio, p, connection);
          JasperViewer view = new JasperViewer(impressao, false);
          view.setTitle("Nota Fiscal");
          view.setVisible(true);
      }catch(Exception e){
          e.printStackTrace();
      }
        }
    }//GEN-LAST:event_btn_notaActionPerformed

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
            java.util.logging.Logger.getLogger(frm_pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_pagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_tipo_comprovante;
    private javax.swing.JLabel LB_registros;
    private javax.swing.JLabel LB_registros_consumos;
    private javax.swing.JLabel LB_total_consumo;
    private javax.swing.JTable TB_lista;
    private javax.swing.JTable TB_lista_consumo;
    private javax.swing.JButton btn_apagar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_nota;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_sair;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser txt_data_emissao;
    private com.toedter.calendar.JDateChooser txt_data_pagamento;
    private javax.swing.JTextField txt_id_pagamento;
    private javax.swing.JTextField txt_id_quarto;
    private javax.swing.JTextField txt_id_reserva;
    private javax.swing.JTextField txt_nome_cliente;
    private javax.swing.JTextField txt_num_comprovante;
    private javax.swing.JTextField txt_quarto;
    public static javax.swing.JTextField txt_taxa;
    private javax.swing.JTextField txt_total_pagamento;
    private javax.swing.JTextField txt_total_reserva;
    // End of variables declaration//GEN-END:variables
}
