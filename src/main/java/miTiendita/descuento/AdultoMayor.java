package miTiendita.descuento;

import miTiendita.venta.Venta;

public class AdultoMayor implements IDesctoStrategy {
    @Override
    public float getDescto(Venta v) {
        System.out.println("Descuento Adulto mayor");
        double st = v.getSubTotal();
        return (float)(st*0.05);
    }    
}