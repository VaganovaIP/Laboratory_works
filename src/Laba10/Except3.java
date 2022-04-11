package Laba10;

public  class Except3 {
    public static int m(){
        System.out.println("Пример 10");
        try {
            System.out.println("0");
            return 15;
        } finally {
            System.out.println("1");
            return 20;
        } }
    public static void main(String[] args) {
        System.out.println(m());
    }
}
