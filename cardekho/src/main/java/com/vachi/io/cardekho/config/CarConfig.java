package com.vachi.io.cardekho.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {

    @Value("${integration.creditByPanUrl}")
    private String creditByPanUrl;

    @Value("${integration.historyByPanUrl}")
    private String historyByPanUrl;

    @Value("${integration.creditUrl}")
    private String creditUrl;

    @Value("${integration.ipsUrl}")
    private String ipsUrl;

    @Value("${integration.carHistoryUrl}")
    private String carHistoryUrl;

    @Value("${integration.historyDetailsUrl}")
    private String historyDetailsUrl;

    public String getCreditByPanUrl() {
        return creditByPanUrl;
    }

    public void setCreditByPanUrl(String creditByPanUrl) {
        this.creditByPanUrl = creditByPanUrl;
    }

    public String getHistoryByPanUrl() {
        return historyByPanUrl;
    }

    public void setHistoryByPanUrl(String historyByPanUrl) {
        this.historyByPanUrl = historyByPanUrl;
    }

    public String getHistoryDetailsUrl() {
        return historyDetailsUrl;
    }

    public void setHistoryDetailsUrl(String historyDetailsUrl) {
        this.historyDetailsUrl = historyDetailsUrl;
    }

    public String getCarHistoryUrl() {
        return carHistoryUrl;
    }

    public void setCarHistoryUrl(String carHistoryUrl) {
        this.carHistoryUrl = carHistoryUrl;
    }

    public String getCreditUrl() {
        return creditUrl;
    }

    public void setCreditUrl(String creditUrl) {
        this.creditUrl = creditUrl;
    }

    public String getIpsUrl() {
        return ipsUrl;
    }

    public void setIpsUrl(String ipsUrl) {
        this.ipsUrl = ipsUrl;
    }

    @Override
    public String toString() {
        return "CarConfig{" +
                "creditByPanUrl='" + creditByPanUrl + '\'' +
                ", historyByPanUrl='" + historyByPanUrl + '\'' +
                ", creditUrl='" + creditUrl + '\'' +
                ", ipsUrl='" + ipsUrl + '\'' +
                ", carHistoryUrl='" + carHistoryUrl + '\'' +
                ", historyDetailsUrl='" + historyDetailsUrl + '\'' +
                '}';
    }
}