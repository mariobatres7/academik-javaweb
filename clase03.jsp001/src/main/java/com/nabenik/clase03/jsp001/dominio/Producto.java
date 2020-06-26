package com.nabenik.clase03.jsp001.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author Mario Batres
 */
@Entity
@Table(name = "productos")
@Data
@EqualsAndHashCode(of = "productoId")
@ToString
public class Producto implements Serializable {

    @Id
    @Column(name = "producto_id")
    private Long productoId;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_base")
    private BigDecimal precioBase;
}
