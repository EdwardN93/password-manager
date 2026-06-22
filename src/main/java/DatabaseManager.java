import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:passwords.db";
    public static void connect() {

        try (Connection conn = DriverManager.getConnection(URL)) {

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


        try (Connection conn = DriverManager.getConnection(URL)) {

            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Table created successfully!");

        } catch (Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    public static void addEntry(PasswordEntry entry) {
        String sql = """
                    INSERT INTO passwords (
                    service_name, 
                    username, 
                    password, 
                    notes
                )
                    VALUES(?, ?, ?, ?)
                """;

        try (Connection conn = DriverManager.getConnection(URL)) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, entry.getServiceName());
            stmt.setString(2, entry.getUserName());
            stmt.setString(3, entry.getPassword());
            stmt.setString(4, entry.getNotes());

            stmt.executeUpdate();
            System.out.println(conn.getMetaData().getURL());
            System.out.println("Entry added successfully");

        } catch (Exception e) {
            System.out.println("Insert failed!");
            e.printStackTrace();
        }
    }

    private static void showAllEntriesFromDb(){

    }

}