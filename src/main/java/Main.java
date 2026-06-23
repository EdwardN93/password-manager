import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        DatabaseManager.connect();
        DatabaseManager.createTable();

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1. Get all entries.");
            System.out.println("2. New entry.");
            System.out.println("3. Delete entry.");
            System.out.println("4. Search By Service name.");
            System.out.println("5. Update password.");
            System.out.println("0. Exit");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        DatabaseManager.showAllEntriesFromDb();
                        break;

                    case 2:
                        addEntry(sc);
                        break;

                    case 3:
                        deleteEntry(sc);
                        break;

                    case 4:
                        searchByService(sc);
                        break;

                    case 5:
                        updatePassword(sc);
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e){
                System.out.println("Please enter a valid number");
            }
        }
    }

    public static void addEntry(Scanner sc){
        System.out.print("Service name: ");
        String serviceName = sc.nextLine();

        System.out.print("Username/Email: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        System.out.print("Notes: ");
        String notes = sc.nextLine();

        PasswordEntry entry = new PasswordEntry(
                serviceName,
                username,
                password,
                notes
        );

        DatabaseManager.addEntry(entry);
    }

    public static void deleteEntry(Scanner sc){
        System.out.println("Showing all entries...");
        DatabaseManager.showAllEntriesFromDb();

        System.out.print("Enter ID of entry to be deleted: ");
        int id = Integer.parseInt(sc.nextLine());
        DatabaseManager.deleteById(id);
    }

    public static void searchByService(Scanner sc){
        System.out.print("Enter service name: ");
        String service = sc.nextLine();
        DatabaseManager.searchByService(service);
    }

    public static void updatePassword(Scanner sc){
        System.out.print("Enter new password: ");
        String newPassword = sc.nextLine();

        System.out.print("Enter id of entry to change password: ");
        int id = Integer.parseInt(sc.nextLine());

        DatabaseManager.updatePassword(newPassword, id);
    }
}
