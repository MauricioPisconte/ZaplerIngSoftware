package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;

public class RepresentanteBD {
    public static String url = "jdbc:mysql://localhost:3306/zapleringsoftware";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public void IngresarPersonaContacto(Representante representante) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO PERSONA_DE_CONTACTO VALUES(?, ?,?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, representante.getDNI());
        pst.setString(2, representante.getNombre());
        pst.setString(3, representante.getApellido());
        pst.setInt(4, representante.getRUCEmpresa());
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public ArrayList<Representante> obtenerRepresentante() throws Exception{
        ArrayList<Representante> listRepresentante = new ArrayList<>();
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM REPRESENTANTE";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int Dni = rs.getInt("DNI");
            String Nombre =  rs.getString("NOMBRE");
            String Apellido = rs.getString("APELLIDO");
            int RucEmpresa = rs.getInt("RUC_EMPRESA");
            Representante pdc = new Representante(Dni,  Nombre,  Apellido,  RucEmpresa);
            listRepresentante.add(pdc);
        }
        rs.close();
        pst.close();
        conn.close();
        return listRepresentante;
    }

}
