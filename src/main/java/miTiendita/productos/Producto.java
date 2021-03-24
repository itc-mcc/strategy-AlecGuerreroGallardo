package miTiendita.productos;

public class Producto {
    int clave; //id
    String descripcion;
    double punit; //precio
    int ctd; //contenido

    Producto(int clave, String descripcion, double punit)
    {
        this.clave = clave;
        this.descripcion = descripcion;
        this.punit = punit;
    }

    public double getPunit()
    {
        return punit;
    }

    public int getCtd()
    {
        return ctd;
    }

    public String toString()
    {
        return descripcion;
    }
}
