package ltm.server;

import ltm.server.controller.DBConnector;
import ltm.server.controller.ServerReactor;
import ltm.server.controller.ServerTCP;

public class ServerRun {
    public static DBConnector conn;
    public static ServerTCP socket;
    
    public static void main(String[] args) {
        System.out.println("Server đang chạy");
        conn = new DBConnector();
        socket = new ServerTCP();
        
        ServerReactor serverReactor = new ServerReactor(conn, socket);
        serverReactor.run();
    }
}
