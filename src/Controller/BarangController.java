package Controller;
import AllObject.AllObjectModel;
import Entity.BarangEntity;
import Controller.ControllerInterface;
import java.util.Date;
import java.util.ArrayList;

public class BarangController implements ControllerInterface {
    @Override
    public ArrayList<BarangEntity> getData(){
        return AllObjectModel.barangModel.getData();
    }
    public int UpdateBarang(int Id, String Nama, int Stok, Double Harga, Date updated_at){
        return AllObjectModel.barangModel.getupdate(Id, Nama, Stok, Harga, updated_at);
        
    }
    public void insertBarang(int id, Date created_at, Date updated_at ,String nama, int stok, Double harga){
        AllObjectModel.barangModel.getInsert(new BarangEntity(0,created_at,updated_at,nama,stok, harga));
    }
   public void HapusBarang(int IdHapus){
       AllObjectModel.barangModel.getdelete(IdHapus);
    
    }
   
    
}
