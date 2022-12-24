package LinkedList;

public class LLprac {
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
    }

    public class Test {
        public static LinkedList copy(LinkedList list) {
            if(list == null) {
                return null;
            }

            LinkedList res = new LinkedList();
            res.addLast(list.data);
            LinkedList resTmp = res;
            LinkedList listTmp = list;

            while(listTmp.next != null) {
                listTmp = listTmp.next;
                resTmp.next = new ListNode(listTmp.value);
                resTmp = resTmp.next;
            }

            
        }
    }

    public static void main(String[] args) {
        LinkedList x = new LinkedList();
        x.addLast(1);
        x.addLast(2);
        x.addLast(3);
        x.addLast(4);
        x.addLast(5);

        LinkedList z = copy(x);

        // x.display();
        // x.removeLast();
        // x.reverseLlist();
        // x.display();
        //int n = 2;
        //x.nthRemoval(n);
        // x.display();

        //x.removeDuplicates();
        
        
    }

    private static LinkedList copy(LinkedList x) {
        return null;
    }
}
