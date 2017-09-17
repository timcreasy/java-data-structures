public class SLList {

    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next */
    private IntNode sentinel;
    private int size;

    /** Create an empty SLList */
    public SLList() {
        // Random val
        this.sentinel = new IntNode(-5, null);
        this.size = 0;
    }

    public SLList(int x) {
        size = 1;
        this.sentinel = new IntNode(-5, null);
        this.sentinel.next = new IntNode(x, null);
    }

    public void addFirst(int x) {
        this.size++;
        this.sentinel.next = new IntNode(x, sentinel.next);
    }

    public int getFirst() {
        return this.sentinel.next.item;
    }

    public void addLast(int x) {

        this.size++;

        IntNode p = this.sentinel;

        while (p.next != null) {
           p = p.next;
        }

        p.next = new IntNode(x, null);
    }
//Linear size solution

//    public int size() {
//        int size = 1;
//        IntNode p = first;
//        while (p.next != null) {
//            size++;
//            p = p.next;
//        }
//        return size;
//    }

//    Recursive Size solution

//    /** Returns the size of SLList starting at IntNode p **/
//    private static int size(IntNode p) {
//        if (p.next == null) {
//            return 1;
//        }
//        return 1 + size(p.next);
//    }
//
//    public int size() {
//        return size(first);
//    }


    // Caching solution - constant lookup time
    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        SLList l = new SLList(15);
        l.addFirst(10);
        l.addFirst(5);
        l.addLast(20);
        System.out.println(l.size());
    }
}