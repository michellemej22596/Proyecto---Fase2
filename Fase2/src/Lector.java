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

                //linea = reader.readLine(); 
                System.out.println("a");
                System.out.println(linea);

            }

        }

        catch (Exception e){
            System.err.println("No se pudo cargar el Stack");
        }
       
        return null;
    }








}