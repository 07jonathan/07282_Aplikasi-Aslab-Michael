package Gui;

import javax.swing.*;

public class Komponen extends JFrame {

    //Jlabel
    protected JLabel labelAdmin = new JLabel("=== Admin ===");
    protected JLabel labelSisa = new JLabel("Sisa           : ");
    protected JLabel labelId = new JLabel("id             : ");
    protected JLabel labelStok = new JLabel("Stok       : ");
    protected JLabel labelHarga = new JLabel("Harga      : ");
    protected JLabel labelTotal = new JLabel("Total        : ");
    protected JLabel labelJumlah = new JLabel("Jumlah    : ");
    protected JLabel labelNama = new JLabel("Nama       : ");
    protected JLabel labelPassword = new JLabel("Password: ");
    protected JLabel labelAlamat = new JLabel("Alamat: ");
    protected JLabel labelNo_hp = new JLabel("No HP: ");
    protected JLabel labelUsername = new JLabel("Username: ");

    //JtextFIeld
    protected JTextField txtId = new JTextField();
    protected JTextField txtNama = new JTextField();
    protected JTextField txtStok = new JTextField();
    protected JTextField txtHarga = new JTextField();
    protected JTextField txtTotal = new JTextField();
    protected JTextField txtJumlah = new JTextField();
    protected JTextField txtPassword = new JTextField();
    protected JTextField txtAlamat = new JTextField();
    protected JTextField txtNo_hp = new JTextField();
    protected JTextField txtUsername = new JTextField();
    protected JTextField txtSisa = new JTextField();

    //Jbutton
    protected JButton btnAdmin = new JButton("Admin");
    protected JButton btnUpdate = new JButton("Update");
    protected JButton btnDelete = new JButton("Delete");
    protected JButton btnBarang = new JButton("Barang");
    protected JButton btnCustomer = new JButton("Customer");
    protected JButton btnTransaksi = new JButton("Transaksi");
    protected JButton btnLogin = new JButton("Login");
    protected JButton btnLogout = new JButton("Logout");
    protected JButton btnMhs = new JButton("Mahasiswa");
    protected JButton btnKeluar = new JButton("Keluar");
    protected JButton btnInsert = new JButton("Insert");

    public void success(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Sukses Tambah Data !!");
    }
    public void failed(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Gagal Tambah Data !!");
    }
    public void error(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Error !!");
    }
}
