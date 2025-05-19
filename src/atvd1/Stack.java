package atvd1;

public class Stack<T> {

    private LinkedList<T> data;

    public Stack() {

        data = new LinkedList<>();

    }

    public void push(T value) {

        data.insertEnd(value);

    }

    public T pop() {

        T rtn = this.pick();
        data.removeEnd();
        return rtn;

    }

    public T pick() {

        return data.getElementByIndex(data.getSize()-1);

    }

    public void display() {

        data.print();

    }

}
