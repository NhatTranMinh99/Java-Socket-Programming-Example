/*
    // Giao diện chính của Client
*/
package ltm.client.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ltm.server.model.Student;

public class MainView extends javax.swing.JFrame {

    public MainView() {
        initComponents();
        
    }
    
    public void addSearchListener(ActionListener listener) {
        btn_search.addActionListener(listener);
    }
    
    public void addEditListener(ActionListener listener) {
        btn_edit.addActionListener(listener);
    }
    
    public String getStudentName() {
        return txt_input.getText().trim();
    }
    
    public Student getSelectedRowData() {
        Student student = null;
        int selectedRow = tbl_student.getSelectedRow();
        
        if (selectedRow != -1) {
            int id = Integer.parseInt(tbl_student.getValueAt(selectedRow, 0).toString());
            String ten = tbl_student.getValueAt(selectedRow, 1).toString();
            String ngaysinh = tbl_student.getValueAt(selectedRow, 2).toString();
            String khoa = tbl_student.getValueAt(selectedRow, 3).toString();
            String que = tbl_student.getValueAt(selectedRow, 4).toString();

            student = new Student(id, ten, ngaysinh, khoa, que);
        }
        return student;
    }
    
    public void setTableData(ArrayList<Student> students) {
        if (!students.isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) tbl_student.getModel();
            model.setRowCount(0);
            for (Student s: students) {
                model.addRow(s.toVector());
            }
        }
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_input = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_student = new javax.swing.JTable();
        btn_edit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("4đ qua môn");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nhập tên sinh viên");

        txt_input.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btn_search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_search.setText("Tìm kiếm");

        tbl_student.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên", "Ngày sinh", "Khóa", "Quê"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_student.setCellSelectionEnabled(true);
        tbl_student.setColumnSelectionAllowed(true);
        tbl_student.setRowHeight(20);
        jScrollPane1.setViewportView(tbl_student);

        btn_edit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_edit.setText("Sửa thông tin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_input, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btn_search)
                        .addGap(44, 44, 44)
                        .addComponent(btn_edit))
                    .addComponent(jScrollPane1))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search)
                    .addComponent(btn_edit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_student;
    private javax.swing.JTextField txt_input;
    // End of variables declaration//GEN-END:variables
}
