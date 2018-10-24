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
        ArrayList<Double> res = new ArrayList<>();

        while (!stackOfOperator.empty()) {
//            if (!stackOfOperator.empty()) {
//                arrOfOperand.add(stackOfOperator.pop().getValue());
//            }
            arrOfOperand.add(stackOfOperator.pop().getValue());
        }

        System.out.println(arrOfOperand);

        for (int i = 0; i < arrOfOperand.size(); i++) {
            double itemInRes = 0;
            String curenntInArr = arrOfOperand.get(i);
            switch (curenntInArr) {
                case "+":
                    itemInRes = res.remove(0);
                    for (Double item : res) {
                        itemInRes += item;
                    }
                    res.clear();
                    res.add(itemInRes);
                    break;
                case "-":
                    itemInRes = res.remove(0);
                    for (Double item : res) {
                        itemInRes -= item;
                    }
                    res.clear();
                    res.add(itemInRes);
                    break;
                case "*":
                    itemInRes = res.remove(0);
                    for (Double item : res) {
                        itemInRes *= item;
                    }
                    res.clear();
                    res.add(itemInRes);
                    break;
                case "/":
                    itemInRes = res.remove(0);
                    for (Double item : res) {
                        itemInRes /= item;
                    }
                    res.clear();
                    res.add(itemInRes);
                    break;
                default:
                    res.add(Double.valueOf(curenntInArr));
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
