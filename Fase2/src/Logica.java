import java.util.ArrayList;

import javax.xml.namespace.QName;

/**
 * Proyecto 1 -- Fase2
 *Erick Barrera 22974
 *Pablo Noack 17596
 *Michelle Mejía 22596
 **/


public class Logica {
    
    public boolean calculadoraLogica(ArrayList<String> lista) {
        boolean resultado = false;
        
        String operando = lista.get(1);

        switch (operando){

            case "1":
                double nextNumber;
                for (int i = 2; i < lista.size() - 1; i++) {
                    double number = Double.parseDouble(lista.get(i));
                     nextNumber = (i < lista.size() - 2) ? Double.parseDouble(lista .get(i + 1)) : number - 10;
                
                    if (number > nextNumber) {
                        continue;
                    } else {
                        return false;
                    }
                }
                return true;

                case "2":

                for (int i = 2; i < lista.size() - 1; i++) {
                    double number = Double.parseDouble(lista.get(i));
                     nextNumber = (i < lista.size() - 2) ? Double.parseDouble(lista.get(i + 1)) : number + 10;
                
                    if (number < nextNumber) {
                        continue;
                    } else {
                        return false;
                    }
                }
                
                return true;

                case "3":

                if(Funciones.variablesDelPrograma.containsKey(lista.get(2)) &&
                        Funciones.variablesDelPrograma.containsKey(lista.get(3))) {
                    if(Funciones.variablesDelPrograma.get(lista.get(2)).equals(Funciones.funcionesLisp.get(lista.get(3)))) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (Funciones.variablesDelPrograma.containsKey((lista.get(2)))) {
                    String comparison = "\"" + Funciones.funcionesLisp.get(lista.get(2)).get(1) +"\"";
                    if(Funciones.variablesDelPrograma.get(lista.get(2)).get(1).equals(lista.get(3)) || comparison.equals(lista.get(3))) {
                        return true;
                    } else {
                        return false;
                    }
                } else if  (Funciones.variablesDelPrograma.containsKey((lista.get(3)))) {
                    if(Funciones.variablesDelPrograma.get(lista.get(3)).equals(lista.get(2))) {
                        return true;
                    } else {
                        return false;
                    }
                }
                if(lista.get(2).equals(lista.get(3))) {
                    return true;
                } else {
                    return false;
                }
        }
        return true;
            
        }
       
        

    }

