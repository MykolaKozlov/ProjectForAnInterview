import java.io.File;

public class Main {

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        File file = new File("testFile\\a.txt");
        readFile.readFile(file);
        readFile.printMap();
    }
}
