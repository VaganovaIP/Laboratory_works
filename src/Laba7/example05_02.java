package Laba7;

import java.util.Scanner;

public class example05_02 {
    public static void main(String[] args) {
        Scanner InCMD = new Scanner(System.in);
        System.out.println("Input value (string)");
        Super_class2 class_1 = new Super_class2(InCMD.nextLine());
        System.out.println("Value: " + class_1.toString());
        System.out.printf("\nLength text: %d ",class_1.Length_str());
        class_1.Value_assignment();
        System.out.println("\nInput value (string) (int)");
        SubClass2 class_2 = new SubClass2(InCMD.nextLine(), InCMD.nextInt());
        System.out.println("Value: (string) " + class_2.toString() + " (int) " + class_2.num);
        System.out.printf("Length text: %d\n", class_2.Length_str());
        class_2.Value_assignment();
        System.out.println("Value : " + class_2.toString() +  " (int) " + class_2.num);
    }
}
class Super_class2 {
    private String Str1;
    @Override
    public String toString() {
        return  Str1;
    }
    //конструктор
    public Super_class2(String str1) {
        this.Str1 = str1;
    }
    public void Value_assignment() {
        Str1 = "null value";
    }
    public void Value_assignment(String a) {
        Str1 = a;
    }
    final int Length_str(){
        return Str1.length();
    }
}
class SubClass2 extends Super_class2{
    public int num;
    public SubClass2(String str1, int b) {
        super(str1);
        num = b;
    }
    public void Value_assignment() {
        super.Value_assignment();
        num = 0;
    }
    public void Value_assignment(String a) {
        Value_assignment(a);
    }
    public void Value_assignment(String a, int n) {
        Value_assignment(a);
        num = n;
    }
}