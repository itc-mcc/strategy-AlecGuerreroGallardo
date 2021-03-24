package miTiendita.descuento;

import miTiendita.productos.Producto;
import miTiendita.venta.LineaDeDetalle;
import miTiendita.venta.Venta;

public class EmbutidosLacteos implements IDesctoStrategy {

    @Override
    public float getDescto(Venta v) {
        System.out.println("Descuento embutidos y lacteos");
        double desc=0;
        for (LineaDeDetalle ld: v.getLineaDeDetalle()) {
            Producto p = ld.getProducto();
            double ctd = ld.getCtd();
            //Lacteos
            if (p.getClave() == 1 || p.getClave() == 2 || 
                p.getClave() == 3 || p.getClave() == 5){
                desc = desc + (p.getPunit()*ctd)*0.15;
            }
            //Embutido
            if (p.getClave() == 4){
                desc = desc + (p.getPunit()*ctd)*0.05;
            }
        }
        return (float)desc;
    }
}
