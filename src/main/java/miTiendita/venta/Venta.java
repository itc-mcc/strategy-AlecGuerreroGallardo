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
            case 2:
                IDescto = new SinDescuento();
            case 3:
                IDescto = new MenonitaDescuento();
            case 4:
                IDescto = new FrutaDescuento();
            case 5:
                IDescto = new EmbutidosLacteos();
            case 6:
                IDescto = new SinDescuento();
            case 7:
                IDescto = new AdultoMayor();
        }
    }

    public double getTotal()
    {
        double subTotal=0;
        for (LineaDeDetalle lineaD : ld) {
            subTotal = subTotal + (lineaD.ctd * lineaD.p.getPunit());
        }
        double desc = IDescto.getDescto(this);
        subTotal = subTotal - desc;
        System.out.println(desc);
        System.out.println(subTotal);
        System.out.println(subTotal*1.16);
        return subTotal*(1.16);
    }
}