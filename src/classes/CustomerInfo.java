public class CustomerInfo {
    private String CustomerName;
    private int Date;
    private String Email;
    private int Phone;
    private String JobAddress;
    private String BillingAddress;

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        Date = date;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
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

    public void setBilling_Address(String billingAddress) {
        BillingAddress = billingAddress;
    }
}
