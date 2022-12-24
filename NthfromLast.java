package LinkedList;

public class NthfromLast {

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

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
              }
              else {
                return head.data;
              }
        }
        public int getLast() {
            if (size == 0) {
              System.out.println("List is empty");
              return -1;
            } else {
              return tail.data;
            }
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

        public void removeFirst() {
            if (size == 0) {
              System.out.println("List is empty");
            } else if (size == 1) {
              head = tail = null;
              size = 0;
            } else {
              head = head.next;
              size--;
            }
          }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data + " ");
                temp = temp.next;
            }
            System.out.println("now see ");
        }

        public void removeLast() {
            if (size == 1 || size == 0) {
                head = tail = null;
            }

            Node fast = head.next;
            Node slow = head;

            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            tail = slow;
            tail.next = null;
        }

        public void reverseLlistHelper(Node temp) {
            if (temp.next == null) {
                head = temp;
                return;
            }
            reverseLlistHelper(temp.next);
            Node q = temp.next;
            q.next = temp;
            temp.next = null;
        }

        public void reverseLlist() {
            reverseLlistHelper(head);
        }

        public Node reverseLlistmaker(Node temp) {
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

        public int nthRemovalhelper(int x, Node temp, int counter, int z) {

            if (temp.next == null) {

                counter += 1;
                System.out.println(counter + " count"); //idhr to inc hua 
                return 0;
            }

            int ans = nthRemovalhelper(x, temp.next, counter, z);
            System.out.println(counter + " count");
            if (counter == x) {
                z = temp.data;
                System.out.println(z);
                return ans + z;
            } else {
                counter++;
                // return ans;
            }
            return ans;
        }

        public int getAt(int idx) {
            if (size == 0) {
              System.out.println("List is empty");
              return -1;
            } else if (idx < 0 || idx >= size) {
              System.out.println("Invalid arguments");
              return -1;
            } else {
              Node temp = head;
              for (int i = 0; i < idx; i++) {
                temp = temp.next;
              }
              return temp.data;
            }
          }

        public void removeDuplicates() {
            LinkedList res = new LinkedList();

            while(this.size > 0) {
                int val = this.getFirst();
                this.removeFirst();

                if(res.size == 0 || res.tail.data != val) {
                    res.addLast(val);
                }
            }
            this.head = res.head;
            this.tail = res.tail;
            this.size = res.size;
        }

        public void nthRemoval(int x) {
            int count = 0;
            int z = 0;
            int output = nthRemovalhelper(x, head, count, z);
            System.out.println(output);
        }

        public boolean isPalindromehelper(Node temp) {     
            
            if(head == null) {
                return true;
            }
            Node mid = midPoint(head);
            Node last = reverseLlistmaker(mid.next);
            Node curr = head;

            while ( last != null) {
                if(last.data != curr.data) {
                    return false;
                }
                last = last.next;
                curr = curr.next;
            }
            return true;

        }

        public boolean isPalindrome(){
           return isPalindromehelper(head);           
        }
    }

    public static void main(String[] args) {
        LinkedList x = new LinkedList();
        x.addLast(78);
        x.addLast(89);
        x.addLast(9);
        x.addLast(23);

        // x.display();
        // x.removeLast();
        
        // x.display();
        //int n = 2;
        //x.nthRemoval(n);
        x.display();
        x.reverseLlist();
        //x.removeDuplicates();
        x.display();
        

    }
}
