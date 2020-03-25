import java.util.Scanner;

public class Exercise_8_15 {
    public static void main(String[] args) {
        System.out.println("Enter five points: ");
        Scanner input = new Scanner(System.in);
        double[][] points = new double[5][2];
        for (int row = 0; row < points.length; row++) {
            for (int column = 0; column < points[row].length; column++) {
                points[row][column] = input.nextDouble();
            }
        }

        System.out.println("The five points are " + (sameLine(points) ? "on " : "not on ") + "the same line");
    }

    // Calculation is found in exercise 3.32
    public static boolean sameLine(double[][] points){
        boolean sameLine = false;
        for (int row = 2; row < points.length; row++) {
            if (((points[1][0] - points[0][0]) * (points[row][1] - points[0][0]) - (points[row][0] - points[0][0]) * (points[1][1] - points[0][1])) == 0)
                sameLine = true;
            else{
                sameLine = false;
                break;
            }
        }
        return sameLine;
    }
}
