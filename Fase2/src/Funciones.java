public class Funciones {
	/***
	 * @param <T> operando a
	 * @param <T> operando b
	 * @param operador entre a y b
	 * @return the boolean result of the comparison
	 */
	public <T> boolean cond( T a, T b, String operador) {
		
		String A= a.toString();
		String B= b.toString();
		
		switch (operador) {
		
		case "<":
			int a1= Integer.parseInt(A);
			int b1= Integer.parseInt(B);
			
			if (a1<b1) {
				return true;
			}
			break;
			
		case ">":
			int a2= Integer.parseInt(A);
			int b2= Integer.parseInt(B);
			
			if (a2>b2) {
				return true;
			}
			break;
			
		case "==":
			try {
				int a3= Integer.parseInt(A);
				int b3= Integer.parseInt(B);
				
				if (a3==b3) {
					return true;
				}
			}
			catch(Exception e1){
				if (A.equals(B)) {
					return true;
				}
			}
			break;
				
		default:
			return false;
			
		}
		return false;
	}
}
