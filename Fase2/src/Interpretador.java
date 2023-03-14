import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

public class Interpretador {
	
	Stack<Float> stackPrincipal = new Stack<>();


	public void evaluator(String [] parts) {
		int i=0;
		while(i!=parts.length) {
			
			switch(parts[i]) {
			
			case "+":
				float num1= Float.parseFloat(parts[i+1]);
				float result=0;
				stackPrincipal.push( result);
				
				
				break;
			
			case "(":
				Stack < String > stack = new Stack < String > ();
				//partsChanged[]= parts;
				//evaluator(partsChanged[]);
				break;
				
			}
			
			i++;
			
		}
		
		
	}
	
	public void operar() {
		
		
	}
	
	public void reader() {
		//The following code to read a text file was found at https://chuwiki.chuidiang.org/index.php?title=Lectura_y_Escritura_de_Ficheros_en_Java#:~:text=Podemos%20abrir%20un%20fichero%20de,y%20extraer%20campos%20de%20ella.
		//Some lines have been edited in order to read properly the text file requested and split the characters.
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String msg="";
		
		try {
			
<<<<<<< Updated upstream
		    archivo = new File ("C:\\lisp.txt");
=======
		    archivo = new File ("Proyecto---Fase2\\Fase2\\src\\lisp.txt");
>>>>>>> Stashed changes
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
		    	evaluator(parts);
		    }
		    
		  
		}
		
		catch(Exception e){
			e.printStackTrace();
		    System.out.println("No se ha encontrado el archivo de texto");
		    System.out.println("Asegúrese de llamarlo lisp.txt dentro del proyecto");
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


