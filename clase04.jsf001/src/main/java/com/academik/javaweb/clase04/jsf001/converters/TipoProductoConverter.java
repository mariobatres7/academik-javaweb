package com.academik.javaweb.clase04.jsf001.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Estos es mucho mejor utilizarlo cuando no tengamos que acceder a datos en un recurso externo
 * por ejemplo, o el mas comun, una base de datos.
 * 
 * @author Mario Batres
 */

//@FacesConverter
public class TipoProductoConverter /*implements Converter*/{

//    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 //   @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
