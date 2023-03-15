import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Lector implements  IStack{
// Para hacer la lectura del txt nos guíamos de la siguiente fuente: https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
    public ArrayList<ArrayList<String>> getStack(String document) {
        try {
        BufferedReader reader = new BufferedReader(new FileReader(document));
        String linea = "";
        int inicio = 0;
        int fin = 0;
        String substring = "";
        ArrayList<String> lineToCalculate = new ArrayList<>();
        

            while(reader.readLine() != null){

                linea = reader.readLine(); 
                System.out.println(linea);

            }

        }

        catch (Exception e){
            int j = 0;
        }
       
        return null;
    }








}