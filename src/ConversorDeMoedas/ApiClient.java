package ConversorDeMoedas;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.Gson;

public class ApiClient {
    public static ExchangeRateResponse getRates(String baseCurrency) throws IOException {
        String urlStr = "https://v6.exchangerate-api.com/v6/1b7f2eb729c0b8427f933da1/latest/" + baseCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            Scanner scanner = new Scanner(url.openStream());
            StringBuilder inline = new StringBuilder();
            while (scanner.hasNext()) {
                inline.append(scanner.nextLine());
            }
            scanner.close();

            Gson gson = new Gson();
            return gson.fromJson(inline.toString(), ExchangeRateResponse.class);
        }
    }
}