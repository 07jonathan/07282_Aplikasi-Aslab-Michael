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

public class GuiCustomer extends Komponen {

    DefaultTableModel modelCus;
    JScrollPane sp_Cus = new JScrollPane();
    JTable tbl_Cus = new JTable();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyy HH:mm:ss");
    Object a;

    public GuiCustomer() {
        initComponent();
    }

    public void initComponent(){
        setSize(1000 , 500);
        
        getContentPane().setBackground(new Color(135, 206, 250));
        setLayout(null);
        setLocationRelativeTo(null);

        labelId.setBounds(20 , 0 , 100 , 30);
        labelId.setFont(new Font("Arial" , Font.BOLD,14));
        txtId.setBounds(110 , 4, 150 , 20);
        add(labelId);
        add(txtId);
        
        labelNama.setBounds(20 , 30 , 100 , 30);
        labelNama.setFont(new Font("Arial" , Font.BOLD,14));
        txtNama.setBounds(110 , 34, 150 , 20);
        add(labelNama);
        add(txtNama);

        labelAlamat.setBounds(20 , 60 , 100 , 30);
        labelAlamat.setFont(new Font("Arial" , Font.BOLD,14));
        txtAlamat.setBounds(110 , 64, 150 , 20);
        add(labelAlamat);
        add(txtAlamat);

        labelNo_hp.setBounds(20 , 90 , 100 , 30);
        labelNo_hp.setFont(new Font("Arial" , Font.BOLD,14));
        txtNo_hp.setBounds(110 , 94, 150 , 20);
        add(labelNo_hp);
        add(txtNo_hp);
        
        
        labelUsername.setBounds(20 , 120 , 100 , 30);
        labelUsername.setFont(new Font("Arial" , Font.BOLD,14));
        txtUsername.setBounds(110 , 124, 150 , 20);
        add(labelUsername);
        add(txtUsername);
        
        
        labelPassword.setBounds(20 , 150 , 100 , 30);
        labelPassword.setFont(new Font("Arial" , Font.BOLD,14));
        txtPassword.setBounds(110 , 154, 150 , 20);
        add(labelPassword);
        add(txtPassword);

        btnInsert.setBounds(20 , 180 , 100 , 30);
        add(btnInsert);
        
        btnUpdate.setBounds(130 , 180 , 100 , 30);
        add(btnUpdate);
        
        btnDelete.setBounds(240 , 180 , 100 , 30);
        add(btnDelete);
        
        btnKeluar.setBounds(20 , 210 , 100 , 30);
        add(btnKeluar);
        
        sp_Cus.setViewportView(tbl_Cus);
        modelCus = (DefaultTableModel) tbl_Cus.getModel();
        tbl_Cus.setDefaultEditor(Object.class, null);
        modelCus.addColumn("Id");
        modelCus.addColumn("Nama");
        modelCus.addColumn("Alamat");
        modelCus.addColumn("No_hp");
        modelCus.addColumn("Username");
        modelCus.addColumn("Password");
        modelCus.addColumn("Created_at");
        modelCus.addColumn("Updated_at");
        sp_Cus.setBounds(20 , 220 , 1300 , 400);
        add(sp_Cus);


//        Cetak data dulu

        cetakCus();
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    success((MouseEvent) a);
                    AllObjectController.customerController.insertCustomer( 0, new Date(), new Date(), txtNama.getText(),txtAlamat.getText(),txtNo_hp.getText(),txtUsername.getText() , txtPassword.getText());
                    cetakCus();
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
                    AllObjectController.customerController.insertCustomer( id, new Date(), new Date(), txtNama.getText(),txtAlamat.getText(),txtNo_hp.getText(),txtUsername.getText() , txtPassword.getText());
                    cetakCus();
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
                    AllObjectController.customerController.HapusCustomer(id);
                    cetakCus();
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
        
        tbl_Cus.addMouseListener(new MouseAdapter()
		{
                    @Override
			public void mouseClicked(MouseEvent me)
			{
				int pilih = tbl_Cus.getSelectedRow();
				if(pilih == -1)
				{
					return;
				}
				
				int id = (int) tbl_Cus.getValueAt(pilih, 0);
                                String iniid = String.valueOf(id);
				txtId.setText(iniid);
				String nama = (String) tbl_Cus.getValueAt(pilih, 1);
				txtNama.setText(nama);
				String alamat = (String) tbl_Cus.getValueAt(pilih, 2);
				txtAlamat.setText(alamat);
				String no_hp = (String) tbl_Cus.getValueAt(pilih, 3);
				txtNo_hp.setText(no_hp);
				String username = (String) tbl_Cus.getValueAt(pilih, 4);
				txtUsername.setText(username);
				String password = (String) tbl_Cus.getValueAt(pilih, 5);
				txtPassword.setText(password);
				
                        }
		});
    }

    public void cetakCus(){
        modelCus.setRowCount(0);
        try{
                Object[] obj = new Object[8];
                for (int i=0;i<AllObjectController.customerController.getData().size();i++){ 
            obj[0] = AllObjectController.customerController.getData().get(i).getId();
            obj[1] = AllObjectController.customerController.getData().get(i).getNama();
            obj[2] = AllObjectController.customerController.getData().get(i).getAlamat();
            obj[3] = AllObjectController.customerController.getData().get(i).getNo_hp();
            obj[4] = AllObjectController.customerController.getData().get(i).getUsername();
            obj[5] = AllObjectController.customerController.getData().get(i).getPassword();
            obj[6] = AllObjectController.customerController.getData().get(i).getCreated_at();
            obj[7] = dateFormat.format(AllObjectController.customerController.getData().get(i).getUpdated_at());
            
                
                modelCus.addRow(obj);
            
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
