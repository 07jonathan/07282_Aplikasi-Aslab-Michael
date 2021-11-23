package Core;
import Entity.BarangEntity;
import Entity.CustomerEntity;
import AllObject.*;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyy HH:mm:ss");
    public static int x =0;
    public static void main(String[] args){
        int pil;
        
        
        do {
            System.out.println("1. Create Data Barang");
            System.out.println("2. Lihat Data Barang");
            System.out.println("3. Update Data Barang");
            System.out.println("4. Hapus Data Barang");
            System.out.println("0. Log Out");
            System.out.print("Pilih: ");
            pil = input.nextInt();
            input.nextLine();
            switch(pil) {
                case 1:
                    insertBarang();
                    break;
                case 2:
                    getBarang();
                    break;
                case 3:
                    updateBarang();
                    break;
                case 4:
                    deleteBarang();
                    break;
            }
        } while (pil != 0);
        
        
    }
    
    static void insertBarang(){  
     System.out.print("Masukkan Nama = ");
     String nama = input.next();
     System.out.print("Masukkan Stok = ");
     int stok = input.nextInt();
     System.out.print("Masukkan Harga = ");
     double harga = input.nextDouble();
        System.out.println("");
        x=x+1;
     AllObjectController.barangController.insertBarang(AllObjectController.barangController.getBarang().size(), new Date(), new Date(), nama, stok, harga);
     }
    
    static void getBarang(){
        
        System.out.println("");
        System.out.println("View:");
        for (int i=0;i<AllObjectController.barangController.getBarang().size();i++){
        //for (int i=0;i<x;i++){
        if (AllObjectController.barangController.getBarang().get(i).getNama()!=" "){
            System.out.println("id"+i);            
            System.out.println("Id = " + AllObjectController.barangController.getBarang().get(i).getId());
                System.out.println("Nama = " + AllObjectController.barangController.getBarang().get(i).getNama());
                System.out.println("Stok = " + AllObjectController.barangController.getBarang().get(i).getStok());
                System.out.println("Harga = " + AllObjectController.barangController.getBarang().get(i).getHarga());
                System.out.println("Created_at = " + dateFormat.format(AllObjectController.barangController.getBarang().get(i).getCreated_at()));
                System.out.println("Update_at = " + AllObjectController.barangController.getBarang().get(i).getUpdated_at());
                System.out.println("\n");
        }
            }
    }
    
    
    
    static void updateBarang(){
    System.out.print("Ubah Id ke: ");
    int id = input.nextInt();
     System.out.print("Masukkan Nama = ");
     String nama = input.next();
     System.out.print("Masukkan Stok = ");
     int stok = input.nextInt();
     System.out.print("Masukkan Harga = ");
     double harga = input.nextDouble();
     System.out.println("");
     AllObjectController.barangController.UpdateBarang(id, nama, stok, harga);
    }
    
    static void deleteBarang(){
        System.out.print("Input Nomor: ");
        int hapus = input.nextInt();
     AllObjectController.barangController.HapusBarang(hapus);
        x=x-1;
    }
}
