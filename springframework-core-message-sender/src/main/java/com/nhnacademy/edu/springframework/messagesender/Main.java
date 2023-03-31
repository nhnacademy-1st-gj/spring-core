package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
   public static void main(String[] args) {
      try{
         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml"); //조립
         /* 위에 라인을 지나면서 어플리케이션 컨텍스트가 객체를 만든다. 이 라인이 끝나고 생성자가 시작되면 스프링 빈을 만듬
         스프링빈을 만드려면 아이디, 타입(xml에 정의가 되어있음), 객체가 필요.
         getBean하면 어플리케이션 컨텍스트에서 저장된 빈을 가져옴
         여기서 객체를 생성하고 이름,타입,객체를 묶어서 빈이라는 단위로 관리를 함
          */

         //MessageSender를 상속 받았기 때문에 MessageSender.class로 찾아온다. 그러면 두개가 나오는데 그중에서 우리가 부여한
         //id로 찾아옴
         //MessageSender emailSender = context.getBean("emailMessageSender",MessageSender.class);//관리
//         MessageSender smsSender = context.getBean("smsMessageSender",MessageSender.class); //앞에가 이름, 뒤에가 타입
//         System.out.println("--------------------");
//         context.getBean("emailMessageSender",MessageSender.class);
//         context.getBean("smsMessageSender",MessageSender.class);

//         emailSender.sendMessage(new User("dave","010-1111-1111"),"dd");
//         smsSender.sendMessage(new User("dave","010-1111-1111"),"dd");

         //new MessageSendService(smsSender).doSendMessage();

         //context.close();

         MessageSendService messageSendService = context.getBean("messageSendService",MessageSendService.class);
         messageSendService.doSendMessage();

      }catch (Exception e){
         e.printStackTrace();
      }
   }

}
