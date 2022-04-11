package Laba10;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
Задание 3
В программе, вычисляющей сумму элементов типа byte одномерного массива,
вводимого с клавиатуры, могут возникать ошибки в следующих случаях:
– ввод строки вместо числа;
– ввод или вычисление значения за границами диапазона типа.
 */
public class example06_04 {
    public static void main(String[] args) {
        System.out.println(SUM_M());
        System.out.println(SUM_Mnot());
    }
    //с использованием собственных методов
    public static byte SUM_M(){
        System.out.println("1 cпособ: c использованием собственных методов");
        int sum = 0; int i;
        Scanner InCMD = new Scanner(System.in);
        byte [] arr = new byte [7];
        try {
            System.out.println("Введите 7 элементов массива типа byte (число от -128 до 127):");
            for (i = 0; i < 7; i++)
                arr[i] = Byte.parseByte(InCMD.nextLine());

            for (i = 0; i < arr.length; i++) {
                sum = sum + arr[i];
            }
            if (sum > 127 || sum < -128){
                throw new NumberFormatException("Сумма выходит за границы типа byte ");
            }
        } catch(InputMismatchException e){
            System.out.println("Несоответствие числового типа данных не byte "+ e);
        }catch (NumberFormatException e){
            System.out.println("Несоответствие числового типа данных не byte "+ e);
        }
        return (byte) sum;
    }
    //
    public static byte SUM_Mnot(){
        System.out.println("2 cпособ: без использования собственных методов");
        int sum = 0; int i;
        Scanner InCMD = new Scanner(System.in);
        byte [] arr = new byte [7];
        try {
            System.out.println("Введите 7 элементов массива типа byte (число от -128 до 127):");
            for (i = 0; i < 7; i++)
                arr[i] = Byte.parseByte(InCMD.nextLine());

            for (i = 0; i < arr.length; i++) {
                sum = sum + arr[i];
            }
            if (sum > 127 || sum < -128) {
                System.out.println("Сумма выходит за границы типа byte");
            }
        }catch (Exception e){
            System.out.println("Ошибка ввода");
        }
        return (byte) sum;
    }
}
