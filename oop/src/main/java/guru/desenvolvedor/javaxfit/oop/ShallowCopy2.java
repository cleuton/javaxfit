package guru.desenvolvedor.javaxfit.oop;

import java.util.concurrent.atomic.AtomicBoolean;

public class ShallowCopy2 {

    class Ponto {
        double x;
        double y;
        AtomicBoolean ocupado;

        Ponto (double x, double y, AtomicBoolean ocupado) {
            this.x = x;
            this.y = y;
            this.ocupado = ocupado;
        }
    }

    private void copiar() {
        Ponto p = new Ponto(10.0, 20.0, new AtomicBoolean(false));
        Ponto p2 = new Ponto(p.x, p.y, p.ocupado);
        p.x = 100.0;
        p.ocupado.set(true);
        System.out.println(String.format("p: %s, p2: %s", p, p2));
        System.out.println(String.format("p.x: %f, p2.x: %f", p.x, p2.x));
        System.out.println(String.format("p.ocupado: %b, p2.ocupado: %b", p.ocupado.get(), p2.ocupado.get()));
        System.out.println(p.ocupado == p2.ocupado);
    }

    public static void main(String [] args) {
        ShallowCopy2 sc = new ShallowCopy2();
        sc.copiar();
    }
}

