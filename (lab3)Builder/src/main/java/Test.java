import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {
        LinkedList<String> list_to = new LinkedList<String>();
        list_to.add("kawalecagata98@gmail.com");
        try {
            EmailMessage wiadomosc = EmailMessage.builder()
                    .setFrom("agatakawalec98@gmail.com")
                    .setTo(list_to)
                    .setSubject("temat")
                    .setContent("treść")
                    .build();
            wiadomosc.send();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
