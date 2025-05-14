package atvd1;

public class LinkedList<T> {

    private Node2<T> head = null;
    private int size = 0;

    public void insertEnd(T data) {

        Node2<T> node = new Node2<>(data);
        Node2<T> nodeC = head;

        while (nodeC.next != null) {
            nodeC = nodeC.next;
        }

        nodeC.next = node;
        size++;

    }

    public void insertStart(T data) {

        Node2<T> node = new Node2<>(data);

        node.next = head;
        head = node;
        size++;

    }

    public void removeStart() {

        head = head.next;
        size--;

    }

    public void removeEnd() {

        Node2<T> nodeC = head;
        Node2<T> prev = head;

        while (nodeC.next != null) {
            prev = nodeC;
            nodeC = nodeC.next;
        }

        prev.next = null;
        size--;

    }

    public T getElementByIndex(int i) {


        Node2<T> nodeRtn = head;

        for (int c = 0; c < i; c++) {

            if (nodeRtn == null)
                return null;

            nodeRtn = nodeRtn.next;

        }

        return nodeRtn.data;

    }

    public void print() {

        Node2<T> nodeC = head;

        while (nodeC != null) {

            System.out.println(nodeC.data);
            nodeC = nodeC.next;

        }
        System.out.println();

    }

    public int getSize() {
        return size;
    }

}
