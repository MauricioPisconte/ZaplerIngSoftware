package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;

public class ReservaBD {

    public static String url = "jdbc:mysql://localhost:3306/zapler";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public void IngresarReserva(Reserva reser) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO RESERVA VALUES(?,?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, reser.getID_Reserva());
        pst.setInt(2, reser.getCodigoVendedor());
        pst.setInt(3, reser.getInv_Id());
        pst.setFloat(4, reser.getCantidad());
        pst.setFloat(5, reser.getID_ListaReservas());
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    /*public ArrayList<Reserva> obtenerPedidoPorEmpresa(int rucemp) throws Exception{
        ArrayList<Reserva> listaReserva = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT DISTINCT P.ID_RESERVA, P.CODIGO_VEND, P.INV_ID, P.CANTIDAD, P.ID_LISTARESERVAS " +
                "FROM RESERVA P, USUARIO V, ATENCIONCLIENTE A, RECIBE_ATENCION R, EMPRESA E " +
                "WHERE E.RUC_EMPRESA = R.RUC_EMPRESA AND R.ID_ATENCION = A.ID_ATENCION AND " +
                "A.CODVENDEDOR = V.CODIGO AND V.CODIGO = P.CODIGO_VEND AND E.RUC_EMPRESA = " + rucemp +"";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int ID_Reserva = rs.getInt("ID_RESERVA");
            int CodVend = rs.getInt("CODIGO_VEND");
            int Inv_Id =  rs.getInt("INV_ID");
            float Cantidad = rs.getFloat("CANTIDAD");
            int ListaRes = rs.getInt("ID_LISTARESERVAS");

            Reserva res = new Reserva(ID_Reserva, CodVend,  Inv_Id,  Cantidad, ListaRes);
            listaReserva.add(res);
        }
        rs.close();
        pst.close();
        con.close();
        return listaReserva;
    }*/

    public ArrayList<Reserva> obtenerReservasPorID(int IDLista) throws Exception{
        ArrayList<Reserva> listaReserva = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM RESERVA WHERE RESERVA.ID_LISTARESERVAS = "+ IDLista +"";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int ID_Reserva = rs.getInt("ID_RESERVA");
            int CodVend = rs.getInt("CODIGO_VEND");
            int Inv_Id =  rs.getInt("INV_ID");
            float Cantidad = rs.getFloat("CANTIDAD");
            int ListaRes = rs.getInt("ID_LISTARESERVAS");

            Reserva ped = new Reserva(ID_Reserva, CodVend,  Inv_Id,  Cantidad, ListaRes);
            listaReserva.add(ped);
        }
        rs.close();
        pst.close();
        con.close();
        return listaReserva;
    }

}
