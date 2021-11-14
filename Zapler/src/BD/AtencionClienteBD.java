package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;

public class AtencionClienteBD {

    public static String url = "jdbc:mysql://localhost:3306/zapler";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public void IngresarAtencionCliente(AtencionCliente atCl) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO ATENCIONCLIENTE VALUES(?, ?, ?, ?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, atCl.getIDAtencion());
        pst.setString(2, atCl.getTiempoInicioAtencion());
        pst.setString(3, atCl.getFecha());
        pst.setString(4, atCl.getDescripcion());
        pst.setInt(5,  atCl.getCodVendedor());

        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public ArrayList<AtencionCliente> obtenerAtencionCliente(String nombreEmp) throws Exception{
        ArrayList<AtencionCliente> listaAtencionCliente = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT A.ID_ATENCION, A.TIEMPO_INICIO_SESION, A.FECHA, A.DESCRIPCION, A.CODVENDEDOR  " +
                "FROM ATENCIONCLIENTE A, EMPRESA E, RECIBEATENCION R " +
                "WHERE R.RUC_EMPRESA = E.RUC_EMPRESA AND R.ID_ATENCION = A.ID_ATENCION "+
                "AND E.NOMBRE_EMPRESA = '"+nombreEmp+"'";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int Numserie = rs.getInt("ID_ATENCION");
            String Estado =  rs.getString("TIEMPO_INICIO_SESION");
            String Fecha = rs.getString("FECHA");
            String Descripcion = rs.getString("DESCRIPCION");
            int CodVendedor = rs.getInt("CODVENDEDOR");
            AtencionCliente atc = new AtencionCliente(Numserie,Estado, Fecha, Descripcion, CodVendedor);
            listaAtencionCliente.add(atc);
        }
        rs.close();
        pst.close();
        con.close();
        return listaAtencionCliente;
    }

    public String fechahora() throws Exception{
        String fechayhora ="" ;
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT CURRENT_TIMESTAMP  AS FH FROM DUAL";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            fechayhora = rs.getString("FH");
        }
        rs.close();
        pst.close();
        con.close();
        return fechayhora;
    }
}
