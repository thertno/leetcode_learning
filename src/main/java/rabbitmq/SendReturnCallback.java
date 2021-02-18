package rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendReturnCallback implements RabbitTemplate.ReturnCallback {
    private static final Logger log = LoggerFactory.getLogger(SendReturnCallback.class);

    @Override
    public void returnedMessage(Message message, int replyCode,String replyText, String exchange, String routingKey) {
        log.error("Fail... message:{},从交换机exchange:{},以路由键routingKey:{}," +
                        "未找到匹配队列，replyCode:{},replyText:{}",
                message, exchange, routingKey, replyCode, replyText);
    }
}
