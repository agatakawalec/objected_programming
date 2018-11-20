/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subtitles;

/**
 *
 * @author emate
 */
public class SubsMain {
    public static void main(String [ ] argv){
        String wejscie = "C:\\Users\\emate\\Documents\\NetBeansProjects\\Aga\\src\\Subtitles\\wejscie2.txt";
        String wyjscie = "C:\\Users\\emate\\Documents\\NetBeansProjects\\Aga\\src\\Subtitles\\wyjscie.txt";

        Subs test = new Subs(wejscie, wyjscie, 10,30);
        test.delay(wejscie, wyjscie, 10,30);
    }
    
}
