import java.util.ArrayList;
import java.util.Stack;

public class Calculator implements CalculatorInterface {

    private Stack<Operator> stackOfOperator = new Stack<>();
    private ArrayList<String> arrOfOperand = new ArrayList<>();
    private Stack<Double> res;

    private double result;

    public void enterOperand(double var1) throws Exception {
        arrOfOperand.add(String.valueOf(var1));
    }

    public void enterOperator(Operator var1) throws Exception {
        if (stackOfOperator.empty()) {
            stackOfOperator.push(var1);
        } else {
            int priorityInStack = stackOfOperator.peek().getPriority();
            if (priorityInStack >= var1.getPriority()) {
                arrOfOperand.add(stackOfOperator.pop().getSign());
                stackOfOperator.push(var1);
            } else {
                stackOfOperator.push(var1);
            }
        }

    }

    public double calculateResults() throws Exception {
        res = new Stack<>();

        while (!stackOfOperator.empty()) {
            arrOfOperand.add(stackOfOperator.pop().getSign());
        }

        for (String item : arrOfOperand) {
            double operand1;
            double operand2;

            switch (item) {
                case "+":
                    operand1 = res.pop();
                    operand2 = res.pop();
                    res.push(operand2 + operand1);
                    break;
                case "-":
                    operand1 = res.pop();
                    operand2 = res.pop();
                    res.push(operand2 - operand1);
                    break;
                case "*":
                    operand1 = res.pop();
                    operand2 = res.pop();
                    res.push(operand2 * operand1);
                    break;
                case "/":
                    operand1 = res.pop();
                    operand2 = res.pop();
                    res.push(operand2 / operand1);
                    break;
                case "s":
                    operand1 = res.pop();
                    res.push(operand1 * operand1);
                    break;
                case "r":
                    operand1 = res.pop();
                    res.push(Math.sqrt(operand1));
                    break;
                default:
                    res.push(Double.valueOf(item));
                    break;
            }
        }

        saveResultToMemory();
        arrOfOperand.clear();
        double output = res.get(0);
        res.clear();
        return output;
    }

    public void saveResultToMemory() {
        this.result = res.peek();
    }

    public double returnResultFromMemory() throws Exception {
        if (this.result == 0.0){
            throw new ResultFromMemoryException("Memory is empty");
        }
        return this.result;
    }

    public void clearMemory() {
        result = 0.0;
    }

    public void addOperandWrapper(StringBuilder digitBuf) throws Exception {
        if (!digitBuf.toString().equals("")) {
            enterOperand(Double.valueOf(digitBuf.toString()));
            digitBuf.delete(0, digitBuf.length());
        }
    }
}
