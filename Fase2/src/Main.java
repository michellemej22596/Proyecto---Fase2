import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

// clase main que se encarga de leer el archivo y ejecutar el interprete
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("HOLA ESTE ES UN INTERPRETE DE LISP!");
        
        Scanner sc = new Scanner(System.in);
        Lector lector = new Lector();
        ArrayList<ArrayList<String>> stack =  lector.getStack("D:\\Escritorio\\Proyecto---Fase2\\Fase2\\src\\lisp.txt");
        
        Interpretador interprete = new Interpretador();

        ArrayList<String> results = interprete.calcular(stack);

        System.out.println("Presione enter");
        sc.nextLine();
        for(int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }

        System.out.println("Presione enter para salir");
        sc.nextLine();
    }
        

    }
