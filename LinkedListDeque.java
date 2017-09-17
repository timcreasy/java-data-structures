/**
 * Created by timcreasy on 9/3/17.
 */

public class LinkedListDeque<Item> {

    private class ItemNode {
        public ItemNode prev;
        public Item item;
        public ItemNode next;

        public ItemNode(ItemNode p, Item i, ItemNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    /******* Member Vars *********/

    private int size;
    private ItemNode sentinel;

    /******* Constructors ********/

    public LinkedListDeque() {
        sentinel = new ItemNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(Item i) {
        sentinel = new ItemNode(null, null, null);
        sentinel.next = new ItemNode(sentinel, i, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /******* Public API **********/

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void printDeque() {
        ItemNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println("");
    }

    public void addFirst(Item i) {
        sentinel.next = new ItemNode(sentinel, i, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    public void addLast(Item i) {
        sentinel.prev = new ItemNode(sentinel.prev, i, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    public Item removeFirst() {
        // Returns null if no item exists
        if (sentinel.next == sentinel) {
            return null;
        }
        Item first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return first;
    }

    public Item removeLast() {
        // Returns null if no item exists
        if (sentinel.prev == sentinel) {
            return null;
        }
        Item last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return last;
    }

    public Item get(int index) {
        if (size == 0 && index == 0) {
            return null;
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        ItemNode p = sentinel.next;
        while (i < index) {
            p = p.next;
            i++;
        }
        return p.item;
    }

//    private static ItemNode getRecursive(ItemNode p, int index) {
//        if (index == 0) {
//            return p;
//        }
//        return getRecursive(p.next, index--);
//    }
//
//    public Item getRecursive(int index) {
//        if (size == 0 && index == 0) {
//            return null;
//        }
//        if (index >= size) {
//            throw new IndexOutOfBoundsException();
//        }
//        return getRecursive(sentinel.next, index).item;
//    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> l = new LinkedListDeque<>(2);
        l.addFirst(1);
//        l.addFirst(2);
//        l.addFirst(1);
        l.addLast(3);
        System.out.println(l.size());
        System.out.println(l.isEmpty());
        l.printDeque();
//        System.out.println(l.removeFirst());
//        l.printDeque();
//        System.out.println(l.removeLast());
//        l.printDeque();
//        System.out.println(l.removeLast());
//        l.printDeque();
//        System.out.println(l.removeLast());
//        System.out.println(l.removeLast());
//        System.out.println(l.removeLast());
//        System.out.println(l.removeFirst());
//        l.printDeque();
        System.out.println(l.get(1));
    }

}
