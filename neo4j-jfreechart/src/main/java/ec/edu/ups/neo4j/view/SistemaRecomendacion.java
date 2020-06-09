/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.neo4j.view;

import ec.edu.ups.neo4j.methods.Metodos;
import ec.edu.ups.neo4j.model.Nodo;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author jmurillo
 */
public class SistemaRecomendacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form SistemaRecomendacion
     */
    private final String[] edp = {"Tamaño de Areas Verdes", "Presencia de Agua", "Juegos Recreativos", "Acceso a Baños", "Acceso a Senderos", "Presencia de Animales"};
    private final String[] edlt = {"Tamaño del Lugar", "Tiendas", "Areas Verdes", "Actividades Extremas", "Galerias"};
    private final String[] sc = {"Nodo Ingresado", "Nodo por Comparar", "Puntaje"};

    public SistemaRecomendacion() {
        initComponents();
        jcbxAlgoritmo.setSelectedIndex(0);
        setTitle("Sistema de Recomendacion - Parques y Lugares Turisticos");
        renderizarTabla("Similitud");
    }

    public void renderizarTabla(String punt) {
        JTableHeader tableHeader = jTable1.getTableHeader();
        TableColumnModel tableColumnModel = tableHeader.getColumnModel();
        TableColumn tableColumn = tableColumnModel.getColumn(0);
        tableColumn.setHeaderValue("Nodo");
        TableColumn tableColumn1 = tableColumnModel.getColumn(1);
        tableColumn1.setHeaderValue(punt);
        tableHeader.repaint();
    }

    public void combos() {
        if (jcbxAlgoritmo.getSelectedItem().toString().equals("Euclidean Distance") && jcbxClaseNodos.getSelectedItem().toString().equals("Parques")) {
            jlbl1.setText(edp[0]);
            jlbl2.setText(edp[1]);
            jlbl3.setText(edp[2]);
            jlbl4.setText(edp[3]);
            jlbl5.setText(edp[4]);
            jlbl6.setText(edp[5]);
            jComboBox1.setEnabled(true);
            jComboBox2.setEnabled(true);
            jComboBox3.setEnabled(true);
            jComboBox4.setEnabled(true);
            jComboBox5.setEnabled(true);
            jComboBox6.setEnabled(true);
            jcbxCaracteristica.setEnabled(false);
            jcbxCantidad.setEnabled(false);
            jlblNodo.setText("");
            jtxtNodo.setEnabled(false);
            jlblNodo1.setText("");
            jtxtNodo1.setEnabled(false);
            jlblCantidad.setText("");
            jlblCarac.setText("");
            renderizarTabla("Similitud");
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Euclidean Distance") && jcbxClaseNodos.getSelectedItem().toString().equals("Lugares Turisticos")) {
            jlbl1.setText(edlt[0] + "     ");
            jlbl2.setText("          " + edlt[1]);
            jlbl3.setText("                  " + edlt[2]);
            jlbl4.setText(edlt[3]);
            jlbl5.setText(" " + edlt[4]);
            jlbl6.setText("");
            jComboBox1.setEnabled(true);
            jComboBox2.setEnabled(true);
            jComboBox3.setEnabled(true);
            jComboBox4.setEnabled(true);
            jComboBox5.setEnabled(true);
            jComboBox6.setEnabled(false);
            jcbxCaracteristica.setEnabled(false);
            jcbxCantidad.setEnabled(false);
            jlblNodo.setText("");
            jtxtNodo.setEnabled(false);
            jlblNodo1.setText("");
            jtxtNodo1.setEnabled(false);
            jlblCantidad.setText("");
            jlblCarac.setText("");
            renderizarTabla("Similitud");
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Same Community") && jcbxClaseNodos.getSelectedItem().toString().equals("Lugares Turisticos") && jcbxCantidad.getSelectedItem().toString().equals("Todos")) {
            jlbl1.setText("");
            jlbl2.setText("");
            jlbl3.setText("");
            jlbl4.setText("");
            jlbl5.setText("");
            jlbl6.setText("");
            jComboBox1.setEnabled(false);
            jComboBox2.setEnabled(false);
            jComboBox3.setEnabled(false);
            jComboBox4.setEnabled(false);
            jComboBox5.setEnabled(false);
            jComboBox6.setEnabled(false);
            jcbxCaracteristica.setEnabled(true);
            jcbxCantidad.setEnabled(true);
            jlblCantidad.setText("Cantidad");
            jlblCarac.setText("Caracteristica");
            jcbxCaracteristica.removeAllItems();
            for (String string : edlt) {
                jcbxCaracteristica.addItem(string);
            }
            jlblNodo.setText("Nombre Nodo 1");
            jtxtNodo.setEnabled(true);
            jlblNodo1.setText("");
            jtxtNodo1.setEnabled(false);
            renderizarTabla("Pertenece");
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Same Community") && jcbxClaseNodos.getSelectedItem().toString().equals("Lugares Turisticos") && jcbxCantidad.getSelectedItem().toString().equals("1-1")) {
            jlbl1.setText("");
            jlbl2.setText("");
            jlbl3.setText("");
            jlbl4.setText("");
            jlbl5.setText("");
            jlbl6.setText("");
            jComboBox1.setEnabled(false);
            jComboBox2.setEnabled(false);
            jComboBox3.setEnabled(false);
            jComboBox4.setEnabled(false);
            jComboBox5.setEnabled(false);
            jComboBox6.setEnabled(false);
            jComboBox6.setEnabled(false);
            jcbxCaracteristica.setEnabled(true);
            jcbxCantidad.setEnabled(true);
            jlblCantidad.setText("Cantidad");
            jlblCarac.setText("Caracteristica");
            jcbxCaracteristica.removeAllItems();
            for (String string : edlt) {
                jcbxCaracteristica.addItem(string);
            }
            jlblNodo.setText("Nombre Nodo 1");
            jtxtNodo.setEnabled(true);
            jlblNodo1.setText("Nombre Nodo 2");
            jtxtNodo1.setEnabled(true);
            renderizarTabla("Pertenece");
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Same Community") && jcbxClaseNodos.getSelectedItem().toString().equals("Parques") && jcbxCantidad.getSelectedItem().toString().equals("Todos")) {
            jlbl1.setText("");
            jlbl2.setText("");
            jlbl3.setText("");
            jlbl4.setText("");
            jlbl5.setText("");
            jlbl6.setText("");
            jComboBox1.setEnabled(false);
            jComboBox2.setEnabled(false);
            jComboBox3.setEnabled(false);
            jComboBox4.setEnabled(false);
            jComboBox5.setEnabled(false);
            jComboBox6.setEnabled(false);
            jcbxCaracteristica.setEnabled(true);
            jcbxCantidad.setEnabled(true);
            jlblCantidad.setText("Cantidad");
            jlblCarac.setText("Caracteristica");
            jcbxCaracteristica.removeAllItems();
            for (String string : edp) {
                jcbxCaracteristica.addItem(string);
            }
            jlblNodo.setText("Nombre Nodo 1");
            jtxtNodo.setEnabled(true);
            jlblNodo1.setText("");
            jtxtNodo1.setEnabled(false);
            renderizarTabla("Pertenece");
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Same Community") && jcbxClaseNodos.getSelectedItem().toString().equals("Parques") && jcbxCantidad.getSelectedItem().toString().equals("1-1")) {
            jlbl1.setText("");
            jlbl2.setText("");
            jlbl3.setText("");
            jlbl4.setText("");
            jlbl5.setText("");
            jlbl6.setText("");
            jComboBox1.setEnabled(false);
            jComboBox2.setEnabled(false);
            jComboBox3.setEnabled(false);
            jComboBox4.setEnabled(false);
            jComboBox5.setEnabled(false);
            jComboBox6.setEnabled(false);
            jComboBox6.setEnabled(false);
            jcbxCaracteristica.setEnabled(true);
            jcbxCantidad.setEnabled(true);
            jlblCantidad.setText("Cantidad");
            jlblCarac.setText("Caracteristica");
            jcbxCaracteristica.removeAllItems();
            for (String string : edp) {
                jcbxCaracteristica.addItem(string);
            }
            jlblNodo.setText("Nombre Nodo 1");
            jtxtNodo.setEnabled(true);
            jlblNodo1.setText("Nombre Nodo 2");
            jtxtNodo1.setEnabled(true);
            renderizarTabla("Pertenece");
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

        jcbxClaseNodos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbxAlgoritmo = new javax.swing.JComboBox<>();
        jlbl1 = new javax.swing.JLabel();
        jlbl2 = new javax.swing.JLabel();
        jlbl5 = new javax.swing.JLabel();
        jlbl6 = new javax.swing.JLabel();
        jlbl3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jlbl4 = new javax.swing.JLabel();
        jcbxCantidad = new javax.swing.JComboBox<>();
        jlblCantidad = new javax.swing.JLabel();
        jlblCarac = new javax.swing.JLabel();
        jcbxCaracteristica = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtNodo = new javax.swing.JTextField();
        jlblNodo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jlblNodo1 = new javax.swing.JLabel();
        jtxtNodo1 = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);

        jcbxClaseNodos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Parques", "Lugares Turisticos" }));
        jcbxClaseNodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxClaseNodosActionPerformed(evt);
            }
        });

        jLabel1.setText("Clases de Nodos");

        jLabel2.setText("Tipo de Algoritmo");

        jcbxAlgoritmo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Euclidean Distance", "Same Community" }));
        jcbxAlgoritmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxAlgoritmoActionPerformed(evt);
            }
        });

        jlbl1.setText("Tamaño de Areas Verdes");

        jlbl2.setText("Presencia de Agua");

        jlbl5.setText("Acceso a Senderos");

        jlbl6.setText("Presencia de Animales");

        jlbl3.setText("Juegos Recreativos");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pequeño", "Mediano", "Grande" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jlbl4.setText("Acceso a Baños");

        jcbxCantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "1-1" }));
        jcbxCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxCantidadActionPerformed(evt);
            }
        });

        jlblCantidad.setText("Cantidad");

        jlblCarac.setText("Caracteristica");

        jLabel3.setText("Seccion 1");

        jLabel4.setText("Seccion 2");

        jtxtNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNodoActionPerformed(evt);
            }
        });

        jlblNodo.setText("Nombre Nodo1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setText("Resultados");

        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jlblNodo1.setText("Nombre Nodo2");

        jtxtNodo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNodo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBox1, 0, 135, Short.MAX_VALUE)
                                .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jlbl4)
                            .addComponent(jlbl1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbl5)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbl6)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblNodo1)
                                    .addComponent(jtxtNodo1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlblNodo)
                                    .addComponent(jtxtNodo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbl2)
                                .addGap(73, 73, 73)
                                .addComponent(jlbl3))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(248, 248, 248)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jcbxClaseNodos, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbxAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblCantidad)
                            .addComponent(jcbxCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblCarac)
                            .addComponent(jcbxCaracteristica, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jlblCantidad)
                            .addComponent(jlblCarac))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbxAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbxCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbxCaracteristica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbxClaseNodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jlbl6))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbl1)
                            .addComponent(jlbl3)
                            .addComponent(jlbl2)
                            .addComponent(jlblNodo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtNodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlbl4)
                                    .addComponent(jlbl5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblNodo1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtNodo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel5))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbxClaseNodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxClaseNodosActionPerformed
        // TODO add your handling code here:
        combos();
    }//GEN-LAST:event_jcbxClaseNodosActionPerformed

    private void jcbxAlgoritmoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxAlgoritmoActionPerformed
        // TODO add your handling code here:
        combos();
    }//GEN-LAST:event_jcbxAlgoritmoActionPerformed

    private void jcbxCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxCantidadActionPerformed
        // TODO add your handling code here:
        combos();
    }//GEN-LAST:event_jcbxCantidadActionPerformed

    private void jtxtNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNodoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String crp = "";
        String crlt = "";
        if (jcbxCaracteristica.isEnabled()==true) {
            crp = jcbxCaracteristica.getSelectedItem().toString();
            switch (crp) {
                case "Tamaño de Areas Verdes":
                    crp = "tamav";
                    break;
                case "Presencia de Agua":
                    crp = "agua";
                    break;
                case "Juegos Recreativos":
                    crp = "juegosrecre";
                    break;
                case "Acceso a Baños":
                    crp = "banios";
                    break;
                case "Acceso a Senderos":
                    crp = "send";
                    break;
                case "Presencia de Animales":
                    crp = "ani";
                    break;
            }
            crlt = jcbxCaracteristica.getSelectedItem().toString();
            switch (crlt) {
                case "Tamaño del Lugar":
                    crlt = "tam";
                    break;
                case "Tiendas":
                    crlt = "tiendas";
                    break;
                case "Areas Verdes":
                    crlt = "averdes";
                    break;
                case "Actividades Extremas":
                    crlt = "aextremas";
                    break;
                case "Galerias":
                    crlt = "gal";
                    break;
            }
        }

        String dato1 = jComboBox1.getSelectedItem().toString();
        int v1 = 0;
        switch (dato1) {
            case "Grande":
                v1 = 3;
                break;
            case "Mediano":
                v1 = 2;
                break;
            case "Pequeño":
                v1 = 1;
                break;
        }
        String dato2 = jComboBox2.getSelectedItem().toString();
        int v2 = 0;
        switch (dato2) {
            case "Si":
                v2 = 1;
                break;
            case "No":
                v2 = 0;
                break;
        }
        String dato3 = jComboBox3.getSelectedItem().toString();
        int v3 = 0;
        switch (dato3) {
            case "Si":
                v3 = 1;
                break;
            case "No":
                v3 = 0;
                break;
        }
        String dato4 = jComboBox4.getSelectedItem().toString();
        int v4 = 0;
        switch (dato4) {
            case "Si":
                v4 = 1;
                break;
            case "No":
                v4 = 0;
                break;
        }

        String dato5 = jComboBox5.getSelectedItem().toString();
        int v5 = 0;
        switch (dato5) {
            case "Si":
                v5 = 1;
                break;
            case "No":
                v5 = 0;
                break;
        }

        String dato6 = jComboBox6.getSelectedItem().toString();
        int v6 = 0;
        switch (dato6) {
            case "Si":
                v6 = 1;
                break;
            case "No":
                v6 = 0;
                break;
        }

        if (jcbxAlgoritmo.getSelectedItem().toString().equals("Euclidean Distance") && jcbxClaseNodos.getSelectedItem().toString().equals("Parques")) {
            int[] a = {v1, v2, v3, v4, v5, v6};
            try (Metodos greeter = new Metodos()) {
                List<Nodo> res = greeter.similitudEuclideanaP(a);
                recargar(res);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Euclidean Distance") && jcbxClaseNodos.getSelectedItem().toString().equals("Lugares Turisticos")) {
            int[] a = {v1, v2, v3, v4, v5};
            try (Metodos greeter = new Metodos()) {
                List<Nodo> res = greeter.similitudEuclideanaL(a);
                recargar(res);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Same Community") && jcbxClaseNodos.getSelectedItem().toString().equals("Parques") && jcbxCantidad.getSelectedItem().toString().equals("Todos")) {
            try (Metodos greeter = new Metodos()) {
                List<Nodo> res = greeter.mismaComunidadPT(jtxtNodo.getText(), crp);
                recargar(res);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Same Community") && jcbxClaseNodos.getSelectedItem().toString().equals("Parques") && jcbxCantidad.getSelectedItem().toString().equals("1-1")) {
            try (Metodos greeter = new Metodos()) {
                List<Nodo> res = greeter.mismaComunidadP1(jtxtNodo.getText(), jtxtNodo1.getText(), crp);
                recargar(res);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Same Community") && jcbxClaseNodos.getSelectedItem().toString().equals("Lugares Turisticos") && jcbxCantidad.getSelectedItem().toString().equals("Todos")) {
            try (Metodos greeter = new Metodos()) {
                List<Nodo> res = greeter.mismaComunidadLT(jtxtNodo.getText(), crlt);
                recargar(res);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Same Community") && jcbxClaseNodos.getSelectedItem().toString().equals("Lugares Turisticos") && jcbxCantidad.getSelectedItem().toString().equals("1-1")) {
            try (Metodos greeter = new Metodos()) {
                List<Nodo> res = greeter.mismaComunidadL1(jtxtNodo.getText(), jtxtNodo1.getText(), crlt);
                recargar(res);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtxtNodo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNodo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNodo1ActionPerformed

    public void recargar(List<Nodo> lista) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        Object[] lis = new Object[2];
        for (Nodo p : lista) {
            lis[0] = p.getNombre();
            lis[1] = p.getSimilitud();
            model.addRow(lis);
        }
        jTable1.setModel(model);

        // Creamos y rellenamos el modelo de datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Visitas del sitio web 
        for (int i = 0; i < lista.size(); i++) {
            if (i <= 3) {
                Nodo ns = lista.get(i);
                dataset.addValue(ns.getSimilitud(), ns.getNombre(), ns.getNombre());
            }
        }

        JFreeChart chart = ChartFactory.createBarChart("Lugares Recomendados", "Lugar",
                "Valor", dataset, PlotOrientation.VERTICAL, true,
                true, false);

        // Creación del panel con el gráfico
        ChartPanel panel = new ChartPanel(chart);

        JFrame ventana = new JFrame("Grafico");
        ventana.getContentPane().add(panel);
        ventana.pack();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbxAlgoritmo;
    private javax.swing.JComboBox<String> jcbxCantidad;
    private javax.swing.JComboBox<String> jcbxCaracteristica;
    private javax.swing.JComboBox<String> jcbxClaseNodos;
    private javax.swing.JLabel jlbl1;
    private javax.swing.JLabel jlbl2;
    private javax.swing.JLabel jlbl3;
    private javax.swing.JLabel jlbl4;
    private javax.swing.JLabel jlbl5;
    private javax.swing.JLabel jlbl6;
    private javax.swing.JLabel jlblCantidad;
    private javax.swing.JLabel jlblCarac;
    private javax.swing.JLabel jlblNodo;
    private javax.swing.JLabel jlblNodo1;
    private javax.swing.JTextField jtxtNodo;
    private javax.swing.JTextField jtxtNodo1;
    // End of variables declaration//GEN-END:variables
}
