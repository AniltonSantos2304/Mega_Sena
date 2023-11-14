package br.com.vainaweb.backendt3.introducaot3;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class MegaSena {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<Integer> numerosEscolhidos = new HashSet<>();
        Set<Integer> numerosDoSorteio = new HashSet<>();
        Random random = new Random();
        int pontos = 0;

        while (numerosEscolhidos.size() < 7) {
            try {
                System.out.println("------------------------------------");
                System.out.print("Digite um número entre (0 e 100): ");
                int numerosDigitados = input.nextInt();

                if (numerosDigitados >= 0 && numerosDigitados <= 100) {
                    if (!numerosEscolhidos.add(numerosDigitados)) {
                        System.out.println("Digite um número que não foi escolhido.");
                    }
                } else {
                    System.out.println("Digite um número entre 0 e 100, Por Favor!");
                }
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.print("Erro: informe um número inteiro\n");
            }
        }
        while (numerosDoSorteio.size() < 7) {
            Integer numerosGerados = random.nextInt(101);
            numerosDoSorteio.add(numerosGerados);
        }

        for (Integer numero : numerosDoSorteio) {
            if (numerosEscolhidos.contains(numero)) {
                pontos++;
            }
        }

        if (pontos == 7) {
            System.out.print("\nParabéns você acertou 7 pontos, e ganhou R$200.000,00");
        } else if (pontos == 6) {
            System.out.print("\nParabéns você acertou 6 pontos, e ganhou R$50.000,00");
        } else if (pontos == 5) {
            System.out.print("\nParabéns você acertou 5 pontos, e ganhou R$10.000,00");
        } else {
            System.out.printf("\nVocê não ganhou nada, mas sorte da próxima vez, sua pontuação: %d ponto.", pontos);
        }
        input.close();
    }
}
