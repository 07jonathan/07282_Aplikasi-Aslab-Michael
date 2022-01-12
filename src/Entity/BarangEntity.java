package Entity;
import Helper.Koneksi;
import java.util.Date;

public class BarangEntity extends EntityAbstract {
    protected String nama;
    protected int stok;
    protected Double harga;
    
    public BarangEntity(){}

    public BarangEntity(int id, Date created_at, Date updated_at, String nama, int stok, Double harga) {
        super(id, created_at, updated_at);
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    @Override
    public Date getUpdated_at() {
        return super.getUpdated_at(); 
    }

    @Override
    public Date getCreated_at() {
        return super.getCreated_at(); 
    }

    @Override
    public int getId() {
        return super.getId(); 
    }   
}
