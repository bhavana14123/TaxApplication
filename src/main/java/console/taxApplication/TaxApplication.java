package console.taxApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;
import java.util.Scanner;

@SpringBootApplication
public class TaxApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("console.taxApplication");
		 Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome to Tax Application !!!");

		while(true){
			System.out.println("Please select which tax you want to pay: \n1. Income \n2. Property \n3. Exit");
			int userChoice= scanner.nextInt();
			String taxChoice="";
			switch (userChoice){
				case 1 ->{
					taxChoice ="incomeTax";
				}
				case 2 ->{
					taxChoice="propertyTax";
				}
				case 3 ->{
					System.out.println("Exiting..");
					return;
				}
				default -> {
					System.out.println("Invalid choice!!");
					return;
				}
			}
			Tax tax=(Tax) context.getBean(taxChoice);
			if(tax.isTaxPayed()){
				System.out.println("You have already paid"+tax.getTaxType()+" tax.");
			}
			else {
				System.out.println("Enter the taxableAmount: ");
				int taxableAmount=scanner.nextInt();
				tax.setTaxableAmount(taxableAmount);
				tax.calculateTaxAmount();
//				double amount=tax.getTaxAmount();
				System.out.println("your taxAmount is: "+tax.getTaxAmount());
				System.out.println("Do you want to pay the Tax: \n1. Yes \n2. No");
				int input=scanner.nextInt();
				if(input==1){
					tax.payTax();
				}
				else{
					System.out.println("Exiting...");
					return;
				}
			}


		}

	}

}
