package com.kitaplik.libraryservice.client;



import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignClientConfiguration {

    private final ObjectFactory<HttpMessageConverters> messageConverterObjectFactory;



    public FeignClientConfiguration(ObjectFactory<HttpMessageConverters> messageConverterObjectFactory) {
        this.messageConverterObjectFactory = messageConverterObjectFactory;
    }
/*
    @Bean
    public ErrorDecoder getErrorDecoder(){
        return new RetreiveMessageErrorDecoder();
    } */
}
