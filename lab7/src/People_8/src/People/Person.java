package People;

public class Person {
    private String fullName;
    private String pesel;
    private String phone;

    public Person(String n, String p, String h){
        fullName=n;
        pesel=p;
        phone=h;
    }

    public String getName(){
        return fullName;
    }

    public String getPesel(){
        return pesel;
    }
}
