/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aga.Krypto;

/**
 *
 * @author emate
 */
public class Polibiusz implements Algorithm {
    final char[][] array= {{'a','b','c','d','e'},
                            {'f','g','h','i','k'},
                            {'l','m','n','o','p'},
                            {'q','r','s','t','u'},
                            {'v','w','x','y','z'}};

    public StringBuilder encrypt(StringBuilder word){
        StringBuilder tmp=new StringBuilder();
        String ePattern = "\\d{2}";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(word.toString());
        System.out.print("1");
        while(m.find()){
            System.out.print(m.find());
        }
        return tmp;
    }

    public StringBuilder crypt(StringBuilder word){
        StringBuilder tmp=new StringBuilder();
        for(int i=0; i<word.length(); i++){
            char c=word.charAt(i);
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    if(c==array[i][j] | c-32==array[i][j]){
                        System.out.print(i+j+" ");
                        tmp.append(i);
                        tmp.append(j);
                        tmp.append(" ");
                    }
                }
            }
        }
        return tmp;
    }
}
