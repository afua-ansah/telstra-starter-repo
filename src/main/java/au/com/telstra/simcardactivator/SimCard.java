package au.com.telstra.simcardactivator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SimCard {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
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

    public Long getId() {
        return id;
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
