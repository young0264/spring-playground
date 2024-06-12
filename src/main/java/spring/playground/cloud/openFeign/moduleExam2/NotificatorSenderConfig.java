package spring.playground.cloud.openFeign.moduleExam2;//package org.okestro.tps.notificator.infrastructure.config;
//
//import feign.Feign;
//import org.okestro.tps.common_lib.infrastructure.client.IntegrationClientWithNotificator;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class NotificatorSenderConfig {
//
//    @Value("${notificator.url}")
//    private String requestUrl;
//
//    @Bean
//    public IntegrationClientWithNotificator integrationClientWithNotificator(){
//        return  Feign.builder()
//                .target(IntegrationClientWithNotificator.class, requestUrl)
//        ;
//    }
//
//}
