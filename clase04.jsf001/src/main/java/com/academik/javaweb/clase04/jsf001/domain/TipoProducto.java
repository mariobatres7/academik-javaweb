package com.academik.javaweb.clase04.jsf001.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Mario Batres
 */
@Entity
@Table(name = "vista_tipo_producto")
@Data
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@Setter(AccessLevel.PROTECTED)
public class TipoProducto implements Serializable {

    @Id
    @Column(name = "id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "descripcion", insertable = false, updatable = false)
    private String descripcion;
    
    @OneToMany(mappedBy = "tipoProducto")
    private List<Producto> productoList;
    
    
    

}
