package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;


public class EmpresaBD {
    public static String url = "jdbc:mysql://localhost:3306/zapler";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public void IngresarEmpresa(Empresa empresa) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO EMPRESA VALUES(?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, empresa.getRUCEmpresa());
        pst.setString(2, empresa.getNombreEmpresa());
        pst.setBoolean(3, true);
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public ArrayList<Empresa> obtenerEmpresa() throws Exception{
        System.out.println("Se ejecuta ComboBoxEmpresa en clase java");
        ArrayList<Empresa> listaEmpresa = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM EMPRESA";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int RucEmpresa = rs.getInt("RUC_EMPRESA");
            String NombreEmpresa =  rs.getString("NOMBRE_EMPRESA");
            boolean Disponibilidad = rs.getBoolean("DISPONIBILIDAD");

            Empresa emp = new Empresa(RucEmpresa, NombreEmpresa,Disponibilidad);
            listaEmpresa.add(emp);
        }
        rs.close();
        pst.close();
        con.close();
        return listaEmpresa;
    }

    public void actualizarDisponibilidad(int ruc, boolean estado) throws Exception{      
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "UPDATE EMPRESA SET DISPONIBILIDAD = ?  WHERE RUC_EMPRESA =" + ruc +"";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setBoolean(1, estado);
                pst.executeUpdate();
            }
            System.out.println("actualizado correctamente");
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
    
    public void actualizarNombre(int ruc, String nuevo) throws Exception{
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "UPDATE EMPRESA SET NOMBRE_EMPRESA = ?  WHERE RUC_EMPRESA = " + ruc +"";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, nuevo);
                pst.executeUpdate();
            }
            System.out.println("actualizado correctamente");
    }
    
    public void actualizarRUC(int original, int nuevo) throws Exception{
        RepresentanteBD representante = new RepresentanteBD();
        RecibeAtencionBD recibeatencion = new RecibeAtencionBD();
        representante.actualizarRUCrepresentante(nuevo, original);
        recibeatencion.actualizarRUCrecibeAtencion(nuevo, original);
        
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "UPDATE EMPRESA SET RUC_EMPRESA = ?  WHERE RUC_EMPRESA =" + original +"";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, nuevo);
                pst.executeUpdate();
            }
            System.out.println("actualizado correctamente");
    }
    
}
