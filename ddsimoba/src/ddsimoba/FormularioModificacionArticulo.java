/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddsimoba;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FormularioModificacionArticulo extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormularioModificacionArticulo
     */
    public FormularioModificacionArticulo(String id, String nombre, String desc) {
        initComponents();
        setValores(id, nombre, desc);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        id_art = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nombre_art = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        desc_art = new javax.swing.JTextField();
        modificar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Modificación Artículo");

        jLabel1.setText("ID");

        id_art.setEditable(false);
        id_art.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_artActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        nombre_art.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_artActionPerformed(evt);
            }
        });

        jLabel3.setText("Descripción");

        desc_art.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc_artActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombre_art)
                                    .addComponent(id_art)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(desc_art, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(modificar)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id_art, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre_art, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(desc_art, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(modificar)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setValores(String id, String nombre, String desc){
        this.id_art.setText(id);
        this.nombre_art.setText(nombre);
        this.desc_art.setText(desc);
    }
    
    private void id_artActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_artActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_artActionPerformed

    private void nombre_artActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_artActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_artActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        ConexionDB conexion = new ConexionDB();
        
        PreparedStatement pstm = null;
        String id = this.id_art.getText();
        String nombre = this.nombre_art.getText();
        String desc = this.desc_art.getText();
        
        String sqlQuery = "UPDATE tienda SET idarticulo= ?, nombre= ?, descripcion= ? WHERE idarticulo= ?";
        
        try{
            pstm = conexion.con.prepareStatement(sqlQuery);
            
            pstm.setString(1, id);
            pstm.setString(2, nombre);
            pstm.setString(3, desc);
            pstm.setString(4, id);
            
            int resultado = pstm.executeUpdate();
            
            if (resultado==1){
                JOptionPane.showMessageDialog(null, "Se ha actualizado la fila correctamente", "Alerta ", JOptionPane.INFORMATION_MESSAGE);
            }else{
                throw new RuntimeException("No se pudo actualizar la fila la fila");
            }
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
            throw new RuntimeException(ex);
        }finally{
            
            try{
                if(pstm!=null) pstm.close();
                if(conexion.con!=null) conexion.cerrarConexionDB();
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
                throw new RuntimeException(ex);
            }
        }
        this.dispose();
    }//GEN-LAST:event_modificarActionPerformed

    private void desc_artActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desc_artActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desc_artActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField desc_art;
    private javax.swing.JTextField id_art;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nombre_art;
    // End of variables declaration//GEN-END:variables
}