package rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "existQueue")
public class Receiver {
    @RabbitHandler
    public void process(String message) {
        System.out.println("########### Receiver Msg:" + message);
    }
}
