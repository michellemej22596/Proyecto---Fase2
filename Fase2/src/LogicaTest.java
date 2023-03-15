import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;;
public class LogicaTest {
    Logica logica = new Logica(); 

    @Test
    public void igualdad(){
        ArrayList<String> lisp = new ArrayList<String>();
        lisp.add("(");
        lisp.add("COND");
        lisp.add("(");
        lisp.add("(");
        lisp.add("EQUAL");
        lisp.add("1");
        lisp.add("1");
        lisp.add(")");
        lisp.add("666");
        lisp.add(")");
        lisp.add("(");
        lisp.add("2");
        lisp.add(")");
        lisp.add(")");
        boolean a=logica.calculadoraLogica(lisp);
        assertEquals(true, a);


    }
    @Test
    public void mayor(){
        ArrayList<String> lisp = new ArrayList<String>();
        lisp.add("(");
        lisp.add("COND");
        lisp.add("(");
        lisp.add("(");
        lisp.add(">");
        lisp.add("2");
        lisp.add("1");
        lisp.add(")");
        lisp.add("666");
        lisp.add(")");
        lisp.add("(");
        lisp.add("2");
        lisp.add(")");
        lisp.add(")");
        boolean a=logica.calculadoraLogica(lisp);
        assertEquals(true, a);


    }

    @Test
    public void menor(){
        ArrayList<String> lisp = new ArrayList<String>();
        lisp.add("(");
        lisp.add("COND");
        lisp.add("(");
        lisp.add("(");
        lisp.add("<");
        lisp.add("1");
        lisp.add("2");
        lisp.add(")");
        lisp.add("666");
        lisp.add(")");
        lisp.add("(");
        lisp.add("2");
        lisp.add(")");
        lisp.add(")");
        boolean a=logica.calculadoraLogica(lisp);
        assertEquals(true, a);


    }
    
}
