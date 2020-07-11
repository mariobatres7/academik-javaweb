package com.academik.javaweb.clase04.jsf001.mb;

import com.academik.javaweb.clase04.jsf001.domain.Producto;
import com.academik.javaweb.clase04.jsf001.domain.TipoProducto;
import com.academik.javaweb.clase04.jsf001.servicio.ProductoServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mario Batres
 */
@Named
@ViewScoped
public class ProductoManagedBean implements Serializable, Converter {

    @Inject
    private CarretillaManagedBean carretillaManagedBean;

    @Inject
    private ProductoServicio productoServicio;

    @Getter
    private List<Producto> productoList;

    @Getter
    @Setter
    private TipoProducto tipoProductoSelected;

    @Getter
    private List<TipoProducto> tipoProductoList;

    @PostConstruct
    public void init() {
        this.productoList = this.productoServicio.findProductoList();

        this.tipoProductoList = this.productoServicio.findTipoProductoList();
    }

    public void agregarProducto(Producto producto) {

        System.out.println("Agregando producto:   " + producto);

        this.carretillaManagedBean.getProductoSet().add(producto);

        FacesMessage fm = new FacesMessage();
        fm.setDetail("Producto " + producto + " agregado.");
        fm.setSummary("Información");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);

        FacesContext.getCurrentInstance().addMessage(null, fm);
    }

    public void procesarTipoProducto() {

        try {
            System.out.println(this.tipoProductoSelected);

            FacesMessage fm = new FacesMessage();
            fm.setDetail("Tipo Producto:   " + tipoProductoSelected + " seleccionado.");
            fm.setSummary("Información");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);

            FacesContext.getCurrentInstance().addMessage(null, fm);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());

        }
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string == null){
            return null;
        }
        
        if (uic.getId().equalsIgnoreCase("tipoProductoSelect")){
            //hacer tal cosaa
        } else if (uic.getId().equalsIgnoreCase("tipoProductoSelect2")){
            //haga otra cosa
        }
        
        Integer id = Integer.parseInt(string);
        
        return this.tipoProductoList.stream().filter(tp -> tp.getId() == id).findFirst().orElse(null);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        return ((TipoProducto) obj).getId().toString();
    }

}
