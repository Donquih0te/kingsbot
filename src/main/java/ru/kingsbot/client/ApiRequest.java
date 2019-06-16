package ru.kingsbot.client;

import org.apache.http.client.methods.HttpGet;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ApiRequest {

    private static final String API = "https://api.vk.com/method/";

    private final String method;
    private final Map<String, Object> params;

    public ApiRequest(String method, Map<String, Object> params) {
        this.method = method;
        this.params = params;
    }

    public HttpGet toHttp(String version, String token) {
        params.put("v", version);
        params.put("access_token", token);
        URI uri = URI.create(buildQuery());
        HttpGet get = new HttpGet(uri);
        get.addHeader("Content-Type", "application/json");
        return get;
    }

    private String buildQuery() {
        StringBuilder query = new StringBuilder(API);
        query.append(method).append("?");
//        String p = params.entrySet().stream()
//                .map(entry -> entry.getKey() + "=" + (entry.getValue() != null ? escape(entry.getValue().toString()) : ""))
//                .collect(Collectors.joining("&"));
//        query.append(p);
        params.forEach((k,v) -> {
            query.append(k).append("=").append(URLEncoder.encode(v.toString(), StandardCharsets.UTF_8)).append("&");
        });

        return query.toString();
    }

    private String escape(String data) {
        return URLEncoder.encode(data, StandardCharsets.UTF_8);
    }

    public static Builder newApiRequest() {
        return new Builder();
    }

    public static class Builder {

        private String method;
        private Map<String, Object> params = new HashMap<>();

        private Builder() {}

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder param(String key, Object value) {
            params.put(key, value);
            return this;
        }

        public Builder params(Map<String, Object> params) {
            this.params = params;
            return this;
        }

        public ApiRequest build() {
            return new ApiRequest(method, params);
        }
    }

}
