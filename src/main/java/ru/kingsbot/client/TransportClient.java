package ru.kingsbot.client;

import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

@Log4j2
public class TransportClient {

    private final String version;
    private final String token;

    private CloseableHttpAsyncClient client;

    public TransportClient(String version, String token) {
        this.version = version;
        this.token = token;

        client = HttpAsyncClients.createDefault();
    }

    public void start() {
        client.start();
    }

    public void close() {
        try {
            client.close();
        } catch(IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    // TODO: Use it in sendVkApiRequest and sendGetRequest
//    private String sendGet(HttpGet getRequest) {
//
//    }

    public String sendVkApiRequest(ApiRequest request) {
        String result = null;
        HttpResponse response = null;
        try {
            response = client.execute(request.toHttp(version, token), null).get();
        }catch(InterruptedException | ExecutionException e) {
            log.error(e.getMessage(), e);
        }
        if(response == null) {
            return "{}";
        }
        try {
            result = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
        }catch(IOException e) {
            log.error(e.getMessage(), e);
        }

        return result;
    }

    public String sendGetRequest(String url) {
        HttpGet get = new HttpGet(url);

        String body = null;
        HttpResponse response = null;
        try {
            response = client.execute(get, null).get();
        }catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage(), e);
        }
        if(response == null) {
            return null;
        }
        try {
            body = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        }catch(IOException e) {
            log.error(e.getMessage(), e);
        }
        return body;
    }

    public CloseableHttpAsyncClient getHttpClient() {
        return client;
    }

}
