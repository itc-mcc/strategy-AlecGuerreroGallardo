package miTiendita.descuento;

import miTiendita.productos.Producto;
import miTiendita.venta.LineaDeDetalle;
import miTiendita.venta.Venta;

public class FrutaDescuento implements IDesctoStrategy {

    @Override
    public float getDescto(Venta v) {
        System.out.println("Descuento embutidos y lacteos");
        double desc=0;
        for (LineaDeDetalle ld: v.getLineaDeDetalle()) {
            Producto p = ld.getProducto();
            double ctd = ld.getCtd();
            //Frutas
            if (p.getClave() == 6 || p.getClave() == 7){
                desc = desc + (p.getPunit()*ctd)*0.15;
            }
        }
        return (float)desc;
    }
}
