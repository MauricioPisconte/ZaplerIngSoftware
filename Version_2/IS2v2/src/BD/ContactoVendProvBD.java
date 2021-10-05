package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;

public class ContactoVendProvBD {
    public static String url = "jdbc:mysql://localhost:3306/zapleringsoftware";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public  void IngresarContactoVendProvee(ContactoVendProv contProv) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO CONTACTOVENDPROV VALUES(?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, contProv.getCodVendedor());
        pst.setInt(2, contProv.getRucProveedor());
        pst.setString(3, contProv.getFechaU());
        pst.executeUpdate();
        pst.close();
        con.close();
    }
    public  ArrayList<ContactoVendProv> obtenerContactoVendProvee() throws Exception{
        ArrayList<ContactoVendProv> listacontactoVP = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM CONTACTOVENDPROV;";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int CodVendedor = rs.getInt("COD_VENDEDOR");
            int RucProveedor =  rs.getInt("RUC_PROVEEDOR");
            String fecha0 = rs.getString("FECHACIERRE");
            ContactoVendProv cdpv = new ContactoVendProv(CodVendedor, RucProveedor,fecha0);
            listacontactoVP.add(cdpv);
        }
        rs.close();
        pst.close();
        con.close();
        return listacontactoVP;
    }
    public void actualizarfecha(String fecha, int codv,int rucp) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "UPDATE CONTACTOVENDPROV SET FECHACONTACTO = ?  WHERE CODVENDEDOR = "+codv
                + " AND RUCPROVEEDOR = "+rucp;
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, fecha);
            pst.executeUpdate();
        }
        System.out.println("actualizado correctamente");
    }

}
