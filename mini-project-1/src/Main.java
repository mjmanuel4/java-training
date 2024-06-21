
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import calculator.Calculator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        boolean firstExpression = true;
        double result = 0;

        System.out.println("Input expression separated by a space (a + b):");
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        while (firstExpression) {
            try {
                double a = Double.parseDouble(inputArray[0]);
                double b = Double.parseDouble(inputArray[2]);

                boolean validOperator = inputArray[1].matches("[+\\-*/]");
                if (!validOperator)
                    throw new InputMismatchException("Invalid operator used, please provide a valid expression:");

                result = switch (inputArray[1]) {
                    case "+" -> calculator.add(a, b);
                    case "-" -> calculator.subtract(a, b);
                    case "*" -> calculator.multiply(a, b);
                    case "/" -> calculator.divide(a, b);
                    default -> result;
                };

                System.out.println(result);
                firstExpression = false;

            } catch (ArithmeticException | InputMismatchException e) {
                System.out.println(e.getMessage());
                input = scanner.nextLine();
                inputArray = input.split(" ");
            } catch (Exception e) {
                System.out.println("Invalid input, please provide a valid expression:");
                input = scanner.nextLine();
                inputArray = input.split(" ");
            }
        }

        // Continuous implementation
        System.out.print("Would you like to continue? [y/n]: ");
        String proceed = scanner.nextLine();

        while (Objects.equals(proceed, "y")){
            System.out.println("Input next operation and number separated by a space (eg. + 45):");
            input = scanner.nextLine();
            inputArray = input.split(" ");
            boolean notUpdated = true;

            while (notUpdated) {
                try {
                    double b = Double.parseDouble(inputArray[1]);
                    boolean validOperator = inputArray[0].matches("[+\\-*/]");
                    if (!validOperator)
                        throw new InputMismatchException("Invalid operator used, please provide a valid expression:");

                    result = switch (inputArray[0]) {
                        case "+" -> calculator.add(result, b);
                        case "-" -> calculator.subtract(result, b);
                        case "*" -> calculator.multiply(result, b);
                        case "/" -> calculator.divide(result, b);
                        default -> result;
                    };

                    System.out.println(result);
                    notUpdated = false;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println(e.getMessage());
                    input = scanner.nextLine();
                    inputArray = input.split(" ");
                } catch (Exception e) {
                    System.out.println("Invalid input, please provide a valid expression:");
                    input = scanner.nextLine();
                    inputArray = input.split(" ");
                }
            }

            System.out.print("Would you like to continue? [y/n]: ");
            proceed = scanner.nextLine();
        }

        scanner.close();
    }
}
