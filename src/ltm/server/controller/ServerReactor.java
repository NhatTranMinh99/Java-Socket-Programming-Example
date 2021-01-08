/*
    Lắng nghe và xử lý các request từ Client
*/

package ltm.server.controller;

import java.util.ArrayList;
import ltm.server.model.ClientMessage;
import ltm.server.model.ServerMessage;
import ltm.server.model.Student;

public class ServerReactor {
    private DBConnector conn;
    private ServerTCP socket;
    
    public ServerReactor(DBConnector conn, ServerTCP socket) {
        this.conn = conn;
        this.socket = socket;
    }
    
    public void run() {
        while(true) {
            ClientMessage message = socket.receive();
            if (message != null) {
                switch (message.getRequest()) {
                    case SEARCH: {
                        String studentName = message.getData().toString();
                        ArrayList<Student> result = conn.searchStudentByName(studentName);
                        if (result.isEmpty()) {
                            socket.send(new ServerMessage(ServerMessage.RESPONSE.ERROR, "Không tìm thấy kết quả"));
                        } else {
                            socket.send(new ServerMessage(ServerMessage.RESPONSE.OK, result));
                        }
                        break;
                    }
                    case EDIT: {
                        Student student = (Student) message.getData();
                        conn.updateStudent(student.getId(), student.getTen(), student.getNgaysinh(), student.getKhoa(), student.getQue());
                        socket.send(new ServerMessage(ServerMessage.RESPONSE.OK, "Cập nhật thông tin sinh viên thành công"));
                        break;
                    }
                }
            }
        }
    }
}
