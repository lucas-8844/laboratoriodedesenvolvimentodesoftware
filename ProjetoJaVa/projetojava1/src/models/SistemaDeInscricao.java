import java.util.ArrayList;
import java.util.List;

class SistemaDeInscricao {
    private List<curso> cursos = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();

    public void adicionarCurso(String nome, int creditos) {
        cursos.add(new curso(nome, creditos));
    }

    public void adicionarAluno(String nome, String login, String senha, String matricula) {
        alunos.add(new Aluno(nome, login, senha, matricula));
    }

    public void adicionarDisciplina(String nome, String codigo, int creditos, Professor professor) {
        disciplinas.add(new Disciplina(nome, codigo, creditos, professor));
    }
    
    public void matricularAlunoEmDisciplina(String matricula, String codigoDisciplina) {
        Aluno aluno = alunos.stream().filter(a -> a.getNumeroMatricula().equals(matricula)).findFirst().orElse(null);
        Disciplina disciplina = disciplinas.stream().filter(d -> d.getCodigo().equals(codigoDisciplina)).findFirst().orElse(null);
        
        if (aluno != null && disciplina != null) {
            disciplina.adicionarAluno(aluno);
            System.out.println("Aluno matriculado com sucesso!");
        } else {
            System.out.println("Aluno ou disciplina não encontrados!");
        }
    }
    
    public void listarAlunosNaDisciplina(String codigoDisciplina) {
        Disciplina disciplina = disciplinas.stream().filter(d -> d.getCodigo().equals(codigoDisciplina)).findFirst().orElse(null);
        if (disciplina != null) {
            disciplina.listarAlunos();
        } else {
            System.out.println("Disciplina não encontrada!");
        }
    }
}
