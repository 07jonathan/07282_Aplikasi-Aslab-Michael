package Entity;
import Helper.Koneksi;
import java.util.Date;

public class TransaksiEntity extends EntityAbstract {
    protected String nama,username;
    protected int stok;
    protected Double harga,total;
    
    public TransaksiEntity(){}

    public TransaksiEntity(int id,String username,String nama, int stok, Double harga, Double total) {
        super(id);
        this.username = username;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.total = total;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

}
