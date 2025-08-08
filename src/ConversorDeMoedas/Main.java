package ConversorDeMoedas;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            ExchangeRateResponse response = ApiClient.getRates("USD");

            while (true) {
                System.out.println("==== CONVERSOR DE MOEDAS ====");
                System.out.println("1. USD para BRL");
                System.out.println("2. BRL para USD");
                System.out.println("3. BOB para EUR");
                System.out.println("4. EUR para BOB");
                System.out.println("5. ARS para CLP");
                System.out.println("6. COP para BRL");
                System.out.println("7. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();

                if (opcao == 7) {
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