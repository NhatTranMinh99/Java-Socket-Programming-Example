package ltm.server.model;

import java.io.Serializable;
import java.util.Vector;

public class Student implements Serializable {
    private int id;
    private String ten;
    private String ngaysinh;
    private String khoa;
    private String que;

    public Student(int id, String ten, String ngaysinh, String khoa, String que) {
        this.id = id;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.khoa = khoa;
        this.que = que;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", ten=" + ten + ", ngaysinh=" + ngaysinh + ", khoa=" + khoa + ", que=" + que + '}';
    }
    
    public Vector toVector() {
        Vector<String> v = new Vector<String>();
        v.add(Integer.toString(id));
        v.add(ten);
        v.add(ngaysinh);
        v.add(khoa);
        v.add(que);
        return v;
    }
}
