package ConversorDeMoedas;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            ExchangeRateResponse response = ApiClient.getRates("USD");

            while (true) {
                System.out.println("==== CONVERSOR DE MOEDAS ====");
                System.out.println("1. Dólar ==> Real");
                System.out.println("2. Real ==> Dólar");
                System.out.println("3. Boliviano ==> Euro");
                System.out.println("4. Euro ==> BolivianoB");
                System.out.println("5. Peso Argentino ==> Peso Chileno");
                System.out.println("6. Peso Colombiano ==> Real");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();

                if (opcao == 0) {
                    System.out.println("Saindo...");
                    break;
                }

                System.out.print("Digite o valor: ");
                double valor = scanner.nextDouble();
                double resultado = 0;

                switch (opcao) {
                    case 1 -> resultado = CurrencyConverter.convert("USD", "BRL", valor, response);
                    case 2 -> resultado = CurrencyConverter.convert("BRL", "USD", valor, response);
                    case 3 -> resultado = CurrencyConverter.convert("BOB", "EUR", valor, response);
                    case 4 -> resultado = CurrencyConverter.convert("EUR", "BOB", valor, response);
                    case 5 -> resultado = CurrencyConverter.convert("ARS", "CLP", valor, response);
                    case 6 -> resultado = CurrencyConverter.convert("COP", "BRL", valor, response);
                    default -> {
                        System.out.println("Opção inválida.");
                        continue;
                    }
                }

                System.out.printf("Valor convertido: %.2f%n%n", resultado);
            }

        } catch (Exception e) {
            System.out.println("Erro ao obter taxas de câmbio: " + e.getMessage());
        }

        scanner.close();
    }
}
