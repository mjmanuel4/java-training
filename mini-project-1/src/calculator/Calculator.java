package calculator;

public class Calculator {
    public double add(double a, double b){
        return(a+b);
    }

    public double subtract(double a, double b){
        return(a-b);
    }

    public double multiply(double a, double b){
        return(a*b);
    }

    public double divide(double a, double b){
        if (b == 0)
            throw new ArithmeticException("Invalid input: division by zero. Please provide a valid expression:");
        else
            return(a/b);
    }
}
