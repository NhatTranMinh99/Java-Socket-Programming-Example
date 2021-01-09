package ltm.server;

import ltm.server.controller.DBConnector;
import ltm.server.controller.ServerReactor;
import ltm.server.controller.ServerTCP;
import ltm.server.controller.ServerUDP;

public class ServerRun {
    public static DBConnector conn;
//    public static ServerTCP socket;     // Gỡ comment nếu dùng TCP
    public static ServerUDP socket;
    
    public static void main(String[] args) {
        System.out.println("Server đang chạy");
        conn = new DBConnector();
//        socket = new ServerTCP();   // Gỡ comment nếu dùng TCP
        socket = new ServerUDP();

        ServerReactor serverReactor = new ServerReactor(conn, socket);
        serverReactor.run();
    }
}
