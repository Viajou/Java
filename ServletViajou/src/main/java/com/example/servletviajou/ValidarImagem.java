package com.example.servletviajou;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ValidarImagem {
    public static boolean validateImageUrl(String url) {
        try {
            URL imageUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) imageUrl.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int responseCode = connection.getResponseCode();
            return (responseCode >= 200 && responseCode < 300);
        } catch (IOException e) {
            return false;
        }
    }
}
