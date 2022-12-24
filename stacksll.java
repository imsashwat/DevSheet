package LinkedList;

public class stacksll {
    public static class Node {
        int data;
        Node next;
    }

    public static class stack{
        Node head;
        int size;


        stack() {
            head = null;
            size=0;
        }

        void push(int element) {
            Node newNode = new Node();
            newNode.data=element;
            newNode.next=head;
            head=newNode;
            size++;
        }

        boolean isEmpty() {
            return size == 0;
        }

        int getSize() {
            return size;
        }

        int pop() {
            int ans = head.data;
            Node temp = head;
            head = temp.next;
            size--;
            return ans;
        }

        int top() {
            if(isEmpty()) {
                return 0;
            }
            return head.data;
        }


    }

    public static void main(String[] args) {
        stack s = new stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop());
        System.out.println(s.top());
    }
}
