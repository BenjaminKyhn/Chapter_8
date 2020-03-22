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
        print(convertStringToChar(decToBin(number)));
    }

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

    public static String padToNinePlaces(String bin) {
        if (bin.length() < 9) {
            for (int i = bin.length(); i < 9; i++) {
                bin = "0" + bin;
            }
        }
        return bin;
    }

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

    public static void print(String bin) {
        for (int i = 0; i < bin.length(); i++) {
            if (i % 3 == 0 && i != 0)
                System.out.print("\n " + bin.charAt(i) + " ");
            else
                System.out.print(" " + bin.charAt(i) + " ");
        }
    }
}

