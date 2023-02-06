import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        Scanner scanInput2 = new Scanner(System.in);

        System.out.println("Input the Value from 0<x <100");

        int inputNumber = scanInput.nextInt();

        System.out.println("Input the Object Name ");

        String inputString = scanInput2.nextLine();

        returnRatio(inputNumber,inputString );

        scanInput.close();
        scanInput2.close();

    }

    private static void returnRatio(int inputNumber, String inputString) {
    }
}
