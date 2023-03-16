import java.util.ArrayList;

public class Estructura {
	//Opera funciones propias de lisp
	
    public String operar(ArrayList<String> linea) {
    	
    	
        String resultado = "";
        String operador = linea.get(1);
        //Switch segun el operador que se encuentre en la segunda posición de la linea
        switch (operador) {
        
            case "LIST":
                resultado = list(linea) + "";
                break;
                
            case "QUOTE":
                resultado = quote(linea);
                break;
                
            case "COND":
                resultado = cond(linea) + "";
                break;
                
            case "first": case "second": case "third": case "fourth": case "fifth": case "sixth": case "seventh":
            case "eighth": case "ninth": case "tenth":
                resultado = acceder(linea);
                break;
        }
        return resultado;
    }
    
    //Condicional
    private ArrayList<String> cond(ArrayList<String> linea) {
        ArrayList<String> resultado = new ArrayList<>();

        int z = 0;
        ArrayList<String> linea2 = new ArrayList<>(linea);  
        ArrayList<String>  fCond = new ArrayList<>();
        for(int i = 3; i < linea.size(); i++) {
            if(linea2.get(i).equals(")")) {
                z = i;
                fCond.add(linea2.get(i));
                break;
            } else {
                fCond.add(linea2.get(i));
            }
        }
        System.out.println(fCond);
        boolean resultadoBinario = resultadoCond(fCond);
        System.out.println(linea2);

        if(resultadoBinario) {
            for(int i = z; i < linea2.size(); i++) {
                int contadorPa = 0;
                int contadorPc = 0;
                System.out.println(linea2.get(i));
                if (linea2.get(i).equals("(")) {
                    contadorPa ++;
                    resultado.add(linea2.get(i));
                } else if(linea2.get(i).equals(")")) {
                    if(contadorPa == contadorPc) {
                        if (contadorPa == 0) {
                            break;
                        }
                        resultado.add(linea2.get(i));
                        break;
                    }
                    resultado.add(linea2.get(i));
                } else {
                    resultado.add(linea2.get(i));
                }
            }
        } else {
            int Pa = 0;
            int Pc = 0;
            int indice = 0;
            linea2.remove(linea2.size() - 1);
            for(int i = linea2.size() - 1; i > 0; i--) {

                if(linea2.get(i).equals(")")) {
                    Pc ++;
                }
                if(linea2.get(i).equals("(")) {
                    Pa++;
                    if(Pa == Pc) {
                        indice = i;
                        break;
                    }

                }
            }
            for(int i = indice + 1; i < linea2.size() - 1; i++) {
                resultado.add(linea2.get(i));
            }

        }
        return resultado;
    }
    
    //Llamamos a la clase logica para resolver y devolver tipo booleanos
    private boolean resultadoCond(ArrayList<String> fCond) {
        Logica logica = new Logica();
        boolean respuesta = logica.calculadoraLogica(fCond);
        return respuesta;
    }

//Permite que no se operen los caracteres
    private String quote(ArrayList<String> linea) {
        String resultado = "";
        linea.remove(0); 
        linea.remove(0); 
        linea.remove(linea.size() - 1);
        for(int i = 0; i < linea.size(); i ++) {

            resultado += linea.get(i) + " ";
        }
        return resultado;
    }

    //Acceso a los distintos indices de la lista
    private String acceder(ArrayList<String> linea) {
        String elemento = "";
        String nombreVariable = linea.get(2);
        String indiceDeAcceso = linea.get(1);
        int i_indice = 0;
        switch (indiceDeAcceso) {
            case "first":
                break;
            case "second":
                i_indice = 1;
                break;
            case "third":
                i_indice = 2;
                break;
            case "fourth":
                i_indice = 3;
                break;
            case "fifth":
                i_indice = 4;
                break;
            case "sixth":
                i_indice = 5;
                break;
            case "seventh":
                i_indice = 6;
                break;
            case "eighth":
                i_indice = 7;
                break;
            case "ninth":
                i_indice = 8;
                break;
            case "tenth":
                i_indice = 9;
                break;

        }
        try {
            elemento = Funciones.funcionesLisp.get(nombreVariable).get(i_indice);
        } catch (Exception E) {
            System.err.println("El índice no existe en la lista");
        }
        return elemento;
    }

    //Opera una lista de lisp
    public ArrayList<String> list(ArrayList<String> linea) {
        ArrayList<String> resultadoList = new ArrayList<>();
        linea.remove(0); 
        linea.remove(0); 

        for(int i = 0; i < linea.size(); i++) {
            char simbolo = linea.get(i).charAt(0);
            if(simbolo == '\'') {
                linea.set(i, linea.get(i).replace("'",""));

                resultadoList.add(linea.get(i));
            } else if (linea.get(i).equals(")")) {
                break;
            } else {
                resultadoList.add(linea.get(i));
            }
        }
        return resultadoList;
    }
}
