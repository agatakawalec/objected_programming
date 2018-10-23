package zad4;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Cryptographer {
    StringBuilder input = new StringBuilder();
    StringBuilder output = new StringBuilder();

    public void cryptfile(File withText, File plain) throws IOException {
        try (InputStream in = new FileInputStream(withText);
             Reader reader = new InputStreamReader(in)) {
            int c;
            while ((c = reader.read()) != -1) {
                input.append(c);
            }
        }
        Algorithm a=;
        a.crypt(input);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(plain))) {
            writer.write(input.toString());
        }
    }

    public void encryptfile(File withText, File plain) throws IOException {
        try (InputStream in = new FileInputStream(withText);
             Reader reader = new InputStreamReader(in)) {
            int c;
            while ((c = reader.read()) != -1) {
                input.append(c);
            }
        }
        Algorithm a;
        a.encrypt(input);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(plain))) {
            writer.write(input.toString());
        }
    }
}
