package BD;
import Entidades.*;
import java.sql.*;
import java.util.*;

public class UsuarioBD {

    public static String url = "jdbc:mysql://localhost:3306/zapler";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public ArrayList<Usuario> InicioDeSesion(int cod, String pass) throws Exception{
        ArrayList<Usuario> listUsuario = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM USUARIO WHERE CODIGO ="+cod+" AND PASS = '"+pass + "'";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery(sql); //1
        while(rs.next()){ //2
            int Codigo = rs.getInt("CODIGO");
            String Contra =  rs.getString("PASS");
            String Nombre = rs.getString("NOMBRE");
            String Apellido = rs.getString("APELLIDO");
            String Rol = rs.getString("ROL");
            boolean Disponibilidad = rs.getBoolean("DISPONIBILIDAD");

            Usuario usuario = new Usuario(Codigo,Contra,Nombre,Apellido, Rol, Disponibilidad);
            listUsuario.add(usuario);//3
        }
        rs.close();
        pst.close();
        con.close();
        System.out.println("Usuario seleccion"); 
        return listUsuario; //4
    }
     
    public void IngresarUsuario(Usuario usuario) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO USUARIO VALUES(?,?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, usuario.getCodigo());
        pst.setString(2, usuario.getPass());
        pst.setString(3, usuario.getNombre());
        pst.setString(4, usuario.getApellido());
        pst.setBoolean(5, usuario.isDisponibilidad());
        pst.executeUpdate();
        pst.close();
        con.close();
    }
    
    /*public static void main(String[] args) throws Exception {
         ArrayList<Usuario> listUsuario = InicioDeSesion(20181473, "soles");
         System.out.println(listUsuario.get(0));
    }*/
    
    
}
