package edu.academik.jaxrs.client;

import java.io.Serializable;

/**
 *
 * @author Mario Batres
 * @param <T>
 */

public class ResponseApi<T> implements Serializable {

    private boolean success;

    private String message;

    private T content;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

}
