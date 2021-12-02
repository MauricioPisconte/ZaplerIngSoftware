package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;

public class ProveedorBD {
    public static String url = "jdbc:mysql://localhost:3306/zapleringsoftware";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public  void IngresarProveedor(Proveedor prove) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO PROVEEDOR VALUES(?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, prove.getRucProveedor());
        pst.setString(2, prove.getNombreProveedor());
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public  int obtenerProveedor(String tipo, String modelo, String marca) throws Exception{
        int rucprov = 0;
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT RUC_PROVEEDOR FROM PROVEEDOR WHERE NOMBRE_PROVEEDOR IN "
                + "(SELECT P.NOMBRE_PROVEEDOR FROM CATALOGO_MAQUINARIA C, PROVEEDOR P, "
                + "MAQUINARIA M WHERE C.ID_MAQ = M.ID_MAQ AND M.RUC_PROVEEDOR = "
                + "P.RUC_PROVEEDOR AND C.TIPO = '"+ tipo +"' AND C.MODELO = '"+ modelo +"' AND C.MARCA = '"+ marca +"')";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            rucprov = rs.getInt("RUC_PROVEEDOR");
        }
        rs.close();
        pst.close();
        con.close();
        return rucprov;
    }

    public  int obtenerNP( String modelo, String marca) throws Exception{
        int rucs = 0;
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT P.RUC_PROVEEDOR FROM PROVEEDOR P, MAQUINARIA M WHERE "
                + "P.RUC_PROVEEDOR = M.RUC_PROVEEDOR "+
                " AND M.INV_ID  = (SELECT M.INV_ID FROM MAQUINARIA M, CATALOGO_MAQUINARIA C WHERE C.ID_MAQ = M.ID_MAQ" +
                "  AND C.MODELO = '"+ modelo +"' AND C.MARCA = '"+ marca +"')";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            rucs = rs.getInt("RUC_PROVEEDOR");
        }
        rs.close();
        pst.close();
        con.close();
        return rucs;
    }

}
