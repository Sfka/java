package project.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String mobile;
    private final String email;
    private String group;

    public ContactData(String FirstName,String LastName, String Address, String Mobile, String Email, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstName = FirstName;
        this.lastName = LastName;
        this.address = Address;
        this.mobile = Mobile;
        this.email = Email;
        this.group = group;
    }
    public ContactData(int id, String FirstName,String LastName, String Address, String Mobile, String Email, String group) {
        this.id = id;
        this.firstName = FirstName;
        this.lastName = LastName;
        this.address = Address;
        this.mobile = Mobile;
        this.email = Email;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
