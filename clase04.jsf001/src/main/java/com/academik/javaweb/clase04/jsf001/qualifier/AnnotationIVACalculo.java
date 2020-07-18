package com.academik.javaweb.clase04.jsf001.qualifier;

import javax.enterprise.util.AnnotationLiteral;

/**
 *
 * @author Mario Batres
 */
public class AnnotationIVACalculo extends AnnotationLiteral<IVA> implements IVA {

    private final IVA.Pais value;

    private AnnotationIVACalculo(IVA.Pais value) {
        this.value = value;
    }

    public static IVA getInstance(IVA.Pais pais) {
        return new AnnotationIVACalculo(pais);
    }

    @Override
    public Pais pais() {
        return value;
    }
}
