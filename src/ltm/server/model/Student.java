package ltm.server.model;

public class Student {
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
    
    
}
