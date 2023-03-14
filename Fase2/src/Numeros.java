public class Numeros {
	
	/***
	 * @param float a and b
	 * @return the boolean result of the comparison
	 */
	public boolean moreThan(float a, float b) {
		return a>b;
	}
	
	/***
	 * @param float a and b
	 * @return the boolean result of the comparison
	 */
	public boolean lessThan(float a, float b) {
		return a<b;
	}
	
	/***
	 * @param float a and b
	 * @return True if both numbers are equals, otherwise False
	 */
	public boolean equals(float a, float b) {
		return a==b;
	}
	
	/***
	 * @param float a and b
	 * @return the result of the addition
	 */
	public Double add(Double a, Double b) {
		return a+b;
	}
	
	/***
	 * @param float a and b
	 * @return the result of the subtraction
	 */
	public Double subtraction(Double a, Double b) {
		return a-b;
	}
	
	/***
	 * @param float a and b
	 * @return the result of the multiplication
	 */
	public float multiplication(float a, float b) {
		return a*b;
	}
	
	/***
	 * @param float a and b
	 * @return the result of the division and 0 when a number is divided into 0.
	 */
	public float division(float a, float b) {
		try {
			return b/a;
		}
		catch(Exception e3) {
			System.out.println("Existe una división inválida. Se ha retornado 0 como resultado.");
			return 0;
		}
	}

	

}
