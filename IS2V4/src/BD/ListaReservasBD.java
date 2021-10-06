package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;

public class ListaReservasBD {
    public static String url = "jdbc:mysql://localhost:3306/zapleringsoftware";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public ArrayList<ListaReservas> ObtenerIDsListaReservas(String NombreEmp) throws Exception{
        ArrayList<ListaReservas> listadeLista = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT L.ID_LISTARESERVAS " +
                "FROM LISTARESERVAS L, RESERVA P, VENDEDOR V, ATENCIONCLIENTE A, RECIBEATENCION R, EMPRESA E " +
                "WHERE E.RUC_EMPRESA = R.RUC_EMPRESA AND R.ID_ATENCION = A.ID_ATENCION AND " +
                "A.CODVENDEDOR = V.CODIGO AND V.CODIGO = P.CODIGO_VEND AND" +
                "P.ID_LISTARESERVAS = L.ID_LISTARESERVAS AND E.NOMBRE_EMPRESA = '"+NombreEmp+"'";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int listaR = rs.getInt("ID_LISTARESERVAS");
            ListaReservas lista = new ListaReservas(listaR);
            listadeLista.add(lista);
        }
        rs.close();
        pst.close();
        con.close();
        return listadeLista;
    }



}
