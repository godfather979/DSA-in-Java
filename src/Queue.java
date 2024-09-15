import java.util.List;

public class Queue {
    static class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data=data;
            next=null;
        }
    }
    int length;
    ListNode rear;
    ListNode front;

    Queue(){
        rear=front=null;
        length=0;
    }


    public void enqueue(int data){

        ListNode newNode = new ListNode(data);
        if(rear==null && front == null){
            rear=front=newNode;
        }

        else{
            newNode.next= rear;
            rear=newNode;
        }
        length++;
    }

    public void offer(BinaryTree.TreeNode temp){


        ListNode newNode = new ListNode(temp.data);
        if(rear==null && front == null){
            rear=front=newNode;
        }

        else{
            newNode.next= rear;
            rear=newNode;
        }
        length++;
    }

    public int dequeue(){

        if(front==rear){
            int result = rear.data;
            front=rear=null;
            return result;
        }
        else {
            int result = front.data;
            ListNode prev = rear;
            while (prev.next != front) {
                prev = prev.next;
            }
            front = prev;
            length--;
            return result;
        }
    }

    public void dis(){

        if(front==null){
            System.out.println("null");
        }
        else {

            System.out.print("rear" + " --> ");
            ListNode current = rear;


                while (current != front){
                    System.out.print(current.data + " --> ");
                    current = current.next;
                }

            System.out.println(current.data + " --> front");
        }
    }

    public static void main(String[] args){
        Queue  q1 = new Queue();
        q1.enqueue(20);
        q1.dis();
        q1.enqueue(10);
        q1.dis();
        q1.enqueue(15);
        q1.dis();
        System.out.println(q1.dequeue());
        q1.dis();


    }

}
