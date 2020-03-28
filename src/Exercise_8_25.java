public class Exercise_8_25 {
    public static void main(String[] args) {
        double[][] matrix = {
                {0.15, 0.875, 0.375},
                {0.55, 0.005, 0.225},
                {0.30, 0.12, 0.4},
        };

        System.out.println("It is " + (isMarkovMatrix(matrix) ? "" : "not ") + "a Markov matrix");
    }

    public static boolean isMarkovMatrix(double[][] m){
        for (int column = 0; column < m[0].length; column++) {
            double sum = 0;
            for (int row = 0; row < m.length; row++) {
                if (m[row][column] >= 0)
                    sum += m[row][column];
                else
                    return false;
            }
            if (sum != 1)
                return false;
        }
        return true;
    }
}
