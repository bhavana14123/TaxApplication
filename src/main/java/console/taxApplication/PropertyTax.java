package console.taxApplication;

import org.springframework.stereotype.Component;

@Component
public class PropertyTax implements Tax{
    double taxAmount;
    double taxableAmount;
    boolean isTaxPayed=false;
    @Override
    public void setTaxableAmount(int amount) {
        this.taxableAmount=amount;
    }

    @Override
    public void calculateTaxAmount() {
        taxAmount=.05*taxableAmount;
    }

    @Override
    public double getTaxAmount() {
        return this.taxAmount;
    }

    @Override
    public String getTaxType() {
        return "property";
    }

    @Override
    public boolean isTaxPayed() {
        return isTaxPayed;
    }

    @Override
    public void payTax() {
        System.out.println("Hii, your property tax is paid");
        isTaxPayed=true;
    }
}
