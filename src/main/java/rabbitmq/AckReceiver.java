package rabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "existQueue")
public class AckReceiver {

    @RabbitHandler
    public void process(String content, Channel channel, Message message) {
        try {
            System.out.println("########### message:" + message);
            // 业务处理成功后调用，消息会被确认消费
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            // 业务处理失败后调用
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(),false, true);
            //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("########### Receiver Msg:" + content);
    }
}
