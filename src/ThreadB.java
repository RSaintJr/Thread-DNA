import java.io.File;
import java.io.IOException;

public class ThreadB implements Runnable {
    private final SearchB search;

    public ThreadB(File[] files) {
        this.search = new SearchB(files);
    }

    @Override
    public void run() {
        try {
            search.searchFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
