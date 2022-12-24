package LinkedList;

public class foldLL {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;
       
        void addLast(int val) {
            Node temp = new Node(); // latest node yaha bani
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp; // previous tail me latest node ka Pointer
                tail = temp; // tail ko last bnate jao
            }
            size++;
        }

        Node reverseLlistHelper(Node temp) {
            if (temp.next == null) {
                head = temp;
                return head;
            }
            reverseLlistHelper(temp.next);
            Node q = temp.next;
            q.next = temp;
            temp.next = null;
            return head;
        }

       
        public void display() {
            Node temp3 = head;
            
            while (temp3 != null) {
                System.out.println(temp3.data + " ");
                temp3 = temp3.next;
            }
            System.out.println("now see ");
        }

        public Node midPoint(Node head) {
            Node slow = head;
            Node fast = head;

            while(fast != null && fast.next!= null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public void reorderListHelper(Node head) {
            Node slow = head;
            Node fast = head.next;

            while(fast!= null && fast.next!=null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            Node second = reverseLlistHelper(slow.next);
            slow.next = null;
            Node first = head;
            System.out.println("first ka data" + head.data);


            while(second != null) {
                Node temp1 = first.next;
                Node temp2 = second.next;
                first.next = second;
                second.next = temp1;
                first = temp1;
                second = temp2;
            }
  
        }

        public void reorderList(){
            reorderListHelper(head);
        }
    }    


    public static void main(String[] args) {
        LinkedList x = new LinkedList();
        x.addLast(1);
        x.addLast(2);
        x.addLast(3);
        x.addLast(4);
        x.addLast(5);
        
        x.reorderList();
        x.display();
    }
}
