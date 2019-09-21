package ru.sky.test.wrike.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ConnectorToURL {
    private static final String WRIKE_COM = "https://www.wrike.com";

    public static int connectionWrike() throws IOException {
        URL url = new URL(WRIKE_COM);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        return  httpCon.getResponseCode();

    }


}
