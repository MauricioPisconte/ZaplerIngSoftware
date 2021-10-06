package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;


public class EmpresaBD {
    public static String url = "jdbc:mysql://localhost:3306/zapleringsoftware";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public void IngresarEmpresa(Empresa empresa) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO EMPRESA VALUES(?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, empresa.getRUCEmpresa());
        pst.setString(2, empresa.getNombreEmpresa());
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public ArrayList<Empresa> obtenerEmpresa() throws Exception{
        ArrayList<Empresa> listaEmpresa = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM EMPRESA";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int RucEmpresa = rs.getInt("RUC_EMPRESA");
            String NombreEmpresa =  rs.getString("NOMBRE_EMPRESA");

            Empresa emp = new Empresa(RucEmpresa, NombreEmpresa);
            listaEmpresa.add(emp);
        }
        rs.close();
        pst.close();
        con.close();
        return listaEmpresa;
    }

    public int obtenerRucEmp(String nombre) throws Exception{
        int ruc = 0;
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT RUC_EMPRESA FROM EMPRESA WHERE NOMBRE_EMPRESA = '"+nombre+"'";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            ruc = rs.getInt("RUC_EMPRESA");
        }
        rs.close();
        pst.close();
        con.close();
        return ruc;
    }

}
