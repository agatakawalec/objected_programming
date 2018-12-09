import java.sql.SQLException;

public class Main {
    public static void main(String[] argv) throws SQLException {
        DB test= new DB();
        test.connect();
        System.out.println(2);
        test.showAll();
    }
}
