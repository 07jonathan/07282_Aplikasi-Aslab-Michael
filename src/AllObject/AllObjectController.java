package AllObject;
import Controller.BarangController;
import Controller.CustomerController;
import Controller.AdminController;
import Controller.TransaksiController;
import java.util.Date;

public class AllObjectController {
    public static CustomerController customerController = new CustomerController();
    public static BarangController barangController = new BarangController();
    public static AdminController adminController = new AdminController();
    public static TransaksiController transaksiController = new TransaksiController();
    
}
