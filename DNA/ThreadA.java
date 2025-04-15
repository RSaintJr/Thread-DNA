package DNA;

import java.io.File;
import java.io.IOException;

public class ThreadA implements Runnable{
    private final Search search;
    private int ocurrency;

    public ThreadA(File file, int ocurrency) throws IOException {
        this.search = new Search(file);
        this.ocurrency = ocurrency;
    }

    @Override
    public void run() {
        try {
            File newDna = new File("DNA-Verificado-"+ocurrency);
            search.searchFile(newDna);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}