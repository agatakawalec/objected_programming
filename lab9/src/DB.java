
import java.sql.*;

public class DB{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public void connect() throws SQLException {
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://mysql.agh.edu.pl/agkawale", "agkawale", "atDC5JzSgY2m1zkZ");
    }


    public void showAll() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM books");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        while( rs.next() ) {
            for (int i = 1; i <= columnsNumber; ++i)
                System.out.print(rs.getString(i) + " ");
            System.out.println();
        }
    }

    public void listNames(){
        try {
            connect();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT name FROM users");

            while(rs.next()){
                String name = rs.getString(1);
                System.out.println("Uzytkownik: "+name);
            }
        }catch (SQLException ex){

        }finally {
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
    }


}

