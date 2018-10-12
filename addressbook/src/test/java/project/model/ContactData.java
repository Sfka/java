package project.model;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String mobile;
    private final String email;
    private String group;

    public ContactData(String FirstName, String LastName, String Address, String Mobile, String Email, String group) {
        firstName = FirstName;
        lastName = LastName;
        address = Address;
        mobile = Mobile;
        email = Email;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {return address; }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
}
