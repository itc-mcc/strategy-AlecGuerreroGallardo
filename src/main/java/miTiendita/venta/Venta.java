package miTiendita.venta;

import miTiendita.descuento.*;
import miTiendita.productos.Producto;
import java.util.*;

public class Venta {
    int diaSemana;
    boolean terceraEdad;
    List<LineaDeDetalle> ld = new ArrayList<LineaDeDetalle>();
    IDesctoStrategy IDescto;

    public Venta(int diaSemana, boolean terceraEdad)
    {
        this.diaSemana = diaSemana;
        this.terceraEdad = terceraEdad;

        addDescto();
    }

    public void addProducto(Producto p, double ctd)
    {
        ld.add(new LineaDeDetalle(p,ctd));
    }

    public void addDescto()
    {
        switch (this.diaSemana){
            case 1:
                IDescto = new AdultoMayor();
                break;
            case 2:
                IDescto = new SinDescuento();
                break;
            case 3:
                IDescto = new MenonitaDescuento();
                break;
            case 4:
                IDescto = new FrutaDescuento();
                break;
            case 5:
                IDescto = new EmbutidosLacteos();
                break;
            case 6:
                IDescto = new SinDescuento();
                break;
            case 7:
                IDescto = new AdultoMayor();
                break;
        }
    }

    public List<LineaDeDetalle> getLineaDeDetalle(){
        return this.ld;
    }

    public double getSubTotal(){
        double subTotal=0;
        for (LineaDeDetalle lineaD : ld) {
            subTotal = subTotal + (lineaD.ctd * lineaD.p.getPunit());
        }
        return subTotal;
    }
    double calculateDesc(){
        return IDescto.getDescto(this);
    }

    public double getTotal()
    {
        return (getSubTotal()-calculateDesc())*1.16;
    }
    
}