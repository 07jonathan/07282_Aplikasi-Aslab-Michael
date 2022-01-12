package Gui;


import AllObject.AllObjectController;
import Entity.BarangEntity;
import Gui.Komponen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GuiBarang extends Komponen {

    DefaultTableModel modelBar;
    JScrollPane sp_Mhs = new JScrollPane();
    JTable tbl_Mhs = new JTable();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyy HH:mm:ss");
    Object a;

    public GuiBarang() {
        initComponent();
    }

    public void initComponent(){
        setSize(1000 , 500);
        
        getContentPane().setBackground(new Color(135, 206, 250));
        setLayout(null);
        setLocationRelativeTo(null);

        labelId.setBounds(20 , 0 , 70 , 30);
        labelId.setFont(new Font("Arial" , Font.BOLD,14));
        txtId.setBounds(90 , 4, 150 , 20);
        add(labelId);
        add(txtId);
        
        labelNama.setBounds(20 , 30 , 70 , 30);
        labelNama.setFont(new Font("Arial" , Font.BOLD,14));
        txtNama.setBounds(90 , 34, 150 , 20);
        add(labelNama);
        add(txtNama);

        labelStok.setBounds(20 , 60 , 70 , 30);
        labelStok.setFont(new Font("Arial" , Font.BOLD,14));
        txtStok.setBounds(90 , 64, 150 , 20);
        add(labelStok);
        add(txtStok);

        labelHarga.setBounds(20 , 90 , 70 , 30);
        labelHarga.setFont(new Font("Arial" , Font.BOLD,14));
        txtHarga.setBounds(90 , 94, 150 , 20);
        add(labelHarga);
        add(txtHarga);

        sp_Mhs.setViewportView(tbl_Mhs);
        modelBar = (DefaultTableModel) tbl_Mhs.getModel();
        tbl_Mhs.setDefaultEditor(Object.class, null);
        modelBar.addColumn("Id");
        modelBar.addColumn("Nama");
        modelBar.addColumn("Stok");
        modelBar.addColumn("Harga");
        modelBar.addColumn("Created_at");
        modelBar.addColumn("Updated_at");
        sp_Mhs.setBounds(380 , 30 , 400 , 400);
        add(sp_Mhs);
        btnInsert.setBounds(20 , 180 , 100 , 30);
        add(btnInsert);
        
        btnUpdate.setBounds(130 , 180 , 100 , 30);
        add(btnUpdate);
        
        btnDelete.setBounds(240 , 180 , 100 , 30);
        add(btnDelete);
        
        btnKeluar.setBounds(20 , 210 , 100 , 30);
        add(btnKeluar);

//        Cetak data dulu

        cetakMhs();
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    success((MouseEvent) a);
                    int stok = Integer.parseInt(txtStok.getText());
                    Double harga = Double.parseDouble(txtHarga.getText());
                    AllObjectController.barangController.insertBarang( 0, new Date(), new Date(), txtNama.getText(),stok,harga);
                    cetakMhs();
                }catch (Exception ex){
                    failed((MouseEvent) a);
                }
            }
        });
        
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    success((MouseEvent) a);
                    
                    int id = Integer.parseInt(txtId.getText());
                    int stok = Integer.parseInt(txtStok.getText());
                    Double harga = Double.parseDouble(txtHarga.getText());
                    AllObjectController.barangController.UpdateBarang(id,txtNama.getText(),stok,harga,new Date());
                    cetakMhs();
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
                    AllObjectController.barangController.HapusBarang(id);
                    cetakMhs();
                }catch (Exception ex){
                    failed((MouseEvent) a);
                }
            }
        });
        
        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GuiMenu().setVisible(true);
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
                                String dimana = String.valueOf(id);
				txtId.setText(dimana);
				String nama = (String) tbl_Mhs.getValueAt(pilih, 1);
				txtNama.setText(nama);
				int stok = (int) tbl_Mhs.getValueAt(pilih, 2);
                                String apa = String.valueOf(stok);
				txtStok.setText(apa);
				Double harga = (Double) tbl_Mhs.getValueAt(pilih, 3);
                                String kapan = String.valueOf(harga);
				txtHarga.setText(kapan);
                        }
		});
    }

    public void cetakMhs(){
        modelBar.setRowCount(0);
        try{
                Object[] obj = new Object[6];
                for (int i=0;i<AllObjectController.barangController.getData().size();i++){ 
            obj[0] = AllObjectController.barangController.getData().get(i).getId();
            obj[1] = AllObjectController.barangController.getData().get(i).getNama();
            obj[2] = AllObjectController.barangController.getData().get(i).getStok();
            obj[3] = AllObjectController.barangController.getData().get(i).getHarga();
            obj[4] = AllObjectController.barangController.getData().get(i).getCreated_at();
            obj[5] = dateFormat.format(AllObjectController.barangController.getData().get(i).getUpdated_at());
            
                
                modelBar.addRow(obj);
            
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
