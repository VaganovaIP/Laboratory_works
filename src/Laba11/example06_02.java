package Laba11;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;
/*
Создать проект, позволяющий из одного, предварительно
созданного программными средствами файла, переписать данные,
соответствующие условию - в исходном файле содержится две строки в
формате UTF-8 и 5 чисел типа double. В результирующий файл переписать
вторую строку и положительные числа.
*/

public class example06_02 {
    public static void main(String[] args) throws IOException{
        Scanner sc= new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.print("Введите имя файла: ");
        String fname = sc.nextLine();
        try{
            File f1 = new File("src/Laba11/" +fname);
            f1.createNewFile(); //создание файла
            System.out.println("Полный путь файла: "+ f1.getAbsolutePath());
            DataOutputStream dOut = new DataOutputStream( new FileOutputStream(f1));//поток ввода
           for (int i = 0; i < 2; i++) {
                System.out.print("Введите строку для записи в файл => ");
                String s = sc.nextLine();
                dOut.writeUTF(s+"\n");
            }
            System.out.print("Введите 5 чисел типа double для записи в файл => ");
            for (int i = 0; i < 5; i++) {
                Double num = sc.nextDouble();
                dOut.writeDouble(num);
            }
            dOut.flush(); // дописываем несохраненные данные на диск
            dOut.close(); // закрываем поток
            File f2 = new File("src/Laba11/Результат.txt");
            f2.createNewFile();
            DataInputStream rd = new DataInputStream(new FileInputStream(f1));//поток чтения
            DataOutputStream wr = new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));
            int k = 0;
            try{
                while(true){
                // положительные числа
                if(k > 1) {
                    double number = rd.readDouble();
                    if(number > 0){
                    wr.writeDouble(number);
                    }
                } else {
                    //вторая строка
                    if(k==1) {
                        String s = rd.readUTF();
                        wr.writeUTF(s);
                    } else rd.readUTF();
                }
                k++;
                }
            }catch(EOFException e){}
                wr.flush();
                wr.close();
                rd.close();
            }catch(EOFException e){}

    }
}

