public class Main {
    public static void main(String[] args) {

        BlocoDeNotas bloco = new BlocoDeNotas();

        try {
            bloco.adicionar("Primeira anotação");
            bloco.adicionar("Segunda anotação");

            bloco.editar(1, "Texto atualizado");

            bloco.remover(2);

            System.out.println("Lista:");
            for (Anotacao a : bloco.listar()) {
                System.out.println(a);
            }

            System.out.println("\nBusca:");
            for (Anotacao a : bloco.buscar("Primeira")) {
                System.out.println(a);
            }

        } catch (AnotacaoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}