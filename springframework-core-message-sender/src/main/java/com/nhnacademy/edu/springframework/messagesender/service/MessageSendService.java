package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.User;
import com.nhnacademy.edu.springframework.messagesender.factory_method.aop.TimeLogging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class MessageSendService {
   private MessageSender messageSender;

   @Autowired
   public MessageSendService(@Qualifier("doorayMessageSender") MessageSender messageSender) {
      this.messageSender = messageSender;
   }

   public MessageSendService() {
      this.messageSender = messageSender;
   }

   //@Autowired
   public void setMessageSender(MessageSender messageSender) {
      this.messageSender = messageSender;
   }

//   @Value("${from}")
//   private String name;

   public boolean doSendMessage(){
      messageSender.sendMessage(new User("test@test.com","010-1111-1111"),
              "test");
      return true;
   }
}
