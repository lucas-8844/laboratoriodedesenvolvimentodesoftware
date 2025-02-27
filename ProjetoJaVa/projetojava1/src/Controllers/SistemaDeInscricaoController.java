
package Controllers;

class SistemaDeInscricaoController {
    @SuppressWarnings("FieldMayBeFinal")
    private SistemaDeInscricaoController sistema;

    public SistemaDeInscricaoController(SistemaDeInscricaoController sistema) {
        this.sistema = sistema;
    }

    public void matricularAluno(String matricula, String codigoDisciplina) {
        sistema.matricularAluno(matricula, codigoDisciplina);
    }
}
