package com.bozhenko.alfarest.config;

import com.bozhenko.alfarest.controller.external.CommonApi;
import com.bozhenko.alfarest.controller.external.ExchangerApi;
import com.bozhenko.alfarest.controller.external.GifApi;
import com.bozhenko.alfarest.properties.ExchangeServiceProperties;
import com.bozhenko.alfarest.properties.GifServiceProperties;
import feign.Feign;
import feign.Target;
import feign.jackson.JacksonDecoder;
import lombok.AllArgsConstructor;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* @author Pavel Bozhenko <bozhenko@rekfost.ru>
*/
@Configuration
@AllArgsConstructor
public class ExternalServicesConfiguration {
    private final ExchangeServiceProperties exchangeServiceProperties;
    private final GifServiceProperties gifServiceProperties;

    @Bean
    public ExchangerApi getExchangerServiceClient() {
        return Feign.builder()
                    .requestInterceptor(template -> template.query("app_id", exchangeServiceProperties.getApiKey()))
                    .contract(new SpringMvcContract())
                    .decoder(new JacksonDecoder())
                    .target(ExchangerApi.class, exchangeServiceProperties.getUrl());
    }

    @Bean
    public GifApi getGifApi() {
        return Feign.builder()
                    .requestInterceptor(template -> template.query("api_key", gifServiceProperties.getApiKey()))
                    .decoder(new JacksonDecoder())
                    .target(GifApi.class, gifServiceProperties.getUrl());
    }

    @Bean
    public CommonApi getDownloadApi() {
        return Feign.builder()
                    .target(Target.EmptyTarget.create(CommonApi.class));
    }
}
