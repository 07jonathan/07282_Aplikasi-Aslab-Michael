package Controller;
import AllObject.AllObjectModel;
import Entity.CustomerEntity;

import java.util.Date;
import java.util.ArrayList;

public class CustomerController implements ControllerInterface {
    @Override
    public ArrayList<CustomerEntity> getData(){
        return AllObjectModel.customerModel.getData();
    }
    public int UpdateCustomer(int id,String nama,String alamat, String no_hp, String username, String password, Date updated_at){
        return AllObjectModel.customerModel.getupdate(id, nama, alamat, no_hp,username,password, updated_at);
    }
    public void insertCustomer(int id,Date created_at, Date updated_at, String nama,String alamat, String no_hp, String username, String password ){
        AllObjectModel.customerModel.getInsert(new CustomerEntity(0,created_at,updated_at,nama, no_hp, alamat,username,password));
    }
   public void HapusCustomer(int IdHapus){
       AllObjectModel.customerModel.getdelete(IdHapus);
    
    }

   public int checkCustomer(String nama, String password){
        return AllObjectModel.customerModel.checkCustomer(nama, password);
   }
    
}