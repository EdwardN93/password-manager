public class Main {
    public static void main(String[] args){
        DatabaseManager.connect();
        DatabaseManager.createTable();

        PasswordEntry pw1 = new PasswordEntry("Google", "edward.n@gmail.com", "asdf", "test");
        PasswordEntry pw2 = new PasswordEntry("Yahoo", "edward.n@yahoo.com", "aa231", "test2");
//        DatabaseManager.addEntry(pw1);
//        DatabaseManager.addEntry(pw2);

        DatabaseManager.showAllEntriesFromDb();
    }


}
