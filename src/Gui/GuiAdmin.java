package Gui;


import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAdmin extends Komponen {

    public GuiAdmin() {
        initComponent();
    }

    public void initComponent(){
        setSize(700 , 400);
        getContentPane().setBackground(new Color(135, 206, 250));
        setLayout(null);
        setLocationRelativeTo(null);

        labelAdmin.setBounds(270 , 10 , 240 , 40);
        labelAdmin.setFont(new Font("Calibri", Font.BOLD,25));
        labelAdmin.setForeground(new Color(20,1,188));
        add(labelAdmin);

        btnMhs.setBounds(20 , 100 , 200 , 40);
        add(btnMhs);

        btnKeluar.setBounds(470 , 300 , 200 , 40);
        add(btnKeluar);

        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GuiMenu().setVisible(true);
            }
        });

        btnMhs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //    new GUI_mahasiswa().setVisible(true);
            }
        });
    }
}
