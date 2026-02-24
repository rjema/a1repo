package division; 

public class Divide {
    public double divide(double numerator, double denominator){
        if (denominator == 0){
            throw new ArithmeticException("Cannot divide by 0.");
        } else if (denominator == Double.NEGATIVE_INFINITY){
            denominator = Double.POSITIVE_INFINITY;
        }
        return numerator/denominator;
    }
}