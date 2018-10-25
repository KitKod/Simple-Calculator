import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        boolean isClead = true;


        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            String str = scanner.nextLine().replaceAll("\\s", "");

            StringBuilder digitBuf = new StringBuilder();
            char oneChar;

            for (int i = 0; i < str.length(); i++) {
                oneChar = str.charAt(i);
                String temp = String.valueOf(oneChar);


                if (i == 0 && !Character.isDigit(str.charAt(0))) {
                    if ('C' == str.charAt(0)) {
                        calculator.clearMemory();
                        isClead = false;
                        break;
                    } else {
                        calculator.enterOperand(calculator.returnResultFromMemory());
                    }
                }

                if (Character.isDigit(oneChar)) {
                    digitBuf.append(oneChar);
                    if (i == (str.length() - 1)) {
                        calculator.addOperandWrapper(digitBuf);
                    }

                } else if (Operator.ADD.getSign().equals(temp)) {
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
                } else {
                    throw new IncorrectOperandException("Incorrect entered operand");
                }
            }

            if (isClead) {
                double res = calculator.calculateResults();
                System.out.println(res);
            } else {
                isClead = true;
            }
        }
    }
}
