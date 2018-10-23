package zad4;

public class ROT11 implements Algorithm {
    public StringBuilder crypt(StringBuilder word){
        StringBuilder tmp=new StringBuilder();
        int len=word.length();
        for(int i=0; i<len; i++){
            char c=word.charAt(i);
            if(c+11<123 & c+11>96){
                tmp.append(c+11);
            }
            else{
                tmp.append(c+11+97);
            }
        }
        return tmp;
    }

    public StringBuilder encrypt(StringBuilder word){
        StringBuilder tmp=new StringBuilder();
        int len=word.length();
        for(int i=0; i<len; i++){
            char c=word.charAt(i);
            if(c+11<123 & c+11>96){
                tmp.append(c-11);
            }
            else{
                tmp.append(c-11+97);
            }
        }
        return tmp;
    }
}
