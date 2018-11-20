/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subtitles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javax.xml.transform.OutputKeys.ENCODING;

/**
 *
 * @author emate
 */
public class Subs {
    private String in;
    private String out;
    private int delay;
    private int fps;
    Subs(String _in, String _out, int _delay, int _fps){
        in = _in;
        out = _out;
        delay = _delay;
        fps = _fps;
    }
    
    public void delay(String in, String out,int delay, int fps){
        
    Pattern regexp = Pattern.compile("^\\{(\\d{1,6})\\}\\{(\\d{1,6})\\}(.+)$");
    Matcher matcher = regexp.matcher("");

    Path path = Paths.get(in);
 
    try (
      BufferedReader reader = Files.newBufferedReader(path);
      LineNumberReader lineReader = new LineNumberReader(reader);
      FileOutputStream output = new FileOutputStream(out);
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
    ){
      String line = null;
      while ((line = lineReader.readLine()) != null) {
        Matcher m = regexp.matcher(line);
        if(m.find()){
            int first = Integer.parseInt(m.group(1));
            int second = Integer.parseInt(m.group(2));
            first += fps/delay*1000;
            second += fps/delay*1000;
            System.out.println("Found value: " + m.group(1) );
         System.out.println("Found value: " + m.group(2) );
         writer.write("{" + String.valueOf(first) +"}{" + String.valueOf(second) +"}" + m.group(3));
         writer.newLine();
         writer.flush();
        }
        if (!matcher.find()) {
          String msg = "Line " + lineReader.getLineNumber() + " is bad: " + line;
        }
      } 
      
    }    
    catch (IOException ex){
      ex.printStackTrace();
    }
    }
    
}
