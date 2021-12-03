package BD;
import Entidades.*;
import java.sql.*;
import java.util.ArrayList;

public class Catalogo_MaquinariaBD {
    public static String url = "jdbc:mysql://localhost:3306/zapler";
    public static String user = "root";
    public static String password = "Contrasena123@";

    public void IngresarCatalogoMaq(Catalogo_Maquinaria maq) throws Exception{
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO CATALOGO_MAQUINARIA VALUES(?, ?, ?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, maq.getIdMaquinaria());
        pst.setString(2, maq.getTipo());
        pst.setInt(3, maq.getCosto());
        pst.setString(4, maq.getMarca());
        pst.setString(5, maq.getModelo());
        pst.executeUpdate();
        pst.close();
        con.close();
    }


    public ArrayList<Catalogo_Maquinaria> obtenerCatalogo(String modelo, String marca, String tipo) throws Exception{
        ArrayList<Catalogo_Maquinaria> listaCatalogo = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM CATALOGO_MAQUINARIA WHERE ";
        if(!modelo.equals(""))
        {
            sql += " MODELO = '"+modelo + "'";
        }
        else
        {
            sql +=" 1";
        }
        if(!marca.equals(""))
        {
            sql += " AND MARCA = '"+marca+ "'";
        }
        else
        {
            sql +=" AND 1";
        }
        if(!tipo.equals(""))
        {
            sql += " AND TIPO = '"+tipo+ "'";
        }
        else
        {
            sql +=" AND 1";
        }

        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int IdMaquinaria= rs.getInt("ID_MAQ");
            String Tipo = rs.getString("TIPO");
            int costo = rs.getInt("COSTO");
            String Marca = rs.getString("MARCA");
            String Modelo = rs.getString("MODELO");
            Catalogo_Maquinaria catmaq = new Catalogo_Maquinaria(IdMaquinaria, Tipo, costo, Marca, Modelo);
            listaCatalogo.add(catmaq);
        }
        rs.close();
        pst.close();
        con.close();
        return listaCatalogo;
    }

    public ArrayList<Catalogo_Maquinaria> ObtenerCatMaq() throws Exception{
        ArrayList<Catalogo_Maquinaria> listaCatalogo = new ArrayList<>();
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM CATALOGO_MAQUINARIA";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int IdMaquinaria = rs.getInt("ID_MAQ");
            String Tipo =  rs.getString("TIPO");
            int costo = rs.getInt("COSTO");
            String Marca = rs.getString("MARCA");
            String Modelo = rs.getString("MODELO");
            Catalogo_Maquinaria catmaq = new Catalogo_Maquinaria(IdMaquinaria,Tipo, costo, Marca, Modelo);
            listaCatalogo.add(catmaq);
        }
        rs.close();
        pst.close();
        con.close();
        return listaCatalogo;
    }

    public int obtenerInvID(String modelo, String marca, String tipo) throws Exception{
        int Invid = 0;
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT M.INV_ID FROM MAQUINARIA M, CATALOGO_MAQUINARIA C "
                + "WHERE C.ID_MAQ = M.ID_MAQ AND C.MODELO = '"+modelo+"' AND C.MARCA = '"+  marca +"' "
                + "AND C.TIPO = '"+tipo+"'";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Invid=rs.getInt("INV_ID");
        }
        rs.close();
        pst.close();
        con.close();
        return Invid;
    }

}
