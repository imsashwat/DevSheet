package BinaryTree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;
import LinkedList.stacksll.stack;

public class Btree {
    
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public static void display(Node node) {
        if( node == null) {
            return;
        }

        String str = "";
        str += node.left  == null? "." : node.left.data + ""; //
        str += " <- " + node.data + "->";
        str += node.right == null? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int sum(Node node) {
        if(node == null) {
            return Integer.MIN_VALUE;
        }

        int lsm = sum(node.left);
        int rsm = sum(node.right);
        int tsm = lsm+rsm+node.data;
        return tsm;
        }

        public static int max(Node node) {
            if(node == null) {
                return Integer.MIN_VALUE;
            }
    
            int lm = max(node.left);
            int rm = max(node.right);
            int tm = Math.max(node.data,Math.max(lm, rm));
            return tm;
            }

    //traversal in binary tree

    public static void traversal(Node node) {
        if(node == null) {
            return;
        }

        System.out.println(node.data + "preorder me ");
        traversal(node.left);
        System.out.println(node.data + "inorder me ");
        traversal(node.right);
        System.out.println(node.data + "postorder me ");
    }

    //level order traversal
    
    public static void levelOrder(Node node) {
        Deque<Node> mq = new ArrayDeque<>();
        mq.add(node);

        while(mq.size() > 0) {
            int count = mq.size();
            for(int i=0; i < count; i++) {
                node = mq.remove();
                System.out.println(node.data);

                if(node.left!= null) {
                    mq.add(node.left);

                }

                if(node.right!= null) {
                    mq.add(node.right);
                }
            }
            System.out.println();

        }

    }

    //height of tree
    public static int height(Node node) {
        if(node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);
        int th = Math.max(lh, rh) + 1;
        return th;

    }


    //pre in post iteratively
    public static void iterativePrePostInTraversal(Node node) {
        Stack<Pair> st = new Stack<>();
        Pair rtp = new Pair(node, 1);

        st.push(rtp);

        String pre = " ";
        String post = " ";
        String in = " ";

        while(st.size()>0) {
            Pair top = st.peek();
                if(top.state == 1) {
                    pre += top.node.data;
                    top.state++;

                    if(top.node.left != null) {
                        Pair lp = new Pair(top.node.left, 1);
                        st.push(lp);
                    }
                }
                else if(top.state == 2) {
                    in += top.node.data + " ";
                    top.state++;

                    if(top.node.right != null) {
                        Pair lp = new Pair(top.node.right, 1);
                        st.push(lp);
                    }
                }
                else {
                    post += top.node.data + " ";
                    st.pop();
                }            
        }

        System.out.println("pre"+pre);
        System.out.println("in"+in);
        System.out.println("post"+post);
    }

    //nodetoroot path
    static ArrayList<Integer> path = new ArrayList<>();
    public static boolean nodetoRoot(Node node, int data) {
        if(node == null) {
            return false;
        }
        if(node.data == data) {
           
            path.add(node.data);
            return true;
        }
        boolean filc =  nodetoRoot(node.left, data); //find in left child
        if(filc) {
            path.add(node.data);
            return true;
        }

        boolean firc = nodetoRoot(node.right, data); //find in right child
        if(firc) {
            path.add(node.data);
            return true;
        }
        return false;
    }

    //klevels down


    public static void printKlevelsDown(Node node, int k) {
        if(node == null || k<0) { //k less than 0
            System.out.println("node.data "+node + "k dekho " + k);
            return ;
        }

        if(k == 0) {
            System.out.println(node.data);
        }
        
        printKlevelsDown(node.left, k-1);

        printKlevelsDown(node.right, k-1);

    }



    //to print a path whole elments sum is between range low<high
    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
        if(node.left == null && node.right == null) {
            sum += node.data;

            if(sum >= lo && sum <= hi) {
                System.out.print(path + node.data);
            }
            return;
        }

        pathToLeafFromRoot(node.left, path + node.data + " ", sum+node.data, lo, hi);
        pathToLeafFromRoot(node.right, path + node.data + " ", sum+node.data, lo, hi);

    }

    //transform to left clone element tree
    public static Node transformToLeft(Node node) {
        if(node == null) {
            return null;
        }

        Node lcr = transformToLeft(node.left);
        Node rcr = transformToLeft(node.right);
        
        Node nn = new Node(node.data, lcr, null);
        node.left = nn;
        node.right = rcr;

        return node;

    }

    //transform back from a cloned tree
    public static Node transbackfromCloned(Node node) {
        if(node == null) {
            return null;
        }

        Node lnn = transbackfromCloned(node.left.left);
        Node rnn = transbackfromCloned(node.right);
        
        //postorder
        node.left = lnn;
        node.right = rnn;

        return node;
    }

    // remove leaves
    public static Node removeLeaves(Node node) {
        if(node == null) {
            return null;
        }

        if(node.left == null & node.right == null) {
            return null;
        }

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;
    }
 
//diameter of a node
    public static int diameter1(Node node) {
        if(node==null) {
            return 0;
        }

        //max dis bw two nodes on left
        int ld = diameter1(node.left); 
        // max dis bw two nodes on right
        int rd = diameter1(node.right); 
         //max dis bw left deepest & right deepest nodes
        int f = height(node.left) + height(node.right) + 2;
        
        System.out.print("f dekh "+ f + " node.data " + node.data);
        int dia = Math.max(f, Math.max(ld, rd)); 
        System.out.println(" dia dekh " + dia); 
        
        return dia;
    }

    //is the given tree a BST?

    public static class BSTPair {
        boolean isBST;
        int min;
        int max;
    }

    public static BSTPair isBST(Node node) {
        if(node == null) {
            BSTPair bp = new BSTPair();
            bp.min = Integer.MAX_VALUE;  //min req to Universalize check for ALLNODES on right
            bp.max = Integer.MIN_VALUE;  //max req to Universalize check for ALLNODES on left
            bp.isBST = true;
            return bp;
        }

        BSTPair lp = isBST(node.left); 
        BSTPair rp = isBST(node.right);

        BSTPair mp = new BSTPair();
        //1st bracket agr true h to mtlb isse niche k nodes BST k liye thiik h
        
        mp.isBST = (lp.isBST && rp.isBST) &&
        //2nd bracket,if true shows current node is apt acc to BST left se bda right se chota
        //uses leftnode max and rightnode max to judge current node
        (node.data >= lp.max && node.data <= rp.min); 

        //stores max and min for current node 
        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));

        return mp; //as an object return hojaega 
    }

    //is tree balanced

    static boolean isBal = true;
    public static int Isbalanced(Node node) {

        if(node==null) {
            return 0;
        }

        int lh = Isbalanced(node.left);
        int rh = Isbalanced(node.right);

        int gap = Math.abs(lh-rh);
        if(gap>1) {
            isBal = false;
        }
        int th = Math.max(lh, rh) + 1;
        return th;
    }

    public static class BSTclass{
        boolean isBST;
        int min;
        int max;
        Node root;
        int size;
    }

    //Largest BST subtree
    public static BSTclass largestBST(Node node) {
        if(node == null) {
            BSTclass bp = new BSTclass();
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.isBST = true;
            return bp;
        }

        BSTclass lp = largestBST(node.left);
        BSTclass rp = largestBST(node.right);

        BSTclass mp = new BSTclass();

        mp.isBST = lp.isBST && rp.isBST  &&
                    (node.data >=lp.max && node.data <= rp.min);
        
        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));

        if(mp.isBST) {
            mp.root = node;
            mp.size = lp.size + rp.size + 1;
        } else if(lp.size > rp.size) {
            mp.root = lp.root;
            mp.size = lp.size;
        } else {
            mp.root = rp.root;
            mp.size = rp.size;
        }

        return mp;

    }


    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Node root = new Node(arr[0], null, null);   //null-50-null
        Pair rtp = new Pair(root, 1);   

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx =0;
        while(st.size() > 0) {
            Pair top = st.peek();  //stack k top pe rkhe element ki state k hisab se fix krega node
            
            //System.out.println("top dekho be" + top.node.data);
            if(top.state == 1){  //left me
                idx++;
                if(arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1); //left
                    st.push(lp); //is new node ko stack me dala now its on top
                }
                else{  
                    top.node.left = null;
                }
                top.state++;
            }
            else if(top.state == 2) {  //right me
                idx++; 
                if(arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);  //right
                    st.push(rp);
                }
                else {
                    top.node.right = null;
                }
                top.state++;
            }
            else {
                st.pop(); //state = 3 to pop
            }
        }

        //display(root);
        //System.out.println(sum(root));
        //System.out.println(max(root));
        //traversal(root);
        //levelOrder(root);      
        //iterativePrePostInTraversal(root);
        //boolean s = nodetoRoot(root, 30);
        //System.out.println(s);
        //System.out.println(path);
        //printKlevelsDown(root, 2);
        System.out.println(diameter1(root));
        System.out.println(height(root.left));
    }
}