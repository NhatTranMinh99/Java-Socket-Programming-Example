/*
    Kết nối CSDL và thực hiện các truy vấn
*/

package ltm.server.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ltm.server.model.Student;

public class DBConnector {
    private String hostName = "localhost";
    private String dbName = "ltm";
    private String username = "root";
    private String password = "";
    
    Connection conn;

    public DBConnector() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
            try {
                conn = DriverManager.getConnection(connectionURL, username, password);
            } catch (SQLException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Student searchStudentByID(int id) {
        Student student = null;
        try {
            String query = "SELECT * FROM sinhvien WHERE id = " + id;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()) {
                student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3),  rs.getString(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }
    
    public ArrayList<Student> searchStudentByName(String name) {
        ArrayList<Student> students = null;
        try {
            String query = "SELECT * FROM sinhvien WHERE ten like '%" + name + "%'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3),  rs.getString(4), rs.getString(5));
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    
    public void updatePoint(int studentID, int subjectID, int cc, int kt, int btl) {
        try {
            String query = "UPDATE hoc SET cc = " + cc + ", kt = " + kt + ", btl = " + btl + 
                            " WHERE id_sinhvien = " + studentID + " AND id_monhoc = " + subjectID;
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
