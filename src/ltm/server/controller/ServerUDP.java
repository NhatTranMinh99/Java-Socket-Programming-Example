/*
    Phụ trách tạo kết nối UDP và gửi/nhận dữ liệu tại Server
*/
package ltm.server.controller;

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
import ltm.server.model.ClientMessage;
import ltm.server.model.ServerMessage;

public class ServerUDP {
    private DatagramSocket socket;
    private int sPort = 4444;
    
    private DatagramPacket receivedPacket;

    public ServerUDP() {
        try {
            socket = new DatagramSocket(sPort);
        } catch (SocketException ex) {
            Logger.getLogger(ServerUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void send(ServerMessage message) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(message);
            oos.flush();

            byte[] sendData = baos.toByteArray();
            InetAddress IPAddress = receivedPacket.getAddress();
            int clientPort = receivedPacket.getPort();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, clientPort);
            socket.send(sendPacket);
        } catch (Exception ex) {
            Logger.getLogger(ServerUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ClientMessage receive() {
        ClientMessage message = null;
        
        try {
            byte[] receiveData = new byte[1024];
            receivedPacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivedPacket);
            
            ByteArrayInputStream bais = new ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            message = (ClientMessage) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ServerUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return message;
    }
}
