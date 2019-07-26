package com.tangly.apigateway.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.GeneralSecurityException;

/**
 * Zuul将请求转发至外网时用到
 */
@Configuration
public class HttpClientConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) throws GeneralSecurityException {
        RestTemplate restTemplate = builder.build();
        restTemplate.setRequestFactory(getHttpRequestFactory());
        return restTemplate;
    }

    @Bean
    @RefreshScope
    public HttpComponentsClientHttpRequestFactory getHttpRequestFactory() throws GeneralSecurityException {
        SSLContext sslContext = new SSLContextBuilder().build();
        HttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();
        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }
}
