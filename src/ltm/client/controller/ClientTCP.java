/*
    Phụ trách tạo kết nối TCP và gửi/nhận dữ liệu tại Client
*/
package ltm.client.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import ltm.server.model.ClientMessage;
import ltm.server.model.ServerMessage;

public class ClientTCP {
    private String host = "localhost";
    private int port = 4444;
    
    private Socket socket;

    public ClientTCP() {
        try {
            socket = new Socket(host, port);
        } catch (IOException ex) {
            Logger.getLogger(ClientTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void send(ClientMessage message) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(ClientTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ServerMessage receive() {
        ServerMessage message = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Object object = ois.readObject();
            if (object instanceof ServerMessage) {
                message = (ServerMessage) object;
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientTCP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
}
