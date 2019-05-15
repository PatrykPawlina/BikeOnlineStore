package bike_store.domain;

public class Customer {

    private String firstName;
    private String lastName;
    private CustomerGender customerGender;
    private String emailAddress;

    public Customer() {
    }

    public Customer(String firsName, String lastName, CustomerGender customerGender, String emailAddress) {
        this.firstName = firsName;
        this.lastName = lastName;
        this.customerGender = customerGender;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CustomerGender getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(CustomerGender customerGender) {
        this.customerGender = customerGender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
