package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SimCard {
    private String iccid;
    private String customerEmail;
    private boolean activationSuccess;

    public SimCard() {

    }

    public SimCard(String iccid, String customerEmail, boolean active) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
        this.activationSuccess = active;
    }

    public String getIccid() {
        return iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public boolean getActivationSuccess() {
        return activationSuccess;
    }

    public void setIccd(String iccid) {
        this.iccid = iccid;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setActivationSuccess(boolean activationSuccess) {
        this.activationSuccess = activationSuccess;
    }
}
