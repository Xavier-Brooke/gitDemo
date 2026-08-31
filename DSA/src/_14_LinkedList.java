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
                throw new IndexOutOfBoundsException("Index out of bound");
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
                throw new IllegalStateException("Can't remove element from empty LinkedList");
            }

            int val = head.val ;
            head = head.next ;
            size-- ;

            if(head == null) {
                tail = null ;
            }

            return val ;
        }

        // removeLast
        public int removeLast() {
            if(head == null) {
                throw new IllegalStateException("Can't remove element from empty LinkedList");
            }

            if(head.next == null) {
                return removeFirst() ;
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
                throw new IndexOutOfBoundsException("Index out of bound");
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

        // linear search (loop)
        public int search(int key) {
            if(head == null) {
                return -1 ;
            }

            int i = 0 ;
            Node itrNode = head ;
            while(itrNode != null) {
                if(itrNode.val == key) {
                    return i ;
                }
                i++ ;
                itrNode = itrNode.next ;
            }

            return -1 ;
        }

        // linear search (recursive)
        public int search(Node itrNode, int key) {
            if(itrNode == null) {
                return -1 ;
            }

            if(itrNode.val == key) {
                return 0 ;
            }

            int idx = search(itrNode.next, key) ;
            if(idx == -1) {
                return -1 ;
            }

            return idx+1 ;
        }

        // reverse a linkedList
        public void reverse() {
            if(head == null) {
                throw new IllegalStateException("Can't reverse empty LinkedList") ;
            }

            if(head == tail) {
                return ;
            }

            Node prev = null;
            Node curr = tail = head ;
            Node next ;
            while(curr != null) {
                next = curr.next ;
                curr.next = prev ;
                prev = curr ;
                curr = next ;
            }

            head = prev ;
        }

        // Find & Remove Nth node from End
        public int remove_Nth_from_end(int n) {
            if(head == null) {
                throw new IllegalStateException("Can't remove element from empty LinkedList") ;
            }

            if(n < 1 || n > size) {
                throw new IllegalStateException(n + "can't be greater than size, or less than 1") ;
            }

            if(n == size) {
                return removeFirst() ;
            }

            if(n == 1) {
                return removeLast() ;
            }

            Node itrNode = head ;
            int idx = (size - n) ;
            int i = 1 ;
            while(i < idx) {
                itrNode = itrNode.next ;
                i++ ;
            }

            int val = itrNode.next.val ;
            itrNode.next = itrNode.next.next ;
            size-- ;
            return val ;
        }

        // get mid
        public Node getMid() {
            if(head == null) {
                throw new IllegalStateException("Can't get mid node of an empty LinkedList") ;
            }

            Node slow = head ;
            Node fast = head ;
            while((fast != null) && (fast.next != null)) {
                slow = slow.next ;
                fast = fast.next.next ;
            }

            return slow ;
        }

        // check if a LinkedList is palindrome
        public boolean isPalindrome() {
            if((head == null) || (head == tail)) {
                return true ;
            }

            Node prev = getMid() ;
            Node curr = prev.next ;
            Node next ;
            prev.next = null ;
            while(curr != null) {
                next = curr.next ;
                curr.next = prev ;
                prev = curr ;
                curr = next ;
            }

            Node leftPtr = head ;
            Node rightPtr = prev ;
            while(rightPtr != null) {
                if(leftPtr.val != rightPtr.val) {
                    return false ;
                }
                rightPtr = rightPtr.next ;
                leftPtr = leftPtr.next ;
            }

            return true ;
        }
    }

    public static void main(String[] args) {

        LinkedList ll = new LinkedList() ;
        ll.addFirst(1);
        ll.addLast(1);
        System.out.println(ll.isPalindrome());
    }
}
