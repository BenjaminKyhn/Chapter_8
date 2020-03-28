import java.util.Scanner;

public class Exercise_8_28 {
    public static void main(String[] args) {
        int[][] list1 = new int[3][3];
        int[][] list2 = new int[3][3];

        // Get input for list 1
        System.out.println("Enter list1 (9 integers): ");
        Scanner input = new Scanner(System.in);
        for (int row = 0; row < list1.length; row++) {
            for (int column = 0; column < list1[row].length; column++) {
                list1[row][column] = input.nextInt();
            }
        }

        // Get input for list 2
        System.out.println("Enter list2 (9 integers): ");
        for (int row = 0; row < list2.length; row++) {
            for (int column = 0; column < list2[row].length; column++) {
                list2[row][column] = input.nextInt();
            }
        }

        System.out.println("The two arrays are " + (equals(list1, list2) ? "" : "not ") + "strictly identical");
    }

    public static boolean equals(int[][] m1, int[][] m2){
        for (int row = 0; row < m1.length; row++) {
            for (int column = 0; column < m1[row].length; column++) {
                if (m1[row][column] != m2[row][column])
                    return false;
            }
        }
        return true;
    }
}
