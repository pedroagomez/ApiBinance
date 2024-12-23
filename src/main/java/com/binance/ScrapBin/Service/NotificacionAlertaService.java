package com.binance.ScrapBin.Service;
import com.binance.ScrapBin.Model.CryptoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class NotificacionAlertaService {

    @Autowired
    private MonedaSeleccioanda monedaSeleccionadaService;

    @Autowired
    private BinanceService binanceService;

    private final List<String> notificaciones = new ArrayList<>();
    private final Set<String> notificacionesEnviadas = new HashSet<>();
    @Scheduled(fixedRate = 60000)
    public void verificarPrecios() {
        HashMap<String, Double> monedaSeleccionada = monedaSeleccionadaService.getMonedasSeleccionadas();

        if (monedaSeleccionada != null && !monedaSeleccionada.isEmpty()) {
            List<CryptoInfo> infoCrypto = binanceService.datosCripto();

            for (CryptoInfo cripto : infoCrypto) {
                if (monedaSeleccionada.containsKey(cripto.getSymbol())) {
                    String symbol = cripto.getSymbol();
                    Double monedaCambio = Double.parseDouble(cripto.getPriceChangePercent());
                    Double porcentajeParametro = monedaSeleccionada.get(symbol);

                    if (monedaCambio < porcentajeParametro && !notificacionesEnviadas.contains(symbol)) {
                        enviarNotificacion(cripto, porcentajeParametro);
                        notificacionesEnviadas.add(symbol);
                    }
                }
            }
        }
    }

    public void enviarNotificacion(CryptoInfo info, Double porcentaje) {
        String mensaje = "La cripto " + info.getSymbol() + " bajó más de un " + porcentaje + "%.";
        System.out.println(mensaje);
        agregarNotificacion(mensaje);
    }

    public void agregarNotificacion(String mensaje) {
        notificaciones.add(mensaje);
    }

    public List<String> getNotificaciones() {
        return new ArrayList<>(notificaciones);
    }

    public void limpiarNotificaciones() {
        notificaciones.clear();
        notificacionesEnviadas.clear();
    }
}
