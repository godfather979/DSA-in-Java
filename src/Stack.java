public class Stack {

    static class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data=data;
            next=null;
        }
    }

    ListNode top;
    int length;

    Stack(){
        top=null;
        length=0;
    }

    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next=top;
        top=temp;
        length++;
    }

    public int pop(){

        if(top==null){
            return 0;
        }
        int result = top.data;
        top=top.next;
        length--;
        return result;
    }

    public int peak(){
        return top.data;
    }

    public void dis(){
        ListNode current =  top;
        while(current!=null){
            System.out.print(current.data + " <-- ");
            current = current.next;
        }
        System.out.println("base");
    }

    public static void main(String[] args){
        Stack stack = new Stack();
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.dis();
        stack.pop();
        stack.dis();

    }


}
