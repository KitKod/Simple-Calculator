import java.util.ArrayList;
import java.util.Stack;

public class Calculator implements CalculatorInterface {

    private Stack<Operator> stackOfOperator = new Stack<>();
    private ArrayList<String> arrOfOperand = new ArrayList<>();

    public void enterOperand(double var1) throws Exception {
        arrOfOperand.add(String.valueOf(var1));
    }

    public void enterOperator(Operator var1) throws Exception {
        if (stackOfOperator.empty()) {
            stackOfOperator.push(var1);
        } else {
            int priorityInStack = stackOfOperator.peek().getPriority();
            if (priorityInStack >= var1.getPriority()) {
                arrOfOperand.add(stackOfOperator.pop().getValue());
                stackOfOperator.push(var1);
            } else {
                stackOfOperator.push(var1);
            }
        }

    }

    public double calculateResults() throws Exception {
        Stack<Double> res = new Stack<>();

        while (!stackOfOperator.empty()) {
            arrOfOperand.add(stackOfOperator.pop().getValue());
        }

        System.out.println(arrOfOperand);

        for (int i = 0; i < arrOfOperand.size(); i++) {
            double operand1;
            double operand2;

            String curenntInArr = arrOfOperand.get(i);
            switch (curenntInArr) {
                case "+":
                    operand1 = res.pop();
                    operand2 = res.pop();
                    res.push(operand1 + operand2);
                    break;
                case "-":
                    operand1 = res.pop();
                    operand2 = res.pop();
                    res.push(operand1 - operand2);
                    break;
                case "*":
                    operand1 = res.pop();
                    operand2 = res.pop();
                    res.push(operand1 * operand2);
                    break;
                case "/":
                    operand1 = res.pop();
                    operand2 = res.pop();
                    res.push(operand1 / operand2);
                    break;
                default:
                    res.push(Double.valueOf(curenntInArr));
                    break;
            }
        }
        return res.get(0);
    }

    public void saveResultToMemory() {

    }

    public double returnResultFromMemory() throws Exception {

        return 0;
    }

    public void clearMemory() {

    }
}
