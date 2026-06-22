import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseManager {

    public static void connect() {

        String url = "jdbc:sqlite:passwords.db";

        try (Connection conn = DriverManager.getConnection(url)) {

            System.out.println("Connected to SQLite!");


        } catch (Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    public static void createTable(){
        String sql = """
                CREATE TABLE IF NOT EXISTS passwords (
                                id INTEGER PRIMARY KEY AUTOINCREMENT,
                        service_name TEXT NOT NULL,
                        username TEXT NOT NULL,
                        password TEXT NOT NULL,
                        notes TEXT
                );
        """;
        String url = "jdbc:sqlite:passwords.db";

        try (Connection conn = DriverManager.getConnection(url)) {

            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Table created successfully!");

        } catch (Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }


}