import java.util.Scanner;

public class Exercise_8_06 {
    public static double[][] multiplyMatrix(double[][] a, double[][] b){
        double[][] product = new double[3][3];
        for (int row = 0; row < b.length; row++) {
            for (int column = 0; column < b[row].length; column++) {
                for (int i = 0; i < b.length; i++) {
                    product[row][column] += a[row][i] * b[i][column];
                }
            }
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println("Enter two 3x3 matrices. Enter matrix1: ");
        Scanner input = new Scanner(System.in);
        double[][] matrix1 = {
                {input.nextDouble(), input.nextDouble(), input.nextDouble()},
                {input.nextDouble(), input.nextDouble(), input.nextDouble()},
                {input.nextDouble(), input.nextDouble(), input.nextDouble()}};
        System.out.println("Enter matrix2: ");
        double[][] matrix2 = {
                {input.nextDouble(), input.nextDouble(), input.nextDouble()},
                {input.nextDouble(), input.nextDouble(), input.nextDouble()},
                {input.nextDouble(), input.nextDouble(), input.nextDouble()}};

        double[][] matrix3 = multiplyMatrix(matrix1, matrix2);

        for (int row = 0; row < matrix3.length; row++) {
            for (int column = 0; column < matrix3[row].length; column++) {
                System.out.printf("%.1f%s", matrix3[row][column], " ");
            }
            System.out.println();
        }
    }
}
