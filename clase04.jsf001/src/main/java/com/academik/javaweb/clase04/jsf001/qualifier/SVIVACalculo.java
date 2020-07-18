package com.academik.javaweb.clase04.jsf001.qualifier;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Mario Batres
 */
@IVA(pais = IVA.Pais.SV)
public class SVIVACalculo  implements IVACalculo {

    @Override
    public BigDecimal desglozarIVA(BigDecimal cantidad) {
        return cantidad.divide(BigDecimal.valueOf(1.13), 2, RoundingMode.HALF_DOWN);
    }
    
}
