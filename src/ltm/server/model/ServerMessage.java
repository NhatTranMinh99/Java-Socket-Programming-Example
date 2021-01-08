/*
    Khung dữ liệu gửi từ Server
*/

package ltm.server.model;

import java.io.Serializable;

public class ServerMessage implements Serializable {
    public enum RESPONSE {
        OK,
        ERROR
    }
    
    private RESPONSE response;
    private Object data;

    public ServerMessage(RESPONSE response, Object data) {
        this.response = response;
        this.data = data;
    }

    public RESPONSE getResponse() {
        return response;
    }

    public void setResponse(RESPONSE response) {
        this.response = response;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
