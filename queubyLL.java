package DevSheet.DSQueue;

public class queubyLL {
    public static class Node {
        int data;
        Node next;

        Node(int element) {
            this.data=element;
            this.next=null;
        }
    }

    public static class QLinkedList {
        Node head;
        Node tail;
        int size;

        QLinkedList() {
            head = null;
            tail = null;
            size=0;
        }

        int getSize() {

            return size;
        }

        boolean isEmpty() {
            return size==0;
        }

        void enque(int element) {
            Node newNode = new Node(element);
            if(head==null) {
                head = newNode;
                tail =newNode;
            }

            else{
                tail.next = newNode;
                tail = newNode;
            }

            size++;
        }

        int front() {
            if(isEmpty()) {
                return 0;
            }
            return head.data;
        }

        int dequeue() {
            if(isEmpty()){
                return 0;
            }

            int ans = head.data;
            head=head.next;
            size--;
            return ans;
        }

    }

    public static void main(String[] args) {
        QLinkedList q = new QLinkedList();
        q.enque(10);
        q.enque(20);
        q.enque(30);
        q.enque(40);
        System.out.println("dq1"+q.dequeue());

        q.enque(90);
        System.out.println("dq2"+q.dequeue());
        System.out.println("front" +q.front());



    }

}
