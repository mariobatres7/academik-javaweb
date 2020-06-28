package com.academik.javaweb.clase04.jsf001.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@ToString(of = "productoId")
@EqualsAndHashCode(of = "productoId")
public class Producto implements Serializable {

    @Id
    @Column(name = "producto_id")
    private Long productoId;

    @Column(name = "producto")
    private String codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_base")
    private BigDecimal precioBase;

    @OneToMany(mappedBy = "producto")
    private List<Inventario> inventarioList;
}
