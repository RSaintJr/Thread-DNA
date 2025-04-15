import java.io.*;
import java.util.ArrayList;

public class SearchB {
    private File[] arquivos;

    public SearchB(File[] arquivos) {
        this.arquivos = arquivos;
    }

    private boolean fitaValida(String linha) {
        return linha.matches("[ATCG]+");
    }

    public void searchFile() throws IOException {
        for (File arquivo : arquivos) {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            FileWriter fw = new FileWriter("path\\complementar_" + arquivo.getName());
            BufferedWriter bw = new BufferedWriter(fw);

            String linha;
            int total = 0;
            int validas = 0;
            int invalidas = 0;
            ArrayList<String> fitasInvalidas = new ArrayList<>();

            while ((linha = br.readLine()) != null) {
                total++;
                linha = linha.trim();
                if (fitaValida(linha)) {
                    validas++;
                    bw.write(new StringBuilder(linha).reverse().toString());
                } else {
                    invalidas++;
                    bw.write("***FITA INVALIDA - " + linha);
                    fitasInvalidas.add("Fita " + total + ": " + linha);
                }
                bw.newLine();
            }

            br.close();
            bw.close();

            System.out.println("Arquivo: " + arquivo.getName());
            System.out.println("Total de fitas: " + total);
            System.out.println("Fitas válidas: " + validas);
            System.out.println("Fitas inválidas: " + invalidas);
            if (!fitasInvalidas.isEmpty()) {
                System.out.println("Lista de fitas inválidas:");
                for (String fitaInv : fitasInvalidas) {
                    System.out.println(fitaInv);
                }
            }
            System.out.println();
        }
    }
}
