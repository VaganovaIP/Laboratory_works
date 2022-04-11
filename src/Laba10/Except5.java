package Laba10;

import java.io.*;
public class Except5 {
    public static void m(String str, double chislo){
        //при выполнении условия бросается соответствующее исключение
        if (str==null) {
            throw new IllegalArgumentException("Строка введена неверно");
        }
        if (chislo>0.001) {
            throw new IllegalArgumentException("Неверное число");

        } }
    public static void main(String[] args) {
        System.out.println("Пример 12");
        m(null,0.000001);
    }
}
