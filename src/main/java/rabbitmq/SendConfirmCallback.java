package rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendConfirmCallback implements RabbitTemplate.ConfirmCallback {
    private static final Logger log = LoggerFactory.getLogger(SendConfirmCallback.class);

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b) {
            log.info("Success... 消息成功发送到交换机! correlationData:{}", correlationData);
        } else {
            log.info("Fail... 消息发送到交换机失败! correlationData:{}", correlationData);
        }
    }
}
