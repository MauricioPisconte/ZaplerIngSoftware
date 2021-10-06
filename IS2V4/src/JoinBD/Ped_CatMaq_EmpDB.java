package JoinBD;
import Joins.*;
import java.sql.*;
import java.util.ArrayList;

public class Ped_CatMaq_EmpDB {
    public static String url = "jdbc:mysql://localhost:3306/zapleringsoftware";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public static ArrayList<Resv_CatMaq_Emp> Join_Ped_CatMaq() throws Exception {
        ArrayList<Resv_CatMaq_Emp> listaJoinPedCatMaqEmp = new ArrayList<>();
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "SELECT P.CODIGO_VEND, P.INV_ID, P.CANTIDAD, C.MODELO, E.NOMBRE_EMPRESA FROM PEDID P, "
                + "CATALOGO_MAQUINARIA C, EMPRESA E, MAQUINARIA M, " +
                "VENDEDOR V, ATENCIONCLIENTE A, RECIBEATENCION R " +
                "WHERE C.ID_MAQ = M.ID_MAQ AND M.INV_ID = P.INV_ID AND P.CODIGO_VEND = V.CODIGO AND A.ID_ATENCION = R.ID_ATENCION AND " +
                "R.RUC_EMPRESA = E.RUC_EMPRESA";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int CodigoVendedor = rs.getInt("CODIGO_VEND");
            int Inv_Id = rs.getInt("INV_ID");
            int Cantidad = rs.getInt("CANTIDAD");
            String Modelo = rs.getString("MODELO");
            String NombreEmpresa = rs.getString("NOMBRE_EMPRESA");
            Resv_CatMaq_Emp pce = new Resv_CatMaq_Emp(CodigoVendedor, Inv_Id, Cantidad, Modelo, NombreEmpresa);
            listaJoinPedCatMaqEmp.add(pce);
        }
        rs.close();
        pst.close();
        conn.close();
        return listaJoinPedCatMaqEmp;

    }
}
