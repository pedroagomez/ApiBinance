package com.binance.ScrapBin.Controller;

import com.binance.ScrapBin.Model.CryptoInfo;
import com.binance.ScrapBin.Service.BinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/crypto")
@CrossOrigin(origins = "http://localhost:4200")
public class CryptoController {

    @Autowired
    private BinanceService binanceService;

    @GetMapping("/obtener")
    public ResponseEntity<?> obtenerCryptos() {
        List<CryptoInfo>listaCrypto = binanceService.datosCripto();
        if(listaCrypto.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listaCrypto);
    }

}
