package Controller;
import AllObject.AllObjectModel;
import Entity.BarangEntity;

import java.util.Date;
import java.util.ArrayList;

public class BarangController {
    public ArrayList<BarangEntity> getBarang(){
        return AllObjectModel.barangModel.getBarang();
    }
    public void UpdateBarang(int Id, String Nama, int Stok, Double Harga){
        AllObjectModel.barangModel.Update(Id, Nama, Stok, Harga);
    }
    public void insertBarang(int id, Date created_at, Date updated_at, String nama, int stok, Double harga ){
        AllObjectModel.barangModel.insertBarang(id, created_at, updated_at, nama, stok, harga);
    }
    public void HapusBarang(int IdHapus){
        AllObjectModel.barangModel.Hapus(IdHapus);
    
    }
}
