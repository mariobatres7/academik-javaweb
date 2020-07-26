package edu.academik.banguat.client;

/**
 *
 * @author Mario Batres
 */
public class Main {

    public static void main(String[] args) {
        
        
        TipoCambio tipoCambio = new TipoCambio();

        var tipoCambioDia = tipoCambio.getTipoCambioSoap().tipoCambioDia();

        System.out.println(tipoCambioDia.cambioDia);
        
        tipoCambioDia.cambioDolar.varDolar.stream().findFirst().ifPresent(v -> {
            System.out.println(v.fecha);
            System.out.println(v.referencia);
        });
        
        System.out.println(tipoCambioDia.totalItems);
        System.out.println(tipoCambioDia.variables);
    }

}
