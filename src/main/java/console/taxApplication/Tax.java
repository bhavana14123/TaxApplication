package console.taxApplication;

public interface Tax {
 void setTaxableAmount(int amount);
 void calculateTaxAmount();
 double getTaxAmount();
 String getTaxType();
 boolean isTaxPayed();
 void payTax();
}
