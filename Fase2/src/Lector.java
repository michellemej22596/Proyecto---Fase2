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
        

            while((linea=reader.readLine()) != null){
                int comentario = 0 ;
                for(int i = 0; i < linea.length(); i ++) {
                    char actual = linea.charAt(i);
                    char siguiente = ' ';
                    if(i < linea.length() - 1){
                        siguiente = linea.charAt(i+1);
                    }

                    else if (i == linea.length() - 1){
                        siguiente = ' ';

                    }

                    if(actual == ';') {
                        comentario = 1;
                    }

                    if (comentario ==0){
                        switch (actual){

                            case '(': case '<': case ' ': case '>': case '+': case '-': case '*': case ')': case '"':
                            case '/':
                            if(actual == '(') {
                                inicio ++;
                            } 
                            else if(actual == ')') {
                                fin ++;
                            }
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

                            default:    // Gets any character that doesn't define an operation
                            substring += actual;
                            if(i == linea.length() - 1) {
                                arr.add(substring);
                            }
                            break;
                    }

                    if(inicio == fin && arr.size() > 0) {
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