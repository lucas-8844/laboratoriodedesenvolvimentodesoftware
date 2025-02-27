import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            SistemaDeInscricao sistema = new SistemaDeInscricao();

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Adicionar Curso");
                System.out.println("2. Adicionar Aluno");
                System.out.println("3. Adicionar Disciplina");
                System.out.println("4. Matricular Aluno em Disciplina");
                System.out.println("5. Listar Alunos em uma Disciplina");
                System.out.println("6. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Nome do curso: ");
                        String nomeCurso = scanner.nextLine();
                        System.out.print("Créditos: ");
                        int creditosCurso = scanner.nextInt();
                        sistema.adicionarCurso(nomeCurso, creditosCurso);
                    }
                    case 2 -> {
                        System.out.print("Nome do aluno: ");
                        String nomeAluno = scanner.nextLine();
                        System.out.print("Login: ");
                        String login = scanner.nextLine();
                        System.out.print("Senha: ");
                        String senha = scanner.nextLine();
                        System.out.print("Matrícula: ");
                        String matricula = scanner.nextLine();
                        sistema.adicionarAluno(nomeAluno, login, senha, matricula);
                    }
                    case 3 -> {
                        System.out.print("Nome da disciplina: ");
                        String nomeDisciplina = scanner.nextLine();
                        System.out.print("Código: ");
                        String codigo = scanner.nextLine();
                        System.out.print("Créditos: ");
                        int creditosDisciplina = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome do professor: ");
                        String nomeProfessor = scanner.nextLine();
                        System.out.print("Login do professor: ");
                        String loginProf = scanner.nextLine();
                        System.out.print("Senha do professor: ");
                        String senhaProf = scanner.nextLine();
                        sistema.adicionarDisciplina(nomeDisciplina, codigo, creditosDisciplina, new Professor(nomeProfessor, loginProf, senhaProf, ""));
                    }
                    case 4 -> {
                        System.out.print("Matrícula do aluno: ");
                        String matriculaAluno = scanner.nextLine();
                        System.out.print("Código da disciplina: ");
                        String codDisciplina = scanner.nextLine();
                        sistema.matricularAlunoEmDisciplina(matriculaAluno, codDisciplina);
                    }
                    case 5 -> {
                        System.out.print("Código da disciplina: ");
                        String codigoDisc = scanner.nextLine();
                        sistema.listarAlunosNaDisciplina(codigoDisc);
                    }
                    case 6 -> {
                        System.out.println("Saindo...");
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            }
        }
    }
}

