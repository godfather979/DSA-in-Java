public class DoublyLinkedList {

    static class ListNode{
        int data;
        ListNode prev,next;

        ListNode(int data){
            this.data=data;
        }
    }

    static ListNode head,tail;
    static int length=0;

    public static void main(String[] args){

        insBef(1);
        insBef(10);
        disf(head);
        disb(tail);
        insEnd(11);
        disf(head);

    }

    public static boolean isEmpty(){
        return (length==0);
    }
    public static void disf(ListNode head){
        ListNode current=head;
        while(current!=null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void disb(ListNode tail){
        ListNode current=tail;
        while(current!=null){
            System.out.print(current.data + " --> ");
            current = current.prev;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void insBef(int data){
        ListNode newNode = new ListNode(data);

        if(isEmpty()){
            tail=newNode; 
        }
        else{
            head.prev=newNode;
        }
        newNode.next=head;
        head=newNode;
        length++;
    }

    public static void insEnd(int data){

        ListNode newNode = new ListNode(data);
        if(isEmpty()){
            head=newNode;
        }
        else{
            tail.next=newNode;
            newNode.prev=tail;

        }
        tail=newNode;
        length++;
    }
}
