/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import BD.*;
import Entidades.*;
import JoinBD.*;
import Joins.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesus
 */
public class Catalogo extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    Catalogo_MaquinariaBD ctdb = new Catalogo_MaquinariaBD();
    public Menu menu;
    
    public Catalogo() throws Exception {
        initComponents();
        setLocationRelativeTo(this);
        actualizarMarcayTipo();
        actualizarCat();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BackMenuButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCatalogo = new javax.swing.JTable();
        MarcaBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ModeloBox = new javax.swing.JComboBox<>();
        TipoBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Catalogo Zapler");

        BackMenuButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BackMenuButton.setText("Regresar");
        BackMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackMenuButtonActionPerformed(evt);
            }
        });

        TablaCatalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDMaquinaria", "Tipo", "Costo", "Marca", "Modelo"
            }
        ));
        TablaCatalogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCatalogoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaCatalogo);

        MarcaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarcaBoxActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Marca:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Modelo:");

        ModeloBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModeloBoxActionPerformed(evt);
            }
        });

        TipoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Tipo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MarcaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(BackMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ModeloBox, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MarcaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ModeloBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(BackMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
     public void actualizarCat() throws Exception{
        CleanTable();
        String modelo = this.ModeloBox.getSelectedItem().toString();
        String marca = this.MarcaBox.getSelectedItem().toString();
        String tipo = this.TipoBox.getSelectedItem().toString();
        ArrayList<Catalogo_Maquinaria> CatMaq = ctdb.obtenerCatalogo(modelo, marca, tipo);
        DefaultTableModel tb = (DefaultTableModel)TablaCatalogo.getModel();
        CatMaq.forEach((objeto) -> {
            tb.addRow(new Object[]{objeto.getIdMaquinaria(), objeto.getTipo(),
                String.valueOf(objeto.getCosto()),
                objeto.getMarca(),
                objeto.getModelo()});
        });
    }
     
     public void actualizarMarcayTipo()
    {
        try {
            // TODO add your handling code here:
            RemoverItems(MarcaBox);
            RemoverItems(TipoBox);
            RemoverItems(ModeloBox);
            MarcaBox.addItem("");
            TipoBox.addItem("");
            ModeloBox.addItem("");
            ArrayList<Catalogo_Maquinaria> obtenerCatMaq= ctdb.obtenerCatalogo(MarcaBox.getSelectedItem().toString()
                    ,TipoBox.getSelectedItem().toString()
                    , ModeloBox.getSelectedItem().toString());
            obtenerCatMaq.forEach( catmaq -> {
                MarcaBox.addItem(catmaq.getMarca());
                TipoBox.addItem(catmaq.getTipo());
                ModeloBox.addItem(catmaq.getModelo());
            });
        } catch (Exception ex) {
            System.out.println("Obteniendo elementos");
        }
    }
     
    private void RemoverItems(javax.swing.JComboBox<String> obj)
    {
        obj.removeAllItems();
    }
     
     public void CleanTable() {
        DefaultTableModel tb = (DefaultTableModel)TablaCatalogo.getModel();
        for(int i=tb.getRowCount()-1; i>=0;i--){
            tb.removeRow(i);
        }
    }
    
    private void BackMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackMenuButtonActionPerformed
        // TODO add your handling code here:
        Regresar();
    }//GEN-LAST:event_BackMenuButtonActionPerformed

    private void TipoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoBoxActionPerformed
        try {
            // TODO add your handling code here:
            actualizarCat();
        } catch (Exception ex) {
            System.out.println("Obteniendo elementos");
        }
    }//GEN-LAST:event_TipoBoxActionPerformed

    private void MarcaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcaBoxActionPerformed
        try {
            // TODO add your handling code here:
            actualizarCat() ;
        } catch (Exception ex) {
            System.out.println("Obteniendo elementos");
        }
    }//GEN-LAST:event_MarcaBoxActionPerformed

    private void ModeloBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModeloBoxActionPerformed
        try {
            // TODO add your handling code here:
            actualizarCat() ;
        } catch (Exception ex) {
            System.out.println("Obteniendo elementos");
        }
    }//GEN-LAST:event_ModeloBoxActionPerformed

    private void TablaCatalogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCatalogoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_TablaCatalogoMouseClicked

    
    private void Regresar(){
        this.setVisible(false);
        menu.setVisible(true);
    }
    
    public void LimpiarReserva()
    {
        DefaultTableModel tb = (DefaultTableModel)TablaCatalogo.getModel();
        for(int i=tb.getRowCount()-1; i>=0;i--){
            tb.removeRow(i);
        }
    }
    
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
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Catalogo().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackMenuButton;
    private javax.swing.JComboBox<String> MarcaBox;
    private javax.swing.JComboBox<String> ModeloBox;
    private javax.swing.JTable TablaCatalogo;
    private javax.swing.JComboBox<String> TipoBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
