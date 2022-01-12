package Model;

import Entity.CustomerEntity;
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

public class CustomerModel extends ModelAbstract {
    Date date = new Date();
    protected static ArrayList<CustomerEntity> customerEntity = new ArrayList<CustomerEntity>();
    private String sql;
    public Connection conn = Koneksi.getconection();
    
    @Override
    public ArrayList<CustomerEntity> getData(){
        ArrayList<CustomerEntity> arraylistCustomer = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * from customer";
            ResultSet rs = stat.executeQuery(sql);
            
            while(rs.next()){
                int id;
                String nama, alamat,no_hp,username, password;
                Date created_at,updated_at;
                id = rs.getInt("id");
                nama =rs.getString("nama");
                alamat = rs.getString("alamat");
                no_hp = rs.getString("no_hp");
                username= rs.getString("username");
                password= rs.getString("password");
                created_at =rs.getTimestamp("created_at");
                updated_at=rs.getTimestamp("updated_at");
                
                arraylistCustomer.add(new CustomerEntity(id, created_at, updated_at, nama, no_hp, alamat, username, password ));
            }
        }catch(SQLException e){
        System.out.println(e);
        }
        return arraylistCustomer;
    }
    
    
    
    //public ArrayList<CustomerEntity> getCustomer(){
    //    return customerEntity;
    //}
    public void getInsert(CustomerEntity customerEntity){
        try{
            sql = "INSERT INTO customer (nama,alamat,no_hp,username,password,created_at,updated_at) values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,customerEntity.getNama());
            preparedStatement.setString(2,customerEntity.getAlamat());
            preparedStatement.setString(3,customerEntity.getNo_hp());
            preparedStatement.setString(4,customerEntity.getUsername());
            preparedStatement.setString(5,customerEntity.getPassword());
            preparedStatement.setTimestamp(6,new Timestamp(customerEntity.getCreated_at().getTime()));
            preparedStatement.setTimestamp(7,new Timestamp(customerEntity.getUpdated_at().getTime()));
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
        //public void insertCustomer(int id, Date created_at, Date updated_at, String nama, int stok, Double harga ){
        //customerEntity.add(new CustomerEntity(id, created_at, updated_at, nama, stok, harga));
    //}
    
    
    
    public int getupdate( int id,String nama, String alamat, String no_hp,String username, String password, Date updated_at) {
        int row = 0;
    try {
            Statement stat = conn.createStatement();
            Date date= new java.util.Date();
            String sql = "UPDATE customer SET nama = ?,alamat =?,no_hp =?,username =?,password =?,updated_at=? WHERE id=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,nama);
            ps.setString(2,alamat);
            ps.setString(3, no_hp);
            ps.setString(4, username);
            ps.setString(5, password);
            ps.setTimestamp(6, new Timestamp(updated_at.getTime()));
            ps.setInt(7,id);
            row = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    return row;
     }
    
    
    
       public ArrayList<CustomerEntity> getdelete(int id) {
         ArrayList<CustomerEntity> arraylistCustomer = new ArrayList<>();
    
     try {
           Statement stat = conn.createStatement();
            String sql = String.format("DELETE FROM customer WHERE id=%d", id);

            stat.execute(sql);
            
            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
     return arraylistCustomer;
      }
       
       
       public int checkCustomer(String username, String password) { 
        int cek = 0;
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM customer WHERE username='"+username+"' AND password='"+password+"'";
            ResultSet rs = stat.executeQuery(sql);
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))){
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
