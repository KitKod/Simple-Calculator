import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        System.out.println(str);

        for (int i = 0; i < str.length(); i++) {
            String temp = String.valueOf(str.charAt(i));
            switch (temp) {
                case "+":
                    calculator.enterOperator(new Operator(temp, 0));
                    break;
                case "-":
                    calculator.enterOperator(new Operator(temp, 0));
                    break;
                case "*":
                    calculator.enterOperator(new Operator(temp, 1));
                    break;
                case "/":
                    calculator.enterOperator(new Operator(temp, 1));
                    break;
                default:
                    calculator.enterOperand(Double.valueOf(temp));
                    break;
            }
        }
        System.out.println(calculator.calculateResults());
    }
}
