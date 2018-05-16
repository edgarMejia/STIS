/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista;

import com.conexion.Conexion;
import com.controlador.DaoMunicipio;
import com.modelo.Departamento;
import com.modelo.Municipio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos franco
 */
public class FrmMunicipio extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmMunicipio
     */
    public FrmMunicipio() {
        initComponents();
        jCbxDepartamentos.removeAllItems();
        llenarCombo();
        
    }
    
    DaoMunicipio daom = new DaoMunicipio();
    Municipio mun = new Municipio();
    //<editor-fold defaultstate="collapsed" desc="llenarComboBox">
    public void llenarCombo(){
        Conexion c = new Conexion();
        ResultSet res;
        try {
            c.conectar();
            String sql="select nombre from Departamento";
            
            PreparedStatement pre = c.getCon().prepareCall(sql);
            res=pre.executeQuery();
            
            while(res.next()){
                jCbxDepartamentos.addItem(res.getString("nombre"));
            }
        } catch (Exception e) {
            e.toString();
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="insertarMunicipio">
    public void insertar(){
        try 
        {
            Municipio mu= new Municipio();
            Departamento d= new Departamento();
            
           mun.setId_municipio(Integer.parseInt(this.jTXTCodMunicipio.getText().trim()));
           mun.setNombre(this.jTXTNombre.getText().trim());
           String depa= jCbxDepartamentos.getSelectedItem().toString();
           String sql="select id_departamento from Departamento where nombre='"+depa+"'";
           int idDepa=daom.valorInteger(sql);
           d.setCodigoDepartamento(idDepa);
           
           d.setDepartamento(depa);
           mun.setDepartamento(d);
           
           
           daom.insertarMunicipio(mun);
           JOptionPane.showMessageDialog(null,"Datos Insertado Correctamente");
           /**tablaE();
           limpiar();**/
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this,e.toString(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//</editor-fold>
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTXTCodMunicipio = new javax.swing.JTextField();
        jTXTNombre = new javax.swing.JTextField();
        jCbxDepartamentos = new javax.swing.JComboBox<>();
        BtnInsertar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("GESTIONAR MUNICIPIO");

        jLabel2.setText("Codigo Municipio:");

        jLabel3.setText("Nombre de Municipio:");

        jLabel4.setText("Departamento:");

        BtnInsertar.setText("Ingresar");
        BtnInsertar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnInsertarMouseClicked(evt);
            }
        });

        jButton2.setText("Modificar");

        jButton3.setText("Eliminar");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCbxDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTXTCodMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTXTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(BtnInsertar)
                        .addGap(35, 35, 35)
                        .addComponent(jButton2)
                        .addGap(44, 44, 44)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTXTCodMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTXTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jCbxDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnInsertar)
                        .addComponent(jButton3))
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnInsertarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnInsertarMouseClicked
        insertar();
    }//GEN-LAST:event_BtnInsertarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnInsertar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jCbxDepartamentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTXTCodMunicipio;
    private javax.swing.JTextField jTXTNombre;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}