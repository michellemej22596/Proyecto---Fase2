import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Collections;

/**
 *Proyecto 1 -- Fase2
 *Erick Barrera 22974
 *Pablo Noack 17596
 *Michelle Mejía 22596
 **/
public class Funciones {
	
    public static LinkedHashMap<String, ArrayList<String>> funcionesLisp = new LinkedHashMap<>();

    public static LinkedHashMap<String, ArrayList<String>> variablesDelPrograma = new LinkedHashMap<>();
   
    public Funciones() {
        ArrayList<String> funcionesAritmeticas = new ArrayList<>();
        funcionesAritmeticas.add("aritmetica");
        funcionesLisp.put("+" , funcionesAritmeticas);
        funcionesLisp.put("-", funcionesAritmeticas);
        funcionesLisp.put("*", funcionesAritmeticas);
        funcionesLisp.put("/", funcionesAritmeticas);
        funcionesLisp.put("SETQ", null);
        funcionesLisp.put("EQUALS", null);
        funcionesLisp.put("DEFUN", null);
        funcionesLisp.put("COND", null);
        funcionesLisp.put("PRINT", null);
        
    }
    
    public String defun(ArrayList<String> lineaEscaneada) {
        ArrayList<String> SETQ = new ArrayList<>();
        
        SETQ.add("SETQ");
        SETQ.add("variable");
        SETQ.add("(");
        SETQ.add("null");
        SETQ.add(")");
        
        String tipoDeFuncion = lineaEscaneada.get(2);
        ArrayList<String> cuerpoFuncion = new ArrayList<>();
        
        
        int j = 0;
        for(int i = 4; i < lineaEscaneada.size(); i ++) {
            String simbolo = lineaEscaneada.get(i);
            if(simbolo.equals(")")) {
                j = i;
                break;
            } else {
                SETQ.set(2,simbolo);
                cuerpoFuncion.add(simbolo);
                System.out.println("Se ha encontrado la palabra reservada SETQ");
                setq(SETQ);
            }
        }
        
        lineaEscaneada.remove(lineaEscaneada.size() - 1);
        for(int i = j + 1; i < lineaEscaneada.size(); i++) {
        	cuerpoFuncion.add(lineaEscaneada.get(i));
        }
        
        funcionesLisp.put(tipoDeFuncion,cuerpoFuncion);
        System.out.println(funcionesLisp);
        System.out.println(funcionesLisp.get(""));
        System.out.println(cuerpoFuncion);
        return "Función: " + tipoDeFuncion;
    }
}
