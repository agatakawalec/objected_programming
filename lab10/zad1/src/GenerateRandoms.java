import java.io.*;
import java.util.Random;

public class GenerateRandoms {
    String name;

    GenerateRandoms(String _name) {
        name = _name;
    }

    public File writing() {
        Random rand = new Random();
        File file = new File("random.txt");
        try {
            FileOutputStream is = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 10000; j++) {
                    int n = rand.nextInt(100) + 1;
                    w.write(n);
                }
                w.write("\n");
            }
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
        return file;
    }
}
