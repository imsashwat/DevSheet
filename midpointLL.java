package LinkedList;

public class midpointLL {

    static class LinkedL {
        static class Node {

            int data;
            Node next;

            // Constructor
            Node(int d) {
                data = d;
                next = null;
            }
        }

        Node head; // head of list
        Node tail; //tail

        public static LinkedL add(LinkedL list, int data) {
            // Create a new node with given data
            Node new_node = new Node(data);

            // If the Linked List is empty,
            // then make the new node as head
            if (list.head == null) {
                list.head = new_node;
            } else {
                // Else traverse till the last node
                // and insert the new_node there
                Node tail = list.head;
                while (tail.next != null) {
                    tail = tail.next;
                }

                // Insert the new_node at last node
                tail.next = new_node;
            }

            // Return the list by head
            return list;
        }
        //midpoint of LinkkedLIST
        public static void midp(LinkedL llist) {
            Node slow = llist.head;
            Node fast = llist.head.next;

            while(fast!=null) {
                fast=fast.next.next;
                slow=slow.next;
            }
            System.out.print(slow.data);
        }

        public static void printList(LinkedL llist) {
            Node currNode = llist.head;

            System.out.print("LinkedList: ");

            // Traverse through the LinkedList
            while (currNode != null) {
                // Print the data at current node
                System.out.print(currNode.data + " ");

                // Go to next node
                currNode = currNode.next;
            }
        }


        public static void main(String[] args) {
            LinkedL llist = new LinkedL();
            llist = add(llist, 24);
            llist = add(llist, 25);
            llist = add(llist, 26);
            llist = add(llist, 27);
            llist = add(llist, 28);

            printList(llist);
            midp(llist);
           
        }
    }
}
