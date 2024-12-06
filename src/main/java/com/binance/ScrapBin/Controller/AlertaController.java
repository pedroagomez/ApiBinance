package com.binance.ScrapBin.Controller;

import com.binance.ScrapBin.Service.BinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/alerta")
@CrossOrigin(origins = "http://localhost:4200")
public class AlertaController {

    private final HashMap<String,Double> alerta = new HashMap<>();


    @PostMapping("/seleccionar")
    public ResponseEntity<?>seleccionarMoneda(@RequestParam String symbol,@RequestParam Double porcentaje)
    {
        alerta.put(symbol,porcentaje);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/seleccionadas")
    public ResponseEntity<?> getMonedasSeleccionadas()
    {
        return ResponseEntity.ok(alerta);
    }

}
