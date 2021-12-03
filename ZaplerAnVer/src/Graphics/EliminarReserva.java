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
public class EliminarReserva extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    Ped_CatMaq_EmpDB joinresbd = new Ped_CatMaq_EmpDB();
    EmpresaBD empresabd = new EmpresaBD();
    ReservaBD reservabd = new ReservaBD();
    ListaReservasBD listaBD = new ListaReservasBD();
    public Menu menu;
    
    public EliminarReserva() {
        initComponents();
        setLocationRelativeTo(this);
        actualizarEmpresas();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BackMenuButton = new javax.swing.JButton();
        BorrarResvButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPedido = new javax.swing.JTable();
        EmpresasBox = new javax.swing.JComboBox<>();
        ReservasBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Eliminar de reserva");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Empresa:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Reservas:");

        BackMenuButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BackMenuButton.setText("Regresar");
        BackMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackMenuButtonActionPerformed(evt);
            }
        });

        BorrarResvButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BorrarResvButton.setText("Borrar Reserva");
        BorrarResvButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarResvButtonActionPerformed(evt);
            }
        });

        TablaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod Vend", "Inv ID", "Cantidad", "Modelo"
            }
        ));
        TablaPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaPedido);

        EmpresasBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpresasBoxActionPerformed(evt);
            }
        });

        ReservasBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservasBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(BackMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(BorrarResvButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ReservasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmpresasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(136, 136, 136))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(EmpresasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ReservasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BorrarResvButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackMenuButtonActionPerformed
        // TODO add your handling code here:
        Regresar();
    }//GEN-LAST:event_BackMenuButtonActionPerformed

    private void BorrarResvButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarResvButtonActionPerformed
        try {
            // Borrar la lista de reservas
            listaBD.EliminarListaDeReservas(Integer.parseInt(ReservasBox.getSelectedItem().toString()));
            JOptionPane.showMessageDialog(null, "Se borró exitosamente la lista de reservas");
            this.actualizarListaReservas();
            this.actualizarReservas();
            
        } catch (Exception ex) {
            Logger.getLogger(EliminarReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BorrarResvButtonActionPerformed

    private void EmpresasBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpresasBoxActionPerformed
        try {
            // TODO add your handling code here:
            LimpiarReserva();
            actualizarListaReservas();

        } catch (Exception ex) {
            Logger.getLogger(EliminarReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EmpresasBoxActionPerformed

    private void TablaPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPedidoMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TablaPedidoMouseClicked

    private void ReservasBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservasBoxActionPerformed
        try {
            // TODO add your handling code here:
            LimpiarReserva();
            this.actualizarReservas();
        } catch (Exception ex) {
            Logger.getLogger(EliminarReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ReservasBoxActionPerformed

    private void actualizarEmpresas(){
        try {
            // TODO add your handling code here:
            EmpresasBox.removeAllItems();
            ArrayList<Empresa> obtenerEmpresa = empresabd.obtenerEmpresa();
            EmpresasBox.addItem("");
            obtenerEmpresa.forEach( emp -> {
                if(emp.isDisponibilidad())
                {
                    EmpresasBox.addItem(emp.getNombreEmpresa());
                }
            });
        } catch (Exception ex) {
            System.out.println("No hay empresas");
        }
    }
    
    private void actualizarListaReservas() throws Exception{
        ReservasBox.removeAllItems();
            int ruc = empresabd.obtenerRucEmp(EmpresasBox.getSelectedItem().toString());
            ArrayList<ListaReservas> lista = listaBD.ObtenerIDsListaReservas(ruc);
            ReservasBox.addItem("");
            lista.forEach( lis -> {
                ReservasBox.addItem(String.valueOf(lis.getIDListaReservas()));
            });
    }
    
    private void actualizarReservas() throws Exception{
 
            int reserva = Integer.parseInt(this.ReservasBox.getSelectedItem().toString());
            ArrayList<Resv_CatMaq_Emp> reservas =joinresbd.Join_Ped_CatMaq(reserva); //reservabd.obtenerReservasPorID(reserva);
            DefaultTableModel tb2 = (DefaultTableModel)TablaPedido.getModel();
            reservas.forEach((objeto) -> {
            tb2.addRow(new Object[]{objeto.getCodigoVendedor(),
            objeto.getInv_Id(),
            objeto.getCantidad(),
            objeto.getModelo()});
        });
    }
    
    private void Regresar(){
        this.setVisible(false);
        menu.setVisible(true);
    }
    
    public void LimpiarReserva()
    {
        DefaultTableModel tb = (DefaultTableModel)TablaPedido.getModel();
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
            java.util.logging.Logger.getLogger(EliminarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EliminarReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackMenuButton;
    private javax.swing.JButton BorrarResvButton;
    private javax.swing.JComboBox<String> EmpresasBox;
    private javax.swing.JComboBox<String> ReservasBox;
    private javax.swing.JTable TablaPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
