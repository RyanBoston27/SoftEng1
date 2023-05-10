package classes;
public class CustomerInfo {
    private String FirstName;
    private String LastName;
    private String Date;
    private String Email;
    private String Phone;
    private String JobAddress;
    private String BillingAddress;

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }


    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getJobAddress() {
        return JobAddress;
    }

    public void setJobAddress(String jobAddress) {
        JobAddress = jobAddress;
    }

    public String getBillingAddress() {
        return BillingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        BillingAddress = billingAddress;
    }
}
