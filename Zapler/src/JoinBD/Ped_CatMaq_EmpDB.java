package JoinBD;
import Joins.*;
import java.sql.*;
import java.util.ArrayList;

public class Ped_CatMaq_EmpDB {
    public static String url = "jdbc:mysql://localhost:3306/zapler";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public ArrayList<Resv_CatMaq_Emp> Join_Ped_CatMaq(int IdLista) throws Exception {
        ArrayList<Resv_CatMaq_Emp> listaJoinPedCatMaqEmp = new ArrayList<>();
        Connection conn = DriverManager.getConnection(url, user, password);
        /*String sql = "SELECT DISTINCT P.CODIGO_VEND, P.INV_ID, P.CANTIDAD, C.MODELO, E.NOMBRE_EMPRESA FROM RESERVA P, " +
    "CATALOGO_MAQUINARIA C, EMPRESA E, MAQUINARIA M, " +
    "usuario V, ATENCIONCLIENTE A, recibe_atencion R " +
    "WHERE C.ID_MAQ = M.ID_MAQ AND M.INV_ID = P.INV_ID AND P.CODIGO_VEND = V.CODIGO AND A.ID_ATENCION = R.ID_ATENCION AND " +
    "R.RUC_EMPRESA = E.RUC_EMPRESA AND E.NOMBRE_EMPRESA = '" + nombreEmp+"'";*/
        System.out.println(IdLista);
        String sql = "SELECT DISTINCT P.CODIGO_VEND, P.INV_ID, P.CANTIDAD, C.MODELO, P.ID_LISTARESERVAS FROM " +
"catalogo_maquinaria C, listareserva L, reserva P, usuario V, atencioncliente A, recibe_atencion R, " +
"empresa E, maquinaria M WHERE M.ID_MAQ = C.ID_MAQ AND M.INV_ID = P.INV_ID " +
" AND P.CODIGO_VEND = V.CODIGO AND V.CODIGO = A.CODVENDEDOR " +
"AND A.ID_ATENCION = R.ID_ATENCION AND R.ID_LISTARESERVA = P.ID_LISTARESERVAS AND " +
"R.RUC_EMPRESA = E.RUC_EMPRESA AND R.ID_LISTARESERVA = L.ID_LISTARESERVAS AND L.ID_LISTARESERVAS = "+ IdLista+ "";
                
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int CodigoVendedor = rs.getInt("CODIGO_VEND");
            int Inv_Id = rs.getInt("INV_ID");
            int Cantidad = rs.getInt("CANTIDAD");
            String Modelo = rs.getString("MODELO");
            Resv_CatMaq_Emp pce = new Resv_CatMaq_Emp(CodigoVendedor, Inv_Id, Cantidad, Modelo);
            listaJoinPedCatMaqEmp.add(pce);
        }
        rs.close();
        pst.close();
        conn.close();
        return listaJoinPedCatMaqEmp;

    }
    
   
    
}
