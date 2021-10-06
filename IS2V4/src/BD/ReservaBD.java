package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;

public class ReservaBD {

    public static String url = "jdbc:mysql://localhost:3306/zapleringsoftware";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public void IngresarReserva(Reserva reser) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO RESERVA VALUES(?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, reser.getCodigoVendedor());
        pst.setInt(2, reser.getInv_Id());
        pst.setFloat(3, reser.getCantidad());
        pst.setFloat(4, reser.getID_ListaReservas());
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    /*public ArrayList<Reserva> obtenerPedidoPorEmpresa(String nombreEmp) throws Exception{
        ArrayList<Reserva> listaPedido = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT DISTINCT P.CODIGO_VEND, P.INV_ID, P.CANTIDAD. P.ID_LISTARESERVAS " +
                "FROM RESERVA P, VENDEDOR V, ATENCIONCLIENTE A, RECIBEATENCION R, EMPRESA E " +
                "WHERE E.RUC_EMPRESA = R.RUC_EMPRESA AND R.ID_ATENCION = A.ID_ATENCION AND " +
                "A.CODVENDEDOR = V.CODIGO AND V.CODIGO = P.CODIGO_VEND AND E.NOMBRE_EMPRESA = '"+nombreEmp+"'";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int CodVend = rs.getInt("CODIGO_VEND");
            int Inv_Id =  rs.getInt("INV_ID");
            float Cantidad = rs.getFloat("CANTIDAD");
            int ListaRes = rs.getInt("LISTARESERVAS");


            Reserva ped = new Reserva(CodVend,  Inv_Id,  Cantidad, ListaRes);
            listaPedido.add(ped);
        }
        rs.close();
        pst.close();
        con.close();
        return listaPedido;
    }*/

    public ArrayList<Reserva> obtenerPedidosPorID(int IDLista) throws Exception{
        ArrayList<Reserva> listaReserva = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM " +
                "RESERVA WHERE ID_LISTARESERVAS = '"+ IDLista + "'";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int CodVend = rs.getInt("CODIGO_VEND");
            int Inv_Id =  rs.getInt("INV_ID");
            float Cantidad = rs.getFloat("CANTIDAD");
            int ListaRes = rs.getInt("LISTARESERVAS");

            Reserva ped = new Reserva(CodVend,  Inv_Id,  Cantidad, ListaRes);
            listaReserva.add(ped);
        }
        rs.close();
        pst.close();
        con.close();
        return listaReserva;
    }

    public void Procedimiento(int  codv, int ivnid) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = ""; //colocamos plsql o full cod de aqui?
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        rs.close();
        pst.close();
        con.close();
    }
}
