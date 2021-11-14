package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;

public class RecibeAtencionBD {

    public static String url = "jdbc:mysql://localhost:3306/zapler";
    public static String user = "root";
    public static String password = "Contrasena123@";
    public void IngresarRecibeAtencion(RecibeAtencion rban) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO RECIBE_ATENCION VALUES(?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, rban.getRucEmpresa());
        pst.setInt(2, rban.getIdAtencion());
        pst.setInt(3, rban.getID_ListaReserva());
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public ArrayList<RecibeAtencion> obtenerRecibeAtencion() throws Exception{
        ArrayList<RecibeAtencion> listaRecibeAtencion = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM RECIBE_ATENCION";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int IdAtencion = rs.getInt("RUC_EMPRESA");
            int RucEmpresa =  rs.getInt("ID_ATENCION");
            int ID_ListaReserva= rs.getInt("ID_LISTARESERVA");

            RecibeAtencion recat = new RecibeAtencion(IdAtencion,  RucEmpresa,ID_ListaReserva);
            listaRecibeAtencion.add(recat);
        }
        rs.close();
        pst.close();
        con.close();
        return listaRecibeAtencion;
    }
    
    
    public void actualizarRUCrecibeAtencion(int nuevo, int original) throws Exception{
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "UPDATE RECIBE_ATENCION SET RUC_EMPRESA = ?  WHERE RUC_EMPRESA = " + original +"";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, nuevo);
                pst.executeUpdate();
            }
    }
}
