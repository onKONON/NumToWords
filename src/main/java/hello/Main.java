package hello;

import java.util.Scanner;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter some number: ");
            long input = in.nextLong();
            System.out.println(Num.toString(input));
        }
    }
}
