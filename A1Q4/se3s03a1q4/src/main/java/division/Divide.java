package division; 

public class Divide {
    // divide function in first TDD iteration
    public double old_divide(double numerator, double denominator) {
        if (denominator == 0.0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return numerator / denominator;
    }

    public double divide(double numerator, double denominator){
        if (denominator == 0){
            throw new ArithmeticException("Cannot divide by 0.");
        } else if (denominator == Double.NEGATIVE_INFINITY){
            denominator = Double.POSITIVE_INFINITY;
        }
        return numerator/denominator;
    }
}