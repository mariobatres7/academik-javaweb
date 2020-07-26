package edu.academik.jaxrs.client;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Mario Batres
 */
public class Producto implements Serializable{

    private Long productoId;

    private String codigo;

    private BigDecimal precioBase;

    private String descripcion;

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(BigDecimal precioBase) {
        this.precioBase = precioBase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
