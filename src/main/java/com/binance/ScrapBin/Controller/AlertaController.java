package com.binance.ScrapBin.Controller;

import com.binance.ScrapBin.Model.CryptoInfo;
import com.binance.ScrapBin.Service.BinanceService;
import com.binance.ScrapBin.Service.MonedaSeleccioanda;
import com.binance.ScrapBin.Service.NotificacionAlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/alerta")
@CrossOrigin(origins = "http://localhost:4200")
public class AlertaController {

    @Autowired
    private BinanceService binanceService;

    @Autowired
    private MonedaSeleccioanda monedaSeleccionadaService;

    @Autowired
    private NotificacionAlertaService notificacionAlertaService;

    /**
     * Endpoint para seleccionar una moneda y su porcentaje de cambio.
     * @param symbol El símbolo de la criptomoneda.
     * @param porcentaje El porcentaje de cambio para activar la alerta.
     * @return Respuesta con mensaje de éxito o error.
     */
    @PostMapping("/seleccionar")
    public ResponseEntity<?> seleccionarMoneda(@RequestParam String symbol, @RequestParam Double porcentaje) {
        // Verificar si el símbolo ingresado existe
        List<CryptoInfo> listaCrypto = binanceService.datosCripto();
        boolean exists = listaCrypto.stream().anyMatch(crypto -> crypto.getSymbol().equalsIgnoreCase(symbol));

        if (!exists) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El símbolo ingresado no existe.");
        }

        // Agregar moneda y porcentaje al servicio de monedas seleccionadas
        monedaSeleccionadaService.agregarMoneda(symbol, porcentaje);
        return ResponseEntity.ok("Moneda seleccionada exitosamente.");
    }

    /**
     * Endpoint para obtener las monedas seleccionadas con sus porcentajes.
     * @return Lista de monedas seleccionadas.
     */
    @GetMapping("/seleccionadas")
    public ResponseEntity<?> getMonedasSeleccionadas() {
        return ResponseEntity.ok(monedaSeleccionadaService.getMonedasSeleccionadas());
    }

    /**
     * Endpoint para obtener las notificaciones generadas por el sistema.
     * @return Lista de notificaciones.
     */
    @GetMapping("/notificaciones")
    public ResponseEntity<List<String>> obtenerNotificaciones() {
        return ResponseEntity.ok(notificacionAlertaService.getNotificaciones());
    }
}
