package Model;
import Core.Main;
import Entity.BarangEntity;
import Helper.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminModel {
    private String sql;
    public Connection conn = Koneksi.getconection();
    public int checkAdmin(String nama, String password) { 
        int cek = 0;
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM admin WHERE username='"+nama+"' AND password='"+password+"'";
            ResultSet rs = stat.executeQuery(sql);
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(nama.equals(rs.getString("username")) && password.equals(rs.getString("password"))){
                    System.out.println("berhasil login");
                    cek = rs.getInt("id");
                }
            }else{
                    System.out.println("gagal login");
                    cek=0;
                }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cek;
    }
}
