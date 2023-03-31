package com.nhnacademy.edu.springframework.messagesender.config;

import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.SmsMessageSender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:message.properties")
public class ServiceConfig {

   private final MessageSender messageSender; //config 자체를 가져오는게 아니라 메세지센더 타입의 빈을 가져오는거.

   public ServiceConfig(@Qualifier("doorayMessageSender") MessageSender messageSender) {
      this.messageSender = messageSender;
   }

   @Bean
   public MessageSendService messageSendService(){
      return new MessageSendService(messageSender);
   }
}
