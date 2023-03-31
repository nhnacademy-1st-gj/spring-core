package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.User;


public class SmsMessageSender implements MessageSender {


   public SmsMessageSender() {
      System.out.println("**SMS Sender initiated**");
   }


   @Override
   public boolean sendMessage(User user, String message) {
      System.out.println("SMS message send to: "+
              user.getPhoneNumber()+".."+
              message);
      return true;
   }

   void init(){
      System.out.println("init method called in SmsMessageSender");
   }
   void destroy(){
      System.out.println("destroy method called in SmsMessageSender\"");
   }
}
