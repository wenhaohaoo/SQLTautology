public class ExpressionDescription {

    private String leftExpression;
    private String rightExpression;
    private String comparatorString;
    private String originalDescription;
    private boolean isSuccessful;

    public ExpressionDescription(String input) {
        // TODO Auto-generated constructor stub
        this.setOriginalDescription(input);
        // verification code
        setSuccessful(true);
    }

    String getLeftExpression() {
        return this.leftExpression;
    }

    void setLeftExpression(String expression) {
        this.leftExpression = expression;
    }

    String getRightExpression() {
        return this.rightExpression;
    }

    void setRightExpression(String rightExpression) {
        this.rightExpression = rightExpression;
    }

    public String getComparatorString() {
        return this.comparatorString;
    }

    public void setComparatorString(String comparatorString) {
        this.comparatorString = comparatorString;
    }

    public String getOriginalDescription() {
        return this.originalDescription;
    }

    public void setOriginalDescription(String originalDescription) {
        this.originalDescription = originalDescription;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

}
