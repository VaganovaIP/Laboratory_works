package Laba8;

import java.util.Scanner;
public class example06_03 {
    public static int i = 0;
    public static void main(String[] args) {
        Scanner InCMD = new Scanner(System.in);
        System.out.println("Size of the array:  ");
        int n = InCMD.nextInt();
        int[] array = new int[n];
        System.out.println("Array fill method");
        Input_mas(array);
        i = 0;
        System.out.println("Array output method");
        Output_mas(array);
    }
    private static void Input_mas(int[] mas) {
        Scanner InCMD = new Scanner(System.in);
        if(i < mas.length){
            mas[i] = InCMD.nextInt();
            i++;
            Input_mas(mas);
        }
    }
    private static void Output_mas(int[] mas) {
        if(i < mas.length){
            System.out.println("massiv[" + (i+1) + "] = " + mas[i]);
            i++;
            Output_mas(mas);
        }
    }
}
