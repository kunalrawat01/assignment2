import java.util.Scanner;

public class InsurancePremiumCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String buildingType = sc.nextLine().trim();
        double amountInsured = Double.parseDouble(sc.nextLine().trim());
        int previousClaims = Integer.parseInt(sc.nextLine().trim());

        double premiumRate = 0.0;
        double processingCharge = 0.0;
        double discountRate = 0.0;

        if (buildingType.equalsIgnoreCase("Domestic")) {
            if (amountInsured < 100000) {
                premiumRate = 0.003 * amountInsured; 
            } else {
                premiumRate = 0.0025 * amountInsured; 
            }
            processingCharge = 50;
            if (previousClaims == 0) {
                discountRate = 0.10; 
            }
        }
        else if (buildingType.equalsIgnoreCase("Commercial")) {
            if (amountInsured < 250000) {
                premiumRate = 0.005 * amountInsured; 
            } else {
                premiumRate = 0.0075 * amountInsured; 
            }
            processingCharge = 80;
            if (previousClaims == 0) {
                discountRate = 0.15; 
            }
        } else {
            System.out.println("Invalid building type");
            sc.close();
            return;
        }

        double totalBeforeDiscount = premiumRate + processingCharge;

        double discount = totalBeforeDiscount * discountRate;
        double finalPremium = totalBeforeDiscount - discount;

        System.out.printf("%.2f%n", finalPremium);

        sc.close();
    }
}