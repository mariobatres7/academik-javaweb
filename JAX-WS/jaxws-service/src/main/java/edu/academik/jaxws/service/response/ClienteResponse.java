package edu.academik.jaxws.service.response;

import java.util.Date;

/**
 *
 * @author Mario Batres
 */
public class ClienteResponse {

    private Long clienteId;

    private String codigo;

    private String nombre;

    private Date creadoEl;

    public ClienteResponse() {
    }

        public ClienteResponse(Long clienteId, String code, String nombre, Date creadoEl) {
        this.clienteId = clienteId;
        this.codigo = code;
        this.nombre = nombre;
        this.creadoEl = creadoEl;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getCreadoEl() {
        return creadoEl;
    }

    public void setCreadoEl(Date creadoEl) {
        this.creadoEl = creadoEl;
    }

}
