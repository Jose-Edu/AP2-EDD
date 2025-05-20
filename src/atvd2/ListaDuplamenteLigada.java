package atvd2;

public class ListaDuplamenteLigada<T> {

    private Node<T> head;
    private Node<T> end;
    private Node<T> acNode;
    private int size;

    public ListaDuplamenteLigada() {

        this.head = null;
        this.end = null;
        this.acNode = null;
        this.size = 0;

    }

    public int getSize() {

        return this.size;

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

    public Node<T> getNodeByIndex(int i) {

        Node<T> nodeRtn = head;

        for (int c = 0; c < i; c++) {

            if (nodeRtn == null)
                return null;

            nodeRtn = nodeRtn.next;

        }

        return nodeRtn;

    }

    public void setNodeByIndex(int i) {

        Node<T> node = head;

        for (int c = 0; c < i; c++) {

            if (node == null)
                return;

            node = node.next;

        }

        this.acNode = node;

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
            this.size++;
            return;
        }

        this.end.next = node;
        node.previous = this.end;
        this.end = node;
        this.size++;

    }

    public void inserirNoInicio(T data) {
        Node<T> node = new Node<T>(data);

        if (this.head == null) {
            this.head = node;
            this.end = node;
            this.size++;
            return;
        }

        this.head.previous = node;
        node.next = this.head;
        this.head = node;
        this.size++;

    }

    public void inserirPorIndex(T data, int i) {

        if (i < 0 || i > size-1) {
            System.out.println("Index inválido!");
            return;
        }

        if (i == 0) {
            this.inserirNoInicio(data);
            return;
        }

        if (i == size-1) {
            this.inserirNoFim(data);
            return;
        }

        Node<T> acNode = head;

        for (int c=0; c < i-1; c++) {
            acNode = acNode.next;
        }

        Node<T> newNode = new Node<>(data);
        newNode.previous = acNode;
        newNode.next = acNode.next;
        //acNode.next = newNode;
        size++;

    }

    public void imprimir() {

        if (head == null)
            System.out.println("A lista está vazia...");

        Node<T> nodeAc = head;

        System.out.println("Núm. Músicas: "+size);
        System.out.println();

        for (int c=0; nodeAc != null; c++) {

            System.out.println(c+":");
            System.out.println(nodeAc.data);
            System.out.println();
            nodeAc = nodeAc.next;

        }
        System.out.println();

    }

    public void imprimirAtual() {

        if (this.getAcNode() == null) {
            System.out.println("Lista vazia...");
            return;
        }

        System.out.println(this.getAcNode().data);

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
            if (nodeAc.data.equals(data)) {

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

                // Any other
                nodeAc.previous.next = nodeAc.next;
                nodeAc.next.previous = nodeAc.previous;

            }

            nodeAc = nodeAc.next;
        }

        size--;

    }

    public void removerPorIndex(int i) {

        if (i < 0 || i > size-1) {
            System.out.println("Index inválido!");
            return;
        }

        Node<T> acNode = head;
        size--;

        for (int c=0; c < i; c++) {
            acNode = acNode.next;
        }

        if (i == size-1) {
            acNode.next = null;
            return;
        }

        if (i == 0) {
            acNode.next.previous = null;
            return;
        }

        acNode.next = acNode.next.next;
        acNode.next.previous = acNode;

    }

}
