import java.util.Scanner;

public class Exercise_8_05 {
    public static double[][] addMatrix(double[][] a, double[][] b){
        double sum[][] = new double[2][2];
        for (int row = 0; row < a.length; row++) {
            for (int column = 0; column < a[row].length; column++) {
                sum[row][column] = a[row][column] + b[row][column];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Enter two 2x2 matrices. Enter matrix1: ");
        Scanner input = new Scanner(System.in);
        double[][] matrix1 = {
                {input.nextDouble(), input.nextDouble()},
                {input.nextDouble(), input.nextDouble()}};
        System.out.println("Enter matrix2: ");
        double[][] matrix2 = {
                {input.nextDouble(), input.nextDouble()},
                {input.nextDouble(), input.nextDouble()}};

        double[][] matrix3 = addMatrix(matrix1, matrix2);

        for (int row = 0; row < matrix3.length; row++) {
            for (int column = 0; column < matrix3[row].length; column++) {
                System.out.print(matrix3[row][column] + " ");
            }
            System.out.println();
        }
        }

}
