import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Lector implements  IStack{
// Para hacer la lectura del txt nos guíamos de la siguiente fuente: https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
    public ArrayList<ArrayList<String>> getStack(String document) {
        System.out.println("a");
        try {
        BufferedReader reader = new BufferedReader(new FileReader(document));
        String linea ="";
        int inicio = 0;
        int fin = 0;
        String substring = "";
        ArrayList<String> lineToCalculate = new ArrayList<>();
        

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
                            } else if(actual == ')') {
                                fin ++;
                           


                        }

                    }

                }

            }

        }

        catch (Exception e){
            System.err.println("No se pudo cargar el Stack");
        }
       
        return null;
    }








}