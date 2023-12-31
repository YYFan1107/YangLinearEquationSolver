public class LinearEquation {
        /* Instance Variables */
        private final int x1;
        private final int y1;
        private final int x2;
        private final int y2;


        /* Creates a LinearEquation object */
/* PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for ensuring
   this precondition is not violated) */
public LinearEquation(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
}


/* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
   the nearest hundredth */
        public double distance() {
            double xDistance = x2 - x1;
            double yDistance = y2 - y1;
            return roundedToHundredth(Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2)));
        }


        /* Calculates and returns the y-intercept of the line between (x1, y1) and
           (x2, y2), rounded to the nearest hundredth */
        public double yIntercept() {
            double m = slope();
            double yInter = y1 - m * x1;
            return roundedToHundredth(yInter);
        }


        /* Calculates and returns the slope of the line between (x1, y1) and
           (x2, y2), rounded to the nearest hundredth */
        public double slope() {
            double m = (double) (y2 - y1) / (x2 - x1);
            return roundedToHundredth(m);
        }


        /* Returns a String that represents the linear equation of the line through points
           (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".

            When generating the m value (slope), here are examples of "printable" slopes:
               5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7

            Here are non-examples of "printable" slopes:
         1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
               -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)

            HINT: Be sure to check if the line is horizontal and return an appropriate string,
            e.g. y = 6
            HINT: Absolute value might be helpful for ensuring proper placement of negative sign!


            When generating the b value, here are some examples of "printable" y-intercepts:
               + 1.0 	- 2.35	      + 12.5		- 8.0		+ 17.19

            Here are non-examples of "printable" y-intercepts:
               - -1.0 	+ -2.35	- -12.5	+ -8.0	     - -17.19	+ 0	- 0

            HINT: Absolute value might be helpful for printing negative y-intercepts as
                   subtraction! */
        public String equation() {
            double s = slope();
            double yInter = yIntercept();
            return "y = " + convertFraction(s) + "x " + bInEquation(yInter);
        }


        /* Returns a String of the coordinate point on the line that has the given x value, with
           both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
        public String coordinateForX(double xValue) {
            double yValue = slope() * xValue + yIntercept();
            return "(" + roundedToHundredth(xValue) + ", " + roundedToHundredth(yValue) + ")";
        }


        /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
            to the nearest hundredth

            HINT:  the Math.round method can help with this! */
        public double roundedToHundredth(double toRound) {
            return Math.round(toRound * 100.0) / 100.0;
        }


        /* Returns a string that includes all information about the linear equation, each on
           separate lines:
             - The original points: (x1, y1) and (x2, y2)
             - The equation of the line in y = mx + b format (using equation() method)
             - The slope of the line, as a decimal (using slope() method)
             - The y-intercept of the line (using yIntercept() method)
             - The distance between the two points (using distance() method)

          This method should call all other appropriate methods to get the info it needs:
          equation(), slope(), yIntercept(), distance(). */
        public String lineInfo() {
            String str = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n";
            str += "The equation of the line between these points is: " + equation() + "\n";
            str += "The slope of this line is: " + slope() + "\n";
            str += "The y-intercept of the line is: " + yIntercept() + "\n";
            str += "The distance between the two points is: " + distance();
            return str;
        }


        //Finds the greatest common factor that both numbers can be divided by
        private int divisor(int num1, int num2) {
            if (num2 == 0) {
                return num1;
            }
            return divisor(num2, num1 % num2);
        }


        //Take the value in form of double and converted to display as a fraction
        private String convertFraction(double douValue) {
            int n = (int) (douValue * 100);
            int d = 100;
            int div = divisor(n, d);
            n = n / div;
            d = d / div;
            if (d == 1) {
                return Integer.toString(n);
            }
            return n + "/" + d;
        }


        //Formatting positive or negative y-intercept
        private String bInEquation(double b) {
            if (b > 0) {
                return " + " + b;
            } else if(b < 0) {
                return " - " + Math.abs(b);
            } else {
                return "";
            }
        }
}