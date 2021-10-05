package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;

public class ReservaBD {

    public static String url = "jdbc:mysql://localhost:3306/zapleringsoftware";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public void IngresarPedido(Reserva prod) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO RESERVA VALUES(?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, prod.getCodigoVendedor());
        pst.setInt(2, prod.getInv_Id());
        pst.setFloat(3, prod.getCantidad());
        pst.executeUpdate();
        pst.close();
        con.close();
    }

    public ArrayList<Reserva> obtenerPedido(String nombreEmp) throws Exception{
        ArrayList<Reserva> listaPedido = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT DISTINCT P.CODIGO_VEND, P.INV_ID, P.CANTIDAD " +
                "FROM RESERVA P, VENDEDOR V, ATENCIONCLIENTE A, RECIBEATENCION R, EMPRESA E " +
                "WHERE E.RUC_EMPRESA = R.RUC_EMPRESA AND R.ID_ATENCION = A.ID_ATENCION AND " +
                "A.CODVENDEDOR = V.CODIGO AND V.CODIGO = P.CODIGO_VEND AND E.NOMBRE_EMPRESA = '"+nombreEmp+"'";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int CodVend = rs.getInt("CODIGO_VEND");
            int Inv_Id =  rs.getInt("INV_ID");
            float Cantidad = rs.getFloat("CANTIDAD");

            Reserva ped = new Reserva(CodVend,  Inv_Id,  Cantidad);
            listaPedido.add(ped);
        }
        rs.close();
        pst.close();
        con.close();
        return listaPedido;
    }

    public void Procedimiento(int  codv, int invid) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = ""; //colocamos plsql o full cod de aqui?
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        rs.close();
        pst.close();
        con.close();
    }
}
