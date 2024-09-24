/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class DemoJTable extends JFrame {

    private JTable tbltaikhoan;
    private JLabel lbTen, lbTien;
    private JTextField txtTen, txtTien;
    private JButton btThem, btXoa;
    

    public DemoJTable() {
        super("Demo Jtable");
        Gui();
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void Gui() {
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        //tạo jTaBle
        String[] clum = {"Tên Tài khoản ", "Số tiền"};
        Object[][] data = new Object[][]{
            {"Lê Thành Công", "1500000"},
            {"Trần Minh Khôi", "1000000"}
        };
        DefaultTableModel model = new DefaultTableModel(data, clum);
        tbltaikhoan = new JTable(model);
        JScrollPane crotable = new JScrollPane(tbltaikhoan);
        jp.add(crotable);
        //Tạo jpanel chứa các điều kiện dữ liệu
        JPanel p = new JPanel();
        p.add(lbTen = new JLabel("Tên tài khoản"));
        p.add(txtTen = new JTextField(15));
        p.add(lbTien = new JLabel("Số tiền "));
        p.add(txtTien = new JTextField(10));
        p.add(btThem = new JButton("Thêm"));
        p.add(btXoa = new JButton("Xoá"));
        jp.add(p, BorderLayout.NORTH);
        add(jp);
    }

    public static void main(String[] args) {
        DemoJTable Jtb = new DemoJTable();
        Jtb.setVisible(true);
    }

    private void SKbuttun() {
         btThem.addActionListener((e) -> {
            DefaultTableModel model = (DefaultTableModel)tbltaikhoan.getModel();
            model.addRow(new Object[]{txtTen.getText(), txtTien.getText()});
        });
        
        
         btXoa.addActionListener((e) -> {

            int SelectedRow = tbltaikhoan.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel)tbltaikhoan.getModel();
            model.removeRow(SelectedRow);
        });
    }

}
