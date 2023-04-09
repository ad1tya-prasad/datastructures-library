package mylib.datastructures.nodes;

public class DNode {
    public int value;
    public DNode next;
    public DNode prev;

    public DNode(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
