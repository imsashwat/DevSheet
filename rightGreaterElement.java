package DevSheet.DSQueue;

import java.util.Stack;

public class rightGreaterElement {
    public static long[] solveNextLargerElement(long[] arr,int n){
        long[] ans  = new long[n];
        
        Stack<Integer> stack = new Stack<>();
        stack.addElement(arr[arr.length-1]);
        
        for(int i=0;i< n;i++){
            if(stack.size()==0){
                stack.push(i);
                //System.out.println("stack dekhlo ghuste hi " + stack.peek());
                continue;
            }
            
            while(stack.size()>0 && arr[i] > arr[stack.peek()]){
                
                ans[stack.pop()]= arr[i];     
            }
            
            stack.push(i);
            System.out.println("stack dekho "+stack.peek());   
        }
        
        while(stack.size()>0){
            ans[stack.pop()]=-1;
        }
        
        return ans;
    }

    public static void main(String[] args) {
        long[]arr = {11,13,21,3};
        int n =4;

        long[] x = solveNextLargerElement(arr,n);
        for(int i=0; i<n; i++) {
           // System.out.println(x[i]);
        }
    }
}
