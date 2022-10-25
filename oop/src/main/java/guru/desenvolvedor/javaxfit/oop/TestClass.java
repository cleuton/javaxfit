package guru.desenvolvedor.javaxfit.oop;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public List<Integer> gerar () {
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(1);
        lista.add(2);
        return lista;
    }


    public static void main (String [] args) {
        TestClass tc = new TestClass();
        List<Integer> lista2 = tc.gerar();
        List<Integer> lista3 = lista2;
        List<Integer> lista4 = new ArrayList<>(lista3);
        System.out.println(
          String.format(
            "Lista2: %s, lista3: %s, lista4: %s",
            System.identityHashCode(lista2),
            System.identityHashCode(lista3),
            System.identityHashCode(lista4)
          )
        );
        System.out.println(lista2 == lista3);
        System.out.println(lista3 == lista4);
    }
}
