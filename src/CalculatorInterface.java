public interface CalculatorInterface {
    void enterOperand(double var1) throws Exception;
    void enterOperator(Operator var1) throws Exception;
    double calculateResults() throws Exception;
    void saveResultToMemory();
    double returnResultFromMemory() throws Exception;
}
