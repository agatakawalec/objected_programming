package build;
import java.util.LinkedList;
import javax.mail.*;
import javax.mail.internet.*;

public class test {
    public static void main(String[] args){
        LinkedList<String> temp = new LinkedList<String>();
        temp.add("zenek682@op.pl");
        temp.add("sosenkiewicz.marta@gmail.com");
        temp.add("wojcikania12@wp.pl");

        EmailMessage message = new EmailMessage.Builder("wojcikania12@wp.pl",temp).subject("Temat").content("123").build();
        message.send();
    }
}