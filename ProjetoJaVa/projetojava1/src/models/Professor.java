

class Professor extends Usuario {
    private String rg;

    public Professor(String nome, String login, String senha, String rg) {
        super(nome, login, senha);
        this.rg = rg;
    }
}
