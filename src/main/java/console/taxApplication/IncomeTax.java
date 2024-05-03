package console.taxApplication;

import org.springframework.stereotype.Component;

@Component
public class IncomeTax implements Tax{
    double taxAmount;
    double taxableAmount;
    boolean isTaxPayed=false;
    @Override
    public void setTaxableAmount(int amount) {
        this.taxableAmount=amount;
    }

    @Override
    public void calculateTaxAmount() {
        if(taxableAmount<=300000){
            taxAmount=0;
        } else if (taxableAmount<=600000) {
            taxAmount=.05*taxableAmount;
        } else if (taxableAmount<=900000) {
            taxAmount=.1*taxableAmount;
        }
        else if (taxableAmount<=1200000){
            taxAmount=.15*taxableAmount;
        } else if (taxableAmount<=1500000) {
            taxAmount=.2*taxableAmount;
        }
        else{
            taxAmount=.3*taxableAmount;
        }

    }

    @Override
    public double getTaxAmount() {
        return taxAmount;
    }

    @Override
    public String getTaxType() {
        return "income";
    }

    @Override
    public boolean isTaxPayed() {
        return isTaxPayed;
    }

    @Override
    public void payTax() {
        System.out.println("Hii, your income tax is paid");
        isTaxPayed=true;
    }
}
