package io.github.leandromalikoski.conversormoeda.Modelos;

public class Moedas {
    private final double conversionRate;

    public Moedas(MoedasExchangeRate moedasExchangeRate) {
        this.conversionRate = moedasExchangeRate.conversion_rate();
    }

    public double getConversionRate() {
        return conversionRate;
    }

    @Override
    public String toString() {
        return "A taxa de conversão da moeda selecionada: " + conversionRate;
    }
}
