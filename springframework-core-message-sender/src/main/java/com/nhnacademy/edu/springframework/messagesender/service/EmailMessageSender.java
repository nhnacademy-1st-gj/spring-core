package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.User;

public class EmailMessageSender implements MessageSender {
   public EmailMessageSender() {
      System.out.println("**Email Sender initiated**");
   }

   @Override
   public boolean sendMessage(User user, String message) {
      System.out.println("Email message send to: "+
              user.getEmail()+".."+
              message);
      return true;
   }

   void destroy(){
      System.out.println("destroy method called in EmailMessageSender\"");
   }

}
