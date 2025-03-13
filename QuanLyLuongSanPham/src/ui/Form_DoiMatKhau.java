package ui;

import dao.TaiKhoan_Dao;
import entity.TaiKhoan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Form_DoiMatKhau extends JFrame {
    private static final long serialVersionUID = 1L;
    JPanel pnNorth, pnCenter, pnSouth;
    JLabel lblTenDangNhap, lblMatKhauCu, lblMatKhauMoi, lblXacNhanMK;
    JTextField txtTenDN;
    JPasswordField tfMatKhauCu, tfMatKhauMoi, tfXacNhanMK;
    JCheckBox chkHienThi;
    JButton btnDoiMatKhau, btnThoat;

    public Form_DoiMatKhau() {
        doShow();
    }

    public void doShow() {
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Đổi Mật Khẩu");

        // pnNorth
        pnNorth = new JPanel();
        JLabel lblTieuDe = new JLabel("ĐỔI MẬT KHẨU");
        lblTieuDe.setForeground(Color.RED);
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
        pnNorth.add(lblTieuDe);

        // pnCenter
        pnCenter = new JPanel();
        Box b, b1, b2, b3, b4, b5;
        b = Box.createVerticalBox();
        b.setPreferredSize(new Dimension(450, 250));
        b.add(Box.createVerticalStrut(20));
        
        b.add(b1 = Box.createHorizontalBox());
        b1.add(lblTenDangNhap = new JLabel("Tên Đăng Nhập: "));
        b1.add(Box.createHorizontalStrut(30));
        b1.add(txtTenDN = new JTextField());
        b.add(Box.createVerticalStrut(15));

        b.add(b2 = Box.createHorizontalBox());
        b2.add(lblMatKhauCu = new JLabel("Mật Khẩu Cũ: "));
        b2.add(Box.createHorizontalStrut(30));
        b2.add(tfMatKhauCu = new JPasswordField());
        tfMatKhauCu.setEchoChar('*');
        b.add(Box.createVerticalStrut(15));

        b.add(b3 = Box.createHorizontalBox());
        b3.add(lblMatKhauMoi = new JLabel("Mật Khẩu Mới: "));
        b3.add(Box.createHorizontalStrut(30));
        b3.add(tfMatKhauMoi = new JPasswordField());
        tfMatKhauMoi.setEchoChar('*');
        b.add(Box.createVerticalStrut(15));

        b.add(b4 = Box.createHorizontalBox());
        b4.add(lblXacNhanMK = new JLabel("Xác Nhận MK: "));
        b4.add(Box.createHorizontalStrut(30));
        b4.add(tfXacNhanMK = new JPasswordField());
        tfXacNhanMK.setEchoChar('*');
        b.add(Box.createVerticalStrut(15));

        b.add(b5 = Box.createHorizontalBox());
        b5.add(Box.createHorizontalStrut(26));
        b5.add(chkHienThi = new JCheckBox("Hiển Thị Mật Khẩu"));
        b.add(Box.createVerticalStrut(20));

        lblMatKhauCu.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblMatKhauMoi.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblXacNhanMK.setPreferredSize(lblTenDangNhap.getPreferredSize());

        pnCenter.add(b);

        // pnSouth
        pnSouth = new JPanel();
        Box bc = Box.createHorizontalBox();
        bc.add(btnDoiMatKhau = new JButton("Đổi Mật Khẩu"));
        btnDoiMatKhau.setBackground(Color.decode("#4caf50"));
        btnDoiMatKhau.setForeground(Color.WHITE);
        bc.add(Box.createHorizontalStrut(30));
        bc.add(btnThoat = new JButton("Thoát"));
        btnThoat.setBackground(Color.decode("#ff0004"));
        btnThoat.setForeground(Color.WHITE);

        pnSouth.add(bc);
        pnSouth.setPreferredSize(new Dimension(0, 70));

        // Sự kiện hiển thị mật khẩu
        chkHienThi.addActionListener(e -> {
            char echoChar = chkHienThi.isSelected() ? (char) 0 : '*';
            tfMatKhauCu.setEchoChar(echoChar);
            tfMatKhauMoi.setEchoChar(echoChar);
            tfXacNhanMK.setEchoChar(echoChar);
        });

        // Sự kiện đổi mật khẩu
        btnDoiMatKhau.addActionListener(this::handleDoiMatKhau);

        // Sự kiện thoát
        btnThoat.addActionListener(e -> dispose());

        this.setLayout(new BorderLayout());
        this.add(pnNorth, BorderLayout.NORTH);
        this.add(pnCenter, BorderLayout.CENTER);
        this.add(pnSouth, BorderLayout.SOUTH);
    }

    private void handleDoiMatKhau(ActionEvent e) {
        TaiKhoan_Dao taiKhoan_dao = new TaiKhoan_Dao();
        String tenDN = txtTenDN.getText().trim();
        String matKhauCu = String.valueOf(tfMatKhauCu.getPassword()).trim();
        String matKhauMoi = String.valueOf(tfMatKhauMoi.getPassword()).trim();
        String xacNhanMK = String.valueOf(tfXacNhanMK.getPassword()).trim();

        if (!matKhauMoi.equals(xacNhanMK)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu mới và xác nhận không trùng khớp!");
            return;
        }

        TaiKhoan taiKhoan = taiKhoan_dao.TimKiemMa(tenDN, matKhauCu);
        if (taiKhoan != null) {
            taiKhoan.setMatKhau(matKhauMoi);
            boolean result = taiKhoan_dao.updateTaiKhoan(taiKhoan.getMaTK(), taiKhoan);
            if (result) {
                JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Đổi mật khẩu thất bại!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu cũ không đúng!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Form_DoiMatKhau().setVisible(true));
    }
}
