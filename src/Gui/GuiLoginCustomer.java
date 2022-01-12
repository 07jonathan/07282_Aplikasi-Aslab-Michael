package Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import AllObject.*;
public class GuiLoginCustomer extends Komponen {
    JButton btnloginadmin = new JButton();
    String pathicon;
    public GuiLoginCustomer(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("Login");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,480);
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(new Color(135, 206, 250));
        //getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelNama.setBounds(35, 250, 80, 25);
        add(labelNama);
        txtNama.setBounds(130, 250, 130, 25);
        add(txtNama);
        
        labelPassword.setBounds(35, 290, 80, 25);
        add(labelPassword);
        txtPassword.setBounds(130, 290, 130, 25);
        add(txtPassword);
        
        btnLogin.setBounds(110, 350, 100, 25);
        btnLogin.setBackground(Color.black);
        btnLogin.setForeground(Color.white);
        btnLogin.setBorder(null);
        add(btnLogin);
        
        pathicon = "./src/Images/keys.png";
        
        
        btnLogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setForeground(Color.black);
                btnLogin.setBackground(Color.green);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                btnLogin.setForeground(Color.white);
                btnLogin.setBackground(Color.black);
            }
        });
        
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String nama = txtNama.getText();
                String password = txtPassword.getText();
                int cek = AllObjectController.customerController.checkCustomer(nama, password);
                if(cek > 0){
                        dispose();
                new GuiMenu().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                }
            }
        });
    }
}
