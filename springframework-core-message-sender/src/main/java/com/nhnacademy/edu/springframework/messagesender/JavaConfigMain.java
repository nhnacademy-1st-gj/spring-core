package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigMain {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework.messagesender");

      MessageSendService messageSendService = context.getBean("messageSendService",MessageSendService.class);
      messageSendService.doSendMessage();
   }


}
