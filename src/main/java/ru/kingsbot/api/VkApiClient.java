package ru.kingsbot.api;

import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpResponse;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;

@Log4j2
public class VkApiClient {

    private CloseableHttpAsyncClient client;

    public VkApiClient() {
        client = HttpAsyncClients.createDefault();
        client.start();
    }

    public String sendRequest(ApiRequest request) {
        String result = null;
        HttpResponse response = null;
        try {
            response = client.execute(request.get(), null).get();
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

    public CloseableHttpAsyncClient getHttpClient() {
        return client;
    }

    public void close() {
        try {
            client.close();
        } catch(IOException e) {
            log.error(e.getMessage(), e);
        }
    }

}
