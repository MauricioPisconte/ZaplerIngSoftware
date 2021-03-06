/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import BD.*;
import Entidades.*;
import JoinBD.*;
import Joins.Maq_CatMaq;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Jesus
 */
public class RegReserva extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    EmpresaBD empresabd = new EmpresaBD();
    RepresentanteBD representanteDB = new RepresentanteBD();
    Catalogo_MaquinariaBD catalogo_Maquinaria =  new Catalogo_MaquinariaBD();
    Maq_CatMaqBD MaqCatDB = new Maq_CatMaqBD();
    MaquinariaBD maquinariaBD = new MaquinariaBD();
    AtencionClienteBD atencionClienteBD = new AtencionClienteBD();
    ReservaBD reservaBD = new ReservaBD();
    ContactoVendProvBD Cbd = new ContactoVendProvBD();
    ListaReservasBD listaResBD = new ListaReservasBD();
    RecibeAtencionBD recibeAtencionBD = new RecibeAtencionBD();
    Random rd = new Random();
    AtencionClienteBD abd = new AtencionClienteBD();
    ProveedorBD prbd = new  ProveedorBD();
    ArrayList<Reserva> reservasJuntas;
    int ID_LISTANUMBER = rd.nextInt(99999999-10000000+1)+10000000;
    
    public Menu menu;
    
    public RegReserva() throws Exception {
        initComponents();
        setLocationRelativeTo(this);
        ListaNueva();
        actualizarEmpresaBox();
        actualizarMarcayTipo();
        //actualizarMaqyCatMaq();
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
        CantidadField = new javax.swing.JTextField();
        BackMenuButton = new javax.swing.JButton();
        RegistrarRepresentante = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        invtab = new javax.swing.JTable();
        EmpBox = new javax.swing.JComboBox<>();
        RepEmpBox = new javax.swing.JComboBox<>();
        TipoBox = new javax.swing.JComboBox<>();
        MarcaBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        ModeloBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Registro de reserva");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Empresa:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Representante:");

        CantidadField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CantidadField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantidadFieldActionPerformed(evt);
            }
        });

        BackMenuButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BackMenuButton.setText("Regresar");
        BackMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackMenuButtonActionPerformed(evt);
            }
        });

        RegistrarRepresentante.setText("Registrar Representante");
        RegistrarRepresentante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarRepresentanteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Marca:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Tipo:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Cantidad:");

        jButton2.setText("Solicitar Maquinaria");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        invtab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Costo", "Marca", "Modelo", "Prov.", "Stock", "Estado", "Desc."
            }
        ));
        invtab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invtabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(invtab);

        EmpBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpBoxActionPerformed(evt);
            }
        });

        RepEmpBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepEmpBoxActionPerformed(evt);
            }
        });

        TipoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoBoxActionPerformed(evt);
            }
        });

        MarcaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarcaBoxActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Modelo:");

        ModeloBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModeloBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(125, 125, 125))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RegistrarRepresentante)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(302, 302, 302)
                                .addComponent(TipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(BackMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jButton2)))
                        .addGap(62, 62, 62))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(MarcaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ModeloBox, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(CantidadField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGap(22, 22, 22)))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RepEmpBox, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EmpBox, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(EmpBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(RepEmpBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RegistrarRepresentante)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(TipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MarcaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(CantidadField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(ModeloBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CantidadFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantidadFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantidadFieldActionPerformed

    private void BackMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackMenuButtonActionPerformed
        // TODO add your handling code here:
        if(!this.reservasJuntas.isEmpty())
        {
            try {
                Guardar();
            } catch (Exception ex) {
                Logger.getLogger(RegReserva.class.getName()).log(Level.SEVERE, null, ex);
            }
            ListaNueva();
        }
        Regresar();
    }//GEN-LAST:event_BackMenuButtonActionPerformed

    public void ListaNueva()
    {
        reservasJuntas = new ArrayList<>();
    }
    
    private void Regresar(){
        this.setVisible(false);
        menu.setVisible(true);
    }
    
    public void CleanTable(){
        DefaultTableModel tb = (DefaultTableModel)invtab.getModel();
        for(int i=tb.getRowCount()-1; i>=0;i--){
            tb.removeRow(i);
        }
    }
    
    private void RegistrarRepresentanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarRepresentanteActionPerformed
        // TODO add your handling code here:
        RegRepresentante regRepresentante = new RegRepresentante();
        RegReserva estaClase = this;
        int ruc;
        regRepresentante.regReserva = estaClase;
        try {
            ruc = empresabd.obtenerRucEmp(EmpBox.getSelectedItem().toString());
            regRepresentante.ruc = ruc;
            regRepresentante.setVisible(true);
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(RegReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RegistrarRepresentanteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String modelo = this.ModeloBox.getSelectedItem().toString();
        String marca = this.MarcaBox.getSelectedItem().toString();
        String tipo = this.TipoBox.getSelectedItem().toString();
        if(modelo.equalsIgnoreCase("") ||  marca.equalsIgnoreCase("") || tipo.equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Se envi?? un mensaje de importaci??n al administrador de ventas :D");
            ContactoVendProv pdc = new ContactoVendProv();
            Random num = new Random();
            int n = (-1)*(num.nextInt(5)+1);
            int codigoVend = menu.CodigoVendedor;
            try {
                String fecha = abd.fechahora();
                String fech = "";
                for(int i=0; i<10;i++)
                {
                    fech += fecha.charAt(i);
                }
                int rpr = prbd.obtenerNP(tipo, marca);
                pdc.setCodVendedor(codigoVend);
                pdc.setRucProveedor(rpr);
                System.out.println(fech);
                pdc.setFechaU(fech);
                Cbd.IngresarContactoVendProvee(pdc);
                maquinariaBD.actualizarStock(tipo, marca, modelo, n);
                maquinariaBD.actualizarDispo(tipo, marca, modelo,"DISPONIBLE");
            } catch (Exception ex) {
                String fecha;
                try {
                    fecha = abd.fechahora();
                    String fech = "";
                    for(int i=0; i<10;i++)
                    {
                        fech += fecha.charAt(i);
                    }
                    int rpr = prbd.obtenerNP(tipo, marca);
                    Cbd.actualizarfecha(fech, codigoVend, rpr);
                    maquinariaBD.actualizarStock(tipo, marca, modelo, n);
                    maquinariaBD.actualizarDispo(tipo, marca, modelo,"DISPONIBLE");
                } catch (Exception ex1) {
                    Logger.getLogger(RegReserva.class.getName()).log(Level.SEVERE, null, ex1);
                    this.CantidadField.setText("");
                }
            }  
        }else{
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void EmpBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpBoxActionPerformed
        actualizarRepBox();
        if(!this.reservasJuntas.isEmpty())
        {
            try {
                Guardar();
            } catch (Exception ex) {
                Logger.getLogger(RegReserva.class.getName()).log(Level.SEVERE, null, ex);
            }
            ListaNueva();
        }
    }//GEN-LAST:event_EmpBoxActionPerformed

    private void Guardar() throws Exception
    {
        ListaReservas listres = new ListaReservas();
        listres.setIDListaReservas(ID_LISTANUMBER);
        listaResBD.IngresarListaReservas(listres);
        int cantidadE = reservasJuntas.size();
        for(int i = 0; i < cantidadE; i++)
        {
            System.out.println("Entrar bucle");
            reservasJuntas.get(i).setID_ListaReservas(ID_LISTANUMBER);
            reservaBD.IngresarReserva(reservasJuntas.get(i));
        }
        ListaNueva();
        ID_LISTANUMBER= rd.nextInt(99999999-10000000+1)+10000000;
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
            ArrayList<Catalogo_Maquinaria> obtenerCatMaq= catalogo_Maquinaria.obtenerCatalogo(MarcaBox.getSelectedItem().toString()
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
    
    public  void actualizarEmpresaBox() throws Exception{
        RemoverItems(EmpBox);
            ArrayList<Empresa> obtenerEmpresa = empresabd.obtenerEmpresa();
            EmpBox.addItem("");
            obtenerEmpresa.forEach( emp -> {
                if(emp.isDisponibilidad()){
                    EmpBox.addItem(emp.getNombreEmpresa());
                }
            });
    }
    
    public void actualizarMaqyCatMaq() throws Exception{
        CleanTable();
        String modelo = ModeloBox.getSelectedItem().toString();
        String marca = MarcaBox.getSelectedItem().toString();
        String tipo = TipoBox.getSelectedItem().toString();
        ArrayList<Maq_CatMaq>MaqCat = MaqCatDB.JoinCatMaqVend(modelo, marca, tipo);
        DefaultTableModel tb = (DefaultTableModel)invtab.getModel();
        MaqCat.forEach((objeto) -> {
            tb.addRow(new String[]{objeto.getTipo(),
                String.valueOf(objeto.getCosto()),
                objeto.getMarca(),
                objeto.getModelo(), 
                objeto.getNombreProveedor(),
                String.valueOf(objeto.getStock()),
                objeto.getEstado(),
                String.valueOf(objeto.getDescuento())});
        });
    }
    
    private void RemoverItems(javax.swing.JComboBox<String> obj)
    {
        obj.removeAllItems();
    }
    
    public  void actualizarRepBox(){
        try {
            // TODO add your handling code here:
            RemoverItems(RepEmpBox);
            ArrayList<Representante> obtenerRep = representanteDB.obtenerRepresentante(empresabd.obtenerRucEmp(EmpBox.getSelectedItem().toString()));
            RepEmpBox.addItem("");
            obtenerRep.forEach( rep -> {
                RepEmpBox.addItem(rep.getNombre() + rep.getApellido());
            });
        } catch (Exception ex) {
            Logger.getLogger(RegReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void RepEmpBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepEmpBoxActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_RepEmpBoxActionPerformed

    private void MarcaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcaBoxActionPerformed
        try {
            // TODO add your handling code here:
            actualizarMaqyCatMaq() ;
        } catch (Exception ex) {
            System.out.println("Obteniendo elementos");
        }
    }//GEN-LAST:event_MarcaBoxActionPerformed

    private void ModeloBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModeloBoxActionPerformed
        try {
            // TODO add your handling code here:
            actualizarMaqyCatMaq() ;
        } catch (Exception ex) {
            System.out.println("Obteniendo elementos");
        }
    }//GEN-LAST:event_ModeloBoxActionPerformed

    private void TipoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoBoxActionPerformed
        try {
            // TODO add your handling code here:
            actualizarMaqyCatMaq() ;
        } catch (Exception ex) {
            System.out.println("Obteniendo elementos");
        }
    }//GEN-LAST:event_TipoBoxActionPerformed

    private void invtabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invtabMouseClicked
        // TODO add your handling code here:
        int index = invtab.getSelectedRow();
        TableModel model = invtab.getModel();
        String modelo = model.getValueAt(index, 3).toString();
        String marca = model.getValueAt(index, 2).toString();
        String tipo = model.getValueAt(index, 0).toString();
        String desct = model.getValueAt(index, 7).toString();
        String precio = model.getValueAt(index, 1).toString();
        
        try {
            int cantidadReservada = Integer.parseInt(this.CantidadField.getText());
            int numstock = maquinariaBD.verStock(modelo, marca, tipo);
            if(numstock <= 0 || cantidadReservada > numstock )
            {
                JOptionPane.showMessageDialog(null, "No hay disponibilidad para cubrir este pedido");
            }
            else
            {
            maquinariaBD.actualizarStock(modelo, marca, tipo, cantidadReservada);
            int invid = catalogo_Maquinaria.obtenerInvID(modelo, marca, tipo);
            //colocarid(n);
            //colocarcant(numero);
            //mandarparametros(tipo, marca, modelo);
            int newstock = maquinariaBD.verStock(modelo, marca, tipo);
            float total = Integer.parseInt(precio) * cantidadReservada  * (1-Float.parseFloat(desct)) ;
            JOptionPane.showMessageDialog(null, "Importe total comunicado al area de ventas: "+total +" nuevos soles");
            if( newstock == 0)
            {
                maquinariaBD.actualizarDispo(modelo, marca, tipo,"NO DISPONIBLE");
            }
            //Setear la reserva y la atenci??n al cliente
            
        int antencionid = rd.nextInt(99999999-10000000+1)+10000000;
        AtencionCliente act = new AtencionCliente();
        //PersonaDeContacto pdc = new PersonaDeContacto(); :D
        //Empresa emp = new Empresa();
        Reserva res = new Reserva();
        RecibeAtencion ra = new RecibeAtencion();
        
        String fandh = atencionClienteBD.fechahora();
        String fecha = "";
        String  hora = "";
        System.out.println(fandh);
        for(int i=0; i<10;i++)
        {
            fecha += fandh.charAt(i);
        }
        System.out.println("");
        for(int i=11; i<19;i++)
        {
            hora += fandh.charAt(i);
        }
       
            int RucEmp = empresabd.obtenerRucEmp(EmpBox.getSelectedItem().toString());
            //LLENAR RESERVAS
            res.setID_Reserva(rd.nextInt(99999999-10000000+1)+10000000);
            res.setCodigoVendedor(menu.CodigoVendedor);
            res.setInv_Id(invid);
            res.setCantidad(cantidadReservada);       
           // LLENAR ATENCION CLIENTE
            act.setIDAtencion(antencionid);
            act.setTiempoInicioAtencion(hora);
            act.setFecha(fecha);
            act.setDescripcion("Usuario atendido");
            act.setCodVendedor(menu.CodigoVendedor);
            //LLENA RECIBE ATENCION
            ra.setIdAtencion(antencionid);
            ra.setRucEmpresa(RucEmp);
            ra.setID_ListaReserva(ID_LISTANUMBER);
            //reservaBD.IngresarReserva(res);
            atencionClienteBD.IngresarAtencionCliente(act);
            recibeAtencionBD.IngresarRecibeAtencion(ra);
            reservasJuntas.add(res);
            }
            this.CantidadField.setText("");
        } catch (Exception ex) {
                      JOptionPane.showMessageDialog(null, "Error: Se introdujo un valor distinto al num??rico");
                      this.CantidadField.setText("");
        }      
        actualizarMarcayTipo();
    }//GEN-LAST:event_invtabMouseClicked
    
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
            java.util.logging.Logger.getLogger(RegReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
            public void run() {
                try {
                    new RegReserva().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(RegReserva.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackMenuButton;
    private javax.swing.JTextField CantidadField;
    private javax.swing.JComboBox<String> EmpBox;
    private javax.swing.JComboBox<String> MarcaBox;
    private javax.swing.JComboBox<String> ModeloBox;
    private javax.swing.JButton RegistrarRepresentante;
    private javax.swing.JComboBox<String> RepEmpBox;
    private javax.swing.JComboBox<String> TipoBox;
    private javax.swing.JTable invtab;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
