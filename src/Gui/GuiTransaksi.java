package Gui;


import AllObject.AllObjectController;
import Controller.CustomerController;
import static Gui.GuiBarang.dateFormat;
import Gui.Komponen;

import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuiTransaksi extends Komponen {

 DefaultTableModel modelBar;
 DefaultTableModel modelTrans;
  JPanel frame = new JPanel();
    JScrollPane sp_Mhs = new JScrollPane();
    JScrollPane sp_Trans = new JScrollPane();
    JTable tbl_Mhs = new JTable();
    JTable tbl_Trans = new JTable();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyy HH:mm:ss");
    Object a;
    
    public GuiTransaksi(int cek) {
        initComponent(cek);
    }

    public void initComponent(final int cek){
     int nama = AllObjectController.barangController.getData().get(cek).getId();
        
        setSize(1000 , 500);
        
        getContentPane().setBackground(new Color(135, 206, 250));
        setLayout(null);
        setLocationRelativeTo(null);

        labelUsername.setBounds(20, 0, 100, 25);
        labelUsername.setFont(new Font("Arial" , Font.BOLD,14));
        add(labelUsername);
        txtUsername.setBounds(100, 4, 100, 25);
        txtUsername.setText(String.valueOf(nama));
        txtUsername.setEditable(false);
        add(txtUsername);
        
        labelId.setBounds(20 , 30 , 100 , 30);
        labelId.setFont(new Font("Arial" , Font.BOLD,14));
        txtId.setBounds(100 , 34, 150 , 20);
        txtId.setEditable(false);
        add(labelId);
        add(txtId);
        
        labelNama.setBounds(20 , 60 , 100 , 30);
        labelNama.setFont(new Font("Arial" , Font.BOLD,14));
        txtNama.setBounds(100 , 64, 150 , 20);
        txtNama.setEditable(false);
        add(labelNama);
        add(txtNama);

        labelJumlah.setBounds(20 , 90 , 100 , 30);
        labelJumlah.setFont(new Font("Arial" , Font.BOLD,14));
        txtJumlah.setBounds(100 , 94, 150 , 20);
        add(labelJumlah);
        add(txtJumlah);
        
        
        labelStok.setBounds(20 ,120 , 100 , 30);
        labelStok.setFont(new Font("Arial" , Font.BOLD,14));
        txtStok.setBounds(100,124, 150, 25);
        txtStok.setEditable(false);
        add(labelStok);
        add(txtStok);

        labelHarga.setBounds(20 , 150 , 100 , 30);
        labelHarga.setFont(new Font("Arial" , Font.BOLD,14));
        txtHarga.setBounds(100 , 154, 150 , 20);
        txtHarga.setEditable(false);
        add(labelHarga);
        add(txtHarga);

        
        labelTotal.setBounds(20 , 180 , 100 , 30);
        labelTotal.setFont(new Font("Arial" , Font.BOLD,14));
        txtTotal.setBounds(100 , 184, 150 , 20);
        txtTotal.setEditable(false);
        add(labelTotal);
        add(txtTotal);
        
        
        
        sp_Mhs.setViewportView(tbl_Mhs);
        modelBar = (DefaultTableModel) tbl_Mhs.getModel();
        tbl_Mhs.setDefaultEditor(Object.class, null);
        modelBar.addColumn("Id");
        modelBar.addColumn("Nama");
        modelBar.addColumn("Jumlah");
        modelBar.addColumn("Harga");
        
        
        sp_Trans.setViewportView(tbl_Trans);
        modelTrans = (DefaultTableModel) tbl_Trans.getModel();
        tbl_Trans.setDefaultEditor(Object.class, null);
        modelTrans.addColumn("Id");
        modelTrans.addColumn("Username");
        modelTrans.addColumn("Nama");
        modelTrans.addColumn("Jumlah");
        modelTrans.addColumn("Harga");
        modelTrans.addColumn("Total");

        
        sp_Mhs.setBounds(380 , 0 , 400 , 120);
        add(sp_Mhs);
        
        sp_Trans.setBounds(380 , 150 , 400 , 120);
        add(sp_Trans);
        
        
        btnInsert.setBounds(20 , 210 , 100 , 30);
        add(btnInsert);
        
        btnDelete.setBounds(240 , 210 , 100 , 30);
        add(btnDelete);
        
        btnLogout.setBounds(20 , 250 , 100 , 30);
        add(btnLogout);
        
        cetakMhs();
        cetakTrans();
        
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    success((MouseEvent) a);
                    int id = Integer.parseInt(txtId.getText());
                    int jumlah = Integer.parseInt(txtJumlah.getText());
                    int stok = Integer.parseInt(txtStok.getText());
                    Double harga = Double.parseDouble(txtHarga.getText());
                    Double total = Double.parseDouble(txtTotal.getText());
                    int sisa = stok-jumlah;
                    AllObjectController.transaksiController.insertTrans(id,txtUsername.getText(),txtNama.getText(),jumlah,harga,total);
                    AllObjectController.barangController.UpdateBarang(id,txtNama.getText(),sisa,harga,new Date());
                    cetakMhs();
                    cetakTrans();
                    
                    //hapus txt
                    
                    txtId.setText("");
                    txtNama.setText("");                    
                    txtJumlah.setText("0");                    
                    txtStok.setText("");                    
                    txtHarga.setText("");                 
                    txtTotal.setText("");
                    
                    
                }catch (Exception ex){
                    failed((MouseEvent) a);
                }
            }
        });
        
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    success((MouseEvent) a);
                    int id = Integer.parseInt(txtId.getText());
                    AllObjectController.transaksiController.HapusTrans(id);		
                    cetakTrans();
                }catch (Exception ex){
                    failed((MouseEvent) a);
                }
            }
        });
        
        
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GuiLogin().setVisible(true);
            }
        });
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                
                    
                    int jumlah = Integer.parseInt(txtJumlah.getText());
                    Double harga = Double.parseDouble(txtHarga.getText());
                    Double total = jumlah*harga;
                    txtTotal.setText(String.valueOf(total));
                
            }
        });
        
        tbl_Mhs.addMouseListener(new MouseAdapter()
		{
                    @Override
			public void mouseClicked(MouseEvent me)
			{
				int pilih = tbl_Mhs.getSelectedRow();
				if(pilih == -1)
				{
					return;
				}
				
				int id = (int) tbl_Mhs.getValueAt(pilih, 0);
                                String di = String.valueOf(id);
				txtId.setText(di);
				String nama = (String) tbl_Mhs.getValueAt(pilih, 1);
				txtNama.setText(nama);
				int stok = (int) tbl_Mhs.getValueAt(pilih, 2);
				String stk = String.valueOf(stok);
                                txtStok.setText(stk);
                                txtJumlah.setText("0");
				Double harga = (Double) tbl_Mhs.getValueAt(pilih, 3);
                                String hrg = String.valueOf(harga);
				txtHarga.setText(hrg);
                        }
		});
        
        tbl_Trans.addMouseListener(new MouseAdapter()
		{
                    @Override
			public void mouseClicked(MouseEvent me)
			{
				int pilih = tbl_Trans.getSelectedRow();
				if(pilih == -1)
				{
					return;
				}
				int id = (int) tbl_Trans.getValueAt(pilih, 0);
                                String di = String.valueOf(id);
                                txtId.setText(di);
				String nama = (String) tbl_Trans.getValueAt(pilih, 2);
				txtNama.setText(nama);
				int jumlah = (int) tbl_Trans.getValueAt(pilih, 3);
                                String jum = String.valueOf(jumlah);
                                txtJumlah.setText(jum);
				Double harga = (Double) tbl_Trans.getValueAt(pilih, 4);
                                String hrg = String.valueOf(harga);
				txtHarga.setText(hrg);
				Double total = (Double) tbl_Trans.getValueAt(pilih, 5);
				String ttl = String.valueOf(total);
                                txtTotal.setText(ttl);
                        }
		});
    }

    public void cetakMhs(){
        modelBar.setRowCount(0);
        try{
                Object[] obj = new Object[4];
                for (int i=0;i<AllObjectController.barangController.getData().size();i++){ 
            obj[0] = AllObjectController.barangController.getData().get(i).getId();
            obj[1] = AllObjectController.barangController.getData().get(i).getNama();
            obj[2] = AllObjectController.barangController.getData().get(i).getStok();
            obj[3] = AllObjectController.barangController.getData().get(i).getHarga();
            
                modelBar.addRow(obj);
            
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public void cetakTrans(){
        modelTrans.setRowCount(0);
        try{
                Object[] obj = new Object[6];
                for (int i=0;i<AllObjectController.transaksiController.getData().size();i++){
                    
            obj[0] = AllObjectController.transaksiController.getData().get(i).getId();
            obj[1] = AllObjectController.transaksiController.getData().get(i).getUsername();
            obj[2] = AllObjectController.transaksiController.getData().get(i).getNama();
            obj[3] = AllObjectController.transaksiController.getData().get(i).getStok();
            obj[4] = AllObjectController.transaksiController.getData().get(i).getHarga();
            obj[5] = AllObjectController.transaksiController.getData().get(i).getTotal();
            
                modelTrans.addRow(obj);
            
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

