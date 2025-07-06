package com.csh.oms.order.config;

import com.csh.oms.order.client.InventoryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientRegistration {

    @Bean
    public InventoryClient createInventoryClient() {
        RestClient client = RestClient.builder().baseUrl("http://localhost:8082").build();
        RestClientAdapter restClientAdapter = RestClientAdapter.create(client);
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServiceProxyFactory.createClient(InventoryClient.class);
    }
}
