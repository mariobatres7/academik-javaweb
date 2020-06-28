package com.academik.javaweb.clase04.jsf001.mb;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 *  Estos son de tipo Stateful 
 * 
 * @author Mario Batres
 */
@Named
@ViewScoped
public class IndexManagedBean implements Serializable {

    @Setter
    @Getter
    private int contador;

    @PostConstruct
    public void init() {

        this.contador = 1;
    }

    public void sumarContador() {
        this.contador++;
        
        System.out.println("Sumando ....");
    }

}
