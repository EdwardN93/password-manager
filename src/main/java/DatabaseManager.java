import java.sql.*;

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

    public static void showAllEntriesFromDb() {
        String sql = "SELECT * FROM passwords";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            boolean foundEntries = false;
            while (rs.next()) {
                foundEntries = true;
                int id = rs.getInt("id");
                String serviceName = rs.getString("service_name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String notes = rs.getString("notes");

                System.out.println("ID: " + id);
                System.out.println("Service: " + serviceName);
                System.out.println("Username: " + username);
                System.out.println("Password: " + "*".repeat(password.length()));
                System.out.println("Notes: " + notes);
                System.out.println("---------------------");
            }
            if (!foundEntries) {
                System.out.println("No entries found.");
            }

        } catch (Exception e) {
            System.out.println("Select failed!");
            e.printStackTrace();
            }
        }

    public static void deleteById(int currentId) {
        String sql = "DELETE FROM passwords WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, currentId);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Entry deleted successfully!");
            } else {
                System.out.println("No entry found with id: " + currentId);
            }

        } catch (Exception e) {
            System.out.println("Delete failed!");
            e.printStackTrace();
        }
    }
}