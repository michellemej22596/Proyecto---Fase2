public class Numeros {
	
	/***
	 * @param double a and b
	 * @return the boolean result of the comparison
	 */
	public boolean moreThan(double a, double b) {
		return a>b;
	}
	
	/***
	 * @param double a and b
	 * @return the boolean result of the comparison
	 */
	public boolean lessThan(double a, double b) {
		return a<b;
	}
	
	/***
	 * @param double a and b
	 * @return True if both numbers are equals, otherwise False
	 */
	public boolean equals(double a, double b) {
		return a==b;
	}
	
	/***
	 * @param double a and b
	 * @return the result of the addition
	 */
	public double add(double a, double b) {
		return a+b;
	}
	
	/***
	 * @param double a and b
	 * @return the result of the subtraction
	 */
	public double subtraction(double a, double b) {
		return a-b;
	}
	
	/***
	 * @param double a and b
	 * @return the result of the multiplication
	 */
	public double multiplication(double a, double b) {
		return a*b;
	}
	
	/***
	 * @param double a and b
	 * @return the result of the division and 0 when a number is divided into 0.
	 */
	public double division(double a, double b) {
		try {
			return b/a;
		}
		catch(Exception e3) {
			System.out.println("Existe una división inválida. Se ha retornado 0 como resultado.");
			return 0;
		}
	}
	

}
