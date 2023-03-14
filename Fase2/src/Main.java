import java.io.File;
import java.io.FileReader;
public class Main {
    public static void main(String[] args) {
        Interpretador inter = new Interpretador();
        System.out.println("Hello world!");
        String str = "(a (b (d j k))) \n (a b c d)"; 
        System.out.println(str);
        String[] value = str.split("\\r?\\n");
        inter.interpretador_lineas(value);
        

        
    }
}