import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Persistencia {
    public static void salvarCursos(List<curso> cursos, String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (curso curso : cursos) {
                writer.write(curso.getNome() + "," + curso.getCreditos());
                writer.newLine();
            }
        }
    }
    
    public static List<curso> carregarCursos(String arquivo) throws IOException {
        List<curso> cursos = new ArrayList<>();
        File file = new File(arquivo);
        if (!file.exists()) return cursos;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                cursos.add(new curso(partes[0], Integer.parseInt(partes[1])));
            }
        }
        return cursos;
    }
}