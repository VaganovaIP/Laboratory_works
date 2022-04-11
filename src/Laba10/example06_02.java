package Laba10;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
Задание 1
В программе, вычисляющей среднее значение среди положительных элементов
одномерного массива (тип элементов int), вводимого с клавиатуры, могут
возникать ошибки в следующих случаях:
– ввод строки вместо числа;
– несоответствие числового типа данных;
– положительные элементы отсутствуют.
*/

public class example06_02 {
    public static void main(String[] args) {
        AVG_MNot();
        AVG_M();
    }
    //с использованием методов
    public static void AVG_M() {
        System.out.println("2 cпособ: c использованием собственных методов");
        int sum = 0;
        int i;
        Scanner InCMD = new Scanner(System.in);
        System.out.println("Введите размер массива ");
        try {
            int n = InCMD.nextInt();
            int[] arr = new int[n];
            System.out.println("Введите положительные (int) элементы массива (" + n + ") :");
            for (i = 0; i < n; i++)
                arr[i] = InCMD.nextInt();
            int k=0;
            for (i = 0; i < arr.length; i++) {
                if (arr[i] >= 0) {
                    sum += arr[i];
                    k++;
                }
            }
            if (sum == 0) {
                throw new IllegalArgumentException();
            }
            double avg = sum / k;
            System.out.println("Среднее значение среди положительных элементов = " + avg);
        } catch (InputMismatchException e) {
            System.out.println("Несоответствие числового типа данных "+e);
        } catch (NegativeArraySizeException e) {
            System.out.println("Неправильно введен размер массива " + e);
        }catch(IllegalArgumentException e){
            System.out.println("Нет положительных чисел");
        }
    }

    //с использования методов
    public static void AVG_MNot() {
        System.out.println("1 cпособ: без " +
                "использования собственных методов");
        int sum = 0;
        int i;
        Scanner InCMD = new Scanner(System.in);
        System.out.println("Введите размер массива ");
        try {
            int n = InCMD.nextInt();
            int[] arr = new int[n];
            System.out.println("Введите положительные (int) элементы массива (" + n + ") :");
            for (i = 0; i < n; i++)
                arr[i] = InCMD.nextInt();
            int k=0;
            for (i = 0; i < arr.length; i++) {
                if (arr[i] >= 0) {
                    sum += arr[i];
                    k++;
                }
            }
            if (sum == 0) {
                System.out.println("Нет положительных чисел");
            }
            double avg = sum / arr.length;
            System.out.println("Среднее значение среди положительных элементов = " + avg);
        }catch (Exception e){
            System.out.println("Ошибка ввода");
        }
    }

}

