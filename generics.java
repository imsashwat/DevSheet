package LinkedList;
//CREATING GENERIC CLASS/DATATYPES
public class generics<T> {
    T x;
    T y;

    void setX(T x){
        this.x=x;
    }

    T getX() {
        return x;
    }

    void setY(T y){
        this.y=y;
    }

    T getY() {
        return y;
    }   


    public static void main(String[] args) {

        generics<Integer> P1 = new generics<>();
        P1.setX(10);
        System.out.println(P1.getX());

    }
}
