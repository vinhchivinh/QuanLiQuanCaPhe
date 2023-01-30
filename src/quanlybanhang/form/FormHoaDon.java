/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang.form;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import quanlybanhang.enity.Ban;
import quanlybanhang.enity.ChiTietHoaDon;
import quanlybanhang.enity.GiaTien;
import quanlybanhang.enity.HoaDon;
import quanlybanhang.enity.ThucUong;
import quanlybanhang.service.SVBan;
import quanlybanhang.service.SVChitiethoadon;
import quanlybanhang.service.SVHoaDon;
import quanlybanhang.service.SVThucUong;

/**
 *
 * @author admin
 */
public class FormHoaDon extends javax.swing.JFrame {

    /**
     * Creates new form FormHoaDon
     */
    private List<ThucUong> danhsachthucuong;
    private String bangchitiethoadon[][];
    private String mahoadon;
    private int soluongsanpham;
    private int id_ban;
    private int trangthai;
    private String trangthaiban;
    private String bangchitiethoadoncu[][];

    public FormHoaDon() {
        initComponents();
        danhsachthucuong = new ArrayList<>();
        bangchitiethoadon = new String[1000][10];
        this.soluongsanpham = 0;
        duaDuLieuVaoCombobox();
    }

    public FormHoaDon(int id_ban, String trangthaiban, String MaHoaDon, String chitiethoadoncu[][]) {
        initComponents();
        this.mahoadon = MaHoaDon;
        this.id_ban = id_ban;
        this.trangthaiban = trangthaiban;
        danhsachthucuong = new ArrayList<>();
        bangchitiethoadon = new String[1000][10];
        bangchitiethoadoncu = new String[1000][10];
        this.bangchitiethoadoncu = chitiethoadoncu;
        duaDuLieuVaoCombobox();
        this.soluongsanpham = 0;
        this.trangthai = 1;
       
    }

    public void xoaPhanTuTrongMang(int index, String a[][], int col) {
        for (int i = index; i < a.length - 1; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = a[i + 1][j];
            }
        }
        for (int j = 0; j < col; j++) {
            a[a.length - 1][j] = null;
        }
    }

    public int kiemTraTonTai(String masanpham, String danhsachsanpham[][], int col) {

        int i = 0;
        for (i = 0; i < this.demSoPhanTuTrongMang(danhsachsanpham); i++) {
            if (danhsachsanpham[i][col].trim().compareTo(masanpham.trim()) == 0) {
                return 1;
            }
        }
        return 0;
    }

    int demSoPhanTuTrongMang(String a[][]) {
        int dem = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i][0] != null) {
                dem = dem + 1;
            } else {
                break;
            }
        }
        return dem;
    }

    public void duaDuLieuVaoCombobox() {
        danhsachthucuong = new ArrayList<>();
        SVThucUong svtu = new SVThucUong();
        danhsachthucuong = svtu.danhSachThucUong();
        for (ThucUong values : danhsachthucuong) {
            this.jComboBox1.addItem(values.getTenthucuong());
        }
    }

    void themDuLieuVaoTable(String a[][], String b, String c, String d, String e) {
        int index = demSoPhanTuTrongMang(a);
        a[index][0] = b;
        a[index][1] = c;
        a[index][2] = d;
        a[index][3] = e;
    }

    public void duaDuLieuVaoTable() {
        String[] column = {"TÊN THỨC UỐNG", "SỐ LƯỢNG"};
        TableModel model = new DefaultTableModel(bangchitiethoadon, column);
        this.jTable1.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        soluongTXT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        themBTN = new javax.swing.JButton();
        themBTN1 = new javax.swing.JButton();
        ghichuTXT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("CHI TIẾT HÓA ĐƠN");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "THỨC UỐNG", "SỐ LƯỢNG"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        soluongTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soluongTXTActionPerformed(evt);
            }
        });

        jLabel2.setText("THỨC UỐNG");

        jLabel3.setText("SỐ LƯỢNG");

        themBTN.setText("THÊM");
        themBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themBTNActionPerformed(evt);
            }
        });

        themBTN1.setText("LƯU");
        themBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themBTN1ActionPerformed(evt);
            }
        });

        ghichuTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ghichuTXTActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Ghi Chú");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/form/house-icon.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setText("TRANG CHỦ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(278, 278, 278))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 462, Short.MAX_VALUE)
                .addComponent(themBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(321, 321, 321))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ghichuTXT))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(themBTN1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(soluongTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(231, 231, 231)))
                .addGap(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(soluongTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(themBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ghichuTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(themBTN1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void themBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themBTNActionPerformed
        // TODO add your handling code here:
        this.soluongsanpham++;
        int index = this.jComboBox1.getSelectedIndex();
        String tenthucuong = danhsachthucuong.get(index).getTenthucuong();
        String soluong = this.soluongTXT.getText();
        String mathucuong = danhsachthucuong.get(index).getMathucuong();
        String idgia = Integer.toString(danhsachthucuong.get(index).getGia().getId());
        themDuLieuVaoTable(bangchitiethoadon, tenthucuong, soluong, mathucuong, idgia);
        duaDuLieuVaoTable();
    }//GEN-LAST:event_themBTNActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void themBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themBTN1ActionPerformed
        // update hoa don va them chi tiet hoa don
        if (this.trangthaiban.compareToIgnoreCase("Đang Sử Dụng")==0) {
            SVHoaDon capnhat = new SVHoaDon();
            HoaDon hoadoncapnhat = new HoaDon();
            ChiTietHoaDon cthdcapnhap = new ChiTietHoaDon();
            ThucUong thucuongcapnhat = new ThucUong();

            for (int i = 0; i < this.demSoPhanTuTrongMang(this.bangchitiethoadon); i++) {
                if (this.kiemTraTonTai(this.bangchitiethoadoncu[i][5], bangchitiethoadon, 2) == 1) {
                    hoadoncapnhat.setMahoadon(this.mahoadon);
                    cthdcapnhap.setSl(Integer.parseInt(this.bangchitiethoadon[i][1]));
                    thucuongcapnhat.setMathucuong(this.bangchitiethoadon[i][2]);

                    cthdcapnhap.setThucuong(thucuongcapnhat);

                    List<ChiTietHoaDon> dschitiet = new ArrayList<>();
                    dschitiet.add(cthdcapnhap);

                    hoadoncapnhat.setChiTietHoaDon(dschitiet);
                    if (capnhat.capNhatHoaDon(hoadoncapnhat) != 0) {
                        JPanel Frame = new JPanel();
                        JOptionPane.showMessageDialog(Frame, "Cap Nhat Hoa Don Thanh Cong");
                    } else {
                        JPanel Frame = new JPanel();
                        JOptionPane.showMessageDialog(Frame, "Cap Nhat That Bai");
                    }
                    this.xoaPhanTuTrongMang(i, bangchitiethoadon, 10);
                }
            }

            List<ChiTietHoaDon> chitiethoadon_themthucuong = new ArrayList<>();
            HoaDon hoadon_themthucuong = new HoaDon();

            for (int i = 0; i < this.demSoPhanTuTrongMang(bangchitiethoadon); i++) {
                ChiTietHoaDon ct = new ChiTietHoaDon();
                int sl = Integer.parseInt(this.bangchitiethoadon[i][1]);
                String mathucuong = this.bangchitiethoadon[i][2];
                int id_gia = Integer.parseInt(this.bangchitiethoadon[i][3]);

                ct.setSl(sl);
                ct.getThucuong().setMathucuong(mathucuong);
                ct.getThucuong().getGia().setId(id_gia);
                chitiethoadon_themthucuong.add(ct);

            }

            hoadon_themthucuong.setGhichu(this.ghichuTXT.getText());
            hoadon_themthucuong.setChiTietHoaDon(chitiethoadon_themthucuong);
            hoadon_themthucuong.setMahoadon(this.mahoadon);
            hoadon_themthucuong.setTrangthai(this.trangthai);

            SVChitiethoadon svcthd = new SVChitiethoadon();
            if (svcthd.capNhatChiTietHoaDon(hoadon_themthucuong) != 0) {
                JPanel Frame = new JPanel();
                JOptionPane.showMessageDialog(Frame, "Cập Nhật Hóa Đơn Thành Công");
            } else {
                JPanel Frame = new JPanel();
                JOptionPane.showMessageDialog(Frame, "Cập Nhật Hóa Đơn Thất Bại");
            }
            
            this.setVisible(false);

        } else {
            SVHoaDon svhd = new SVHoaDon();
            SVBan ban = new SVBan();
            Ban banan = new Ban();
            HoaDon hd = new HoaDon();

            List<ThucUong> thucuong = new ArrayList<>();
            GiaTien giatien = new GiaTien();
            List<ChiTietHoaDon> cthd = new ArrayList<>();
            for (int i = 0; i < this.demSoPhanTuTrongMang(bangchitiethoadon); i++) {
                ChiTietHoaDon ct = new ChiTietHoaDon();
                int sl = Integer.parseInt(this.bangchitiethoadon[i][1]);
                String mathucuong = this.bangchitiethoadon[i][2];
                int id_gia = Integer.parseInt(this.bangchitiethoadon[i][3]);

                ct.setSl(sl);
                ct.getThucuong().setMathucuong(mathucuong);
                ct.getThucuong().getGia().setId(id_gia);
                cthd.add(ct);
            }

            hd.setGhichu(this.ghichuTXT.getText());
            hd.setChiTietHoaDon(cthd);
            hd.setMahoadon(this.mahoadon);
            hd.setTrangthai(this.trangthai);
            banan.setId_ban(this.id_ban);
            banan.setHoadon(hd);
            if (ban.taoHoaDonChoBan(banan) != 0 && svhd.taoHoaDon(banan.getHoadon()) != 0) {
                JPanel Frame = new JPanel();
                JOptionPane.showMessageDialog(Frame, "Thêm Hóa Đơn Thành Công");
            } else {
                JPanel Frame = new JPanel();
                JOptionPane.showMessageDialog(Frame, "Thêm Hóa Đơn Thất Bại");
            }
            this.setVisible(false);

        }

//       
    }//GEN-LAST:event_themBTN1ActionPerformed

    private void soluongTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soluongTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soluongTXTActionPerformed

    private void ghichuTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ghichuTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ghichuTXTActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new FromMenu().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ghichuTXT;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField soluongTXT;
    private javax.swing.JButton themBTN;
    private javax.swing.JButton themBTN1;
    // End of variables declaration//GEN-END:variables
}