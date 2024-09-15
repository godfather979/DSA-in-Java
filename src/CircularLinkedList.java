import java.sql.SQLOutput;
import java.util.List;

public class CircularLinkedList {

    static class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data=data;
            next=null;
        }
    }

    static ListNode last;

    public static void main(String[] args){

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode last = new ListNode(4);

        one.next=two;
        two.next=three;
        three.next=last;
        last.next=one;

        last = ins(last,5);
        inse(last,6);
        dis(last);


    }

    public static void dis(ListNode last){

        ListNode current = last;
        if(current==null){
            System.out.println("null");
            return;
        }

        System.out.print(current.data + " --> ");
        current=last.next;
        while(current!=last){
            System.out.print(current.data+ " --> ");
            current=current.next;
        }
        System.out.print(current.data);
        current=last.next;

    }

    public static ListNode ins(ListNode last, int data){

        ListNode newNode= new ListNode(data);
        if(last==null){
            last=newNode;
        }
        else {
            newNode.next = last.next;
        }
        last.next=newNode;

        return newNode;
    }

    public static void inse(ListNode last, int data){

        ListNode newNode = new ListNode(data);
        ListNode current = last.next;
        ListNode prev = last;
        while(current!=last){
            current=current.next;
            prev=prev.next;
        }
        prev.next=newNode;
        newNode.next=last;

    }
}
