package com.binance.ScrapBin.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service

public class MonedaSeleccioanda {
    private final HashMap<String, Double> monedasSeleccionadas = new HashMap<>();

    public HashMap<String, Double> getMonedasSeleccionadas() {
        return monedasSeleccionadas;
    }

    public void agregarMoneda(String symbol, Double porcentaje) {
        monedasSeleccionadas.put(symbol, porcentaje);
    }
}
