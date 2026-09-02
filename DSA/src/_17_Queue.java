import java.util.ArrayList;

public class _17_Queue {

    /*
    * Problem 1 :-
    * Queue Implementation using Array */
    static class Queue_Array {
        int[] arr ;
        int rear;
        int size;
        Queue_Array(int length) {
            arr = new int[length] ;
            rear = -1 ;
            this.size = 0 ;
        }

        // isEmpty
        public boolean isEmpty() {
            return size == 0 ;
        }

        // isFull
        public boolean isFull() {
            return rear == (arr.length-1) ;
        }

        // peek
        public int peek() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't get the peek of empty Queue") ;
            }

            return arr[0] ;
        }

        // push
        public void push(int val) {
            if(rear == (arr.length-1)) {
                throw new IllegalStateException("Can't push more element, Queue is full") ;
            }
            arr[++rear] = val ;
            size++ ;
        }

        // pop
        public int pop() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't remove element form empty Queue") ;
            }
            int deleted_ele = arr[0] ;
            for(int i = 0; i < (size -1); i++) {
                arr[i] = arr[i+1] ;
            }
            size-- ;
            return deleted_ele ;
        }
    }

    /*
    * Problem 2 :-
    * Circular Queue Implementation using Array */
    static class CircularQueue_Array {
        int[] arr ;
        int front ;
        int rear ;
        int size;
        CircularQueue_Array(int length) {
            arr = new int[length] ;
            front = rear = -1 ;
            this.size = length ;
        }

        // isEmpty
        public boolean isEmpty() {
            return front == -1 ;
        }

        // isFull
        public boolean isFull() {
            return ((rear + 1) % size) == front;
        }

        // peek
        public int peek() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't get peek of empty Circular Queue") ;
            }

            return arr[front] ;
        }

        // push
        public void push(int val) {
            if(isFull()) {
                throw new IllegalStateException("Can't push element, Circular Queue is full") ;
            }

            rear = (rear+1)%size ;
            arr[rear] = val ;
        }

        // pop
        public int pop() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't pop element from empty Circular Queue") ;
            }

            int deleted_ele = arr[front] ;

            if(front == rear) {
                front = rear = -1 ;
            } else {
                front = (front+1)%size ;
            }

            return deleted_ele ;
        }
    }

    /*
    * Problem 3 :-
    * Queue Implementation using ArrayList */
    static class Queue_ArrayList {
        ArrayList<Integer> list = new ArrayList<>() ;

        // isEmpty
        public boolean isEmpty() {
            return list.isEmpty() ;
        }

        // peek
        public int peek() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't get the peek of empty Queue") ;
            }

            return list.getFirst() ;
        }

        // push
        public void push(int val) {
            list.addLast(val);
        }

        // pop
        public int pop() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't remove element form empty Queue") ;
            }

            return list.removeFirst() ;
        }
    }

    /*
    * Problem 4 :-
    * Queue Implementation using LinkedList*/
    static class Node {
        int data ;
        Node ptr ;
        Node(int data) {
            this.data = data ;
            ptr = null ;
        }
    }

    static class Queue_LinkedList {
        Node head ;
        Node tail ;

        // isEmpty
        public boolean isEmpty() {
            return (head == null) ;
        }

        // peek
        public int peek() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't get peek of an empty Queue") ;
            }

            return head.data ;
        }

        // push
        public void push(int data) {
            Node newNode = new Node(data) ;
            if(head == null) {
                head = tail = newNode ;
                return ;
            }

            tail.ptr = newNode ;
            tail = newNode ;
        }

        // pop
        public int pop() {
            if(isEmpty()) {
                throw new Error("Can't pop element from empty Queue") ;
            }

            int deleted_val = head.data ;
            head = head.ptr ;
            if(head == null) {
                tail = null ;
            }

            return deleted_val ;
        }
    }

    // main function
    public static void main(String[] args) {

        // Test Case for Problem 4 :-
//        Queue_LinkedList queueLinkedList = new Queue_LinkedList() ;
//        queueLinkedList.push(1);
//        queueLinkedList.push(2);
//        queueLinkedList.push(3);
//        while (!queueLinkedList.isEmpty()) {
//            System.out.print(queueLinkedList.pop() + " ");
//        }

        // Test Case for Problem 3 :-
//        Queue_ArrayList queueArrayList = new Queue_ArrayList() ;
//        queueArrayList.push(1);
//        queueArrayList.push(3);
//        queueArrayList.push(4);
//        System.out.println(queueArrayList.peek());
//        while (!queueArrayList.isEmpty()) {
//            System.out.print(queueArrayList.pop() + ",");
//        }

        // Test Case for Problem 2 :-
//        CircularQueue_Array circularQueueArray = new CircularQueue_Array(5) ;
//        circularQueueArray.push(1);
//        circularQueueArray.push(2);
//        circularQueueArray.push(4);
//        while(!circularQueueArray.isEmpty()) {
//            System.out.print(circularQueueArray.pop() + ",");
//        }

        // Test Case for Problem 1 :-
//        Queue_Array queueArray = new Queue_Array(5) ;
//        System.out.println(queueArray.isEmpty());
//        queueArray.push(1);
//        queueArray.push(2);
//        queueArray.push(3);
//        queueArray.push(4);
//        System.out.println(queueArray.isFull());
//        queueArray.push(5);
//        System.out.println(queueArray.isFull());
//        System.out.println(queueArray.peek());
//        System.out.println(queueArray.pop());
//        System.out.println(queueArray.peek());
//        System.out.println(queueArray.isEmpty());
//        while (!queueArray.isEmpty()) {
//            System.out.print(queueArray.pop() + ",");
//        }
    }
}
