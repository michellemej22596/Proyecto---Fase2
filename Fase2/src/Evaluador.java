
import java.util.Stack;
public class Evaluador {

    public Double operador(String[] valores){
        int cuenta = 0;
        for (int i=0; i<3; i++) {
            switch (valores[i]) {
                case "(": 
                cuenta = cuenta +1;
                
                case ")":
                cuenta = cuenta -1;

                default:
                System.out.println(valores[i]);

                
            }
            

    }

    return null;

       //Double a = mystack.pop();
       //Double b = mystack.pop();

    }

}
