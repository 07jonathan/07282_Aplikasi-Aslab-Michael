package Controller;
import AllObject.AllObjectModel;
import Entity.TransaksiEntity;
import Controller.ControllerInterface;
import java.util.Date;
import java.util.ArrayList;

public class TransaksiController implements ControllerInterface {
    @Override
    public ArrayList<TransaksiEntity> getData(){
        return AllObjectModel.transaksiModel.getData();
    }
    
    public void insertTrans(int id,String username,String nama, int stok, Double harga,Double total){
        AllObjectModel.transaksiModel.getInsert(new TransaksiEntity(id,username,nama,stok, harga,total));
    }
    
    public void HapusTrans(int id){
       AllObjectModel.transaksiModel.getdelete(id);
    
    }
   
    
}
