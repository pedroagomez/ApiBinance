package com.binance.ScrapBin.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CryptoInfo {
   private String symbol;
   private String priceChange;
   private String priceChangePercent;
   private String lastPrice;
   private String volume;

    public CryptoInfo(String symbol, String priceChange, String priceChangePercent, String lastPrice, String volume) {
        this.symbol = symbol;
        this.priceChange = priceChange;
        this.priceChangePercent = priceChangePercent;
        this.lastPrice = lastPrice;
        this.volume = volume;
    }

    public CryptoInfo() {
    }
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(String priceChange) {
        this.priceChange = priceChange;
    }

    public String getPriceChangePercent() {
        return priceChangePercent;
    }

    public void setPriceChangePercent(String priceChangePercent) {
        this.priceChangePercent = priceChangePercent;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}
