package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;

public class ListaReservasBD {
    public static String url = "jdbc:mysql://localhost:3306/zapler";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public ArrayList<ListaReservas> ObtenerIDsListaReservas(int RucEmp) throws Exception{
        ArrayList<ListaReservas> listadeLista = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT DISTINCT L.ID_LISTARESERVAS FROM listareserva l, recibe_atencion R,  EMPRESA E WHERE E.RUC_EMPRESA = R.RUC_EMPRESA AND L.ID_LISTARESERVAS = R.ID_LISTARESERVA AND E.RUC_EMPRESA = " + RucEmp + "";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int listaR = rs.getInt("ID_LISTARESERVAS");
            System.out.println(listaR);
            ListaReservas lista = new ListaReservas(listaR);
            listadeLista.add(lista);
        }
        rs.close();
        pst.close();
        con.close();
        return listadeLista;
    }

    public void IngresarListaReservas(ListaReservas listaRes) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO LISTARESERVA VALUES(?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, listaRes.getIDListaReservas());
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public void EliminarListaDeReservas(int listaReservasID) throws Exception{
        Connection con  = DriverManager.getConnection(url, user, password);
        String sql = "DELETE FROM reserva WHERE ID_LISTARESERVAS =   ? ; ";
                              //" DELETE FROM listareserva WHERE ID_LISTARESERVAS = "+listaReservasID +  " ; " ;
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, listaReservasID);
        pst.executeUpdate();
        pst.close();
        con.close();
        BorrarListaDeReservas(listaReservasID);
    }
    
    public void BorrarListaDeReservas(int listaReservasID) throws Exception{
        Connection con  = DriverManager.getConnection(url, user, password);
        String sql = " DELETE FROM listareserva WHERE ID_LISTARESERVAS = ? ; " ;
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, listaReservasID);
        pst.executeUpdate();
        pst.close();
        con.close();
    }
    

}
