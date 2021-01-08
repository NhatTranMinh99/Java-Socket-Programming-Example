/*
    Phụ trách tạo kết nối TCP và gửi/nhận dữ liệu tại Server
*/
package ltm.server.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import ltm.client.controller.ClientTCP;
import ltm.server.model.ClientMessage;
import ltm.server.model.ServerMessage;

public class ServerTCP {
    private int sPort = 4444;
    private ServerSocket sSocket;
    
    private Socket cSocket;

    public ServerTCP() {
        try {
            sSocket = new ServerSocket(sPort);
        } catch (IOException ex) {
            Logger.getLogger(ServerTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void send(ServerMessage message) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(cSocket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(ClientTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ClientMessage receive() {
        ClientMessage message = null;
        try {
            cSocket = sSocket.accept();
            ObjectInputStream ois = new ObjectInputStream(cSocket.getInputStream());
            Object object = ois.readObject();
            if (object instanceof ClientMessage) {
                message = (ClientMessage)object;
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerTCP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
}
