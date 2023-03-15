import java.util.ArrayList;

public class Aritmetica {

    public double calculadoraAritmetica(ArrayList<String> line) {
        
        Funciones variables = new Funciones();
        double result = 1;
        if(line.size() == 1) {
            try {
                return Double.parseDouble(line.get(0));
            } catch (Exception E) {
                return variables.getVariable(line.get(0));
            }
        }

        int index = 0;
        while(line.size() > 1) {
            int openParentheses = 0;
            int closedParentheses = 0;

            for(int i = 0; i < line.size(); i ++) {
                String currentWord = line.get(i);
                if(currentWord.equals("(")) {
                    openParentheses = i;
                } else if (currentWord.equals(")")) {
                    closedParentheses = i + 1;
                    break;
                }
            }
            calculateParenthesis(openParentheses,closedParentheses,line);
            index++;
        }

        result = Double.parseDouble(line.get(0));
        return result;
    }

    /**
     * Calculates sub-parentheses inside an arithmetic expression
     * @param line line to be
     * @return
     */
    public void calculateParenthesis(int open, int closed, ArrayList<String> line) {
        double result = 0;
        String operator = line.get(open + 1);
        switch (operator) {
            case "+":

                for(int i = open + 2; i < closed - 1; i ++) {
                    double number;
                    try {
                        number = Double.parseDouble(line.get(i));
                    } catch (Exception E) {
                        number = Double.parseDouble(Funciones.variablesDelPrograma.get(line.get(i)).get(1));
                    }
                    result += number;
                }
                break;

            case "-":

                result = Double.parseDouble(line.get(open + 2));
                for(int i = open + 3; i < closed - 1; i ++) {
                    double number;
                    try {
                        number = Double.parseDouble(line.get(i));
                    } catch (Exception E) {
                        number = Double.parseDouble(Funciones.variablesDelPrograma.get(line.get(i)).get(1));
                    }
                    result -= number;
                }
                break;

            case "*":
                System.out.println("IN MULT");
                result = 1;
                for(int i = open + 2; i < closed - 1; i ++) {
                    double number;
                    try {
                        number = Double.parseDouble(line.get(i));
                    } catch (Exception E) {
                        number = Double.parseDouble(Funciones.variablesDelPrograma.get(line.get(i)).get(1));
                    }
                    result *= number;
                }
                break;

            case "/":
                result = Double.parseDouble(line.get(open + 2));
                for(int i = open + 3; i < closed - 1; i ++) {
                    double number;
                    try {
                        number = Double.parseDouble(line.get(i));
                    } catch (Exception E) {
                        number = Double.parseDouble(Funciones.variablesDelPrograma.get(line.get(i)).get(1));
                    }
                    result /= number;
                }
                break;
        }


        for(int i = closed - 1; i > open; i --) {
            try {
                line.remove(i);
            } catch (Exception E) {
                System.err.println("An error occurred during the calculation");
            }
        }
        line.set(open, String.valueOf(result));
    }
}
