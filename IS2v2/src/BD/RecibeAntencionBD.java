package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;

public class RecibeAntencionBD {

    public static String url = "jdbc:mysql://localhost:3306/zapleringsoftware";
    public static String user = "root";
    public static String password = "Contrasena123@";
    public  void IngresarRecibeAtencion(RecibeAtencion rban) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO RECIBEATENCION VALUES(?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, rban.getRucEmpresa());
        pst.setInt(2, rban.getIdAtencion());
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public  ArrayList<RecibeAtencion> obtenerRecibeAtencion() throws Exception{
        ArrayList<RecibeAtencion> listaRecibeAtencion = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM RECIBEATENCION";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int IdAtencion = rs.getInt("RUC_EMPRESA");
            int RucEmpresa =  rs.getInt("ID_ATENCION");

            RecibeAtencion recat = new RecibeAtencion(IdAtencion,  RucEmpresa);
            listaRecibeAtencion.add(recat);
        }
        rs.close();
        pst.close();
        con.close();
        return listaRecibeAtencion;
    }
}
