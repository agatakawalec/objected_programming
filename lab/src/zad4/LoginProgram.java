package zad4;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;

public class LoginProgram {
    public static void main(String[] argv){
        Login log = new Login ("ala", "makota");
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);
            System.out.print("Podaj login: ");
            String login = bfr.readLine();
            System.out.print("Podaj haslo: ");
            String haslo = bfr.readLine();
        if(log.check(login,haslo)) System.out.println("OK");
        else System.out.print("Zły login lub hasło");
        }catch(IOException e){e.printStackTrace();}

    }
}

