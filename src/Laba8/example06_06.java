package Laba8;

import java.util.Scanner;

public class example06_06 {
    static class Numbers {
        public int number;
        public Numbers next; // поле – ссылка (указатель) на следующий узел
        Numbers(int num, Numbers next) { // конструктор класса
            this.number = num;
            this.next = next;
        }
    }

    public static Numbers createHead(Numbers head)
    {
         head = null; //начальное значение ссылки на голову
         for (int i = 0; i <= 9; i++)
         {
            head = new Numbers(i, head);
        };
        return head;
    }

    public static Numbers createTail(Numbers tail)
    {
        for (int i = 0; i < 9; i++)
        {
            tail.next = new Numbers(i+1+3, null);
            tail = tail.next;
        }
        return tail;
    }
    public static Numbers AddFirst(Numbers head)
    {
        head = new Numbers(111,  head);
        return head;
    }

    public static void AddLast(Numbers head)
    {
        Numbers newtail = new Numbers(123, null);
        Numbers ref = head;
        while (ref.next != null) ref = ref.next;
        ref.next=newtail;
    }

    public static Numbers Insert(Numbers head, int index, int n)
    {
        Numbers newNode=new Numbers(n, null);
        Numbers ref = head; // используем временную переменную
        int k=1; // счетчик элементов
        while (ref.next!= null && (k<index-1 )) {
            ref = ref.next;
            k++;
        }
        newNode.next=ref.next.next;
        ref.next = newNode;
        return head;
    }

    public static Numbers RemoveFirst(Numbers head)
    {
        head = head.next;
        return head;
    }

    public static Numbers RemoveLast(Numbers head)
    {
        Numbers ref = head;
        while (ref.next.next != null) {
            ref = ref.next;
        }
        ref.next=null;
        return head;
    }

    public static Numbers Remove(Numbers head, int index) {
        Numbers ref = head;
        int k = 1;
        while (ref.next != null && (k < index-1)) {
            ref = ref.next;
            k++;
        }
        ref.next = ref.next.next;
        return head;
    }
    public static String ToString(Numbers head) {
        Numbers ref = head;
        String result = "";
        int i = 0;
        while (ref != null) {
            result += ref.number + " ";
            ref = ref.next;
        }
        return result;
    }
    public static int i;
    public static void createHeadRec(int size)
    {
        if (i < size){
            headR = new Numbers(i, headR);
            i++;
            createHeadRec(size);
        }
    }
    public static Numbers createTailRec(Numbers tail, int size)
    {
        if (i < size)
        {
            tail.next = new Numbers(i, null);
            tail = tail.next;
            i++;
            createTailRec(tail,size);
        }
        return tail;
    }
    public static void ToStringRec(Numbers head, String result) {
        if(head == null){
            System.out.println(result);
        } else {
            result += head.number + " ";
            ToStringRec(head.next,result);
        }
    }
    public static Numbers headR;
    public static Numbers tailR;
    public static void main(String[] args) {
        Scanner InCMD = new Scanner(System.in);
        System.out.println("createHead:");
        Numbers head = null;
        head = createHead(head);
        System.out.println(ToString(head));
        System.out.println("createTail:");
        head = new Numbers(0,null);
        Numbers tail = head;
        createTail(tail);
        System.out.println(ToString(tail));
        System.out.print("AddFirst (): \n");
        head = AddFirst(head);
        System.out.println(ToString(head));
        System.out.print("AddLast: \n");
        AddLast(head);
        System.out.println(ToString(head));
        System.out.print("Insert: \n");
        System.out.print("Number to insert: \n");
        int num = InCMD.nextInt();
        System.out.print("Index to insert: \n");
        int in = InCMD.nextInt();
        head = Insert(head,in,num);
        System.out.println(ToString(head));
        System.out.print("RemoveFirst: \n");
        head = RemoveFirst(head);
        System.out.println(ToString(head));
        System.out.print("RemoveLast: \n");
        head = RemoveLast(head);
        System.out.println(ToString(head));
        System.out.print("Remove: \n");
        System.out.print("Index to remove: \n");
        in = InCMD.nextInt();
        head = Remove(head, in);
        System.out.println(ToString(head));
        System.out.println("Input size: " );
        int n = InCMD.nextInt();
        System.out.print("createHeadRec: \n");

        headR = null;
        createHeadRec(n);
        String result = "";
        ToStringRec(headR,result);
        tailR = new Numbers(0,null);
        System.out.print("createTailRec: \n");
        i=0;
        tailR = createTailRec(tailR,n);
        Numbers ref = tailR;
        result = "";
        ToStringRec(ref, result);
    }
}
