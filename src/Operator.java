public enum Operator {
    ADD("+", 0),
    SUBTRACT("-", 0),
    MULTIPLY("*", 1),
    DIVIDE("/", 1),
    SQUARE("s", 1),
    ROOT("r", 1);

    private String sign;
    private int priority;

    Operator(String sign, int priority){
        this.sign = sign;
        this.priority = priority;
    }

    public String getSign() {
        return sign;
    }

    public int getPriority() {
        return priority;
    }
}
