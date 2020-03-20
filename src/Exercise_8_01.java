public class Exercise_8_01 {
    public static double sumRow(double[][] m, int rowIndex){
        double sum = 0;
        for (int i = 0; i < m[rowIndex].length; i++) {
            sum = sum + m[rowIndex][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        double[][] array = new double[3][4];
        double[][] numbers = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                array[row][column] = Math.random()*10;
            }
        }

        System.out.println(sumRow(array, 2));
        System.out.println(sumRow(numbers,1));
    }
}
