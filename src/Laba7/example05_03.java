package Laba7;

import java.util.Scanner;

public class example05_03 {
    public static void main(String[] args) {
        Scanner InCMD = new Scanner(System.in);
        //
        System.out.println("Input value (int)");
        Super_class3 class_1 = new Super_class3(InCMD.nextInt());
        System.out.println(class_1.toString());
        //
        System.out.println("\nInput value (int) (char) ");
        SubClass3_1 subclass3_1 = new SubClass3_1(InCMD.nextInt(), InCMD.next().charAt(0));
        System.out.println(subclass3_1.toString());
        //
        System.out.println("\nInput value (int) (char) (string)");
        SubClass3_2 subclass3_2 = new SubClass3_2(InCMD.nextInt(), InCMD.next().charAt(0), InCMD.next());
        System.out.println(subclass3_2.toString());
        InCMD.close();
    }
}
class Super_class3{
    public int num;
    public void Value_assignment(int a) {
        num = a;
    }
    public Super_class3(int num) {
        this.num = num;
    }
    @Override
    public String toString() {
        return "Name class:  " + this.getClass().getSimpleName()  + "|"  + "  Value of number: " + num;
    }
}
class SubClass3_1 extends Super_class3{
    public char sym;
    SubClass3_1(int n, char s) {
        super(n);
        sym = s;
    }
    public void setNumber(int n, char s) {
        num = n;
        sym = s;
    }
    @Override
    public String toString() {
        return "Name class:  " + this.getClass().getSimpleName()  + "|"  + "  Value of number: " + num + " char: " + sym ;
    }
}

class SubClass3_2 extends SubClass3_1{
    public String text;
    SubClass3_2(int n, char s, String str) {
        super(n, s);
        text = str;
    }
    public void SubClass3_2(int n, char s, String str) {
        num = n;
        sym = s;
        text = str;
    }
    @Override
    public String toString() {
        return "Name class:  " + this.getClass().getSimpleName()  + "|"  + "  Value of number: " + num + " char: " + sym + " string: " + text;
    }
}
