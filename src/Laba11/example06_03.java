package Laba11;

import java.io.*;

/*
Задание 3. Создать проект, позволяющий из одного текстового файла,
содержащего несколько строк (тип String) заранее подготовленного текста
на русском языке (Пушкин, Лермонтов или другой российсмки классик на
Ваш вкус), построчно переписать в другой текстовый файл слова
начинающиеся с согласных букв.
Требования:
– слова из предложения выделять методом split();
– в новом файле следует указать номер строки, в которой иско- мые
слова находились в исходном файле;
– для каждой строки указать количество выбранных слов.
 */
public class example06_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        PrintWriter out=null;
        try {
            String letters = "бБвВгГдДжЖзЗйЙкКлЛмМнНпПрРсСтТфФхХцЦчЧшШщЩ";
            // Создание потоков
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("src/Laba11/Текст для тестирования.txt"),"UTF8"));
            File f1 = new File("src/Laba11/Результат.txt");
            f1.createNewFile(); //создание файла
            out = new PrintWriter("src/Laba11/Результат.txt","UTF8");
            int lineCount = 0;
            int wordCount = 0;
            String s;
            char sym;
            while ((s = br.readLine()) != null) {
                wordCount = 0;
                if (s.length() != 0) {
                    out.print("Строка № " + lineCount + ": ");
                    for (String word : s.split(" ")) {
                        if (letters.contains(word.substring(0, 1))){
                            out.print(word + " ");
                            wordCount++;
                        }
                    }
                } else out.print("Строка № " + lineCount +": ");
                out.print(" Количество слов: " + wordCount);
                lineCount++;
                out.println();
            }
        } catch (IOException e) {
            System.out.println("Ошибка!"); }
        finally{
            br.close();
            out.flush();
            out.close();
        }
    }
}
