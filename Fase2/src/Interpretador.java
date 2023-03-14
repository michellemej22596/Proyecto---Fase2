import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Stack;
import java.util.LinkedList;

public class Interpretador {
		
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



	public String Format(String Lista){
		if (Lista.equals("+") ||  Lista.equals("-") ||  Lista.equals("*") ||  Lista.equals("/")  ){
			return "Num";

		}

		else if (Lista.equals("cond")){
			return "cond";
		}

		else if (Lista.equals("<") || Lista.equals(">") || Lista.equals("==") ){
			return "CondStep";
		}

		else if (Lista.equals("defunc")){
			return "Eqn";
		}

		else {
			return "¡Cristo rey! ERES TONTO";
		}
}


		public void interpretador_lineas(String[] lista){
			for(String list: lista){
				String[] list_Lista = list.split(" ");
				String a =Format(list_Lista[1]);
				System.out.println(list_Lista[1]);
				if(a.equals("Num")){
					interpretador_numericas(list_Lista);	
				}
					
				

			}
			
		

			//return "P";


		}

		public double interpretador_numericas(String [] lista){
			int contador = 0;
			LinkedList<String> myStack =  new LinkedList<>();

			for(String a: lista){
				if(a.equals("(")){
					contador = contador + 1;
				}
				else if(a.equals(")")){
					contador = contador-1;
				}

				else {

					myStack.addFirst(a);

				}
			}
			System.out.println(contador);

			if (contador!=0){
				System.out.println("esta mala la expresion");
			}
			else {

				Stack<Double> myStack2 = new Stack();
				while(myStack.size()!=1){
					if (isNumeric(myStack.getFirst())){
						double d = Double.parseDouble(myStack.getFirst()); 
						myStack.removeFirst();
						myStack2.push(d);

					}

					else {
						Numeros calculator = new Numeros();
						Double a = myStack2.pop(); 
						Double b = myStack2.pop(); 

						if (myStack.getFirst().equals("+")){
							myStack2.push(calculator.add(a,b));

						}

						else if (myStack.getFirst().equals("-")){
							myStack2.push(calculator.subtraction(a,b));
						}
					}
				}
			}







			return 5.7;
		}
		
		public static boolean isNumeric(String strNum) {
			if (strNum == null) {
				return false;
			}
			try {
				double d = Double.parseDouble(strNum);
			} catch (NumberFormatException nfe) {
				return false;
			}
			return true;
		}


	










            



	} 
	
	





