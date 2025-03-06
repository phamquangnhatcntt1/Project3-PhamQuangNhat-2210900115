package application;

import ui.Form_DangNhap;

public class RunApplication {
    public static void main(String[] args) {
        Form_DangNhap form_dangNhap = new Form_DangNhap();
        form_dangNhap.doShow();
        form_dangNhap.setVisible(true);
    }
}
