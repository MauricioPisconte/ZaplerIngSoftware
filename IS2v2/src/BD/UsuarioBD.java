package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioBD {

    public static String url = "jdbc:mysql://localhost:3306/zapleringsoftware";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public ArrayList<Usuario> InicioDeSesion(int cod, String pass) throws Exception{
        ArrayList<Usuario> listUsuario = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM VENDEDOR WHERE CODIGO ="+cod+"AND PASS = '"+pass + "'";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery(sql);
        while(rs.next()){
            int Codigo = rs.getInt("CODIGO");
            String Contra =  rs.getString("PASS");
            String Nombre = rs.getString("NOMBRE");
            String Apellido = rs.getString("APELLIDO");

            Usuario usuario = new Usuario(Codigo,Contra,Nombre,Apellido);
            listUsuario.add(usuario);
        }
        rs.close();
        pst.close();
        con.close();
        return listUsuario;
    }
}
