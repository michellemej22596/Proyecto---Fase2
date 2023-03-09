import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

public class Interpretador {
	
	public void evaluator() {
		
	}

	public void nextToken() {
		
	}
	
	public void tokenator() {
		
	}
	
	public void reader() {
		//The following code to read a text file was found at https://chuwiki.chuidiang.org/index.php?title=Lectura_y_Escritura_de_Ficheros_en_Java#:~:text=Podemos%20abrir%20un%20fichero%20de,y%20extraer%20campos%20de%20ella.
		//Some lines have been edited in order to read properly the text file requested and split the characters.
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String msg="";
		
		try {
			
		    archivo = new File ("C:\\lisp.txt");
		    fr = new FileReader (archivo);
		    br = new BufferedReader(fr);
		    
		    System.out.println("Su archivo ha sido leído con éxito.");
		    System.out.println("");
		    System.out.println("Contenido encontrado: ");
		
		    // Lectura 
		    String linea;
		    while((linea=br.readLine())!=null) {
		       System.out.println(linea);
		    	msg=linea;
		    	String[] parts = msg.split(" ");
		    	
		    }
		    
		  
		}
		
		catch(Exception e){
			e.printStackTrace();
		    System.out.println("No se ha encontrado el archivo de texto");
		    System.out.println("Asegúrese de llamarlo lisp.txt en su disco C");
		 }
		
		finally{
			
		    try{   
		    	
		       if( null != fr ){   
		          fr.close();     
		       }   
		    }
		    
		    catch (Exception e2){ 
		       e2.printStackTrace();
		    }
		
		}
				
	}
	
	
}


