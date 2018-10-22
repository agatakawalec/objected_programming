import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class EmailMessage {

    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional

    protected EmailMessage( Builder builder){
        from=builder.from;
        to=builder.to;
        subject=builder.subject;
        content=builder.content;
        mimeType=builder.mimeType;
        cc=builder.cc;
        bcc=builder.bcc;
    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    public String getFrom() {
        return from;
    }

    public LinkedList<String> getTo() {
        return to;
    }

    static public class Builder{
        private String from;
        private LinkedList<String> to;
        private String subject;
        private String content;
        private String mimeType;
        private LinkedList<String> cc;
        private LinkedList<String> bcc;

        public EmailMessage build(){
            return new EmailMessage(this);
        }

        public boolean isValidEmailAddress(String email) {
            String ePattern = "^\\w*@+[a-z]*\\.+[a-z]*$";
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
            java.util.regex.Matcher m = p.matcher(email);
            System.out.print("4");
            return m.matches();
        }

        public Builder setFrom(String s){
            if(isValidEmailAddress(s)) from=s;
            else throw new IllegalArgumentException("Wrong e-mail address");
            System.out.print("3");
            return this;
        }

        public Builder setTo(LinkedList<String> s){
            /*for(String obj: s) {
                if(isValidEmailAddress(obj)) to.add(obj);
                else throw new IllegalArgumentException("Wrong e-mail address");
            }
            System.out.print("1");
            return this;*/
            for(int i=0; i<s.size(); i++){
                if(!isValidEmailAddress(s.get(i))){
                    throw new IllegalArgumentException("Niewłaściwy adres odbiorcy numer "+i);
                }
            }
            to=s;
            return this;
        }

        public Builder setSubject(String s){
            subject=s;
            System.out.print("2");
            return this;
        }

        public Builder setContent(String s){
            content=s;
            return this;
        }

        public Builder setMimeType(String s){
            mimeType=s;
            return this;
        }

        public Builder setCc(LinkedList<String> s){
            cc=s;
            return this;
        }

        public Builder stBcc(LinkedList<String> s){
            bcc=s;
            return this;
        }
    }

    public void send(){
        final String username = from;
        final String password;
        System.out.println("Type your password here: ");
        Scanner in=new Scanner(System.in);
        password=in.nextLine();

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance
                (props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("agatakawalec98@gmail.com"));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            System.out.println("Done.");
        }
        catch (MessagingException e){
            throw new RuntimeException(e);
        }
    }
}

