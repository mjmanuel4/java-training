
import java.util.Scanner;

import calculator.Calculator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input expression separated by a space (a + b):");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        Calculator calculator = new Calculator();

        try{
            double a = Double.parseDouble(inputArray[0]);
            double b = Double.parseDouble(inputArray[2]);


            if(inputArray[1].contains("+"))
                System.out.println(calculator.add(a,b));
            else if(inputArray[1].contains("-"))
                System.out.println(calculator.subtract(a,b));
            else if(inputArray[1].contains("*"))
                System.out.println(calculator.multiply(a,b));
            else if(inputArray[1].contains("/"))
                System.out.println(calculator.divide(a,b));

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("Invalid input.");
        }

        scanner.close();
    }
}
