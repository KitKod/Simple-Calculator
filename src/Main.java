import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine().replaceAll("\\s","");
        System.out.println(str);

        for (int i = 0; i < str.length(); i++) {
            String temp = String.valueOf(str.charAt(i));
            switch (temp) {
                case "+":
                    calculator.enterOperator(Operator.ADD);
                    break;
                case "-":
                    calculator.enterOperator(Operator.SUBTRACT);
                    break;
                case "*":
                    calculator.enterOperator(Operator.MULTIPLY);
                    break;
                case "/":
                    calculator.enterOperator(Operator.DIVIDE);
                    break;
                case "s":
                    calculator.enterOperator(Operator.SQUARE);
                    break;
                case "r":
                    calculator.enterOperator(Operator.ROOT);
                    break;
                default:
                    calculator.enterOperand(Double.valueOf(temp));
                    break;
            }
        }
        System.out.println(calculator.calculateResults());
    }
}
