
import java.sql.*;

public class DB {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void finalFunc(){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) { }
            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) { }
            stmt = null;
        }
    }
    public void connect(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/agkawale", "agkawale", "fbkypLh1M41vQtJS");
            /*try(ResultSet rs = stmt.executeQuery("SELECT title FROM books")) {
                //przeglądnięcie obiektu typu ResultSet element po elemencie
                while( rs.next() ) {
                    //Wybranie pierwszej kolumny w postaci Stringa
                    System.out.println(rs.getString(1));
                }
            }*/
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void listNames(){
        try {
            connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books");

            ResultSetMetaData rsmd = rs.getMetaData();

            int columnsNumber = rsmd.getColumnCount();
            System.out.println(columnsNumber);
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();

            /*while(rs.next()){
                String name = rs.getString(1);
                System.out.println("Tytuł: "+name);
            }*/
            }

        }catch (SQLException ex){
            // handle any errors

        }finally {
            finalFunc();
        }
    }

    public void searchAuthor(String surname){
        try {
            connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT title FROM books WHERE author LIKE '% \"+surname+\"'");
            if (!rs.next()) {
                System.out.println("No records found");

            }
            else {
                do {
                    String name = rs.getString(1);
                    System.out.println("Tytuł: "+name);
                } while (rs.next());
            }
        }catch (SQLException ex){

        }finally {
            finalFunc();
        }
    }

    public void searchIsbn(String number){
        try {
            connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT title FROM books WHERE isbn LIKE number");
            if (!rs.next()) {
                System.out.println("No records found");

            }
            else {
                do {
                    String name = rs.getString(1);
                    System.out.println("Tytuł: "+name);
                } while (rs.next());
            }
        }catch (SQLException ex){

        }finally {
            finalFunc();
        }
    }

    public void addBook(String isbn, String title, String author, String year){
        try {
            connect();
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO books(isbn,title,author,year) VALUES ('"+isbn+"','" +title
                    +"','" +author+"','"+year+"');");
        }catch (SQLException ex){

        }finally {
            finalFunc();
        }
    }

}
