package au.com.telstra.simcardactivator;

public class SimCard {
    private String iccd;
    private String customerEmail;

    public SimCard() {

    }
    
    public SimCard(String iccd, String customerEmail) {
        this.iccd = iccd;
        this.customerEmail = customerEmail;
    }

    public String getIccd() {
        return iccd;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setIccd(String iccd) {
        this.iccd = iccd;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

}
