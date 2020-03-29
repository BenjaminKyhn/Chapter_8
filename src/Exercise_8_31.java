import java.util.Scanner;

public class Exercise_8_31 {
    public static void main(String[] args) {
        double[][] points = new double[4][2];
        System.out.println("Enter 4 points (x, y): ");
        Scanner input = new Scanner(System.in);
        for (int row = 0; row < points.length; row++) {
            for (int column = 0; column < points[row].length; column++) {
                points[row][column] = input.nextDouble();
            }
        }

        if (getIntersectingPoint(points) == null)
            System.out.println("The two lines are parallel.");
        else
            System.out.printf("The intersection point is (%.2f, %.2f).", getIntersectingPoint(points)[0], getIntersectingPoint(points)[1]);
    }
//2 2 5 -1.0 4.0 2.0 -1.0 -2.0
    public static double[] getIntersectingPoint(double[][] points) {
        double[] intersection = new double[2];
        double a = points[0][1] - points[1][1]; //y1 - y2;
        double b = -1 * (points[0][0] - points[1][0]); // (x1 - x2);
        double c = points[2][1] - points[3][1]; //y3 - y4;
        double d = -1 * (points[2][0] - points[3][0]); //(x3 - x4);
        double e = a * points[0][0] - (points[0][0] - points[1][0]) * points[0][1]; //x1 - (x1 - x2) * y1;
        double f = c * points[2][0] - (points[2][0] - points[3][0]) * points[2][1]; //x3 - (x3 - x4) * y3;

        if (a * d - b * c == 0)
            return null;

        else {
            intersection[0] = (e * d - b * f) / (a * d - b * c); //x
            intersection[1] = (a * f - e * c) / (a * d - b * c); //y

            return intersection;
        }
    }
}
