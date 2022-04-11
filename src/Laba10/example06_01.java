package Laba10;

public class example06_01 {
    public static void main(String[] args) {
        Pr1();
        Pr2();
        Pr3();
        Pr4();
        //Pr5();
        //Pr6();
        //Pr7();
    }
    public static void Pr1(){
        System.out.println("Пример 1");
        //в блок try заключаем код, в котором может произойти исключение
        try {
            System.out.println("0");

            throw new RuntimeException("Непроверяемая ошибка");//генерация исключения
        } catch (RuntimeException e) { // перехват исключения
            System.out.println("1 "+ e); // обработка исключения
        }
        System.out.println("2");
    }
    public static void Pr2() {
        System.out.println("Пример 2");
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
            //System.out.println("1");//строка не будет выполнена
        } catch (Exception e) {
            System.out.println("2 "+ e );
        }
        System.out.println("3");
    }
    public static void Pr3() {
        System.out.println("Пример 3"); //перехват исключений подходящим классом
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) { //перехват исключения пустой ссылки
            System.out.println("1" );
        }catch (RuntimeException e) {
            System.out.println("2" );
        }catch (Exception e) {
            System.out.println("3" );
        }
        System.out.println("4");
    }
    public static void Pr4() {
        System.out.println("Пример 4");//перехват исключений подходящим классом
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {//перехват пустой ссылки
            System.out.println("1" );
        }catch (Exception e) {//Перехват исключений для обработки программой
            System.out.println("2" );
        }catch (Error e) {//Error служит для обработки ошибок в самом языке Java
            System.out.println("3" );
        }
        System.out.println("4");
    }
    public static void Pr5() {
        System.out.println("Пример 5");
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");//генерация исключения (не сработает)
            //исключение не будет перехвачено
        } catch (NullPointerException e) {
            System.out.println("1" );
        }
        //нужно добавить перехват исключения RuntimeException
       /* catch (RuntimeException e) { // перехват исключения
            System.out.println("перехват "+ e); // обработка исключения
        }*/
        System.out.println("2");
    }

    public static void Pr6() {
        System.out.println("Пример 6");
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (ArithmeticException e){//ошибка ArithmeticException потомок RuntimeException
            System.out.println("1" );
        }catch (Exception e) {
            System.out.println("2" );
        /*} catch (RuntimeException e) {//исключение не будет перехвачено, т.к. нарушена иерархия классов
            System.out.println("3" );
        */}
        System.out.println("4");
    }
    public static void Pr7() {
        System.out.println("Пример 7");
        try {
               System.out.println("0");
               throw new NullPointerException("ошибка");
                } catch (NullPointerException e) {
                System.out.println("1" );
                throw new ArithmeticException();//для перехвата исключения надо создать новый обработчик
            } catch (ArithmeticException e) {
                System.out.println("2" );
            }
        System.out.println("3");
    }
}
