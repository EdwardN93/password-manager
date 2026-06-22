public class Main {
    public static void main(String[] args){
        DatabaseManager.connect();
        DatabaseManager.createTable();

        PasswordManager manager = new PasswordManager();

        manager.addEntry(new PasswordEntry("Google", "edward.n@gmail.com", "asdf", "Nobody has to know!"));
        manager.addEntry(new PasswordEntry("YouTube", "edward.n@yahoo.com", "xcvfdsa", "I won't remember"));

        manager.showAllEntries();
        manager.findEntryByService("Google");
        }
}
