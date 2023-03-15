import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("HOLA ESTE ES UN INTERPRETE DE LISP!");
        
        Scanner sc = new Scanner(System.in);

        Lector lector = new Lector();
        lector.getStack("lisp.txt");
        
        
    }
}