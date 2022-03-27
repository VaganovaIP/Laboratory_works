package Laba9;

import java.util.*;

public class example06_01 {
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<Integer>();
        LinkedList<Integer> linlist = new LinkedList<Integer>();
        Set hashSet = new HashSet();
        Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();

        //System.out.println("Время выполнения операции добавление в начало коллекции ArrayList = " + getRunningTime_AddListB(list));
        System.out.println("Время выполнения операции добавление в конец коллекции ArrayList = " + getRunningTime_AddListE(list));
        //System.out.println("Время выполнения операции добавление в середину коллекции ArrayList = " + getRunningTime_AddListM(list));

        System.out.println("Время выполнения операции добавление в начало коллекции LinkedList = " + getRunningTime_AddLinkedListB(linlist));
        //System.out.println("Время выполнения операции добавление в конец коллекции LinkedList = " + getRunningTime_AddLinkedListE(linlist));
        //System.out.println("Время выполнения операции добавление в середину коллекции LinkedList = " + getRunningTime_AddLinkedListM(linlist));

        System.out.println("Время выполнения операции удаления первого элемента (10 000 э.) коллекции ArrayList = " + getRunningTime_RemoveListB(list));
        System.out.println("Время выполнения операции удаления последнего элемента (10 000 э.) коллекции ArrayList = " + getRunningTime_RemoveListE(list));
        System.out.println("Время выполнения операции удаления элемента по середине коллекции (10 000 э.) ArrayList = " + getRunningTime_RemoveListM(list));

        System.out.println("Время выполнения операции удаления первого элемента (10 000 э.) коллекции LinkedList = " + getRunningTime_RemoveListB(linlist));
        System.out.println("Время выполнения операции удаления последнего элемента (10 000 э.) коллекции LinkedList = " + getRunningTime_RemoveListE(linlist));
        System.out.println("Время выполнения операции удаления элемента по середине (10 000 э.) коллекции LinkedList = " + getRunningTime_RemoveListM(linlist));

        System.out.println("Время выполнения операции добавление в начало (100 000 э.) linkedHashMap = " + getRunningTime_AddLinkedHashMapB(linkedHashMap));
        System.out.println("Время выполнения операции добавление в конец (100 000 э.) linkedHashMap = " + getRunningTime_AddLinkedHashMapE(linkedHashMap));

        //HashSet
        long i;
        for(i = 0; i < 40000000; i++)
        {
            linlist.addFirst(1);
        };
        System.out.println("-----------------------");
        System.out.println("Время выполнения операции получения по индексу (6 000 эл.) linkedlist = " + getRunningTime_GetList(linlist, 140006));
        for(i = 0; i < 40000000; i++)
        {
            list.add(1);
        };
        System.out.println("Время выполнения операции получения по индексу (6 000 эл.) Arraylist = " + getRunningTime_GetList(list, 140006));
        for(i = 0; i < 40000000; i++)
        {
            hashSet.add(1);
        };
        System.out.println("Время выполнения операции получения по индексу (6 000 эл.) HashSet = " + getRunningTime_GetHashSet(hashSet, 140006));

       for(i = 0; i < 6000000; i++)
        {
            linkedHashMap.put("abc"+i, " "+i);
        };
        System.out.println("Время выполнения операции получения по индексу (6 000 эл.) linkedHashMap = " + getRunningTime_GetLinkedHashMap(linkedHashMap, 140006));
    }
    private static long getRunningTime_AddListM(List<Integer> list){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 6000000; i++)
        {
            list.add((list.size() / 2), i); //середина коллекции
        };
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long getRunningTime_AddListB(List<Integer> list){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 6000000; i++)
        {
            list.add(0,i); //начало
        };
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long getRunningTime_AddListE(List<Integer> list){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 6000000; i++)
        {
            list.add(i); //конец
        };
        long end = System.currentTimeMillis();
        return end - start;
    }
    ///////////////////////////////////////////////////////////////////
    private static long getRunningTime_AddLinkedListM(LinkedList<Integer> list){
        int count = list.size() / 2;
        long start = System.currentTimeMillis();
        for(int i = 0; i < 6000000; i++)
        {
            list.add(list.size()/2, 1); //середина коллекции
        };
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long getRunningTime_AddLinkedListB(LinkedList<Integer> list){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 6000000; i++)
        {
            list.addFirst(i); //начало
        };
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long getRunningTime_AddLinkedListE(LinkedList<Integer> list){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 6000000; i++)
        {
            list.addLast(i); //конец
        };
        long end = System.currentTimeMillis();
        return end - start;
    }
    private static long getRunningTime_RemoveListB(List<Integer> list){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {
            list.remove(0); // удаляем первый элемент
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
    private static long getRunningTime_RemoveListE(List<Integer> list){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {
            list.remove(list.size()-1); // удаляем последний элемент
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
    private static long getRunningTime_RemoveListM(List<Integer> list){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {
            list.remove(list.size()/2); // удаляем средний элемент
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
    private static long getRunningTime_GetList(List<Integer> list, int index){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 6000; i++, index++)
        {
            list.get(index);
        };
        long end = System.currentTimeMillis();
        return end - start;
    }
    //////////////////////////////////////////////////////////////
 public static long getRunningTime_GetHashSet(Set HashSet, int index){
     int i = 0, kol = 0;
     long start = System.currentTimeMillis();
     Iterator iterator = HashSet.iterator();
     //Извлечение элементов через итератор
     while (iterator.hasNext() && (i < 40000000)) {
         if ((i >= index) && (kol <= 6000)){
             Object z = iterator.next();
            kol++;i++;
         } else {
             iterator.next();
             i++;
         }
     }
     long end = System.currentTimeMillis();
     return end - start;
 }
    ///////////////////////////////////////////////////////////////////
    private static long getRunningTime_AddLinkedHashMapB(Map linkedHashMap){
        long start = System.currentTimeMillis();
        for(long i = 0; i < 100000; i++) { //начало
            Map<String, String> linkedHashMapClon = new LinkedHashMap<String, String>(linkedHashMap);
            linkedHashMap.clear();
            linkedHashMap.put(i, i);
            linkedHashMap.putAll(linkedHashMapClon);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
    private static long getRunningTime_AddLinkedHashMapE(Map linkedHashMap){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++)
        {
            linkedHashMap.remove(linkedHashMap.size());
            linkedHashMap.put(linkedHashMap.size(),i); //конец

        };
        long end = System.currentTimeMillis();
        return end - start;
    }
    public static long getRunningTime_GetLinkedHashMap(Map linkedHashMap, int index){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 6000;i++,index++) {
            String s = new ArrayList<String>(linkedHashMap.keySet()).get(index);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
