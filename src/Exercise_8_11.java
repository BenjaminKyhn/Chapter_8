import java.util.Scanner;

public class Exercise_8_11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;

        // Keep looping if the user inputs an incorrect number
        do{
            System.out.println("Enter a number between 0 and 511: ");
            number = input.nextInt();
        } while (number < 0 || number > 511);
        printMatrix(coinsMatrix(decToBin(number)));
        //        printString(convertStringToChar(decToBin(number)));
    }

    // Method for converting a decimal number to a String resembling a binary number
    public static String decToBin(int dec) {
        StringBuilder bin = new StringBuilder();
        if (dec == 0) {
            bin.append("0");
        } else {
            while (dec != 0) {
                bin.insert(0, dec % 2);
                dec /= 2;
            }
        }
        return padToNinePlaces(bin.toString());
    }

    // Pad the string with zeroes so that the length of the string is always 9
    public static String padToNinePlaces(String bin) {
        if (bin.length() < 9) {
            for (int i = bin.length(); i < 9; i++) {
                bin = "0" + bin;
            }
        }
        return bin;
    }

    // Convert the 0's and 1's in the binary String to H's and T's
    public static String convertStringToChar(String s){
        StringBuilder headsTails = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                headsTails.append('H');
            else
                headsTails.append('T');
        }
        return headsTails.toString();
    }

    public static char[][] coinsMatrix(String bin){
        int charNumber = 0;
        char[][] coinsMatrix = new char[3][3];
        for (int row = 0; row < coinsMatrix.length; row++) {
            for (int column = 0; column < coinsMatrix[row].length; column++) {
                if (bin.charAt(charNumber) == '0')
                    coinsMatrix[row][column]= 'H';
                else
                    coinsMatrix[row][column]= 'T';
                charNumber++;
            }
        }
        return coinsMatrix;
    }

    // Print out the String in a 3x3 formation
    public static void printString(String bin) {
        for (int i = 0; i < bin.length(); i++) {
            if (i % 3 == 0 && i != 0)
                System.out.print("\n " + bin.charAt(i) + " ");
            else
                System.out.print(" " + bin.charAt(i) + " ");
        }
    }

    public static void printMatrix(char[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}

