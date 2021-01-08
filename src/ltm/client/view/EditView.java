/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltm.client.view;

import java.awt.event.ActionListener;
import ltm.server.model.Student;

/**
 *
 * @author iamabear
 */
public class EditView extends javax.swing.JFrame {

    private Student student;
    
    public EditView(Student student) {
        initComponents();
        this.student = student;
        txt_name.setText(student.getTen());
        txt_dob.setText(student.getNgaysinh());
        txt_major.setText(student.getKhoa());
        txt_country.setText(student.getQue());
    }

    public void addUpdateListener(ActionListener a) {
        btn_update.addActionListener(a);
    }
    
    public Student getStudent() {
        return new Student(student.getId(), txt_name.getText(), txt_dob.getText(), txt_major.getText(), txt_country.getText());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_name = new javax.swing.JLabel();
        lbl_dob = new javax.swing.JLabel();
        lbl_major = new javax.swing.JLabel();
        lbl_country = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_dob = new javax.swing.JTextField();
        txt_major = new javax.swing.JTextField();
        txt_country = new javax.swing.JTextField();
        btn_update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit");

        lbl_name.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbl_name.setText("Tên");

        lbl_dob.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbl_dob.setText("Ngày sinh");

        lbl_major.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbl_major.setText("Khóa");

        lbl_country.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbl_country.setText("Quê");

        txt_name.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        txt_dob.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        txt_major.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        txt_country.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        btn_update.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_update.setText("Cập nhật");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_name)
                    .addComponent(lbl_dob)
                    .addComponent(lbl_major)
                    .addComponent(lbl_country))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_dob)
                    .addComponent(txt_name)
                    .addComponent(txt_major)
                    .addComponent(txt_country, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_name)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_dob)
                    .addComponent(txt_dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_major)
                    .addComponent(txt_major, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_country)
                    .addComponent(txt_country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btn_update)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel lbl_country;
    private javax.swing.JLabel lbl_dob;
    private javax.swing.JLabel lbl_major;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JTextField txt_country;
    private javax.swing.JTextField txt_dob;
    private javax.swing.JTextField txt_major;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables
}
