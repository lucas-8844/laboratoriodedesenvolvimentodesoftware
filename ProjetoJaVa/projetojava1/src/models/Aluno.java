

class Aluno extends Usuario {
    private String numeroMatricula;

    public Aluno(String nome, String login, String senha, String numeroMatricula) {
        super(nome, login, senha);
        this.numeroMatricula = numeroMatricula;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }
}