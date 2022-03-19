package Laba7;

import java.util.Scanner;

public class example05_04 {
    public static void main(String[] args) {
        Scanner InCMD = new Scanner(System.in);
        //
        System.out.println("Input value (char)");
        Class4_1 class_1 = new Class4_1(InCMD.next().charAt(0));
        Class4_1 class_1_copy = new Class4_1(class_1);
        System.out.println("Value char  " + class_1_copy.sym);
        //
        System.out.println("\nInput value (char) (string) ");
        Class4_2 class_2 = new Class4_2(InCMD.next().charAt(0),InCMD.next());
        Class4_2 class_2_copy = new Class4_2(class_2);
        System.out.println("Value (char)" + class_2_copy.sym + "(string) " + class_2_copy.text);
        //
        System.out.println("\nInput value (char) (string) (int)");
        Class4_3 class_3 = new Class4_3(InCMD.next().charAt(0),InCMD.next(), InCMD.nextInt());
        Class4_3 class_3_copy = new Class4_3(class_3);
        System.out.println("Value (char)" + class_3_copy.sym + "(string) " + class_3_copy.text + " (int) " + class_3_copy.num);
    }
}
class Class4_1{
    public char sym;
    Class4_1(char s) {
        sym = s;
    }
    public Class4_1(Class4_1 copy){
       sym = copy.sym;
    }
}
class Class4_2 extends Class4_1{
    public String text;
    Class4_2(char s, String str) {
        super(s);
        text = str;
    }

    public Class4_2(Class4_2 copy) {
        super(copy);
        text = copy.text;
    }
}
class Class4_3 extends Class4_2{
    public int num;
    Class4_3(char s, String str,int n) {
        super(s, str);
        num = n;
    }
    Class4_3(Class4_3 copy){
        super(copy);
        num = copy.num;
    }
}
