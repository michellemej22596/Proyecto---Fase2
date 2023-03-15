import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Stack;
import java.util.LinkedList;

public class Interpretador {
		



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
					//interpretador_numericas(list_Lista);	
				}
					
				

			}
			
		

			//return "P";


		}

		public double interpretador_numericas(String  lista, int start, int stop){
			int contador = 0;
			Stack<Double> myStack =  new Stack<>();

			for(int i = start;i < stop;i++){
				if (lista.substring(i).equals("(")){
					

					contador = contador+1;
					

					if (contador>1){
						//Double valor=interpretador_numericas(lista, i, stop-1);
						

					}

					else if (contador==1){

						int a=lista.lastIndexOf(")", stop);
						stop = a;


					}


				}

				else if ( lista.substring(i).equals("+") || lista.substring(i).equals("-")){
					String operator = lista.substring(i) ;
						
				}

				else if (isNumeric(lista.substring(i))){
					
					myStack.push(Double.parseDouble(lista.substring(i)));

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
	
	





