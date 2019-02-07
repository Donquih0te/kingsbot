package ru.kingsbot.service;

import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import ru.kingsbot.api.ApiRequest;
import ru.kingsbot.api.VkApiClient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

@Log4j2
public class RequestHandler {

    private final VkApiClient vkApiClient;
    private final String token;
    private final String version;

    public RequestHandler(VkApiClient vkApiClient, String token, String version) {
        this.vkApiClient = vkApiClient;
        this.token = token;
        this.version = version;
    }

    public String sendVkApiRequest(ApiRequest request) {
        request.setToken(token);
        request.setVersion(version);
        return vkApiClient.sendRequest(request);
    }

    public String sendGetRequest(String url) {
        HttpGet get = new HttpGet(url);

        String body = null;
        HttpResponse response = null;
        try {
            response = vkApiClient.getHttpClient().execute(get, null).get();
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

}
