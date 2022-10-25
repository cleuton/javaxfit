package guru.desenvolvedor.javaxfit.oop;

public class ReferenceCopy {

    class Ponto {
        double x;
        double y;
        Ponto (double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private void copiar() {
        Ponto p = new Ponto(10.0, 20.0);
        Ponto p2 = p;
        p.x = 100.0;
        System.out.println(String.format("p.x: %f, p2.x: %f", p.x, p2.x));
        System.out.println(String.format("p: %s, p2: %s", p, p2));
    }

    public static void main(String [] args) {
        ReferenceCopy rc = new ReferenceCopy();
        rc.copiar();
    }
}
