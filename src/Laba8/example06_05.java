package Laba8;

public class example06_05 {
    static class Node { // описание элемента
        public int value;
        public Node next;
        Node(int value, Node next) { // конструктор
            this.value = value;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        System.out.println("Adding elements from the tail");
        // создание 1-го узла, который изначально является и головой, и хвостом списка
        Node head=new Node(0, null);
        Node tail=head;
        // добавление элементов с наращиванием хвоста
        for (int i = 0; i <9; i++) {
            tail.next=new Node(i+1, null);
            tail=tail.next; // указатель на созданный элемент запоминается
        }
        // вывод элементов на экран
        Node ref = head; // ref – рабочая переменная для текущего узла
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
        System.out.println("\nAdding elements from the head");
        // добавление элементов с перемещением головы (наращивание с головы)
        Node head2=null; // начальное значение ссылки на голову
        for (int i =0; i <= 9; i++) {
            head2=new Node(i, head2);
        }
        // вывод элементов на экран
        Node ref2 = head2;
        while (ref2 != null) {
            System.out.print(" " + ref2.value);
            ref2 = ref2.next;
        }
    }
}
