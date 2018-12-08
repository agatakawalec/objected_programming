/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aga.Krypto;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Cryptographer {
    static StringBuilder input = new StringBuilder();
    static StringBuilder output = new StringBuilder();
    static StringBuilder tmp = new StringBuilder();

    public static void cryptfile(File withText, File plain, Algorithm alg) throws IOException {
        try (InputStream in = new FileInputStream(withText);
             Reader reader = new InputStreamReader(in)) {
            int c=0;
            char c2;
            while ((c = reader.read()) != -1) {
                if(c!=32 && c!='\n'){
                    tmp.append(char(c));

                } else{
                    input.append(Algorithm.crypt(tmp));
                    tmp.setLength(0);
            }
            }
        alg.crypt(input);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(plain))) {
            writer.write(input.toString());
        }
    }

    public static void encryptfile(File withText, File plain, Algorithm alg) throws IOException {
        try (InputStream in = new FileInputStream(withText);
             Reader reader = new InputStreamReader(in)) {
            int c;
            while ((c = reader.read()) != -1) {
                input.append(c);
            }
        }
        alg.encrypt(input);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(plain))) {
            writer.write(input.toString());
        }
    }
    
}
