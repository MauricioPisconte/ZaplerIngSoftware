package JoinBD;
import Joins.*;
import java.sql.*;
import java.util.ArrayList;

public class Maq_CatMaqBD {

    public static String url = "jdbc:mysql://localhost:3306/zapler";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public  ArrayList<Maq_CatMaq> JoinCatMaqVend(String modelo, String marca, String tipo) throws Exception{
        ArrayList<Maq_CatMaq> listaJoinCatMaqVend= new ArrayList<>();
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "SELECT C.TIPO, C.COSTO, C.MARCA, "
                + "C.MODELO, P.NOMBRE_PROVEEDOR, M.STOCK, M.ESTADO, "
                + "M.DESCUENTO FROM CATALOGO_MAQUINARIA C, PROVEEDOR P,"
                + "MAQUINARIA M WHERE C.ID_MAQ = M.ID_MAQ AND M.RUC_PROVEEDOR = P.RUC_PROVEEDOR ";
        //+ "AND C.TIPO = '"+modelo+"' AND C.MARCA = '"+marca+"' AND C.MODELO = '"+tipo+"'";
        if(!tipo.equals(""))
        {
            sql += " AND C.TIPO = '"+tipo + "'";
        }
        else
        {
            sql +=" AND 1 ";
        }
        if(!marca.equals(""))
        {
            sql += " AND C.MARCA = '"+marca+ "'";
        }
        else
        {
            sql +=" AND 1 ";
        }
        if(!modelo.equals(""))
        {
            sql += " AND C.MODELO = '"+modelo+ "'";
        }
        else
        {
            sql +=" AND 1 ";
        }

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            String Tipo =  rs.getString("TIPO");
            int costo = rs.getInt("COSTO");
            String Marca = rs.getString("MARCA");
            String Modelo = rs.getString("MODELO");
            String NombreProveedor =rs.getString("NOMBRE_PROVEEDOR") ;
            String Estado = rs.getString("ESTADO");
            float Descuento =rs.getFloat("DESCUENTO");
            int Stock =rs.getInt("STOCK");
            Maq_CatMaq catmaq = new Maq_CatMaq(Tipo, costo, Marca, Modelo, NombreProveedor, Estado, Descuento, Stock);
            listaJoinCatMaqVend.add(catmaq);
        }
        rs.close();
        pst.close();
        conn.close();
        return listaJoinCatMaqVend;
    }
    
    public  float CalcularT(String  tipo, String marca , String modelo, int cantidad) throws Exception{
        float total = 0;
        Connection conn = DriverManager.getConnection(url, user, password);
        /*String sql = "DECLARE " +
                            "   MARCA CATALOGO_MAQUINARIA.MARCA%TYPE := '"+marca+"'; " +
                            " TIPO CATALOGO_MAQUINARIA.TIPO%TYPE := '"+tipo+"'; " +
                            " MODELO CATALOGO_MAQUINARIA.MODELO%TYPE := '"+modelo+"'; " +
                            " CANTIDAD NUMBER := "+cantidad+
                            " TOTAL NUMBER; " +
                            "BEGIN " +
                            "    TOTAL := CALCULART(TIPO, MARCA, MODELO, CANTIDAD); " +
                            "    dbms_output.put_line('CANTIDAD TOTAL: ' || TOTAL);" +
                            "END;";
        PreparedStatement pst = conn.prepareStatement(sql);*/
        //ResultSet rs = pst.executeQuery();
        CallableStatement cstmt = conn.prepareCall(" begin ? := CALCULART(?,?,?,?); end;");
        cstmt.registerOutParameter(1, Types.FLOAT);
        cstmt.setString(2, tipo);
        cstmt.setString(3, marca);
        cstmt.setString(4, modelo);
        cstmt.setInt(5, cantidad);
        cstmt.executeUpdate();
        total = cstmt.getFloat(1);
        
        //rs.close();
        cstmt.close();
        conn.close();
        
        return total ;
    }
}
