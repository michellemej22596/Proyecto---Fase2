import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;;
public class FuncionesTest {

    @Test

    public void definir_funciones(){
        Funciones funcion = new Funciones(); 
        ArrayList<String> lisp = new ArrayList<String>();
        ArrayList<String> lisp2 = new ArrayList<String>();
        Aritmetica calculadora = new Aritmetica();
        lisp.add("(");
        lisp.add("setq");
        lisp.add("n");
        lisp.add("5");
        lisp.add(")");
        funcion.setq(lisp);

        lisp2.add("(");
        lisp2.add("+");
        lisp2.add("n");
        lisp2.add("5");
        lisp2.add(")");
        double a=calculadora.calculadoraAritmetica(lisp2);
        assertEquals(10, a, 0.0001);

    }
    
}
