package Laba12;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/*
2-й проект – работа через сериализацию
Записать в исходный файл информацию о фильмах:
Название_фильма, год_выпуска, страна, жанр, стоимость_проката
Количество фильмов задать с клавиатуры.
Создать программным способом другой файл и переписать в него
информацию о фильмах, выпущенных в России.
 */
class Cinema implements Serializable {
    String  name_f,    //
            age_f,     //
            country_f, //
            genre_f;   //
    double price_f;    //

    public Cinema(String name_f, String age_f, String country_f, String genre_f, Double price_f) {
        this.name_f = name_f;
        this.age_f = age_f;
        this.country_f = country_f;
        this.genre_f = genre_f;
        this.price_f = price_f;
    }

}
public class example06_03_2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in, "utf8");
        File f = new File("src/Laba12/Фильмы - 2 проект");
        f.createNewFile();
        System.out.print("Введите количество фильмов для записи в файл\n"
                + "=> ");
        int kol = sc.nextInt();
        //создание массива объектов
        Cinema[] film_all = new Cinema[kol];
        sc.nextLine();
        String name_f, age_f, country_f, genre_f;
        Double price_f;
        for (int i = 0; i < kol; i++) {
            sc.nextLine();
            System.out.println("Введите информацию о фильме: ");
            System.out.print("Название фильма => ");
            name_f = sc.nextLine();
            System.out.print("Год выпуска  => ");
            age_f = sc.nextLine();
            System.out.print("Страна  => ");
            country_f = sc.nextLine();
            System.out.print("Жанр  => ");
            genre_f = sc.nextLine();
            System.out.print("Стоимость проката  => ");
            price_f = sc.nextDouble();
            film_all[i] = new Cinema(name_f,age_f,country_f,genre_f,price_f);
        }
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeInt(film_all.length);
        for(Cinema film:film_all){
            oos.writeObject(film);
        }
        oos.flush();
        oos.close();
        //переписывание информации о фильмах, выпущенных в России
        try {
                PrintWriter out=null;
                File f2 = new File("src/Laba12/Фильмы России - 2 проект.txt");
                f2.createNewFile(); //создание файла
                out = new PrintWriter("src/Laba12/Фильмы России - 2 проект.txt","UTF8");
                out.println("Название_фильма \t\t Год_выпуска \t\t Страна \t\t Жанр \t\t Стоимость_проката ");
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream oin = new ObjectInputStream(fis);
                int filmCount = oin.readInt();
                Cinema[] filmR = new Cinema[filmCount];
                for (int i = 0; i < filmCount; i++) {
                    filmR[i] = (Cinema) oin.readObject();
                    if (filmR[i].country_f.equals("Россия")){
                        out.println(filmR[i].name_f + "\t\t" + filmR[i].age_f + "\t\t" + filmR[i].country_f +
                                "\t\t" + filmR[i].genre_f + "\t\t" + filmR[i].price_f);
                    }
                }
                out.flush();
                out.close();
                oin.close();
        }catch(ClassNotFoundException e){}

    }
}
