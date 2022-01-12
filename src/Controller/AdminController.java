package Controller;

import AllObject.AllObjectModel;

public class AdminController {
    public int checkAdmin(String nama, String password){
        return AllObjectModel.adminModel.checkAdmin(nama, password);
    }
}
