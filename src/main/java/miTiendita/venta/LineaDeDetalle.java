package miTiendita.venta;

import miTiendita.productos.Producto;

public class LineaDeDetalle {
    Producto p;
    double ctd; //contenido
    public  LineaDeDetalle(Producto p, double ctd)
    {
        this.p = p;
        this.ctd = ctd;
    }
}
