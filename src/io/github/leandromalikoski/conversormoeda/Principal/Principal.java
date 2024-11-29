package io.github.leandromalikoski.conversormoeda.Principal;

import io.github.leandromalikoski.conversormoeda.metodos.Menu;

import java.util.InputMismatchException;

public class Principal {
    public static void main(String[] args) {
        try {
            Menu menu = new Menu();
            menu.chamarMenu();
        } catch (InputMismatchException e) {
            System.out.println("Erro: Opção inválida, tente novamente.");
        }
    }
}
