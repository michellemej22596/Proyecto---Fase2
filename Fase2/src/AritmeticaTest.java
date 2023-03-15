import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;;
public class AritmeticaTest {

    Aritmetica calculadora = new Aritmetica();

    @Test
    public void suma(){
        ArrayList<String> lisp = new ArrayList<String>();
        lisp.add("(");
        lisp.add("+");
        lisp.add("5");
        lisp.add("6");
        lisp.add(")");
        double a=calculadora.calculadoraAritmetica(lisp);
        assertEquals(11, a, 0.0001);

    }
    @Test
    public void resta(){
        ArrayList<String> lisp = new ArrayList<String>();
        lisp.add("(");
        lisp.add("-");
        lisp.add("5");
        lisp.add("6");
        lisp.add(")");
        double a=calculadora.calculadoraAritmetica(lisp);
        assertEquals(-1, a, 0.0001);


    }

    @Test
    public void producto(){
        ArrayList<String> lisp = new ArrayList<String>();
        lisp.add("(");
        lisp.add("*");
        lisp.add("5");
        lisp.add("6");
        lisp.add(")");
        double a=calculadora.calculadoraAritmetica(lisp);
        assertEquals(30, a, 0.0001);


    }

   @Test
    public void division(){
        ArrayList<String> lisp = new ArrayList<String>();
        lisp.add("(");
        lisp.add("/");
        lisp.add("5");
        lisp.add("6");
        lisp.add(")");
        double a=calculadora.calculadoraAritmetica(lisp);
        assertEquals(5.0/6.0, a, 0.000001);


    }



    
}
