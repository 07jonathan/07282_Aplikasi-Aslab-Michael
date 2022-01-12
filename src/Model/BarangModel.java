package Model;

import Entity.BarangEntity;
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


public class BarangModel extends ModelAbstract {
    Date date = new Date();
    protected static ArrayList<BarangEntity> barangEntity = new ArrayList<BarangEntity>();
    private String sql;
    public Connection conn = Koneksi.getconection();

@Override    
    public ArrayList<BarangEntity> getData(){
        ArrayList<BarangEntity> arraylistBarang = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * from barang";
            ResultSet rs = stat.executeQuery(sql);
            
            while(rs.next()){
                int id,stok;
                double harga;
                String nama;
                Date created_at, updated_at;
                id = rs.getInt("id");
                nama=rs.getString("nama");
                stok = rs.getInt("stok");
                harga = rs.getDouble("harga");
                created_at =rs.getTimestamp("created_at");
                updated_at=rs.getTimestamp("updated_at");
     
                arraylistBarang.add(new BarangEntity(id, created_at, updated_at, nama, stok, harga));
                }
        }catch(SQLException e){
        System.out.println(e);
        }
        return arraylistBarang;
    }
    
    public void getInsert(BarangEntity barangEntity){
        try{
            sql = "INSERT INTO barang (nama,stok,harga,created_at,updated_at) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,barangEntity.getNama());
            preparedStatement.setInt(2,barangEntity.getStok());
            preparedStatement.setDouble(3,barangEntity.getHarga());
            preparedStatement.setTimestamp(4,new Timestamp(barangEntity.getCreated_at().getTime()));
            preparedStatement.setTimestamp(5,new Timestamp(barangEntity.getUpdated_at().getTime()));
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    
    
    public int getupdate( int id,String nama, int stok, double harga, Date updated_at) {
        int row = 0;
    try {
            Statement stat = conn.createStatement();
            Date date= new java.util.Date();
            String sql = "UPDATE barang SET nama = ?,stok =?,harga =?,updated_at=? WHERE id=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,nama);
            ps.setInt(2,stok);
            ps.setDouble(3, harga);
            ps.setTimestamp(4, new Timestamp(updated_at.getTime()));
            ps.setInt(5,id);
            // update data buku
            row = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    return row;
     }
    
    public ArrayList<BarangEntity> getdelete(int id) {
         ArrayList<BarangEntity> arraylistBarang = new ArrayList<>();
    
     try {
           Statement stat = conn.createStatement();
            // buat query hapus
            String sql = String.format("DELETE FROM barang WHERE id=%d", id);

            // hapus data
            stat.execute(sql);
            
            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
     return arraylistBarang;
       }
}
