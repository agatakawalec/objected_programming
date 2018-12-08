/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aga.Krypto;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author emate
 */
public class CryptoMain {
    public static void main(String[] argv) throws IOException{
        Algorithm al1=new ROT11();
        Algorithm al2=new Polibiusz();
        File wejscie=new File("C:\\Users\\emate\\Documents\\NetBeansProjects\\AgKrypto\\src\\Aga\\Krypto\\wejscie.txt");
        File wyjscie=new File("wyjscie.txt");
        Cryptographer.encryptfile(wejscie, wyjscie,al2);
        System.out.print("Hello World");
    }
}
