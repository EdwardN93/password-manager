import java.util.List;
import java.util.ArrayList;

public class PasswordManager {
    private List<PasswordEntry> entries = new ArrayList<>();


    public void addEntry(PasswordEntry entry){
        entries.add(entry);
    }

    public void showAllEntries(){
        for(PasswordEntry entry : entries){
            System.out.println(entry);
            System.out.println("---------------------");
        }
    }

    public void findEntryByService(String service){
        for(PasswordEntry entry : entries){
            if(entry.getServiceName().equalsIgnoreCase(service)){
                System.out.println(entry);
                System.out.println("---------------------");
            }
        }
    }
}
