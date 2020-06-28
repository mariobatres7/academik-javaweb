package com.academik.javaweb.clase04.jsf001.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author Mario Batres
 */
@Entity
@Table(name = "inventarios")
@Data
@ToString
@EqualsAndHashCode(of = "inventarioId")
public class Inventario implements Serializable {

    @Id
    @Column(name = "inventario_id")
    private Long inventarioId;

    @Column(name = "cantidad")
    private BigDecimal cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="producto_id", referencedColumnName = "producto_id")
    private Producto producto;
}
