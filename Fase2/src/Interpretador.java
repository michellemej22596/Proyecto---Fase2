import java.util.ArrayList;

public class Interpretador implements Interpretador_i{

    int i = 0;
    
    public ArrayList<String> calcular (ArrayList<ArrayList<String>> stack) {
        ArrayList<String> results = new ArrayList<>();


        for(int i = 0; i < stack.size(); i++) {
            ArrayList<String> lineToCalculate = stack.get(i);
            System.out.println(lineToCalculate);

            if (EsAritmetica(lineToCalculate)) {
                Aritmetica arithmetic = new Aritmetica();
                double result = arithmetic.calculadoraAritmetica(lineToCalculate);
                results.add(result + "");
                System.out.println(lineToCalculate);


            } else if (EsLogic(lineToCalculate)) {
                Logica logicOperations = new Logica();
                boolean result = logicOperations.calculadoraLogica(lineToCalculate);
                results.add(result + "");

            } else if (isStructural(lineToCalculate)) {
                Estructura structuralDefinitions = new Estructura();
                String structureResult = structuralDefinitions.operar(lineToCalculate);
                results.add(structureResult);

            } else if (lineToCalculate.get(1).equals("setq") || lineToCalculate.get(1).equals("defun")) {
                Funciones memorySet = new Funciones();
                String result = "NO RESULT";


                if(lineToCalculate.get(1).equals("setq")) {
                    result = memorySet.setq(lineToCalculate);
                } else {
                    result = memorySet.defun(lineToCalculate);
                }
                results.add(result);

            }   else {
            lineToCalculate.remove(lineToCalculate.size() - 1);
            lineToCalculate.remove(0);
            String result = Funciones.ejecutarFunciones(lineToCalculate) + "";
            results.add(result);
        }

    }

        System.out.println("Resultado: ");
        System.out.println(results);
        return results;
    }

        private boolean EsLogic(ArrayList<String> line) {
            String logicalValue = line.get(1);
    
            if(logicalValue.equals(">") || logicalValue.equals("<") || logicalValue.equals("equal")) {
                return true;
            }
            return false;
        }

        private boolean EsAritmetica(ArrayList<String> line) {
            Funciones functions = new Funciones();
            for(int i = 0; i < line.size(); i ++) {
                String currentWord = line.get(i);
                if(functions.operar(currentWord)) {
                    continue;
                } else if(currentWord.equals("(") || currentWord.equals(")")) {
                    continue;
                } else {
                    try {
                        Double.parseDouble(currentWord);
                    } catch (Exception E) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isStructural(ArrayList<String> line) {
            String structuralValue = line.get(1);
            if(structuralValue.equals("cond") || structuralValue.equals("list") || structuralValue.equals("quote")
                    ||structuralValue.equals("'") || structuralValue.equals("first") || structuralValue.equals("second")
                    || structuralValue.equals("third") || structuralValue.equals("fourth") || structuralValue.equals("fifth")
                    || structuralValue.equals("sixth") || structuralValue.equals("seventh")|| structuralValue.equals("eighth")
                    || structuralValue.equals("ninth") || structuralValue.equals("tenth") ) {
                return true;
            }
            return false;        
    
}
}
