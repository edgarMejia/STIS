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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edgar Mejía
 */
public class FrmMunicipio extends javax.swing.JInternalFrame {
    /**
     * Creates new form FrmMunicipio
     */
    public FrmMunicipio() {
        initComponents();
        tablaE();
        jCbxDepartamentos.removeAllItems();
        llenarCombo();
        this.jTXTCodMunicipio.setVisible(false);
    }
    
    DaoMunicipio daom = new DaoMunicipio();
    Municipio mun = new Municipio();
    Departamento dep = new Departamento();
    
    public void llenarTabla(){
        int fila = this.jTableMunicipio.getSelectedRow();
        this.jTXTCodMunicipio.setText(String.valueOf(this.jTableMunicipio.getValueAt(fila, 0)));
        this.jTXTNombre.setText(String.valueOf(this.jTableMunicipio.getValueAt(fila, 1)));
    }
    
    public void llenarCombo(){
        Conexion c = new Conexion();
        ResultSet res;
        try {
            c.conectar();
            String sql = "SELECT nombre_departamento FROM Departamento WHERE activo = 1";
            
            PreparedStatement pre = c.getCon().prepareCall(sql);
            res = pre.executeQuery();
            
            while(res.next()){
                jCbxDepartamentos.addItem(res.getString("nombre_departamento"));
            }
        } catch (Exception e) {
            e.toString();
        }
    }
    
    public void tablaE(){
        String [] columnas = {"id", "Municipio", "Departamento"} ;
        Object[] obj = new Object[3];
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        List ls;
        try {
           ls = daom.mostrarMunicipio();
            for(int i=0; i<ls.size(); i++){
                mun = (Municipio)ls.get(i);
                obj[0] = mun.getCodmunicipio();
                obj[1] = mun.getMunicipio();
                obj[2] = dep.getDepartamento();
                tabla.addRow(obj);
            }
            ls = daom.mostrarMunicipio();
            this.jTableMunicipio.setModel(tabla);
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al mostrar datos" + e.toString());
        }
    }

    public void insertar(){
        try {
            //Municipio mu= new Municipio();
            Departamento d = new Departamento();
            
           //mun.setCodmunicipio(Integer.parseInt(this.jTXTCodMunicipio.getText().trim()));
           mun.setMunicipio(this.jTXTNombre.getText().trim());
           String depa = jCbxDepartamentos.getSelectedItem().toString();
           String sql = "SELECT id_departamento FROM Departamento WHERE nombre_departamento = '" + depa + "'";
           int idDepa = daom.valorInteger(sql);
           d.setCoddepartamento(idDepa);
           
           d.setDepartamento(depa);
           mun.setDepartamento(d);
           
           daom.insertarMunicipio(mun);
           JOptionPane.showMessageDialog(null, "Datos Insertado Correctamente");
           tablaE();
           limpiar();
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this,e.toString(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void limpiar(){
        this.jTXTCodMunicipio.setText("");
        this.jTXTNombre.setText("");
        this.jCbxDepartamentos.setSelectedIndex(0);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTXTCodMunicipio = new javax.swing.JTextField();
        jTXTNombre = new javax.swing.JTextField();
        jCbxDepartamentos = new javax.swing.JComboBox<>();
        BtnInsertar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMunicipio = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("GESTIONAR MUNICIPIO");

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

        jTableMunicipio.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableMunicipio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMunicipioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMunicipio);

        jButton1.setText("Limpiar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTXTCodMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTXTNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(jCbxDepartamentos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(BtnInsertar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTXTCodMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTXTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jCbxDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(BtnInsertar)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnInsertarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnInsertarMouseClicked
        if(this.jTXTNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
        }else{
            insertar();
        }
    }//GEN-LAST:event_BtnInsertarMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTableMunicipioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMunicipioMouseClicked
        // TODO add your handling code here:
        llenarTabla();
    }//GEN-LAST:event_jTableMunicipioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnInsertar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jCbxDepartamentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTXTCodMunicipio;
    private javax.swing.JTextField jTXTNombre;
    private javax.swing.JTable jTableMunicipio;
    // End of variables declaration//GEN-END:variables
}
