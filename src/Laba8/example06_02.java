package Laba8;

import java.util.Scanner;

public class example06_02 {
    public static void main(String[] args) {
        Scanner InCMD = new Scanner(System.in);
        System.out.println("Input number ");
        System.out.println(Binary(InCMD.nextInt()));
    }
    public static String Binary(int x){
        if (x <= 0) {
            return (String.valueOf(x));
        }
        return Binary(x/2) + String.valueOf(x%2);
    }
}
