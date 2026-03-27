import java.time.LocalDateTime;

public class Anotacao {
    private int id;
    private String texto;
    private LocalDateTime dataCriacao;
    private boolean ativa;

    public Anotacao(int id, String texto) {
        if (texto == null || texto.isEmpty()) {
            throw new AnotacaoException("Texto não pode ser vazio");
        }

        this.id = id;
        this.texto = texto;
        this.dataCriacao = LocalDateTime.now();
        this.ativa = true;
    }

    public int getId() { return id; }
    public String getTexto() { return texto; }
    public boolean isAtiva() { return ativa; }

    public void editar(String novoTexto) {
        if (!ativa) {
            throw new AnotacaoException("Anotação removida");
        }
        if (novoTexto == null || novoTexto.isEmpty()) {
            throw new AnotacaoException("Novo texto inválido");
        }
        this.texto = novoTexto;
    }

    public void remover() {
        if (!ativa) {
            throw new AnotacaoException("Anotação já removida");
        }
        this.ativa = false;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Texto: " + texto;
    }
}