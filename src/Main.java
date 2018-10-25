import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine().replaceAll("\\s","");
        System.out.println(str);

        StringBuilder digitBuf = new StringBuilder();
        char oneChar;

        for (int i = 0; i < str.length(); i++) {
            oneChar = str.charAt(i);
            String temp = String.valueOf(oneChar);

            if (Character.isDigit(oneChar)) {
                digitBuf.append(oneChar);

                if (i == (str.length() - 1)) {
                    calculator.addOperandWrapper(digitBuf);
                }

                continue;

            } else if (Operator.ADD.getSign().equals(temp)) {
//                if (!digitBuf.toString().equals("")) {
//                    calculator.enterOperand(Double.valueOf(digitBuf.toString()));
//                    digitBuf.delete(0, digitBuf.length());
//                }
                calculator.addOperandWrapper(digitBuf);
                calculator.enterOperator(Operator.ADD);
            } else if (Operator.SUBTRACT.getSign().equals(temp)) {
                calculator.addOperandWrapper(digitBuf);
                calculator.enterOperator(Operator.SUBTRACT);
            } else if (Operator.MULTIPLY.getSign().equals(temp)) {
                calculator.addOperandWrapper(digitBuf);
                calculator.enterOperator(Operator.MULTIPLY);
            } else if (Operator.DIVIDE.getSign().equals(temp)) {
                calculator.addOperandWrapper(digitBuf);
                calculator.enterOperator(Operator.DIVIDE);
            } else if (Operator.SQUARE.getSign().equals(temp)) {
                calculator.addOperandWrapper(digitBuf);
                calculator.enterOperator(Operator.SQUARE);
            } else if (Operator.ROOT.getSign().equals(temp)) {
                calculator.addOperandWrapper(digitBuf);
                calculator.enterOperator(Operator.ROOT);
            }







//            switch (temp) {
//                case "+":
//                    calculator.enterOperator(Operator.ADD);
//                    break;
//                case "-":
//                    calculator.enterOperator(Operator.SUBTRACT);
//                    break;
//                case "*":
//                    calculator.enterOperator(Operator.MULTIPLY);
//                    break;
//                case "/":
//                    calculator.enterOperator(Operator.DIVIDE);
//                    break;
//                case "s":
//                    calculator.enterOperator(Operator.SQUARE);
//                    break;
//                case "r":
//                    calculator.enterOperator(Operator.ROOT);
//                    break;
//                default:
//                    calculator.enterOperand(Double.valueOf(temp));
//                    break;
//            }
        }
        System.out.println(calculator.calculateResults());
    }
}
