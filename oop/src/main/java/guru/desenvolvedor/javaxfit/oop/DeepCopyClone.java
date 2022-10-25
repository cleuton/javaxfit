package guru.desenvolvedor.javaxfit.oop;

import java.util.concurrent.atomic.AtomicBoolean;

public class DeepCopyClone {

    class Ponto implements Cloneable {
        double x;
        double y;
        AtomicBoolean ocupado;

        Ponto (double x, double y, AtomicBoolean ocupado) {
            this.x = x;
            this.y = y;
            this.ocupado = ocupado;
        }

        @Override
        public Ponto clone() {
            try {
                Ponto clone = (Ponto) super.clone();
                // Aqui clonamos ou recriamos as propriedades referências
                // AtomicBoolean não suporta clone...
                clone.ocupado = new AtomicBoolean(this.ocupado.get());
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    private void copiar() {
        Ponto p = new Ponto(10.0, 20.0, new AtomicBoolean(false));
        Ponto p2 = p.clone();
        p.x = 300.0;
        p.ocupado.set(true);
        System.out.println(5);
        System.out.println(String.format("p: %s, p2: %s", p, p2));
        System.out.println(String.format("p.x: %f, p2.x: %f", p.x, p2.x));
        System.out.println(String.format("p.ocupado: %b, p2.ocupado: %b", p.ocupado.get(), p2.ocupado.get()));
        System.out.println(p.ocupado == p2.ocupado);
    }

    public static void main(String [] args) {
        DeepCopyClone sc = new DeepCopyClone();
        sc.copiar();
    }
}

