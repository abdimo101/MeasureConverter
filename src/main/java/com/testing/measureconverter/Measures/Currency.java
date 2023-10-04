package com.testing.measureconverter.Measures;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.boot.json.BasicJsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Currency {
    private String baseCurrency;
    private final String URL = "https://freecurrencyapi.net/";
    private final String APIKEY = "cur_live_uVRDVl0xaz2hg1dI7i0KKW7Z5KzWkzpYcck23Jaq";

    public Currency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public double convert(double amount) throws IOException {
        URL url = new URL(URL + "latest?apikey="+APIKEY+"&base_currency="+baseCurrency);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        double convertedNumber = 0.0;
        try {
            if(request.getResponseCode() == 200) {
                JsonParser jp = new JsonParser();
                JsonElement root = jp.parse(new InputStreamReader(request.getInputStream()));
                JsonObject jsonObject = root.getAsJsonObject();
                JsonObject rates = jsonObject.getAsJsonObject("rates");

                String code = "USD";

                if(rates.has(code)){
                    double exchangeRate = rates.get(code).getAsDouble();
                    convertedNumber = amount * exchangeRate;
                }
                else {
                    throw new IllegalArgumentException("Non valid currency code: " + code);
                }
            } else {
                throw new IOException("Failed to fetch exchange rates. Status code: " + request.getResponseCode());
            }
        } finally {
            request.disconnect();
        }
        return Math.round(convertedNumber * 100.0) / 100.0;
    }


}
