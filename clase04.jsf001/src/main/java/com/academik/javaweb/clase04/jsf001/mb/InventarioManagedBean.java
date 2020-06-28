package com.academik.javaweb.clase04.jsf001.mb;

import com.academik.javaweb.clase04.jsf001.domain.Inventario;
import com.academik.javaweb.clase04.jsf001.servicio.InventarioServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;

/**
 *
 * @author Mario Batres
 */
@Named
@ViewScoped
public class InventarioManagedBean implements Serializable {
    
    @Inject
    private InventarioServicio inventarioServicio;
    
    @Getter
    private List<Inventario> inventarioList;
    
    @PostConstruct
    public void init(){
        this.inventarioList = this.inventarioServicio.findInventarioList();
    }

}
