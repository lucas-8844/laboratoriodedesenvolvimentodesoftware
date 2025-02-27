import java.util.ArrayList;
import java.util.List;

class Disciplina {
    private String nome;
    private String codigo;
    private int creditos;
    private Professor professor;
    private List<Aluno> alunosMatriculados = new ArrayList<>();

    public Disciplina(String nome, String codigo, int creditos, Professor professor) {
        this.nome = nome;
        this.codigo = codigo;
        this.creditos = creditos;
        this.professor = professor;
    }

    public void adicionarAluno(Aluno aluno) {
        alunosMatriculados.add(aluno);
    }
    
    public void listarAlunos() {
        System.out.println("Alunos matriculados em " + nome + ":");
        for (Aluno aluno : alunosMatriculados) {
            System.out.println("- " + aluno.nome + " (Matrícula: " + aluno.getNumeroMatricula() + ")");
        }
    }
    
    public String getCodigo() {
        return codigo;
    }
}
