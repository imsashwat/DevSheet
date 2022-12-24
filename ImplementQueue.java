package DevSheet.DSQueue;

public class ImplementQueue {
    public static class queue {
        int[] data;
        int nextIndex;
        int firstIndex;
        int size;
        int capacity;

            queue(int s) {
            data = new int[s];
            nextIndex = 0;
            firstIndex = -1;
            size=0;
            capacity = s;
        }

        int getSize() {
            return size;
        }

        Boolean isEmpty() {
            return size == 0;
        }



        void enqueue(int element) {
            if(size == capacity) {
                System.out.println("size full");
            }

            data[nextIndex] = element;
            nextIndex = (nextIndex + 1)%capacity;
            if(firstIndex == -1) {
                firstIndex = 0;
            }
            size++;
        }

        int dequeue() {
            
            if(isEmpty()) {
                System.out.println("queue is empty");
                return 0;
            }
            int ans = data[firstIndex];
            firstIndex = (firstIndex+1)%capacity;
            size--;
            if(size==0) {
                firstIndex=-1;
                nextIndex=0;
            }           
            return ans;
        }
    }

    public static void main(String[] args) {
        queue n = new queue(5); //constructor called parameterised

        n.enqueue(10);
        n.enqueue(20);
        n.enqueue(30);
        n.enqueue(40);
        n.enqueue(50);
        System.out.println(n.dequeue());
        System.out.println(n.dequeue());
        System.out.println(n.dequeue());
        System.out.println(n.dequeue());
        System.out.println(n.dequeue());
        System.out.println(n.dequeue());     
    }
}
