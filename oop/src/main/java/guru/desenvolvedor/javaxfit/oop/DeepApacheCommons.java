package guru.desenvolvedor.javaxfit.oop;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.lang3.SerializationUtils;

public class DeepApacheCommons implements Serializable {

    class Ponto implements Serializable {
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
        Ponto p2 = SerializationUtils.clone(p);
        p.x = 100.0;
        p.ocupado.set(true);
        System.out.println(String.format("p: %s, p2: %s", p, p2));
        System.out.println(String.format("p.x: %f, p2.x: %f", p.x, p2.x));
        System.out.println(String.format("p.ocupado: %b, p2.ocupado: %b", p.ocupado.get(), p2.ocupado.get()));
        System.out.println(p.ocupado == p2.ocupado);
        System.out.println(String.format(
          "p: %s, p2: %s",
          System.identityHashCode(p.ocupado),
          System.identityHashCode(p2.ocupado)
        ));
    }

    public static void main(String [] args) {
        DeepApacheCommons sc = new DeepApacheCommons();
        sc.copiar();
    }
}

