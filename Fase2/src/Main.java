import java.io.File;
import java.io.FileReader;
public class Main {
    public static void main(String[] args) {
        Interpretador inter = new Interpretador();
        String str = "( + 5 ( - 7 ( - 5 6 ) ) ) \n( - 9 7 )"; 
        String[] value = str.split("\\r?\\n");

        inter.interpretador_lineas(value);
        

        
    }
}