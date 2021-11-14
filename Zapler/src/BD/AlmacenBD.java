package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;

public class AlmacenBD {
    public static String url = "jdbc:mysql://localhost:3306/zapler";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public ArrayList<Almacen> obtenerAlmacen() throws Exception{
        ArrayList<Almacen> listAlmacen = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM ALMACEN";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery(sql);
        while(rs.next()){
            int NAlmacen = rs.getInt("N_ALMACEN");
            String Ubicacion =  rs.getString("UBICACION");
            Almacen aln = new Almacen(NAlmacen, Ubicacion);
            listAlmacen.add(aln);
        }
        rs.close();
        pst.close();
        con.close();
        return listAlmacen;
    }

}
