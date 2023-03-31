import com.nhnacademy.edu.springframework.messagesender.User;
import com.nhnacademy.edu.springframework.messagesender.service.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;

public class testMessageSender {


   @Test
   void testMessageSend(){
      DoorayMessageSender mockDoorayMessageSender = mock(DoorayMessageSender.class);
      MessageSendService messageSendService = new MessageSendService();
      User user = new User("test@test.com","010-1111-1111");

      messageSendService.setMessageSender(mockDoorayMessageSender);
      messageSendService.doSendMessage();

      Mockito.verify(mockDoorayMessageSender, Mockito.times(1)).sendMessage(Mockito.any(User.class),Mockito.anyString());
      //몇번 찍혔나 테스트 해봄
   }

   /*
   @InjectMocks
   private MessageSendService messageSendService; //얘의 객체를 만들어줌. 멍텅구리 아님.

   @Mock
   MessageSender MessageSender;



   @BeforeEach
   public void setup(){
      MockitoAnnotations.initMocks(this);
   }

   @Test
   void testEmailMessageSend(){
      messageSendService.doSendMessage();

      Mockito.verify(MessageSender, Mockito.times(1)).sendMessage(Mockito.any(User.class),Mockito.anyString());
   }

    */


}
