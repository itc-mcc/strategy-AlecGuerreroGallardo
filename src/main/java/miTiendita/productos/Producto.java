package miTiendita.productos;

public class Producto {
    private int clave; //id
    String descripcion;
    private double punit; //precio
    private int ctd; //contenido

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
    public int getClave(){
        return this.clave;
    }
}
