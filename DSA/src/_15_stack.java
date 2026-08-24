import java.util.ArrayList;
import java.util.Stack ;

public class _15_stack {

    static class stack_ArrayList {
        private ArrayList<Integer> list = new ArrayList<>() ;

        // peek
        public int peek() {
            if(list.isEmpty()) {
                throw new Error("Stack is empty") ;
            }

            return list.getLast() ;
        }

        // isEmpty
        public boolean isEmpty() {
            return list.isEmpty() ;
        }

        // push
        public void push(int val) {
            list.addLast(val) ;
            return ;
        }

        // pop
        public int pop() {
            if(list.isEmpty()) {
                throw new Error("Stack is Empty") ;
            }

            return list.removeLast() ;
        }
    }

    static class stack_Node {
        static class Node {
            int val ;
            Node next ;

            Node(int val) {
                this.val = val ;
                this.next =  null ;
            }
        }

        Node head ;

        // peek
        public int peek() {
            if(head == null) {
                throw new Error("Stack is empty") ;
            }

            return head.val ;
        }

        // isEmpty
        public boolean isEmpty() {
            return head == null ;
        }

        // push
        public void push(int val) {
            Node newNode = new Node(val) ;
            if(head == null) {
                head = newNode ;
                return ;
            }

            newNode.next = head ;
            head = newNode ;
        }

        // pop
        public  int pop() {
            if(head == null) {
                throw new Error("Stack is empty") ;
            }

            int ans = head.val ;
            head = head.next ;
            return ans ;
        }
    }

    public static void pushAtBottom(Stack<Integer> stack, int val) {
        if(stack.isEmpty()) {
            stack.push(val) ;
            return ;
        }

        int top = stack.pop() ;
        pushAtBottom(stack, val);
        stack.push(top) ;
    }

    // reverse string
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>() ;

        int i = 0 ;
        while(i < str.length()) {
            stack.push(str.charAt(i)) ;
            i++ ;
        }

        StringBuilder sb = new StringBuilder( );
        while (!stack.isEmpty()) {
            sb.append(stack.pop()) ;
        }

        return sb.toString() ;
    }

    // reverse stack
    public static void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return ;
        }

        int top = stack.pop() ;
        reverseStack(stack);
        pushAtBottom(stack, top);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>() ;
        stack.push(1) ;
        stack.push(2) ;
        stack.push(3) ;
        System.out.println(stack.peek());
        reverseStack(stack);
        System.out.println(stack.peek());

//        String str = "Nusrat Fateh Ali Khan" ;
//        String reverseStr = reverseString(str) ;
//        System.out.println(reverseStr);

//        Stack<Integer> stack = new Stack<>() ;
//        stack.push(1) ;
//        System.out.println(stack.peek());
//        pushAtBottom(stack, 2);
//        pushAtBottom(stack, 3);
//        System.out.println(stack.peek());
    }
}
