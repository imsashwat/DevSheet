package DevSheet.DSQueue;

import java.util.ArrayList;

public class queuebyArrList {

    public static class queueImplement {
        ArrayList<Integer> data;       
        int size;

        queueImplement() {
            data = new ArrayList<>();
            size=0;
        }

        int getSize() {
            return size;
        }

        Boolean isEmpty() {
            return size == 0;
        }

        void enqueue(int element) {
            data.add(element);
            size++;
        }

        int dequeue() {           
            if(isEmpty()) {
                System.out.println("queue is empty");
                return 0;
            }
            int ans = data.get(0);
            data.remove(0);
            size--;        
            return ans;
    }


    public static void main(String[] args) {
        queueImplement n = new queueImplement(); //constructor called parameterised

        n.enqueue(10);
        n.enqueue(20);
        n.enqueue(30);
        n.enqueue(40);
        n.enqueue(50);
        System.out.println("size " + n.getSize());
        System.out.println(n.dequeue());
        System.out.println(n.dequeue());
        System.out.println("size " + n.getSize());
        System.out.println(n.dequeue());
       
    }
}
}
