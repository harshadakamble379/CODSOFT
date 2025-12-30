import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter base currency (USD, INR, EUR): ");
            String base = sc.next().toUpperCase();

            System.out.print("Enter target currency (USD, INR, EUR): ");
            String target = sc.next().toUpperCase();

            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            String apiUrl = "https://api.frankfurter.app/latest?from=" 
                            + base + "&to=" + target;

            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();

            
            String rateStr = body.split(target + "\":")[1].split("}")[0].trim();
            double rate = Double.parseDouble(rateStr);

            double converted = amount * rate;

            System.out.println("\nConverted Amount:");
            System.out.printf("%.2f %s = %.2f %s\n", amount, base, converted, target);

        } catch (Exception e) {
            System.out.println("Error: Invalid currency or connection issue.");
        }

        sc.close();
    }
}


