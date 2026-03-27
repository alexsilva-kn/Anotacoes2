import java.util.ArrayList;
import java.util.List;

public class BlocoDeNotas {
    private List<Anotacao> anotacoes;
    private int contadorId;

    public BlocoDeNotas() {
        anotacoes = new ArrayList<>();
        contadorId = 1;
    }

    public void adicionar(String texto) {
        anotacoes.add(new Anotacao(contadorId++, texto));
    }

    private Anotacao buscarPorId(int id) {
        for (Anotacao a : anotacoes) {
            if (a.getId() == id) {
                return a;
            }
        }
        throw new AnotacaoException("Anotação não encontrada");
    }

    public void editar(int id, String texto) {
        Anotacao a = buscarPorId(id);
        a.editar(texto);
    }

    public void remover(int id) {
        Anotacao a = buscarPorId(id);
        a.remover();
    }

    public List<Anotacao> buscar(String termo) {
        List<Anotacao> resultado = new ArrayList<>();

        for (Anotacao a : anotacoes) {
            if (a.isAtiva() && a.getTexto().contains(termo)) {
                resultado.add(a);
            }
        }

        if (resultado.isEmpty()) {
            throw new AnotacaoException("Nenhuma anotação encontrada");
        }

        return resultado;
    }

    public List<Anotacao> listar() {
        List<Anotacao> lista = new ArrayList<>();

        for (Anotacao a : anotacoes) {
            if (a.isAtiva()) {
                lista.add(a);
            }
        }

        if (lista.isEmpty()) {
            throw new AnotacaoException("Nenhuma anotação ativa");
        }

        return lista;
    }
}