package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.springframework.web.client.RestTemplate;

public class DoorayMessageSender implements MessageSender{

   public DoorayMessageSender() {
      System.out.println("**Dooray Sender initiated **");
   }

   @Override
   public boolean sendMessage(User user, String message) {
      System.out.println("Dooray sendMessage");
      String originalHookUrl = "https://hook.dooray.com/services/3036349505739914786/3371740733259172017/cdnzcggTTWmx2GtusEMUJw";
      String secondHookUrl = "https://hook.dooray.com/services/3204376758577275363/3384022857846510742/w6YfeELzSfayE8EQrVS3JA";
      String testHookUrl = "https://hook.dooray.com/services/3204376758577275363/3384802060404173420/9vXmcSzLRIKj-teIXqqwLw";

      new DoorayHookSender(new RestTemplate(), secondHookUrl)
              .send(DoorayHook.builder()
                      .botName("김지은")
                      .text(message)
                      .build());
      System.out.println("finish");
      return true;
   }
}
