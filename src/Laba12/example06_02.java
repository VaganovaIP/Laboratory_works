package Laba12;

import java.io.*;
/*
Создать проект, позволяющий из одного текстового
файла, содержащего несколько строк (тип String) заранее
подготовленного текста на русском языке (обратитесь к классике),
построчно переписать в другой текстовый файл слова, отвечающие
условию.
Условие:
Переписать в результирующий файл слова, которые начинаются с той же
буквы, что и первое слово.
Требования:
– слова из предложения выделять методом split();
– в новом файле следует указать номер строки, в которой искомые
слова находились в исходном файле;
– для каждой строки указать количество выбранных слов.
 */
class example06_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        PrintWriter out=null;
        try {
            // Создание потоков
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("src/Laba12/Текст для тестирования.txt"),"UTF8"));
            File f1 = new File("src/Laba12/Результат.txt");
            f1.createNewFile(); //создание файла
            out = new PrintWriter("src/Laba12/Результат.txt","UTF8");
            int lineCount = 0;
            int wordCount = 0;
            String s,s1, firstStr;
            firstStr = br.readLine();
            s1 = firstStr.toLowerCase();
            firstStr = firstStr.substring(0, 1);
            wordCount = 0;
            //первая строка
            if (s1.length() != 0) {
                out.print("Строка № " + lineCount + ": ");
                for (String word : s1.split(" ")) {
                    if (word.substring(0, 1).equals(firstStr.toLowerCase())){
                            out.print(word + " ");
                            wordCount++;
                        }
                    }
            } else out.print("Строка № " + lineCount +": ");
                out.print(" Количество слов: " + wordCount);
                lineCount++;
                out.println();

            while ((s = br.readLine()) != null) {
                s = s.toLowerCase();
                wordCount = 0;
                if (s.length() != 0) {
                    out.print("Строка № " + lineCount + ": ");
                    for (String word : s.split(" ")) {
                        if (word.substring(0, 1).equals(firstStr.toLowerCase())){
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
