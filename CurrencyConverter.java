import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class CurrencyConverter {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Map<String, BigDecimal>rates = new HashMap<>();
        rates.put("USD",new BigDecimal("1.0"));
        rates.put("INR",new BigDecimal("83.50"));
        rates.put("EUR",new BigDecimal("0.92"));
        rates.put("GBP",new BigDecimal("0.79"));
        boolean repeat = true;
        do{
            try {
                System.out.println("\nAvailable Currencies:USD,INR,EUR,GBP");
                System.out.println("Enter Source Currency:");
                String from = sc.next().toUpperCase();
                System.out.print("Enter Target Currency:");
                String to = sc.next().toUpperCase();
                if(!rates.containsKey(from)||!rates.containsKey(to)){
                    System.out.println("Invalid Currency Code.");
                    continue;
                }
                System.out.print("Enter Amount:");
                BigDecimal amount = sc.nextBigDecimal();
                if(amount.compareTo(BigDecimal.ZERO)<0)
                {
                    System.out.println("Amount cannot be negative:");
                    continue;
                }
                BigDecimal usdAmount= amount.divide(rates.get(from),10,RoundingMode.HALF_EVEN);
                BigDecimal convertedAmount=usdAmount.multiply(rates.get(to)).setScale(2,RoundingMode.HALF_EVEN);
                System.out.println("ConvertedAmount:"+convertedAmount+""+to);
            } catch (Exception e) {
                System.out.println("Invalid Input.");
                sc.nextLine();
            }
            System.out.print("Do you want another conversion?(yes/no):");
            String choice = sc.next().toLowerCase();
            repeat = choice.equals("yes");
        }
        while(repeat);
        System.out.println("Thank You!");
        sc.close();
    }
}
