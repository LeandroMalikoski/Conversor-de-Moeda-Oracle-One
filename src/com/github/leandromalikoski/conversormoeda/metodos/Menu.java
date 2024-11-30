package com.github.leandromalikoski.conversormoeda.metodos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void chamarMenu() {
        Scanner scanner = new Scanner(System.in);
        Requisicao requisicao = new Requisicao();
        try {
            int op = 10;
            while (op != 0) {
                System.out.println("""
                        
                        **************** Menu ****************

                        1 - Real Brasileiro == Dólar Americano
                        2 - Dólar Americano == Real Brasileiro
                        3 - Real Brasileiro == Euro
                        4 - Euro            == Real Brasileiro
                        5 - Dólar Americano == Euro
                        6 - Euro            == Dólar Americano
                        7 - Peso Argentino  == Real Brasileiro
                        8 - Real Brasileiro == Peso Argentino
                        9 - Dólar Americano == Peso Argentino
                        0 - Sair

                        **************** Menu ****************
                        
                        Escolha uma opção:""");
                op = scanner.nextInt();
                if (op > 9) {
                    System.out.println("Opção inválida, tente novamente:");
                }
                switch (op) {
                    case 1:
                        requisicao.chamarApi("BRL", "USD");
                        break;
                    case 2:
                        requisicao.chamarApi("USD", "BRL");
                        break;
                    case 3:
                        requisicao.chamarApi("BRL", "EUR");
                        break;
                    case 4:
                        requisicao.chamarApi("EUR", "BRL");
                        break;
                    case 5:
                        requisicao.chamarApi("USD", "EUR");
                        break;
                    case 6:
                        requisicao.chamarApi("EUR", "USD");
                        break;
                    case 7:
                        requisicao.chamarApi("ARS", "BRL");
                        break;
                    case 8:
                        requisicao.chamarApi("BRL", "ARS");
                        break;
                    case 9:
                        requisicao.chamarApi("USD", "ARS");
                        break;
                    case 0:
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Opção inválida, tente novamente.");
        }
    }
}
