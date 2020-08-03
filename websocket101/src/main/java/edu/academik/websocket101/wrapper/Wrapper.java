package edu.academik.websocket101.wrapper;

/**
 *
 * @author Mario Batres
 */
public class Wrapper {

    private Long code;

    private String message;

    private String status;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Wrapper{" + "code=" + code + ", message=" + message + ", status=" + status + '}';
    }
    
    

}
