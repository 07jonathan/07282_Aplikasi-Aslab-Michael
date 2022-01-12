package Entity;

import java.util.Date;

public class CustomerEntity extends EntityAbstract {
    protected String username, nama, alamat,password, no_hp;
    
    public CustomerEntity(){}

    public CustomerEntity(int id, Date created_at, Date updated_at, String nama, String no_hp, String alamat, String username,String password ) {
        super(id, created_at, updated_at);
        this.nama = nama;
        this.no_hp = no_hp;
        this.alamat = alamat;
        this.username = username;
        this.password = password;
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
