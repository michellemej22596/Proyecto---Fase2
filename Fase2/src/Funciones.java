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
                setq(SETQ);
            }
        }
        
        lineaEscaneada.remove(lineaEscaneada.size() - 1);
        for(int i = j + 1; i < lineaEscaneada.size(); i++) {
        	cuerpoFuncion.add(lineaEscaneada.get(i));
        }
        
        funcionesLisp.put(tipoDeFuncion,cuerpoFuncion);
        return "Función: " + tipoDeFuncion;
    }

    public static String ejecutarFunciones(ArrayList<String> lineaEscaneada) {
        System.out.println(lineaEscaneada);
        ArrayList<String> FuncionSETQ = new ArrayList<>();
        FuncionSETQ.add("(");
        FuncionSETQ.add("setq");
        FuncionSETQ.add("nombreVariable");
        FuncionSETQ.add("0");
        FuncionSETQ.add(")");
        String nombreFuncion = lineaEscaneada.get(0);
        Interpretador interpretador = new Interpretador();
        ArrayList<ArrayList<String>> codigoAInterpretar = new ArrayList<>();
        ArrayList<String> linea = funcionesLisp.get(lineaEscaneada.get(0));
        String k = "3";
        try {
            k = lineaEscaneada.get(1);
        } catch (Exception E) {

        }
        
        lineaEscaneada.remove(0);
        int l = 0; //l contador cuantas lineas debe remover
        for(int i = 0; i < linea.size(); i++) {
            System.out.println("Contenido encontrado: " + linea);
            if(linea.get(i).equals("(")) {
                break;
            } else {
                l ++;
                String nombreVariable = linea.get(i);
                String valor = lineaEscaneada.remove(0);
                Collections.replaceAll(linea,nombreVariable,valor);
            }
        }
        for(int i = 0; i <l; i++) {
            linea.remove(0);
        }

        for(int i = 0; i < linea.size(); i ++ ) {
            try {
                String valorActual= linea.get(i);
                double valor = Double.parseDouble(variablesDelPrograma.get(valorActual).get(1));
                Collections.replaceAll(linea,valorActual,valor + "");

            } catch (Exception E) {
                continue;
            }
        }
        System.out.println("Contenido encontrado: " + linea);
        codigoAInterpretar.add(linea);
        ArrayList<String> resultadoadoF = interpretador.calcular(codigoAInterpretar);

        System.out.println(nombreFuncion + resultadoadoF.size());
        if(Recursividad(resultadoadoF,nombreFuncion)) {
            long resultado = 1;
            for(int i = Integer.parseInt(k); i > 0; i --) {
                resultado *= i;

            }
            return resultado +"";
        }

        return  resultadoadoF + "";
    }

    private static boolean Recursividad(ArrayList<String> linea, String nombre) {
        String[] partes = linea.get(0).split(",");
        for(int i = 0; i<partes.length; i++) {
        	partes[i] = partes[i].replace(" ","");
            if(partes[i].equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public String setq(ArrayList<String> linea) {
        String valorVariable = "";
        String nombreVariable = linea.get(2);
        String tipoVariable = "";
        ArrayList<String> contenidoVariable = new ArrayList<>();
        double resultado = 1.0d;
        if (linea.get(3).equals("(")) {
            if(linea.get(4).equals("LIST")) {
                Estructura estructura = new Estructura();
                for(int i = 0; i < 3; i++) {
                	linea.remove(i);
                }
                ArrayList<String> listValues = estructura.list(linea);
                variablesDelPrograma.put(nombreVariable,listValues);
                return " " + nombreVariable + " == " + listValues;
            } else if (linea.get(4).equals("+") || linea.get(4).equals("-") || linea.get(4).equals("*")
                    || linea.get(4).equals("/")) {
                tipoVariable = "aritmetica";

                linea.remove(linea.size() - 1);
                for(int i = 0; i < 3; i++) {
                    linea.remove(0);
                }
                Aritmetica aritmetica = new Aritmetica();
                resultado = aritmetica.calculadoraAritmetica(linea);
                valorVariable = String.valueOf(resultado);
            } else {
                ArrayList<String> funcionEjecutar = new ArrayList<>();
                for(int i = 4; i < linea.size(); i++) {
                    if(linea.get(i).equals(")")) {
                        break;
                    } else {
                        funcionEjecutar.add(linea.get(i));
                    }
                }
                valorVariable = ejecutarFunciones(funcionEjecutar);
            }
        } else if (linea.get(3).charAt(0) == '"') {
            tipoVariable = "string";
            valorVariable = linea.get(3);
        } else {
            tipoVariable = "aritmetica";
            valorVariable = linea.get(3);
        }


        contenidoVariable.add(tipoVariable);
        contenidoVariable.add(valorVariable);
        variablesDelPrograma.put(nombreVariable,contenidoVariable);

        return " " + nombreVariable + " == " + valorVariable;
    }
 
    public double getVariable(String variable) {
        try {
            return Double.parseDouble(variablesDelPrograma.get(variable).get(1));
        } catch (Exception E) {
            System.err.println("No se ha encontrado contenido numérico en su variable");
            return -1;
        }
    }
    
    public boolean operar(String key) {
        if(funcionesLisp.containsKey(key) && funcionesLisp.get(key) != null && funcionesLisp.get(key).get(0).equals("aritmetica")) {
            return true;
        }
        return false;
    }
    
}
