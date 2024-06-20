
import java.util.Scanner;

import calculator.Calculator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input expression separated by a space (a + b):");
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] num = in.split(" ");

        Calculator calculator = new Calculator();

        try{
            double a = Double.parseDouble(num[0]);
            double b = Double.parseDouble(num[2]);


            if(num[1].contains("+"))
                System.out.println(calculator.add(a,b));
            else if(num[1].contains("-"))
                System.out.println(calculator.subtract(a,b));
            else if(num[1].contains("*"))
                System.out.println(calculator.multiply(a,b));
            else if(num[1].contains("/"))
                System.out.println(calculator.divide(a,b));
        }catch (Exception e){
            System.out.println("Invalid input.");
        }

        sc.close();
    }
}
