import java.util.Scanner;


public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1, y1, x2, y2;
        String coord1, coord2;


        //Welcomes user
        System.out.println("Welcome!");


        //Get coordinates from user
        System.out.print("Enter coordinate 1: ");
        coord1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        coord2 = scan.nextLine();


        //Isolate x1, y1, x2, y2
        x1 = Integer.parseInt(coord1.substring(1, coord1.indexOf(",")));
        y1 = Integer.parseInt(coord1.substring(coord1.indexOf(" ") + 1, coord1.length() - 1));
        x2 = Integer.parseInt(coord2.substring(1, coord2.indexOf(",")));
        y2 = Integer.parseInt(coord2.substring(coord2.indexOf(" ") + 1, coord2.length() - 1));


        System.out.println();


        //Checks to see the line if the line is a vertical or horizontal line then creates a LinearEquation object
        if (x1 == x2) {
            System.out.println("These points are on a vertical line: x = " + x1);
        } else if (y1 == y2) {
            System.out.println("These points are on a horizontal line: y = " + y1);
        } else {
            LinearEquation equ = new LinearEquation(x1, y1, x2, y2);


            //Displays info using the lineInfo method
            System.out.println(equ.lineInfo());


            //Ask for an x value and give the corresponding coordinate point
            System.out.println("Enter a value for x: ");
            double xValue = scan.nextDouble();
            System.out.println(equ.coordinateForX(xValue));
        }
    }
}