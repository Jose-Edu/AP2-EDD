package atvd1;

public class Pedido {
    public int id;
    public static int countPedidos;
    public String desc;

    public Pedido(String desc) {

        countPedidos++;
        this.id = countPedidos;
        this.desc = desc;

    }

    @Override
    public String toString() {

        return "Pedido ["+this.id+"]: '"+this.desc+"'";

    }
}
