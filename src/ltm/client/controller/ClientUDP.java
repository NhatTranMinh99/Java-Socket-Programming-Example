/*
    Phụ trách tạo kết nối UDP và gửi/nhận dữ liệu tại Client
*/
package ltm.client.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ltm.server.controller.ServerUDP;
import ltm.server.model.ClientMessage;
import ltm.server.model.ServerMessage;

public class ClientUDP {
    private String host = "localhost";
    private int sPort = 4444;
    private int cPort = 5555;
    
    private DatagramSocket socket;
    private DatagramPacket receivedPacket;
    
    public ClientUDP() {
        try {
            socket = new DatagramSocket(cPort);
        } catch (SocketException ex) {
            Logger.getLogger(ClientUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect() {
        socket.close();
    }
    
    public void send(ClientMessage message) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(message);
            oos.flush();

            byte[] sendData = baos.toByteArray();
            InetAddress IPAddress = InetAddress.getByName(host);
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, sPort);
            socket.send(sendPacket);
        } catch (Exception ex) {
            Logger.getLogger(ServerUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ServerMessage receive() {
         ServerMessage message = null;
         
         try {
            byte[] receiveData = new byte[1024];
            receivedPacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivedPacket);
            
            ByteArrayInputStream bais = new ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            message = (ServerMessage) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ServerUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return message;
    }
}
