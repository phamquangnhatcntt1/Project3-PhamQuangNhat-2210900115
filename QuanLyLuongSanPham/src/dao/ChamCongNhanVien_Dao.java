package dao;

import connection.MyConnection;
import entity.ChamCongNhanVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChamCongNhanVien_Dao {
    private Connection con;
    private CaLamViec_Dao caLamViec_dao;
    private NhanVienHanhChinh_Dao nhanVienHanhChinh_dao;

    public ChamCongNhanVien_Dao() {
        con = MyConnection.getInstance().getConnection();
        caLamViec_dao = new CaLamViec_Dao();
        nhanVienHanhChinh_dao = new NhanVienHanhChinh_Dao();
    }

    public ResultSet getResultSet(String storeName) throws Exception {
        try {
            String callStore = "{CALL " + storeName + "}";
            CallableStatement cs = this.con.prepareCall(callStore);
            cs.execute();
            return cs.getResultSet();
        } catch (SQLException e) {
            throw new Exception("Lỗi khi gọi Store: " + e.getMessage(), e);
        }
    }

    public List<ChamCongNhanVien> getLS() {
        List<ChamCongNhanVien> ds = new ArrayList<>();
        try (ResultSet rs = getResultSet("select_CCNV")) {
            while (rs != null && rs.next()) {
                ChamCongNhanVien chamCongNhanVien = new ChamCongNhanVien(
                        rs.getString(1), rs.getDate(2), rs.getInt(3), rs.getInt(4));
                chamCongNhanVien.setCaLamViec(caLamViec_dao.TimKiemMa(rs.getString(5)));
                chamCongNhanVien.setNhanVienHanhChinh(nhanVienHanhChinh_dao.TimKiemMa(rs.getString(6)));
                ds.add(chamCongNhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public boolean addChamCongNV(ChamCongNhanVien chamCongNhanVien) {
        String sql = "INSERT INTO ChamCongNhanVien (NGAYCHAM, TRANGTHAI, NGHIPHEP, MACA, MANV) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement cnAdd = con.prepareStatement(sql)) {
            cnAdd.setDate(1, chamCongNhanVien.getNgayCham());
            cnAdd.setInt(2, chamCongNhanVien.getTrangThai());
            cnAdd.setInt(3, chamCongNhanVien.getNghiPhep());
            cnAdd.setString(4, chamCongNhanVien.getCaLamViec().getMaCa());
            cnAdd.setString(5, chamCongNhanVien.getNhanVienHanhChinh().getMaNV());

            int n = cnAdd.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteChamCong(String maCC) {
        String sql = "DELETE FROM ChamCongNhanVien WHERE MACONG = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, maCC);
            int n = stmt.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateChamCongNV(ChamCongNhanVien chamCongNhanVien) {
        String sql = "UPDATE ChamCongNhanVien SET TRANGTHAI = ?, NGHIPHEP = ?, MACA = ? WHERE MACONG = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, chamCongNhanVien.getTrangThai());
            stmt.setInt(2, chamCongNhanVien.getNghiPhep());
            stmt.setString(3, chamCongNhanVien.getCaLamViec().getMaCa());
            stmt.setString(4, chamCongNhanVien.getMaCong());

            int n = stmt.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ChamCongNhanVien TimKiemMa(String ma) {
        String sql = "SELECT * FROM ChamCongNhanVien WHERE MACONG = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, ma);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ChamCongNhanVien chamCongNhanVien = new ChamCongNhanVien(
                            rs.getString(1), rs.getDate(2), rs.getInt(3), rs.getInt(4));
                    chamCongNhanVien.setCaLamViec(caLamViec_dao.TimKiemMa(rs.getString(5)));
                    chamCongNhanVien.setNhanVienHanhChinh(nhanVienHanhChinh_dao.TimKiemMa(rs.getString(6)));
                    return chamCongNhanVien;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
