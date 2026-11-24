import java.util.*;

class Calculator {
    //calculator class
    int add(int a, int b) {
        return a+b;
    }
    double add(double a, double b) {
        return a+b;
    }
    //subtraction
    double subtract(double a, double b) {
        return a-b;
    }
    //multiplication
    double multiply(double a, double b) {
        return a*b;
    }
    //division
    double divide(double a, double b) {
        if(b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a/b;
    }
    //square root
    double sqrt(double a) {
        return Math.sqrt(a);
    }
    //power function
    double power(double a, double b) {
        return Math.pow(a, b);
    }
    //Trigonometric function
    double sin(double angle) {
        return Math.sin(Math.toRadians(angle));
    }
    double cos(double angle) {
        return Math.cos(Math.toRadians(angle));
    }
}
public class ScientificCalculator  {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Calculator cals = new Calculator();
        int choice;
        do {
            System.out.println("\n===== Scientific Calculator =====");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root");
            System.out.println("6. Power");
            System.out.println("7. Sin");
            System.out.println("8. Cos");
            System.out.println("9. Exit");

            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            try {
                switch(choice) {
                    case 1:
                    System.out.println("Enter two integers: ");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    System.out.println("Addition (int): "+ cals.add(a,b));

                    System.out.println("Enter two decimal numbers: ");
                    double x = sc.nextDouble();
                    double y = sc.nextDouble();
                    System.out.println("Addition (double): "+ cals.add(x,y));
                    break;

                    case 2:
                    System.out.println("Enter two number: ");
                    double s1 = sc.nextDouble();
                    double s2 = sc.nextDouble();
                    System.out.println("Subtraction: "+cals.subtract(s1, s2));
                    break;

                    case 3:
                    System.out.println("Enter two number: ");
                    double m1 = sc.nextDouble();
                    double m2 = sc.nextDouble();
                    System.out.println("Multiplication: "+cals.multiply(m1, m2));
                    break;

                    case 4:
                    System.out.println("Enter two number ");
                    double d1 = sc.nextDouble();
                    double d2 = sc.nextDouble();
                    System.out.println("Division "+cals.divide(d1, d2));
                    break;

                    case 5:
                    System.out.println("Enter number: ");
                    double num = sc.nextDouble();
                    System.out.println("Square root: "+cals.sqrt(num));
                    break;

                    case 6:
                    System.out.println("Enter base and exponent: ");
                    double base = sc.nextDouble();
                    double exp = sc.nextDouble();
                    System.out.println("Power: "+cals.power(base, exp));
                    break;

                    case 7:
                    System.out.println("Enter angle in degrees: ");
                    double angle1 = sc.nextDouble();
                    System.out.println("Sin value: "+cals.sin(angle1));
                    break;

                    case 8:
                    System.out.println("Enter angle in degree: ");
                    double angle2 = sc.nextDouble();
                    System.out.println("Cos value: "+cals.cos(angle2));
                    break;

                    case 9:
                    System.out.println("Exiting Calculator...");
                    break;

                    default:
                    System.out.println("Invalid Choice!");
                }
            } catch(ArithmeticException e) {
                System.out.println("Error: "+e.getMessage());
            } catch(Exception e) {
                System.out.println("Invalid input");
            }
        } while (choice != 9);
        sc.close();
    }
}