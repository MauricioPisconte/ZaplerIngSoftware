package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;

public class MaquinariaBD {
    public static String url = "jdbc:mysql://localhost:3306/zapleringsoftware";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public  void IngresarMaquinaria(Maquinaria maq) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO MAQUINARIA VALUES(?, ?, ?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, maq.getInv_Id());
        pst.setString(2, maq.getEstado());
        pst.setFloat(3, maq.getDescuento());
        pst.setInt(4, maq.getStock());
        pst.setInt(5, maq.getNAlmacen());
        pst.setInt(6, maq.getIdMaq());
        pst.setInt(7, maq.getRUCProveedor());

        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public  ArrayList<Maquinaria> obtenerMaquinaria() throws Exception{
        ArrayList<Maquinaria> listaMaquinaria = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM MAQUINARIA";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int Inv_Id = rs.getInt("INV_ID");
            String estado =  rs.getString("ESTADO");
            float descuento = rs.getFloat("DESCUENTO");
            int stock = rs.getInt("STOCK");
            int almacen = rs.getInt("N_ALMACEN");
            int idmaq = rs.getInt("ID_MAQ");
            int RUCProveedor = rs.getInt("RUC_PROVEEDOR");
            Maquinaria maq = new Maquinaria(Inv_Id,  estado,  descuento,  stock,  almacen,  idmaq,  RUCProveedor);
            listaMaquinaria.add(maq);
        }
        rs.close();
        pst.close();
        con.close();
        return listaMaquinaria;
    }



    // necesario implementar una funcion propia para ver stock de cada maquinaria
    public  int verStock(String modelo, String marca, String tipo) throws Exception{
        int actualstock  = 0;
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT STOCK FROM MAQUINARIA WHERE ID_MAQ IN (SELECT ID_MAQ FROM CATALOGO_MAQUINARIA " +
                "WHERE TIPO = '"+tipo+"' AND MARCA = '"+marca+"' AND MODELO = '"+modelo+"')";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int stock = rs.getInt("STOCK");
            actualstock = stock;
        }
        rs.close();
        pst.close();
        con.close();
        return actualstock;
    }



    public void actualizarStock(String modelo, String marca, String tipo, int cantidad) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "UPDATE MAQUINARIA SET STOCK = STOCK - ? "
                + " WHERE ID_MAQ IN (SELECT C.ID_MAQ FROM CATALOGO_MAQUINARIA C, PROVEEDOR P, MAQUINARIA M "
                +"WHERE C.ID_MAQ = M.ID_MAQ AND M.RUC_PROVEEDOR = P.RUC_PROVEEDOR AND C.TIPO = ? AND C.MARCA "
                + "= ? AND C.MODELO = ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, cantidad);
            pst.setString(2, tipo);
            pst.setString(3, marca);
            pst.setString(4, modelo);
            pst.executeUpdate();
        }
        System.out.println("actualizado correctamente");
    }

    public void actualizarDispo(String modelo, String marca, String tipo, String dispo) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "UPDATE MAQUINARIA SET ESTADO = ?  WHERE ID_MAQ IN (SELECT ID_MAQ FROM CATALOGO_MAQUINARIA " +
                "WHERE TIPO = ? AND MARCA = ? AND MODELO = ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, dispo);
            pst.setString(2, tipo);
            pst.setString(3, marca);
            pst.setString(4, modelo);
            pst.executeUpdate();
        }
        System.out.println("actualizado correctamente");
    }

}
