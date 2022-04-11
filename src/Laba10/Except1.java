package Laba10;

public class Except1{
    public static  int m(){
        System.out.println("Пример 8");
        try {
            System.out.println("0");
            throw new RuntimeException();//создание экземпляра RuntimeException
        } finally {
            System.out.println("1");
        }
    }
    public static void main(String[] args) {
        System.out.println(m());
    }
}
