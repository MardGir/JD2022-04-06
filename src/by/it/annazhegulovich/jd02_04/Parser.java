package by.it.annazhegulovich.jd02_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
private final static Map<String, Integer> priorityMap = Map.of(
        "=", 0,
        "+", 1,
        "-", 1,
        "*", 2,
        "/", 2

);

    public Var calc(String expression) {
        expression=expression.trim().replaceAll(Patterns.SPACES, "");
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();

        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()){
            operations.add(matcher.group());
        }
        int index = getPriority(operations);
        while (operations.isEmpty()){
        String left = operands.remove(index);
        String operation = operations.remove(index);
        String right = operands.remove(index);
        Var result = calcOneOperation(left, operation, right);
            assert result != null;
            operands.add(index, result.toString());
        }




        return Var.createVar(operands.get(0));

    }

    private Var calcOneOperation(String leftOperand, String operation, String rightOperand) {

        Var right = Var.createVar(rightOperand);
        Var left = Var.createVar(leftOperand);

            switch (operation){
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);
            }


        return Var.createVar(operation);
    }

    private int getPriority(List<String> operations) {
        int indexOperation=-1;
        int bestPriority = -1;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if(priorityMap.get(operation)>bestPriority){
                indexOperation = i;
                bestPriority = priorityMap.get(operation);
            }
            
        }
        return indexOperation;
    }
}
