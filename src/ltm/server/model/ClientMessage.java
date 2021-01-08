/*
    Khung dữ liệu gửi từ Client
*/

package ltm.server.model;

import java.io.Serializable;

public class ClientMessage implements Serializable {
    public enum REQUEST {
        SEARCH,
        EDIT
    }
    
    private REQUEST request;
    private Object data;

    public ClientMessage(REQUEST request, Object data) {
        this.request = request;
        this.data = data;
    }

    public REQUEST getRequest() {
        return request;
    }

    public void setRequest(REQUEST request) {
        this.request = request;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
