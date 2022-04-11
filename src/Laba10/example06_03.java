package Laba10;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
/*
Задание 2
В программе, где требуется из матрицы вывести столбец с номером, заданным с
клавиатуры, могут возникать ошибки в следующих случаях:
– ввод строки вместо числа;
– нет столбца с таким номером.
 */
public class example06_03 {
    public static void main(String[] args) {
        MATRIX();
        MATRIXnot();
    }
    //с использованием собственных методов
    public static void MATRIX(){
        System.out.println("1 cпособ: c использованием собственных методов");
        Random random = new Random();
        int i, j;
        Scanner InCMD = new Scanner(System.in);
        int [][] matrix = new int [4][5];
            for (i = 0; i < 4; i++) {
                for (j = 0; j < 5; j++) {
                    matrix[i][j] = random.nextInt(15);
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
        try {
            System.out.println("Введите номер столбца для вывода ");
            int n = InCMD.nextInt();
            System.out.println("Элементы " + n + " столбца ");
            for (i = 0; i < 4; i++) {
                for (j = 0; j < n; j++) {
                    if (j == n - 1) System.out.println(matrix[i][j] + " ");
                }
            }
        }
        catch(InputMismatchException e){
            System.out.println("Несоответствие числового типа данных "+ e);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Нет столбца с таким номером "+ e);
        }
    }
    //без использования собственных методов
    public static void MATRIXnot(){
        System.out.println("2 cпособ: без использования собственных методов");
        Random random = new Random();
        int i, j;
        Scanner InCMD = new Scanner(System.in);
        int [][] matrix = new int [4][5];
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 5; j++) {
                matrix[i][j] = random.nextInt(15);
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        try {
            System.out.println("Введите номер столбца для вывода ");
            int n = InCMD.nextInt();
            System.out.println("Элементы " + n + " столбца ");
            for (i = 0; i < 4; i++) {
                for (j = 0; j < n; j++) {
                    if (j == n - 1) System.out.println(matrix[i][j] + " ");
                }
            }
        }
        catch(Exception e){
            System.out.println("Ошибка ввода");
        }
    }
}
