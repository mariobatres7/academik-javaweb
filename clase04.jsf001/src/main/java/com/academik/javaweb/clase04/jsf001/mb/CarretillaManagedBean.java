package com.academik.javaweb.clase04.jsf001.mb;

import com.academik.javaweb.clase04.jsf001.domain.Producto;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Getter;

/**
 *
 * @author Mario Batres
 */
@Named
@SessionScoped
public class CarretillaManagedBean implements Serializable {

    @Getter
    private Set<Producto> productoSet;

    @PostConstruct
    public void init() {
        this.productoSet = new HashSet<>();
    }

}
