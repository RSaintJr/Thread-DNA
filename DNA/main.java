package DNA;

import java.io.File;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        File files = new File("Path");
        File[] arq = files.listFiles();
        int ocurrency = 0;

        assert arq != null;
        for (File file : arq){
            Thread thread = new Thread(new ThreadA(file, ocurrency));
            thread.start();
            ocurrency++;
        }
    }
}
