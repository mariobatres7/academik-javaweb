package edu.academik.cors101.modelo;

import javax.validation.constraints.NotNull;


/**
 *
 * @author Mario Batres
 */
public class Cliente {

    @NotNull(message = "clienteId no puede ser nulo")
    private Long clienteId;

    @NotNull(message = "codigo no pueder ser nulo")
    private String codigo;

    @NotNull(message = "nombre no pueder ser nulo")
    private String nombre;

    //Patrón Builder
    // Cliente cliente = new Cliente(1L, "0001", "mario Batres", null, null, null, 1);
    public Cliente() {
    }

    public Cliente(Long clienteId, String codigo, String nombre) {
        this.clienteId = clienteId;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public static class Builder {

        private Long clienteId;

        private String codigo;

        private String nombre;

        public Builder clienteId(Long clienteId) {
            this.clienteId = clienteId;
            return this;
        }

        public Builder codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Cliente build() {

            Cliente cliente = new Cliente();
            cliente.setClienteId(clienteId);
            cliente.setCodigo(codigo);
            cliente.setNombre(nombre);
            return cliente;

        }

    }

    public static Builder builder() {
        return new Cliente.Builder();
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" + "clienteId=" + clienteId + ", codigo=" + codigo + ", nombre=" + nombre + '}';
    }

}
