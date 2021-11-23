package Model;

import Entity.BarangEntity;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class BarangModel extends ModelAbstract {
    private ArrayList<BarangEntity> barangEntity = new ArrayList<BarangEntity>();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyy HH:mm:ss");
    public ArrayList<BarangEntity> getBarang(){
        return barangEntity;
    }
    public void insertBarang(int id, Date created_at, Date updated_at, String nama, int stok, Double harga ){
        barangEntity.add(new BarangEntity(id, created_at, updated_at, nama, stok, harga));
    }
    
    public void Update(int Id, String Nama,int Stok, Double Harga){
        barangEntity.set(Id, new BarangEntity(Id,barangEntity.get(Id).getCreated_at(),new Date(),Nama,Stok,Harga));
    }

    public void Hapus(int IdHapus){
        barangEntity.set(IdHapus, new BarangEntity(0,barangEntity.get(IdHapus).getCreated_at(),new Date()," ",0,0.0));
            //barangEntity.remove(IdHapus);
    }

   
}
