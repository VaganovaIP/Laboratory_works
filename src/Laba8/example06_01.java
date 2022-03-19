package Laba8;

import java.util.Scanner;
//пример1
public class example06_01 {
    public static void main(String[] args) {
        Scanner InCMD = new Scanner(System.in);
        //
        System.out.println("Input n =  ");
        int n = InCMD.nextInt();
        System.out.println("Rec1: ");
        Rec1(n);
        System.out.println("Rec2: ");
        Rec2(n);
        System.out.println("Rec3: ");
        Rec3(n);
        System.out.println("Rec4: Factorial "+n+" = "+ fact(n));
        System.out.println("Input n =  ");
        int n2 = InCMD.nextInt();
        System.out.println("Rec5: Fibonacci " + n2);
        for (int i = 0; i <= n2; i++) {
            int result = f(i);
            System.out.print(result + " ");
        }
    }
    public static void Rec1(int x) {
        System.out.println("x=" + x);
        if ((2 * x + 1) < 20) {
            Rec1(2 * x + 1);
        }
    }
    public static void Rec2(int x) {
        if ((2 * x + 1) < 20) {
            Rec2(2 * x + 1);
        }
        System.out.println("x=" + x);
    }
    public static void Rec3(int x) {
        space();
        System.out.println("" + x + "-> ");
        step++;
        if ((2 * x + 1) < 20) {
            Rec3(2 * x + 1);
        }
        step --;
        space();
        System.out.println("" + x + " <-");
    }
    private static int step = 0;
    public static void space() {
        for (int i = 0; i < step; i++) {
            System.out.print(" ");
        }
    }
    public static int fact(int n){
        int result;
        if (n==1)
            return 1;
        else{
            result=fact(n-1)*n;
            return result;
        }
    }
    public static int f(int n){
        if (n==0){
            return 0;
        }else
        if (n==1){
            return 1;
        } else {
            return f(n-2)+f(n-1);
        }
    }
}



