package Laba10;

public class Except6 {
    public static void main(String[] args) {
        System.out.println("Пример 13");
        try {
            int l = args.length;
            System.out.println("размер массива= " + l);
            int h=10/l;
            args[l + 1] = "10";
        } catch (ArithmeticException e) {//перехват исключения арифметической ошибки
            System.out.println("Деление на ноль");//обработка исключения
        } catch (ArrayIndexOutOfBoundsException e) {//перехват исключения выхода индекса за границу массива
            System.out.println("Индекс не существует");//обработка исключения
        }
    }
}
