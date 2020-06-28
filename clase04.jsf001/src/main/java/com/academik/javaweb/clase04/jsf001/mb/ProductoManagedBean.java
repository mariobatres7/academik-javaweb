package com.academik.javaweb.clase04.jsf001.mb;

import com.academik.javaweb.clase04.jsf001.domain.Producto;
import com.academik.javaweb.clase04.jsf001.servicio.ProductoServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
public class ProductoManagedBean implements Serializable {

    @Inject
    private CarretillaManagedBean carretillaManagedBean;
    
    @Inject
    private ProductoServicio productoServicio;

    @Getter
    private List<Producto> productoList;

    @PostConstruct
    public void init() {
        this.productoList = this.productoServicio.findProductoList();
    }
    
    public void agregarProducto(Producto producto){
        
        System.out.println("Agregando producto:   " + producto);
        
        this.carretillaManagedBean.getProductoSet().add(producto);
        
        FacesMessage fm = new FacesMessage();
        fm.setDetail("Producto " +  producto + " agregado.");
        fm.setSummary("Información");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);

        FacesContext.getCurrentInstance().addMessage(null, fm);
    }

}
