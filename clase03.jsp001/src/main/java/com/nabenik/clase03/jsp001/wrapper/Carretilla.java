package com.nabenik.clase03.jsp001.wrapper;

import com.nabenik.clase03.jsp001.dominio.Producto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author Mario Batres
 */
@Data
@ToString
@EqualsAndHashCode(of = "producto")
public class Carretilla {

    private Producto producto;

    private Integer cantidad;

}
