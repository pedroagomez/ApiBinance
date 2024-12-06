package com.binance.ScrapBin.Service;

import com.binance.ScrapBin.Model.CryptoInfo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class BinanceService {

    private final String urlApi = "https://api.binance.com/api/v3/ticker/24hr";

    public List<CryptoInfo>datosCripto()
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<CryptoInfo>> respuesta= restTemplate.exchange(
                urlApi,
                org.springframework.http.HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CryptoInfo>>() {}  // lo utilizo para descerialzar
        );
        return respuesta.getBody();

    }
}
