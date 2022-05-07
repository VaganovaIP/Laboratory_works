package Laba12;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;
/*
1-й проект – работа с файлом с произвольным доступом
Записать в исходный файл информацию о фильмах:
Название_фильма, год_выпуска, страна, жанр, стоимость_проката
Количество фильмов задать с клавиатуры.
Создать программным способом другой файл и переписать в него
информацию о фильмах, выпущенных в России.
 */
public class example06_03_1 {
    public static void main(String[] args) {
        try {
            File f1 = new File("src/Laba12/Фильмы - 1 проект.txt");
            if (!f1.exists())
                f1.createNewFile();
            RandomAccessFile rf = new RandomAccessFile(f1,"rw"); // чтение и запись
            Scanner sc = new Scanner(System.in, "UTF8");
            System.out.print("Введите количество фильмов для записи в файл\n"
                    + "=> ");
            int kol = sc.nextInt();
            sc.nextLine(); // очистка буфера после ввода числа
            String name_f, age_f, country_f, genre_f;
            Double price_f;
            //----ЗАПИСЬ ИНФОРМАЦИИ О ФИЛЬМАХ В ФАЙЛ----
            for (int i = 0; i < kol; i++) {
                System.out.print("Введите название " + (i + 1) + " фильма => ");
                name_f = sc.next();
                rf.seek(rf.length()); // поиск конца файла
                rf.writeUTF(name_f); // названия фильма
                for (int j = 0; j < 20 - name_f.length(); j++)
                    rf.writeByte(1);
                System.out.print("Введите год выпускa => ");
                age_f = sc.next();
                rf.writeUTF(age_f); // запись года выпуска
                for (int j = 0; j < 20 - age_f.length(); j++)
                    rf.writeByte(1);
                System.out.print("Введите страну => ");
                country_f = sc.next();
                rf.writeUTF(country_f); // запись страны
                for (int j = 0; j < 20 - country_f.length(); j++)
                    rf.writeByte(1);
                System.out.print("Введите жанр фильма => ");
                genre_f = sc.next();
                rf.writeUTF(genre_f); // запись жанра
                for (int j = 0; j < 20 - genre_f.length(); j++)
                    rf.writeByte(1);
                System.out.print("Введите стоимость проката => ");
                price_f = sc.nextDouble();
                sc.nextLine();
                rf.writeDouble(price_f); // запись стоимости проката
            }

            rf.close();
            //переписывание информации о фильмах, выпущенных в России
            PrintWriter out=null;
            File f2 = new File("src/Laba12/Фильмы России - 1 проект.txt");
            f2.createNewFile(); //создание файла
            out = new PrintWriter("src/Laba12/Фильмы России - 1 проект.txt","UTF8");
            out.println("Название_фильма \t Год_выпуска \t Страна \t Жанр \t Стоимость_проката ");
            rf = new RandomAccessFile(f1, "r");
            rf.seek(0); // перемещение в начало файла
            System.out.println("Название_фильма \t Год_выпуска \t Страна \t Жанр \t Стоимость_проката ");
            for (int i = 0; i < kol; i++) {
                name_f = rf.readUTF();
                for (int j = 0; j < 20 - name_f.length(); j++)
                    rf.readByte();
                age_f = rf.readUTF();
                for (int j = 0; j < 20 - age_f.length(); j++)
                    rf.readByte();
                country_f = rf.readUTF();
                for (int j = 0; j < 20 - country_f.length(); j++)
                    rf.readByte();
                genre_f = rf.readUTF();
                for (int j = 0; j < 20 - genre_f.length(); j++)
                    rf.readByte();
                price_f = rf.readDouble();
                if(country_f.equals("Россия")) {
                    out.println(name_f + "\t\t\t" + age_f + "\t\t\t" + country_f + "\t\t\t" + genre_f + "\t\t\t" + price_f);
                }
            }
            out.flush();
            out.close();
            rf.close();
        } catch (IOException e) {
            System.out.println("End of file " + e);
        }
    }
}
