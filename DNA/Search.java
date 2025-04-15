package DNA;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {

    private File f;

    public Search(File file){
        this.f = file;
    }

    public File getF() {
        return f;
    }

    public void setF(File f) {
        this.f = f;
    }

    public void searchFile(File newDna) throws IOException {
        newDna.createNewFile();
        FileWriter writer = new FileWriter(newDna);
        FileReader arq = new FileReader(getF());
        BufferedReader reader = new BufferedReader(arq);
        String line = reader.readLine();
        int ocurrency = 1;
        int ValidOcurrency = 0;
        int InvalidOcurrency = 0;
        Pattern pattern = Pattern.compile("[^ATCG]+", Pattern.CASE_INSENSITIVE);
        while (line != null){
            Matcher matcher = pattern.matcher(line);
            if (!matcher.find()){
                writer.write(new StringBuilder(line).reverse().toString());
                ValidOcurrency++;
            } else {
                System.out.println("\nFita " + ocurrency + " invalida " + line + "\n");
                writer.write(  "\n****FITA INVALIDA - " + line);
                InvalidOcurrency++;
            }
            line = reader.readLine();
            ocurrency++;
        }

        System.out.println("Total de fitas do arquivo: " + (ocurrency - 1));
        System.out.println("Número de fitas validas: " + ValidOcurrency);
        System.out.println("Número de fitas invalidas: " + InvalidOcurrency +"\n");
    }



}