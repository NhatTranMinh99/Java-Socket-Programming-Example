/*
    
*/
package ltm.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import ltm.client.view.EditView;
import ltm.client.view.MainView;
import ltm.server.model.ClientMessage;
import ltm.server.model.ServerMessage;
import ltm.server.model.Student;

public class MainController {
    MainView view;
    EditView editView;
//    ClientTCP socket;   // bỏ comment nếu dùng TCP
    ClientUDP socket;   // bỏ comment nếu dùng TCP

    public MainController() {
        view = new MainView();
        view.addSearchListener(new SearchButtonListener());
        view.addEditListener(new EditButtonListener());
        view.setVisible(true);
    }
    
    class SearchButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            socket = new ClientTCP();   // Bỏ comment nếu dùng TCP
            socket = new ClientUDP();   // Bỏ comment nếu dùng UDP
            String studentName = view.getStudentName();
            if (!studentName.equals("")) {
                socket.send(new ClientMessage(ClientMessage.REQUEST.SEARCH, studentName));
                
                ServerMessage receivedMessage = socket.receive();
                if (receivedMessage.getResponse() == ServerMessage.RESPONSE.OK) {
                    ArrayList<Student> students = (ArrayList<Student>) receivedMessage.getData();
                    view.setTableData(students);
                } else {
                    view.showMessage(receivedMessage.getData().toString());
                }
                socket.disconnect();
            }
        }
    
    }
    
    class EditButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Student student = view.getSelectedRowData();
            if (student != null) {
                editView = new EditView(student);
                editView.addUpdateListener(new UpdateButtonListener());
                editView.setVisible(true);
            } else {
                view.showMessage("Không có dòng nào được chọn");
            }
        }
        
    }
    
    class UpdateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            socket = new ClientTCP();   // Bỏ comment nếu dùng TCP
            socket = new ClientUDP();   // Bỏ comment nếu dùng UDP
            Student student = editView.getStudent();
            
            if (student.getTen().equals("") || student.getNgaysinh().equals("") ||
                    student.getKhoa().equals("") || student.getQue().equals("")) {
                view.showMessage("Không được để trống thông tin");
            } else {
                socket.send(new ClientMessage(ClientMessage.REQUEST.EDIT, student));

                ServerMessage receivedMessage = socket.receive();
                if (receivedMessage.getResponse() == ServerMessage.RESPONSE.OK) {
                    editView.dispose();
                } else {
                    view.showMessage(receivedMessage.getData().toString());
                }
            }
            
            socket.disconnect();
        }
        
    }
}
