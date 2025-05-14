public class Queue<T> {

    private LinkedList<T> data;

    public void push(T value) {

        data.insertEnd(value);

    }

    public T pop() {

        T rtn = this.pick();
        data.removeStart();
        return rtn;

    }

    public T pick() {

        return data.getElementByIndex(0);

    }

    public void display() {

        data.print();

    }

}
