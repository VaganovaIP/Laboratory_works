package Laba10;

public class Except7 {
    //порождение к исключению арифмитической ошибки, чтобы предохранить от данного исключения
    public static void m(int x) throws ArithmeticException{
        int h=10/x;
    }
    public static void main(String[] args) {
        System.out.println("Пример 14");
        try {
            int l = args.length;
            System.out.println("размер массива= " + l);
            m(l);
        } catch (ArithmeticException e) {//перехват исключения арифметической ошибки
            System.out.println("Ошибка: Деление на ноль");
        }
    }
}