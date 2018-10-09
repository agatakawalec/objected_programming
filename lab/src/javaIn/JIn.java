package javaIn;

import java.io.*;

public class JIn {
    public static String getString() {
        String text = null;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            text = bfr.readLine();
        }catch(IOException e){e.printStackTrace();}
        return text;
    }

    public static int getInt() {
        int number=0;
        try {
            System.out.print("Podaj liczbę: ");
            InputStreamReader i = new InputStreamReader(System.in);
            BufferedReader bf = new BufferedReader(i);

            number = bf.read();
        }catch(IOException e) {}
        return number;
    }
}