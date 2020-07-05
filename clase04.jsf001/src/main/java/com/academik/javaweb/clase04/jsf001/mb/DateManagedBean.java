package com.academik.javaweb.clase04.jsf001.mb;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mario Batres
 */
@Named
@ViewScoped
@Getter
@Setter
public class DateManagedBean implements Serializable {

    @NotNull
    private Integer numero;

    //Desde casi siempre
    private Date date;

    //Desde java 8
    private LocalDate localDate;

    @PostConstruct
    public void init() {
        this.date = new Date();

        this.localDate = LocalDate.now();
    }

    public String getLocalDateWithFormat() {
        return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public Date getLocalDateAsDate() {
        return Date.from(this.localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

}
