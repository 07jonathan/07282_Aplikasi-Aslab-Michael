package Model;

import Entity.TransaksiEntity;
import Helper.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.sql.*;
import java.sql.Timestamp;


public class TransaksiModel extends ModelAbstract {
    Date date = new Date();
    protected static ArrayList<TransaksiEntity> transEntity = new ArrayList<TransaksiEntity>();
    private String sql;
    public Connection conn = Koneksi.getconection();

@Override    
    public ArrayList<TransaksiEntity> getData(){
        ArrayList<TransaksiEntity> arraylistTransaksi = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * from transaksi";
            ResultSet rs = stat.executeQuery(sql);
            
            while(rs.next()){
                int id;
                String nama,no_hp,username, password;
                int stok;
                Double harga,total;
                TransaksiEntity transaksi = new TransaksiEntity();
                
                id = rs.getInt("id");
                username = rs.getString("Username");
                nama =rs.getString("nama");
                stok = rs.getInt("stok");
                harga = rs.getDouble("harga");
                total = rs.getDouble("total");
                
                arraylistTransaksi.add(new TransaksiEntity(id, username,nama, stok, harga, total ));
                }
        }catch(SQLException e){
        System.out.println(e);
        }
        return arraylistTransaksi;
    }
    
            
            
    
    public void getInsert(TransaksiEntity transaksiEntity){
        try{
            sql = "INSERT INTO transaksi (username, nama,stok,harga,total) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,transaksiEntity.getUsername());
            preparedStatement.setString(2,transaksiEntity.getNama());
            preparedStatement.setInt(3,transaksiEntity.getStok());
            preparedStatement.setDouble(4,transaksiEntity.getHarga());
            preparedStatement.setDouble(5,transaksiEntity.getTotal());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public ArrayList<TransaksiEntity> getdelete(int id) {
         ArrayList<TransaksiEntity> arraylistTransaksi = new ArrayList<>();
    
     try {
           Statement stat = conn.createStatement();
            String sql = String.format("DELETE FROM transaksi WHERE id=%d", id);

            stat.execute(sql);
            
            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
     return arraylistTransaksi;
      }
}
