package Laba7;

import java.util.Scanner;

public class example05_01 {
    public static void main(String[] args) {
        Scanner InCMD = new Scanner(System.in);
        //
        System.out.println("Input string: ");
        Super_class class1_s = new Super_class(InCMD.nextLine());
        String str1 = class1_s.toString();
        System.out.println(str1);
        //
        System.out.println("\nInput string: ");
        Subclass subclass1 = new Subclass(InCMD.nextLine());
        str1 = subclass1.toString();
        System.out.println(str1);
        //
        System.out.println("\nInput two strings: ");
        Subclass subclass2 = new Subclass(InCMD.nextLine(), InCMD.nextLine());
        str1 = subclass2.toString();
        System.out.println(str1);
        InCMD.close();
    }
}

class Super_class {
    private String str1;
    public Super_class(String str1) {
        this.str1 = str1;
    }
    @Override
    public String toString() {
        String str;
        str = "Name class: " + this.getClass().getSimpleName() +"|" + "Value str: " + str1;
        return str;
    }
    public String getStr1() {
        return str1;
    }
}
class Subclass extends Super_class{
    private String str2;
    @Override
    public String toString() {
        String str;
        if (str2==null) str = "Name class:  " + this.getClass().getSimpleName()  + "|" + " Value str: " + getStr1();
        else str = "Name class:  " + this.getClass().getSimpleName() +"|" + " Value str1: " + getStr1() + "|" + " Value str2: " + str2;
        return str;
    }
    public Subclass(String str1) {
        super(str1);
    }
    public Subclass(String s1, String s2) {
        super(s1);
        str2 = s2;
    }
}

