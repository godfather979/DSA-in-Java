import java.util.List;

public class LinkedLIst {

    static class ListNode {

        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static ListNode head;

    public static void main(String[] args) {





        head = new ListNode(10);
        insertlast(head,5);
        insertlast(head,7);
        insertlast(head, 3);
        insertlast(head,1);
        insertlast(head,12);

        dis(head);

        head=sort(head);
        dis(head);



    }

    public static ListNode del(ListNode head, int position){
        if(position==1){
            head=head.next;
            return head;
        }
        ListNode prev = head;
        int count = 1;
        while(count<position-1){
            prev = prev.next;
            count ++;
        }
        ListNode ahead = prev.next.next;
        prev.next=ahead;
        return head;
    }

    public static void insert(ListNode head, int data,int position) {
        ListNode node = new ListNode(data);
        if (position == 1) {
            node.next = head;
            head = node;
        } else {
            ListNode prev = head;
            int count = 1;
            while (count < (position - 1)) {
                prev = prev.next;
                count++;
            }
            ListNode current = prev.next;

            prev.next = node;
            node.next = current;
        }
    }

    public static void insertlast(ListNode head,int data){
        ListNode newNode = new ListNode(data);
        ListNode current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next=newNode;

    }

    public static ListNode insertfirst(ListNode head, int data){
        ListNode newNode = new ListNode(data);
        newNode.next=head;

        return newNode;
    }
    public static void delfirst(){
        if(head==null)
            return;
        else
            head=head.next;
    }

    public static ListNode dellast(ListNode head){
        ListNode current = head;
        ListNode previous=null;
        while(true) {
            if(current.next==null) {
                previous.next = null;
                return head;
            }
            else{
                previous = current;
                current = current.next;
            }
        }

    }


    public static void dis(ListNode head){
        ListNode current=head;
        while(current!=null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static int search(ListNode head, int search) {
        ListNode current = head;
        int count = 1;
        while (current != null) {
            if (current.data == search)
                return count;



            else {
                current = current.next;
                count++;
            }
        }
        return 0;
    }

    public static ListNode rev(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        while (current!=null){
            next=current.next;
            current.next=prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static int end(ListNode head, int n){
        ListNode current = head;
        ListNode ref = head;
        int count = 0;

        while(count<n){
            ref = ref.next;
            count ++;
        }


        while(ref!=null){
            ref=ref.next;
            current=current.next;


        }
        return current.data;
    }

    public static void add_to_sort(ListNode head, int data){
        ListNode current = head;
        int count = 1;
        while(current!=null && current.data<data) {
            current = current.next;
            count ++;
        }
        insert(head,data,count);
        }

    public static void loop(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) {
                breakLoop(slow);
                //return (getStart(head, slow));
            }

        }

    }

    public static ListNode getStart(ListNode head,ListNode slow){
        ListNode temp = head;

        while(slow!=temp){
            temp=temp.next;
            slow=slow.next;
        }
        return temp;

    }

    public static void breakLoop(ListNode slow){
        ListNode temp = head;
        ListNode prev = null;

        while(slow!=temp){
            temp=temp.next;
            prev=slow;
            slow=slow.next;
        }

        prev.next=null;


    }

  public static ListNode join(ListNode head1, ListNode head2) {

      ListNode dummy = new ListNode(0);
      ListNode tail = dummy;
    while(head1!=null && head2!=null) {
        if (head1.data < head2.data) {
            tail.next = head1;
            head1 = head1.next;
        } else {
            tail.next = head2;
            head2 = head2.next;
        }
        tail = tail.next;
    }
     if(head1==null){
         tail.next=head2;
     }
     else{
         tail.next=head1;
     }
      return dummy.next;

  }

  public static ListNode sort(ListNode head){
        ListNode dummy= new ListNode(0);
        ListNode current = head;
        ListNode current1 = dummy;

        int max=current.data;


        while(true) {

            max=0;

            if(head.next==null){
                dummy = insertfirst(dummy,head.data);
                break;
            }

            else {
                while (current != null) {

                    if (current.data > max)
                        max = current.data;

                    current = current.next;
                }
                dummy = insertfirst(dummy, max);

                head=del(head,search(head, max));
                current=head;
            }

        }
    dummy = dellast(dummy);
    return dummy;
  }

}
