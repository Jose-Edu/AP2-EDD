//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ListaDuplamenteLigada<String> paises = new ListaDuplamenteLigada<>();

        paises.imprimir();
        paises.inserirNoFim("Brasil");
        paises.imprimir();
        paises.inserirNoFim("Argentina");
        paises.imprimir();
        paises.inserirNoInicio("França");
        paises.imprimir();
        System.out.println(paises.contem("Brasil"));
        System.out.println();
        paises.removerPorValor("França");
        paises.imprimir();

    }
}