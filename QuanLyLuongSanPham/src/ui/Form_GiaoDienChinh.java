package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Form_GiaoDienChinh extends JFrame implements MouseListener, ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JPanel pnCneter;
    JMenu mnTrangChu, mnThoat;
    JMenuItem mnChamCong, mnTinhLuong;
    JMenuItem mnCongDoan;
    JMenuItem mnPhanCong,mnChamCongCN,mnTinhLuongCN;
    JMenuItem mnCapNhatNV,mnCapNhatCN, mnCapNhatSP;
    JMenuItem mnTimSanPham,mnTimNhanVien,mnTimCongNhan;
    JMenuItem mnDangXuat,mnDoiMatKhau;

    public Form_GiaoDienChinh(){
        doShow();
    }
    public void doShow(){
        setSize(1400,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Quản Lý Lương Sản Phẩm");

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        //Menu chương trình
        Font ftmn = new Font("arial",Font.BOLD,16);
        JMenuBar menuBar = new JMenuBar();

        mnTrangChu = new JMenu("Trang Chủ");
        mnTrangChu.setIcon(new ImageIcon(getClass().getResource("/icons/home_icon.png")));
        mnTrangChu.setFont(ftmn);
        mnTrangChu.isSelected();


        JMenu mnNhanVien = new JMenu("Nhân Viên");
        mnNhanVien.setIcon(new ImageIcon(getClass().getResource("/icons/employee_icon.png")));
        mnNhanVien.setFont(ftmn);
        mnChamCong = new JMenuItem("Chấm Công");
        mnNhanVien.add(mnChamCong);
        mnTinhLuong = new JMenuItem("Tính Lương");
        mnNhanVien.add(mnTinhLuong);
        mnChamCong.setPreferredSize(new Dimension(150,30));
        mnTinhLuong.setPreferredSize(new Dimension(150,30));


        JMenu mnCongNhan = new JMenu("Công Nhân");
        mnCongNhan.setIcon(new ImageIcon(getClass().getResource("/icons/worker_icon.png")));
        mnCongNhan.setFont(ftmn);
        mnCongNhan.add(mnPhanCong = new JMenuItem("Phân Công"));
        mnCongNhan.add(mnChamCongCN = new JMenuItem("Chấm Công"));
        mnCongNhan.add(mnTinhLuongCN = new JMenuItem("Tính Lương"));
        mnPhanCong.setPreferredSize(new Dimension(150,30));
        mnChamCongCN.setPreferredSize(new Dimension(150,30));
        mnTinhLuongCN.setPreferredSize(new Dimension(150,30));


        JMenu mnSanPham = new JMenu("Sản Phẩm");
        mnSanPham.setIcon(new ImageIcon(getClass().getResource("/icons/product_icon.png")));
        mnSanPham.setFont(ftmn);
        mnSanPham.add(mnCongDoan = new JMenuItem("Công Đoạn"));
        mnCongDoan.setPreferredSize(new Dimension(150,30));


        JMenu mnCapNhat = new JMenu("Cập Nhật");
        mnCapNhat.setIcon(new ImageIcon(getClass().getResource("/icons/update_icon_menu.png")));
        mnCapNhat.setFont(ftmn);
        mnCapNhat.add(mnCapNhatNV = new JMenuItem("Nhân Viên"));
        mnCapNhat.add(mnCapNhatCN = new JMenuItem("Công Nhân"));
        mnCapNhat.add(mnCapNhatSP = new JMenuItem("Sản Phẩm"));
        mnCapNhatNV.setPreferredSize(new Dimension(150,30));
        mnCapNhatCN.setPreferredSize(new Dimension(150,30));
        mnCapNhatSP.setPreferredSize(new Dimension(150,30));


        JMenu mnTimKiem = new JMenu("Tìm Kiếm");
        mnTimKiem.setIcon(new ImageIcon(getClass().getResource("/icons/search_icon.png")));
        mnTimKiem.setFont(ftmn);
        mnTimKiem.add(mnTimNhanVien = new JMenuItem("Nhân Viên"));
        mnTimKiem.add(mnTimCongNhan = new JMenuItem("Công Nhân"));
        mnTimKiem.add(mnTimSanPham = new JMenuItem("Sản Phẩm"));

        mnTimSanPham.setPreferredSize(new Dimension(150,30));
        mnTimNhanVien.setPreferredSize(new Dimension(150,30));
        mnTimCongNhan.setPreferredSize(new Dimension(150,30));


        JMenu mnTaiKhoan = new JMenu("Tài Khoản");
        mnTaiKhoan.setIcon(new ImageIcon(getClass().getResource("/icons/user_icon.png")));
        mnTaiKhoan.setFont(ftmn);
        mnTaiKhoan.add(mnDoiMatKhau = new JMenuItem("Đổi Mật Khẩu"));
        mnTaiKhoan.add(mnDangXuat = new JMenuItem("Đăng Xuất"));
        mnDoiMatKhau.setPreferredSize(new Dimension(150,30));
        mnDangXuat.setPreferredSize(new Dimension(150,30));

        mnThoat = new JMenu("Thoát");
        mnThoat.setIcon(new ImageIcon(getClass().getResource("/icons/exit_icon.png")));
        mnThoat.setFont(ftmn);

        JMenu menu = new JMenu("                                                                    " +
                "                                                       ");
        menu.setEnabled(true);

        menuBar.add(mnTrangChu);
        menuBar.add(mnNhanVien);
        menuBar.add(mnCongNhan);
        menuBar.add(mnSanPham);
        menuBar.add(mnCapNhat);
        menuBar.add(mnTimKiem);
        menuBar.add(mnTaiKhoan);
        menuBar.add(menu);
        menuBar.add(mnThoat);
        mnThoat.setMargin(new Insets(0,300, 0,0));


        //PnCneter
        pnCneter = new JPanel();
        JPanel pnCenterN = new JPanel();
        JPanel pnCenterC = new JPanel();
        pnCneter.setLayout(new BorderLayout());
        JLabel lblTieuDe = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ LƯƠNG SẢN PHẨM");
        lblTieuDe.setFont(new Font("arial",Font.BOLD,24));
        lblTieuDe.setForeground(Color.RED);
        pnCenterN.setPreferredSize(new Dimension(1000,80));

        JLabel lbImage = new JLabel();
        lbImage.setIcon(new ImageIcon(getClass().getResource("/icons/background.jpg")));

        pnCenterN.add(lblTieuDe);
        pnCenterC.add(lbImage);
        pnCneter.add(pnCenterN,BorderLayout.NORTH);
        pnCneter.add(pnCenterC,BorderLayout.CENTER);

        //pnSouth
        JPanel pnSouth = new JPanel();

        cp.add(menuBar,BorderLayout.NORTH);
        cp.add(pnCneter,BorderLayout.CENTER);
        cp.add(pnSouth,BorderLayout.SOUTH);
        menuBar.setBackground(Color.decode("#B2EBF2"));
        pnCneter.setForeground(Color.decode("#CCCCCC"));

        //Event
        mnTrangChu.addMouseListener(this);
        mnThoat.addMouseListener(this);

        mnChamCong.addActionListener(this);
        mnTinhLuong.addActionListener(this);
        mnChamCongCN.addActionListener(this);
        mnTinhLuongCN.addActionListener(this);
        mnPhanCong.addActionListener(this);
        mnCapNhatCN.addActionListener(this);
        mnCapNhatNV.addActionListener(this);
        mnCapNhatSP.addActionListener(this);
        mnTimNhanVien.addActionListener(this);
        mnTimCongNhan.addActionListener(this);
        mnTimSanPham.addActionListener(this);
        mnDoiMatKhau.addActionListener(this);
        mnDangXuat.addActionListener(this);
        mnCongDoan.addActionListener(this);

    }

    public static void main(String[] args) {
        new Form_GiaoDienChinh().setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(mnTrangChu)) {
            System.out.println("Menu Trang Chu Selected!");
            Form_TrangChu form_trangChu = new Form_TrangChu();
            pnCneter.removeAll();
            pnCneter.add(form_trangChu);
            validate();
        }else if(e.getSource().equals(mnThoat)) {
            System.out.println("Menu Thoat Selected!");
            setVisible(false);
            dispose();
            System.out.println("Exit Program!");
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mnChamCong)) {
            System.out.println("Menu Cham Cong NV Selected!");
            Form_ChamCongNhanVien form_chamCongNhanVien = new Form_ChamCongNhanVien();
            pnCneter.removeAll();
            pnCneter.add(form_chamCongNhanVien);
            validate();
        } else if (e.getSource().equals(mnTinhLuong)) {
            System.out.println("Menu Tinh Luong Nhan Vien Selected!");
            Form_LuongNhanVien form_luongNhanVien = new Form_LuongNhanVien();
            pnCneter.removeAll();
            pnCneter.add(form_luongNhanVien);
            validate();

        } else if(e.getSource().equals(mnDangXuat)) {
            System.out.println("Menu Dang Xuat Selected!");
            setVisible(false);
            Form_DangNhap form_dangNhap = new Form_DangNhap();
            form_dangNhap.setVisible(true);
        } else if (e.getSource().equals(mnCapNhatNV)) {
            System.out.println("Menu Cap Nhat Nhan Vien Selected!");
            Form_NhanVienHanhChinh form_nhanVienHanhChinh = new Form_NhanVienHanhChinh();
            pnCneter.removeAll();
            pnCneter.add(form_nhanVienHanhChinh);
            validate();
        } else if (e.getSource().equals(mnCapNhatCN)) {
            System.out.println("Menu Cap Nhat Cong Nhan Selected!");
            Form_CongNhan form_congNhan = new Form_CongNhan();
            pnCneter.removeAll();
            pnCneter.add(form_congNhan);
            validate();
        } else if (e.getSource().equals(mnCapNhatSP)) {
            System.out.println("Menu Cap Nhat San Pham Selected!");
            Form_SanPham form_sanPham = new Form_SanPham();
            pnCneter.removeAll();
            pnCneter.add(form_sanPham);
            validate();
        } else if (e.getSource().equals(mnCongDoan)) {
            System.out.println("Menu Cong Doan Selected!");
            Form_CongDoan form_congDoan = new Form_CongDoan();
            pnCneter.removeAll();
            pnCneter.add(form_congDoan);
            validate();
        } else if (e.getSource().equals(mnPhanCong)) {
            System.out.println("Menu Phan Cong Selected!");
            Form_PhanCong form_phanCong = new Form_PhanCong();
            pnCneter.removeAll();
            pnCneter.add(form_phanCong);
            validate();
        } else if (e.getSource().equals(mnChamCongCN)) {
            System.out.println("Menu Cham Cong CN Selected!");
            Form_ChamCongCongNhan form_chamCongCongNhan = new Form_ChamCongCongNhan();
            pnCneter.removeAll();
            pnCneter.add(form_chamCongCongNhan);
            validate();
        } else if (e.getSource().equals(mnTinhLuongCN)) {
            System.out.println("Menu Tinh Luong CN Selected!");
            Form_LuongCongNhan form_luongCongNhan = new Form_LuongCongNhan();
            pnCneter.removeAll();
            pnCneter.add(form_luongCongNhan);
            validate();
        } else if (e.getSource().equals(mnTimNhanVien)) {
            System.out.println("Menu Tim Kiem Nhan Vien Selected!");
            Form_TimNhanVien form_timNhanVien = new Form_TimNhanVien();
            pnCneter.removeAll();
            pnCneter.add(form_timNhanVien);
            validate();
        } else if (e.getSource().equals(mnTimCongNhan)) {
            System.out.println("Menu Tim Kiem Cong Nhan Selected!");
            Form_TimCongNhan form_timCongNhan = new Form_TimCongNhan();
            pnCneter.removeAll();
            pnCneter.add(form_timCongNhan);
            validate();
        } else if (e.getSource().equals(mnTimSanPham)) {
            System.out.println("Menu Tim Kiem San Pham Selected!");
            Form_TimSanPham form_timSanPham = new Form_TimSanPham();
            pnCneter.removeAll();
            pnCneter.add(form_timSanPham);
            validate();
        }
    }
}
