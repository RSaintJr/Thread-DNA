import java.io.File;

public class MainB {
    public static void main(String[] args) {
        File files = new File("path");
        File[] arq = files.listFiles();

        assert arq != null;
        Thread thread = new Thread(new ThreadB(arq));
        thread.start();
    }
}
