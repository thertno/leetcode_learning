package rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendConfirmSuccess() {
        String content = "Message sent to exist exchange!";
        this.rabbitTemplate.convertAndSend("directConfirmExchange", "exist", content);
        System.out.println("########### SendConfirmSuccess : " + content);
    }

    public void sendConfirmError() {
        String content = "Message sent to not exist exchange!";
        this.rabbitTemplate.convertAndSend("notExistExchange", "exist", content);
        System.out.println("########### SendConfirmError : " + content);
    }

    public void sendReturn() {
        String content = "Message sent to exist exchange! But no queue to routing to";
        this.rabbitTemplate.convertAndSend("directConfirmExchange", "not-exist", content);
        System.out.println("########### SendWReturn : " + content);
    }
}
