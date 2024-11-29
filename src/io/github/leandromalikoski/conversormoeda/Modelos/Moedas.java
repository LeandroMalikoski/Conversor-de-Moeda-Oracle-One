package io.github.leandromalikoski.conversormoeda.Modelos;

public class Moedas {
    private double conversionRate;

    public Moedas(MoedasExchangeRate moedasExchangeRate) {
        this.conversionRate = moedasExchangeRate.conversion_rate();
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    @Override
    public String toString() {
        return "Valor de conversão: " + conversionRate;
    }
}
