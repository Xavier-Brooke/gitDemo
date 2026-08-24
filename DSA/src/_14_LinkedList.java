public class _14_LinkedList {

    static class Node {
        int val ;
        Node next ;
        Node(int val) {
            this.val = val ;
            this.next = null ;
        }
    }

    static class LinkedList {
        Node head ;
        Node tail ;
        int size = 0 ;

        // addFirst
        public void addFirst(int val) {
            Node newNode = new Node(val) ;
            size++ ;
            if(head == null) {
                head = tail = newNode ;
                return ;
            }

            newNode.next = head ;
            head = newNode ;
        }

        // addLast
        public void addLast(int val) {
            Node newNode = new Node(val) ;
            size++ ;
            if(head == null) {
                head = tail = newNode ;
                return ;
            }

            tail.next = newNode ;
            tail =  newNode ;
        }

        // add
        public void add(int idx, int val) {
            if(idx < 0 || idx > size) {
                throw  new Error("Index out of bound") ;
            }

            if(idx == 0) {
                addFirst(val);
                return ;
            }

            if(idx == size) {
                addLast(val);
                return ;
            }

            Node itrNode = head ;
            int i = 1 ;
            while (i < idx) {
                itrNode = itrNode.next ;
                i++ ;
            }

            Node newNode = new Node(val) ;
            newNode.next = itrNode.next ;
            itrNode.next = newNode ;
            size++ ;
        }

        // removeFirst
        public int removeFirst() {
            if(head == null) {
                throw new Error("Can't remove element from empty LinkedList") ;
            }

            int val = head.val ;
            head = head.next ;
            size-- ;
            return val ;
        }

        // removeLast
        public int removeLast() {
            if(head == null) {
                throw new Error("Can't remove element from empty LinkedList") ;
            }

            Node itrNode = head ;
            int i = 1 ;
            while(i < (size-1)) {
                itrNode = itrNode.next ;
                i++ ;
            }

            int val = itrNode.next.val ;
            itrNode.next = null ;
            tail = itrNode ;
            size-- ;
            return val ;
        }

        // remove
        public int remove(int idx) {
            if(idx < 0 || idx >= size) {
                throw new Error("Index out of bound") ;
            }

            if(idx == 0) {
                return removeFirst() ;
            }

            if(idx == (size-1)) {
                return removeLast() ;
            }

            Node itrNode = head ;
            int i = 1 ;
            while(i < idx) {
                itrNode = itrNode.next ;
                i++ ;
            }

            int val = itrNode.next.val ;
            itrNode.next = itrNode.next.next ;
            size-- ;
            return  val ;
        }

        // print
        public void print() {
            if(head == null) {
                System.out.println("null");
                return ;
            }

            Node itrNode = head ;
            while (itrNode != null) {
                System.out.print(itrNode.val + "->") ;
                itrNode = itrNode.next ;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {

    }
}
