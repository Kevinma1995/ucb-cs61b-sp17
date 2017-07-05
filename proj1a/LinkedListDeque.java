/**
 * @author Ziyi Yan cxfyzy@gmail.com
 *         Created on 04/07/2017.
 */
public class LinkedListDeque<Item> implements Deque<Item> {
    private class Node {
        Item item;
        Node prev;
        Node next;

        public Node() {
            this.item = null;
            this.prev = null;
            this.next = null;
        }

        public Node(Item item) {
            this.item = item;
            this.prev = null;
            this.next = null;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(Item item) {
        Node node = new Node(item);
        node.prev = sentinel;
        node.next = sentinel.next;
        sentinel.next = node;
        size++;
    }

    @Override
    public void addLast(Item item) {
        Node node = new Node(item);
        node.prev = sentinel.prev;
        node.next = sentinel;
        sentinel.prev = node;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node curr = sentinel.next;
        while (curr != sentinel) {
            System.out.print(curr.item + " ");
            curr = curr.next;
        }
    }

    @Override
    public Item removeFirst() {
        Item toRemove = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size--;
        return toRemove;
    }

    @Override
    public Item removeLast() {
        Item toRemove = sentinel.prev.item;
        sentinel.next = sentinel.next.next;
        size--;
        return toRemove;
    }

    @Override
    public Item get(int index) {
        Node curr = sentinel.next;
        while (index-- > 0) {
            curr = curr.next;
        }
        return curr.item;
    }

    public Item getRecursive(int i) {
        return getRecursive(i, sentinel.next);
    }

    public Item getRecursive(int i, Node curr) {
        if (i == 0) {
            return curr.item;
        }
        return getRecursive(i - 1, curr.next);
    }
}
