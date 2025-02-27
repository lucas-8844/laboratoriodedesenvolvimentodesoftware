import java.util.ArrayList;
import java.util.List;

class curso {
    private String nome;
    private int creditos;
    private List<Disciplina> disciplinas = new ArrayList<>();

    public curso(String nome, int creditos) {
        this.nome = nome;
        this.creditos = creditos;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }
}

