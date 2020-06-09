/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.neo4j.view;

import ec.edu.ups.neo4j.methods.Metodos;
import ec.edu.ups.neo4j.model.Nodo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author jmurillo
 */
public class SistemaBusqueda extends javax.swing.JInternalFrame {

    /**
     * Creates new form SistemaBusqueda
     */
    public SistemaBusqueda() {
        initComponents();
        jtxtInicio.setEnabled(false);
        jtxtDestino.setEnabled(false);
        jlblFin.setText("");
        jlbInicio.setText("");
        renderizarTabla("# Salientes");
    }

    public void combos() {
        if (jcbxAlgoritmo.getSelectedItem().toString().equals("Degree Centraly") && jcbxCantidad.getSelectedItem().toString().equals("1")) {
            jcbxCantidad.setEnabled(true);
            jtxtInicio.setEnabled(true);
            jtxtDestino.setEnabled(false);
            jlblFin.setText("");
            jlbInicio.setText("Nodo");
            renderizarTabla("# Salientes");
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Degree Centraly") && jcbxCantidad.getSelectedItem().toString().equals("Todos")) {
            jcbxCantidad.setEnabled(true);
            jtxtDestino.setEnabled(false);
            jtxtInicio.setEnabled(false);
            jlblFin.setText("");
            jlbInicio.setText("");
            renderizarTabla("# Salientes");
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Depth First Search")) {
            jcbxCantidad.setEnabled(false);
            jtxtInicio.setEnabled(true);
            jtxtDestino.setEnabled(true);
            jlblFin.setText("Destino");
            jlbInicio.setText("Inicio");
            renderizarTabla("");
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Degree Centraly Reverse") && jcbxCantidad.getSelectedItem().toString().equals("1")) {
            jcbxCantidad.setEnabled(true);
            jtxtInicio.setEnabled(true);
            jtxtDestino.setEnabled(false);
            jlblFin.setText("");
            jlbInicio.setText("Ciudad");
            renderizarTabla("# Entrantes");
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Degree Centraly Reverse") && jcbxCantidad.getSelectedItem().toString().equals("Todos")) {
            jcbxCantidad.setEnabled(true);
            jtxtDestino.setEnabled(false);
            jtxtInicio.setEnabled(false);
            jlblFin.setText("");
            jlbInicio.setText("");
            renderizarTabla("# Entrantes");
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Modularity Optimization") && jcbxCantidad.getSelectedItem().toString().equals("Todos")) {
            jcbxCantidad.setEnabled(true);
            jLabel5.setText("Cantidad");
            jtxtDestino.setEnabled(false);
            jtxtInicio.setEnabled(false);
            jlblFin.setText("");
            jlbInicio.setText("");
            renderizarTabla("Id de Comunidad");
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Modularity Optimization") && jcbxCantidad.getSelectedItem().toString().equals("1")) {
            jcbxCantidad.setEnabled(true);
            jLabel5.setText("Cantidad");
            jtxtDestino.setEnabled(false);
            jtxtInicio.setEnabled(true);
            jlblFin.setText("");
            jlbInicio.setText("Nodo");
            renderizarTabla("Id de Comunidad");
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Modularity Optimization") && jcbxCantidad.getSelectedItem().toString().equals("1+")) {
            jcbxCantidad.setEnabled(true);
            jLabel5.setText("Cantidad");
            jtxtDestino.setEnabled(false);
            jtxtInicio.setEnabled(true);
            jlblFin.setText("");
            jlbInicio.setText("Nodo");
            renderizarTabla("Id de Comunidad");
        }
    }

    public void renderizarTabla(String punt) {
        JTableHeader tableHeader = tblRes.getTableHeader();
        TableColumnModel tableColumnModel = tableHeader.getColumnModel();
        TableColumn tableColumn = tableColumnModel.getColumn(0);
        tableColumn.setHeaderValue("Nodo");
        TableColumn tableColumn1 = tableColumnModel.getColumn(1);
        tableColumn1.setHeaderValue(punt);
        tableHeader.repaint();
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
        jcbxAlgoritmo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jlbInicio = new javax.swing.JLabel();
        jtxtInicio = new javax.swing.JTextField();
        jlblFin = new javax.swing.JLabel();
        jtxtDestino = new javax.swing.JTextField();
        jcbxCantidad = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jbtnCalcular = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Sistema De Busqueda");

        jcbxClaseNodos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Parques", "Iglesias", "Hospitales", "Bomberos", "Policia", "Escuelas", "Centros Medicos", "Lugares Turisticos", "Centros de Estimulacion Temprana", "Centros Educativos para el Desarrollo de Niños" }));

        jLabel1.setText("Clases de Nodos");

        jcbxAlgoritmo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Degree Centraly", "Degree Centraly Reverse", "Depth First Search", "Modularity Optimization" }));
        jcbxAlgoritmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxAlgoritmoActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo de Algoritmo");

        jlbInicio.setText("Inicio");

        jlblFin.setText("Fin");

        jcbxCantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "1", "1+" }));
        jcbxCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxCantidadActionPerformed(evt);
            }
        });

        jLabel5.setText("Cantidad");

        tblRes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tblRes);

        jLabel3.setText("Datos Resultado");

        jbtnCalcular.setText("Calcular");
        jbtnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbInicio)
                                    .addComponent(jtxtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlblFin))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jtxtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(131, 131, 131)
                                        .addComponent(jbtnCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jLabel3))
                        .addGap(145, 145, 145))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jcbxClaseNodos, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbxAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jcbxCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbxClaseNodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbxAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbxCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbInicio)
                    .addComponent(jlblFin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnCalcular))
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbxCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxCantidadActionPerformed
        // TODO add your handling code here:
        combos();
    }//GEN-LAST:event_jcbxCantidadActionPerformed

    private void jcbxAlgoritmoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxAlgoritmoActionPerformed
        // TODO add your handling code here:
        combos();
    }//GEN-LAST:event_jcbxAlgoritmoActionPerformed

    private void jbtnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCalcularActionPerformed
        // TODO add your handling code here:
        String tipoNodos = jcbxClaseNodos.getSelectedItem().toString();
        switch (tipoNodos) {
            case "Parques":
                tipoNodos = "Parque";
                break;
            case "Iglesias":
                tipoNodos = "Iglesia";
                break;
            case "Lugares Turisticos":
                tipoNodos = "LugarTuristico";
                break;
            case "Hospitales":
                tipoNodos = "Hospital";
                break;
            case "Bomberos":
                tipoNodos = "Bombero";
                break;
            case "Policia":
                tipoNodos = "Policia";
                break;
            case "Escuelas":
                tipoNodos = "Escuela";
                break;
            case "Centros Medicos":
                tipoNodos = "CentroMedico";
                break;
            case "Centros de Estimulación Temprana":
                tipoNodos = "CentroET";
                break;
            case "Centros Educativos para el Desarrollo de Niños":
                tipoNodos = "CentroEDN";
                break;
        }

        if (jcbxAlgoritmo.getSelectedItem().toString().equals("Degree Centraly") && jcbxCantidad.getSelectedItem().toString().equals("Todos")) {
            try (Metodos greeter = new Metodos()) {
                                System.out.println("TODOS");
                List<Nodo> res = greeter.degreeCentralyT(tipoNodos);
                recargar(res);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Degree Centraly Reverse") && jcbxCantidad.getSelectedItem().toString().equals("Todos")) {
            try (Metodos greeter = new Metodos()) {
                List<Nodo> res = greeter.degreeCentralyTR(tipoNodos);
                recargar(res);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Degree Centraly") && jcbxCantidad.getSelectedItem().toString().equals("1")) {
            try (Metodos greeter = new Metodos()) {
                List<Nodo> res2 = new ArrayList<>();
                List<Nodo> res = greeter.degreeCentralyT(tipoNodos);
                for (Nodo re : res) {
                    if (re.getNombre().equals(jtxtInicio.getText())) {
                        res2.add(re);
                    }
                }
                recargar(res2);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Degree Centraly Reverse") && jcbxCantidad.getSelectedItem().toString().equals("1")) {
            try (Metodos greeter = new Metodos()) {
                List<Nodo> res2 = new ArrayList<>();
                List<Nodo> res = greeter.degreeCentralyTR(tipoNodos);
                for (Nodo re : res) {
                    if (re.getNombre().equals(jtxtInicio.getText())) {
                        res2.add(re);
                    }
                }
                recargar(res2);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Depth First Search")) {
            try (Metodos greeter = new Metodos()) {
                List<Nodo> res = greeter.dfs(tipoNodos, jtxtInicio.getText(), jtxtDestino.getText());
                recargar(res);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else if (jcbxAlgoritmo.getSelectedItem().toString().equals("Modularity Optimization")) {
            try (Metodos greeter = new Metodos()) {
                List<Nodo> res = greeter.mo(tipoNodos);
                if (jcbxCantidad.getSelectedItem().toString().equals("Todos")) {
                    recargar(res);
                } else if (jcbxCantidad.getSelectedItem().toString().equals("1")) {
                    List<Nodo> res2 = new ArrayList<>();
                    for (Nodo re : res) {
                        if (re.getNombre().equals(jtxtInicio.getText())) {
                            res2.add(re);
                        }
                    }
                    recargar2(res2);
                } else if (jcbxCantidad.getSelectedItem().toString().equals("1+")) {
                    List<Nodo> res2 = new ArrayList<>();
                    int idc = 0;
                    for (Nodo re : res) {
                        if (re.getNombre().equals(jtxtInicio.getText())) {
                            idc = re.getCodigo();
                        }
                    }
                    for (Nodo re : res) {
                        if (re.getCodigo() == idc && !re.getNombre().equals(jtxtInicio.getText())) {
                            res2.add(re);
                        }
                    }
                    recargar2(res2);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            renderizarTabla("Id de Comunidad");
        }
    }//GEN-LAST:event_jbtnCalcularActionPerformed

    public void recargar(List<Nodo> lista) {
        DefaultTableModel model = (DefaultTableModel) tblRes.getModel();
        model.setRowCount(0);

        Object[] lis = new Object[2];
        for (Nodo p : lista) {
            lis[0] = p.getNombre();
            lis[1] = p.getSimilitud();
            model.addRow(lis);
        }
        tblRes.setModel(model);
    }
    
    public void recargar2(List<Nodo> lista) {
        DefaultTableModel model = (DefaultTableModel) tblRes.getModel();
        model.setRowCount(0);

        Object[] lis = new Object[2];
        for (Nodo p : lista) {
            lis[0] = p.getNombre();
            lis[1] = p.getCodigo();
            model.addRow(lis);
        }
        tblRes.setModel(model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCalcular;
    private javax.swing.JComboBox<String> jcbxAlgoritmo;
    private javax.swing.JComboBox<String> jcbxCantidad;
    private javax.swing.JComboBox<String> jcbxClaseNodos;
    private javax.swing.JLabel jlbInicio;
    private javax.swing.JLabel jlblFin;
    private javax.swing.JTextField jtxtDestino;
    private javax.swing.JTextField jtxtInicio;
    private javax.swing.JTable tblRes;
    // End of variables declaration//GEN-END:variables
}