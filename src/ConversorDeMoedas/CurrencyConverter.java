package ConversorDeMoedas;

public class CurrencyConverter {
    public static double convert(String from, String to, double amount, ExchangeRateResponse rates) {
        if (from.equals("USD")) {
            double rate = rates.conversion_rates.get(to);
            return amount * rate;
        } else {
            double rateFrom = rates.conversion_rates.get(from);
            double rateTo = rates.conversion_rates.get(to);
            return (amount / rateFrom) * rateTo;
        }
    }
}