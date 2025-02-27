
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static final String ARQUIVO_CURSOS = "cursos.txt";
    private static List<curso> cursos = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        cursos = Persistencia.carregarCursos(ARQUIVO_CURSOS);
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Curso");
            System.out.println("2. Listar Cursos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do curso: ");
                    String nome = scanner.nextLine();
                    System.out.print("Créditos: ");
                    int creditos = scanner.nextInt();
                    scanner.nextLine();
                    cursos.add(new curso(nome, creditos));
                    try {
                        Persistencia.salvarCursos(cursos, ARQUIVO_CURSOS);
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar cursos: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("\nCursos disponíveis:");
                    for (curso c : cursos) {
                        System.out.println(c);
                    }
                }
                case 3 -> {
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}

