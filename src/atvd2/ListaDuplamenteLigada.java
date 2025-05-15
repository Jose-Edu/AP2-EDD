package atvd2;

public class ListaDuplamenteLigada<T> {

    private Node<T> head;
    private Node<T> end;
    private Node<T> acNode;

    public ListaDuplamenteLigada() {

        this.head = null;
        this.end = null;
        this.acNode = null;

    }

    public Node<T> getAcNode() {

        if(acNode == null) {
            acNode = this.head;
        }

        return acNode;
    }

    public Node<T> nextNode() {

        if (acNode.next == null) {
            acNode = head;
            return acNode;
        }

        acNode = acNode.next;
        return acNode;

    }

    public Node<T> previousNode() {

        if (acNode.previous == null) {
            acNode = end;
            return acNode;
        }

        acNode = acNode.previous;
        return acNode;

    }

    public void inserirNoFim(T data) {
        Node<T> node = new Node<T>(data);

        if (this.head == null) {
            this.head = node;
            this.end = node;
            return;
        }

        this.end.next = node;
        node.previous = this.end;
        this.end = node;

    }

    public void inserirNoInicio(T data) {
        Node<T> node = new Node<T>(data);

        if (this.head == null) {
            this.head = node;
            this.end = node;
            return;
        }

        this.head.previous = node;
        node.next = this.head;
        this.head = node;

    }

    public void imprimir() {

        if (head == null)
            System.out.println("A lista está vazia...");

        Node<T> nodeAc = head;

        while (nodeAc != null) {

            System.out.println(nodeAc.data);
            nodeAc = nodeAc.next;

        }
        System.out.println();

    }

    public boolean contem(T data) {

        if (head == null)
            System.out.println("A lista está vazia...");

        Node<T> nodeAc = head;

        while (nodeAc != null) {

            if(nodeAc.data == data)
                return true;

            nodeAc = nodeAc.next;

        }

        return false;
    }

    public void removerPorValor(T data) {

        if (this.head == null)
            return;

        Node<T> nodeAc = this.head;

        while (nodeAc != null) {
            if (nodeAc.data == data) {

                // First
                if (nodeAc == this.head) {
                    head = head.next;
                    if (head != null) head.previous = null;
                    return;
                }

                // Last one
                if (nodeAc == end) {
                    end = end.previous;
                    if(end!=null) end.next = null;
                    return;
                }

                nodeAc.previous.next = nodeAc.next;
                nodeAc.next.previous = nodeAc.previous;

            }

            nodeAc = nodeAc.next;
        }

    }


}
