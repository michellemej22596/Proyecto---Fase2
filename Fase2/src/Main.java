import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("HOLA ESTE ES UN INTERPRETE DE LISP!");
        
        Scanner sc = new Scanner(System.in);
        Lector lector = new Lector();
        lector.getStack("C:\\Users\\pablo\\Desktop\\Estructura de datos\\Git\\mi proyecto2\\main\\Fase2\\src\\lisp.txt");
        
        
    }
}