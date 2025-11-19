public class contact{
    String name;
    String email;
    String address;
    String notes;
    String phoneNumber;
    boolean blocked;

    contact(String name, String email, String address, String notes, String phoneNumber, boolean blocked){
        this.name = name;
        this.email = email;
        this.address = address;
        this.notes = notes;
        this.phoneNumber = phoneNumber;
        this.blocked = blocked;
    }
}