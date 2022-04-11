package Laba10;

public class Except2 {
    public static int m(){
        System.out.println("Пример 9");
        try {
            System.out.println("0");
            return 55; // выход из метода
        // блок кода finally будет выполнен после завершения блока try/catch
        //Оператор finally не обязателен, но оператор try требует наличия либо catch, либо finally.
        } finally {
            System.out.println("1");
        } }
    public static void main(String[] args) {
        System.out.println(m());
    }
}
