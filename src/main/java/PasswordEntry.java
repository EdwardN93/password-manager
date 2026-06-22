public class PasswordEntry {
    private String serviceName;
    private String userName;
    private String password;
    private String notes;

    public PasswordEntry(String serviceName, String userName, String password, String notes){
        this.serviceName = serviceName;
        this.userName = userName;
        this.password = password;
        this.notes = notes;
    }

    public String getUserName(){return userName;}
    public String getServiceName(){return serviceName;}
    public String getPassword(){return password;}
    public String getNotes(){return notes;}

    @Override
    public String toString(){

        String hashedPass = "*".repeat(this.password.length());
        return "Service: " + this.serviceName + "\n" + "User Name: " + this.userName + "\n"
                + "Password: " + hashedPass + "\n" + "Notes: " + this.notes;
    }
}
