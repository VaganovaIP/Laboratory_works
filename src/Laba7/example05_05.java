package Laba7;

import java.util.Scanner;

public class example05_05 {
    public static void main(String[] args) {
        Scanner InCMD = new Scanner(System.in);
        //
        System.out.println("Input value (string)");
        Super_class5 class_1 = new Super_class5(InCMD.nextLine());
        //
        System.out.println("\nInput value (string) (int) ");
        Subclass5_1 class_2 = new Subclass5_1(InCMD.next(), InCMD.nextInt());
        //
        System.out.println("\nInput value (string) (char) ");
        Subclass5_2 class_3 = new Subclass5_2(InCMD.next(),InCMD.next().charAt(0));
        System.out.println("======================================================");
        Super_class5 ref;
        ref = class_1;
        ref.getClassAndField();
        ref = class_2;
        ref.getClassAndField();
        ref = class_3;
        ref.getClassAndField();
    }
}
class Super_class5 {
    protected String str;
    Super_class5(String s) {
        str = s;
    }
    public void getClassAndField() {
        System.out.println(toString() + "  value : " + str);
    }
    public final String toString() {
        return "Name class:  " + this.getClass().getName();
    }
}
class Subclass5_1 extends Super_class5 {
    protected int num;
    Subclass5_1(String s, int n) {
        super(s);
        num = n;
    }
    public void getClassAndField() {
        System.out.println(toString() + " values : (string)  " + str + " (int) "+num);
    }
}
class Subclass5_2 extends Super_class5 {
    protected char sym;
    Subclass5_2(String s, char ch) {
        super(s);
        sym = ch;
    }
    public void getClassAndField() {
        System.out.println(toString() + " values : (string)  " + str + " (char) "+ sym);
    }
}