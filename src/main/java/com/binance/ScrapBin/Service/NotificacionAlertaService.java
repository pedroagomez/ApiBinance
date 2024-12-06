package com.binance.ScrapBin.Service;

import com.binance.ScrapBin.Controller.AlertaController;
import com.binance.ScrapBin.Model.CryptoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class NotificacionAlertaService {

    @Autowired
    private AlertaController alertaController;
    @Autowired
    private BinanceService binanceService;

    @Scheduled(fixedRate = 60000)
    public void verificarPrecios()
    {
        HashMap<String,Double>monedaSeleccionada= (HashMap<String, Double>) alertaController.getMonedasSeleccionadas().getBody();

        if(monedaSeleccionada != null &&!monedaSeleccionada.isEmpty())
        {
            List<CryptoInfo> infoCrypto = binanceService.datosCripto();
            for(CryptoInfo cripto  : infoCrypto)
            {
                if(monedaSeleccionada.containsKey(cripto.getSymbol()))
                {
                    String symbol = cripto.getSymbol();
                    Double monedaCambio = Double.parseDouble(cripto.getPriceChangePercent());
                    Double porcentajeParamtro= monedaSeleccionada.get(symbol);
                    if(monedaCambio < porcentajeParamtro)
                    {
                        enviarNotificacion(cripto,porcentajeParamtro);
                    }

                }
            }
        }
    }


    public StringBuilder enviarNotificacion(CryptoInfo info, Double porcentaje)
    {
        StringBuilder build = new StringBuilder();
        return build.append("La cripto "+info.getSymbol()+" bajo mas de un "+porcentaje);

    }

}
