package LinkedList;

public class MergeLL {

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

        public void display() {
            Node temp3 = head;
            
            while (temp3 != null) {
                System.out.println(temp3.data + " ");
                temp3 = temp3.next;
            }
            System.out.println("now see ");
        }

        public static Node midPoint(Node head, Node tail) {
            Node slow = head;
            Node fast = head;

            while(fast != null && fast.next!= null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            LinkedList ml = new LinkedList();
      
            Node one = l1.head;
            Node two = l2.head;
            while (one != null && two != null) {
              if (one.data < two.data) {
                ml.addLast(one.data);
                one = one.next;
              } else {
                ml.addLast(two.data);
                two = two.next;
              }
            }
      
            while (one != null) {
              ml.addLast(one.data);
              one = one.next;
            }
      
            while (two != null) {
              ml.addLast(two.data);
              two = two.next;
            }
      
            return ml;
          }

        public static LinkedList mergeSort(Node head, Node tail){
            // write your code here
            
            Node mid = midPoint(head,tail);
            LinkedList fsh = mergeSort(head,mid);
            LinkedList ssh = mergeSort(mid.next,tail);
            LinkedList res = mergeTwoSortedLists(fsh,ssh);
            return res;
          }

    }

    public static void main(String[] args) {
        LinkedList x = new LinkedList();
        x.addLast(10);
        x.addLast(2);
        x.addLast(19);
        x.addLast(23);
        x.addLast(3);
        x.addLast(7);

        x.display();
        LinkedList sorted = LinkedList.mergeSort(x.head,x.tail);
        sorted.display();

    }
    
}
