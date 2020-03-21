import java.util.Scanner;

public class Exercise_8_08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points: ");
        int numberOfPoints = input.nextInt();

        // Create an array to store points
        double[][] points = new double[numberOfPoints][2];
        System.out.println("Enter " + numberOfPoints + " points: ");
        for (int i = 0; i < points.length; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }

        // p1 and p2 are the indices in the points' array
        int p1 = 0, p2 = 1;
        double shortestDistance = distance(points[p1][0], points[p1][1], points[p2][0], points[p2][1]);

        // Compute the distance for every two points
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distance(points[i][0], points[i][1], points[j][0], points[j][1]); // Find distance

                if (shortestDistance > distance) {
                    p1 = i; // Update p1
                    p2 = j; // Update p2
                    shortestDistance = distance; // Update shortest distance
                }
            }
        }

        // Find all the points with a distance equal to the shortest distance and display them
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distance(points[i][0], points[i][1], points[j][0], points[j][1]); // Find distance

                if (distance == shortestDistance) {
                    System.out.println("The closest two points are " + "(" + points[i][0] + ", " + points[i][1] +
                            ") and (" + points[j][0] + ", " + points[j][1] + ")");
                }
            }
        }

        System.out.println("Their distance is " + shortestDistance);
    }

    // Compute the distance between two points (x1, y1) and (x2, y2)
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}
