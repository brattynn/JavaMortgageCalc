
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte monthsInYear = 12;
        final byte percent = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextFloat();
        float monthlyInterestRate = annualInterestRate / percent / monthsInYear;

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * monthsInYear;

        System.out.print("Yearly Property Tax: ");
        double yearlyPropertyTax = scanner.nextDouble();
        double monthlyPropertyTax = yearlyPropertyTax / monthsInYear;

        System.out.print("Yearly Insurance Premium: ");
        double yearlyInsurancePremium = scanner.nextDouble();
        double monthlyInsurancePremium = yearlyInsurancePremium / monthsInYear;

        double mortgage = principal
                            * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                            / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1))
                            + monthlyPropertyTax + monthlyInsurancePremium;

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
        }
    }