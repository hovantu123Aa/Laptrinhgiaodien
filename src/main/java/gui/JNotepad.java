/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class JNotepad extends JFrame {

    private JMenuBar Mbar;
    private JMenu MFile, MEdit, MFormat, MView, MHelp, MZoom;
    private JMenuItem itemNew, ItemOpen, itemSave, itemSaveAs, itemPageSetup, itemPrint, itemExit, itemZoomin, itemZoomOut, itemRestoredeFaultZoom;
    private JMenuItem itemUndo, itemCopy, itemPaste, itemDelete, itemSearchwithBing, itemFind, itemFindNext, itemGoto, itemSelectAll, itemTimeDelete, itemCut, itemWordWrap, itemFont, itemStatusBar, itemViewHelp, itemSendFeedback, itemAboutNotepad, itemFindPrevious, itemReplace;
    private JTextArea txteditor;
    private JToolBar toolbar;
    private JButton btNew, btSave, btOpen;
    int size = 20;

    public JNotepad(String title) {

        super(title);
        CreateMenu();
        CreateToolbar();
        processEvent();
        txteditor = new JTextArea();
        JScrollPane editor = new JScrollPane(txteditor);
        add(editor);
        txteditor.setFont(new Font("Arial", Font.PLAIN, size));
        txteditor.setLineWrap(true);
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void CreateMenu() {
        //tạo thanh thực đơn
        Mbar = new JMenuBar();
        //tạo các thực đơn add vào thực đơn
        Mbar.add(MFile = new JMenu("File"));
        Mbar.add(MEdit = new JMenu("Edit"));
        Mbar.add(MFormat = new JMenu("Format"));
        Mbar.add(MView = new JMenu("View"));
        Mbar.add(MHelp = new JMenu("help"));
        //tạo các item add vào thực đơn file
        MFile.add(itemNew = new JMenuItem("New"));
        MFile.add(ItemOpen = new JMenuItem("Open..."));
        MFile.add(itemSave = new JMenuItem("Save"));
        MFile.addSeparator();
        MFile.add(itemSaveAs = new JMenuItem("Save As..."));
        MFile.add(itemPageSetup = new JMenuItem("Page Setup.."));
        MFile.add(itemPrint = new JMenuItem("Print..."));
        MFile.addSeparator();
        MFile.add(itemExit = new JMenuItem("Exit"));
        //tạo các item add vào thực đơn edit
        MEdit.add(itemUndo = new JMenuItem("Undo"));
        MEdit.addSeparator();
        MEdit.add(itemCut = new JMenuItem("Cut"));
        MEdit.add(itemCopy = new JMenuItem("Copy"));
        MEdit.add(itemPaste = new JMenuItem("Paste"));
        MEdit.add(itemDelete = new JMenuItem("Delete"));
        MEdit.addSeparator();
        MEdit.add(itemSearchwithBing = new JMenuItem("Search with Bing..."));
        MEdit.add(itemFind = new JMenuItem("Find..."));
        MEdit.add(itemFindNext = new JMenuItem("Find Next"));
        MEdit.add(itemFindPrevious = new JMenuItem("Find Previous "));
        MEdit.add(itemReplace = new JMenuItem("Replace..."));
        MEdit.add(itemGoto = new JMenuItem("Goto..."));
        MEdit.addSeparator();
        MEdit.add(itemSelectAll = new JMenuItem("select All"));
        MEdit.add(itemTimeDelete = new JMenuItem("Time/Date"));
        //tạo các item add vào thực đơn format
        MFormat.add(itemWordWrap = new JCheckBoxMenuItem("Word Wrap", true));
        MFormat.add(itemFont = new JMenuItem("Font..."));
        //tạo các item add vào thực đơn View
        MView.add(MZoom = new JMenu("Zoom"));
        MZoom.add(itemZoomin = new JMenuItem("Zoom in"));
        MZoom.add(itemZoomOut = new JMenuItem("Zoom out"));
        MZoom.add(itemRestoredeFaultZoom = new JMenuItem("Restore Default Zoom"));
        MView.add(itemStatusBar = new JCheckBoxMenuItem("Status Bar", true));
        //tạo các item add vào thực đơn Help
        MHelp.add(itemViewHelp = new JMenuItem("View Help"));
        MHelp.add(itemSendFeedback = new JMenuItem("Send Feedback"));
        MHelp.addSeparator();
        MHelp.add(itemAboutNotepad = new JMenuItem("About Notepad"));
        //Tạo tổ hợp phím cho item menu file
        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        ItemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        itemSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        itemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        //Tạo tổ hợp phím cho item menu edit
        itemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
        itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        itemSearchwithBing.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        itemFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK));
        itemReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
        itemGoto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK));
        itemSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        itemDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
        itemFindNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
        itemFindPrevious.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, KeyEvent.SHIFT_DOWN_MASK));
        itemTimeDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
        //Tạo tổ hợp phím cho item menu View
        itemZoomin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, KeyEvent.CTRL_DOWN_MASK));
        itemZoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.CTRL_DOWN_MASK));
        itemRestoredeFaultZoom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        //gắn thực đơn vào cửa sổ
        setJMenuBar(Mbar);

    }

    public static void main(String[] args) {
        JNotepad notepad = new JNotepad("demo Notepad");
        notepad.setVisible(true);
    }

    public void processEvent() {
        itemZoomin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                size += 4;
                txteditor.setFont(new Font("Arial", Font.PLAIN, size));
            }
        });

        itemZoomOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                size -= 4;
                txteditor.setFont(new Font("Arial", Font.PLAIN, size));
            }
        });
        //xử lí open
        ItemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SaveFile();
            }
        });
        itemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SaveFile();
            }
        });
         itemExit.addActionListener((ActionEvent e) -> {
            if (JOptionPane.showConfirmDialog(null, "Are you sure to Exit") == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        itemCut.addActionListener(e -> txteditor.cut());
        itemCopy.addActionListener(e -> txteditor.copy());
        itemPaste.addActionListener(e -> txteditor.paste());
        itemDelete.addActionListener(e -> delete());
    }

    private void SaveFile() {
        JFileChooser dlgfile = new JFileChooser();
        if (dlgfile.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                //Tạo luồng liên kết tập tin cần lưu
                FileOutputStream fos = new FileOutputStream(dlgfile.getSelectedFile());
                //ghi nội dung của txtEditter ra file 
                fos.write(txteditor.getText().getBytes());
                fos.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "lỗi ghi file");
            }

        }
    }

    private void OpenFile() {
        JFileChooser dlgfile = new JFileChooser();
        if (dlgfile.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                //Tạo luồng liên kết tập tin cần lưu
                FileInputStream fis = new FileInputStream(dlgfile.getSelectedFile());
                //độc tất cả file lưu vào mảng byte
                byte[] B = new byte[fis.available()];
                fis.read(B);
                txteditor.setText(new String(B));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "lỗi độc file");
            }

        }

    }



    private void delete() {
        // Nhận vị trí bắt đầu và kết thúc của văn bản đã chọn
        int start = txteditor.getSelectionStart();
        int end = txteditor.getSelectionEnd();

        // Nếu có một số văn bản được chọn, hãy xóa nó
        if (start != end) {
            txteditor.replaceRange("", start, end);
        }
    }

    private void CreateToolbar() {
        //Tạo thanh công cụ Toobar
        toolbar = new JToolBar();
        //add các nút lệnh vào thanh công cụ
        toolbar.add(btNew = new JButton("New"));
        toolbar.add(btOpen = new JButton("Open"));
        toolbar.add(btSave = new JButton("Save"));
        //set icon cho jbutton
        btNew.setIcon(new ImageIcon(this.getClass().getResource("/img/new.png")));
        btSave.setIcon(new ImageIcon(this.getClass().getResource("/img/Save.png")));
        btOpen.setIcon(new ImageIcon(this.getClass().getResource("/img/open.png")));

        add(toolbar, BorderLayout.NORTH);

    }

}
