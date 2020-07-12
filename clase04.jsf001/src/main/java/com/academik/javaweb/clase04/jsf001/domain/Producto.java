package com.academik.javaweb.clase04.jsf001.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @JsonbProperty("producto_id") //analogía con Jackson es @JsonProperty
    private Long productoId;

    @Column(name = "producto")
    private String codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_base")
    private BigDecimal precioBase;

    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    //Esto se utiliza si se mapean en dos atributos el mismo campo
    //@JoinColumn(name = "tipo_producto", referencedColumnName = "id", insertable = false, updatable = false)

    @JoinColumn(name = "tipo_producto", referencedColumnName = "id", insertable = false, updatable = false)
    private TipoProducto tipoProducto;

    
    @JsonbTransient // analogía en Jackson es @JsonIgnore
    //@Column(name = "tipo_producto")
    //private Integer tipoProductoId;
    @OneToMany(mappedBy = "producto")
    private List<Inventario> inventarioList;
}
