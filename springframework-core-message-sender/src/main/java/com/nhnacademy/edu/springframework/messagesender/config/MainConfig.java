package com.nhnacademy.edu.springframework.messagesender.config;

import com.nhnacademy.edu.springframework.messagesender.service.DoorayMessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.EmailMessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.SmsMessageSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class MainConfig {

   @Bean
   public SmsMessageSender smsMessageSender(){
      return new SmsMessageSender();
   }

   @Bean
   public EmailMessageSender emailMessageSender(){
      return new EmailMessageSender();
   }

   @Bean
   public DoorayMessageSender doorayMessageSender() {return new DoorayMessageSender();}

}
