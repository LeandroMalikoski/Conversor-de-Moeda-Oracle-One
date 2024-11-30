package com.github.leandromalikoski.conversormoeda.metodos;

import com.github.leandromalikoski.conversormoeda.Modelos.Moedas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.github.leandromalikoski.conversormoeda.Modelos.MoedasExchangeRate;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Requisicao {
    Scanner sc = new Scanner(System.in);
    //Insira sua Chave da API na variável "key"
    String key = "886865d938e1eb6361941999";

    public void chamarApi(String cotacao1, String cotacao2) {
        try (HttpClient client = HttpClient.newHttpClient()){

            var endereco = "https://v6.exchangerate-api.com/v6/" + key + "/pair/";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco + cotacao1 + "/" + cotacao2))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            MoedasExchangeRate moedasExchangeRate = gson.fromJson(json, MoedasExchangeRate.class);

            Moedas moedas = new Moedas(moedasExchangeRate);

            System.out.println("Digite o valor que deseja converter:");
            double valorUsuario = sc.nextDouble();
            double valorConvertido = valorUsuario * moedas.getConversionRate();
            System.out.println("A conversão de " + valorUsuario + " (" + cotacao1 + ")" + " para " + "(" + cotacao2 + ")" + " resulta em = " + valorConvertido + " (" + cotacao2 + ")");

            System.out.println(moedas);
        } catch (InputMismatchException | IOException | InterruptedException e) {
            System.out.println("Erro: Valor inválido, por favor, tente novamente.");
            System.exit(1);
        }
    }
}
