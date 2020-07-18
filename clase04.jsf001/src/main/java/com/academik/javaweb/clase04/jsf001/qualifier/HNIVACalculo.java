package com.academik.javaweb.clase04.jsf001.qualifier;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Mario Batres
 */
@IVA(pais = IVA.Pais.HN)
public class HNIVACalculo implements IVACalculo {

    @Override
    public BigDecimal desglozarIVA(BigDecimal cantidad) {
        return cantidad.divide(BigDecimal.valueOf(1.15), 2, RoundingMode.HALF_DOWN);
    }
    
}
