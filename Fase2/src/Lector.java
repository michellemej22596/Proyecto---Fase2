import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Lector implements  IStack{
// Para hacer la lectura del txt nos guíamos de la siguiente fuente: https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
    public ArrayList<ArrayList<String>> getStack(String document) {
        System.out.println("a");
        ArrayList<ArrayList<String>> stack = new ArrayList<>();
        try {
        BufferedReader reader = new BufferedReader(new FileReader(document));
        String linea ="";
        int inicio = 0;
        int fin = 0;
        String substring = "";
        ArrayList<String> arr = new ArrayList<>();
        //Vamos a tomar cada linea y una por una vamos a pre-procesarlas para insertarlas en un arraylist.
            while((linea=reader.readLine()) != null){//Vamos a detenernos cuando se acaben las lineas
                int comentario = 0 ;//Nos dice si la linea es codigo o comentario
                for(int i = 0; i < linea.length(); i ++) {//Teniendo la linea vamos a recorrerla.
                    char actual = linea.charAt(i);//Espacio por el que estamos
                    char siguiente = ' ';//Siguiente espacio
                    if(i < linea.length() - 1){//Significa que se va  a cumplir si no estamos en el final
                        siguiente = linea.charAt(i+1);//Si sucede entonces vamos a almacenar el siguiente caracter
                    }

                    else if (i == linea.length() - 1){//Si estamos en el final
                        siguiente = ' ';//llenamos con un espacio en blanco

                    }

                    if(actual == ';') {//Nos dice si la linea es comentario
                        comentario = 1;
                    }

                    if (comentario ==0){// Si no es comentario entonces procedemos a pre-procesar.
                        switch (actual){

                            case '(': case '<': case ' ': case '>': case '+': case '-': case '*': case ')': case '"':
                            case '/'://Validamos si los caracteres son de tipo aritmetico o de agrupación
                            if(actual == '(') {//si encontramos un parentesis sabemos que sige una instrucción
                                inicio ++;//Contamos el parentesis
                            } 
                            else if(actual == ')') {
                                fin ++;//Hacemos lo mismo que la instrucción anterior pero ahora contamos la cerradura de parentesis
                            }
                            //Separamos por el tipo de caracteries
                            if(actual == '<' || actual == '>' || actual == '=') {
                                if(siguiente == '=') {
                                    substring += actual;
                                    break;
                                }
                            } 
                            else if(actual == '-') {
                                if(siguiente != ' ') {
                                    substring += actual;
                                    break;
                                }
                            }
                            if(actual == '=') {
                                if(siguiente =='=') {
                                    substring += actual;
                                }
                            }  
                            
                            if(substring.length() > 0 && substring.charAt(0) != '"' && actual != '"') {
                                arr.add(substring);
                                substring = "";
                            }

                            if(actual != ' ' && actual != '"' && substring.length() == 0){
                                substring += actual;
                                arr.add(substring);
                                substring = "";
                            }

                            if(actual == '"'){
                                if(substring.length() > 0) {
                                    substring += actual;
                                    arr.add(substring);
                                    substring = "";
                                } else {
                                    substring += actual;
                                }
                            }

                            if(substring.length() > 0 && substring.charAt(0) == '"') {
                                if(substring.length() > 1) {
                                    substring+= actual;
                                }
                            }
                            break;

                            default:    // devuelve cualquier cosa que no sea una palabra reservada o un simbolo especial
                            substring += actual;
                            if(i == linea.length() - 1) {
                                arr.add(substring);
                            }
                            break;
                    }

                    if(inicio == fin && arr.size() > 0) {// Cuando llegamos al final devolvemos la linea pre-procesada, esto sucede cuando tengamos la misma cantidad de parentesis abiertos y cerrados
                        ArrayList<String> arr2 = new ArrayList<>(arr);
                        stack.add(arr2);
                        arr.clear();
                        inicio = 0;
                        fin = 0;
                    }

                }

            }

        }
    }

        catch (Exception e){
            System.err.println("No se pudo cargar el Stack");
        }
       
        return stack;
    








}
}