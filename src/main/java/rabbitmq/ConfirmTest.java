package rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest
@SpringBootConfiguration
@ComponentScan(basePackages = {"rabbitmq"})
public class ConfirmTest {
    @Autowired
    private Sender sender;

    @Test
    public void sendConfirmSuccess() {
        sender.sendConfirmSuccess();

//        结果：成功发送并消费了消息，并输出监听日志
//        ########### SendConfirmSuccess : Message sent to exist exchange!
//                Success... 消息成功发送到交换机! correlationData:null
//        ########### Receiver Msg:Message sent to exist exchange!
    }

    @Test
    public void sendConfirmError() {
        sender.sendConfirmError();
//        结果：消息发送失败，并输入监听日志
//        ########### SendConfirmError : Message sent to not exist exchange!
//                Fail... 消息发送到交换机失败! correlationData:null
//        Channel shutdown: channel error; protocol method: #method<channel.close>(reply-code=404, reply-text=NOT_FOUND - no exchange 'notExistExchange' in vhost '/', class-id=60, method-id=40)
    }

    @Test
    public void sendReturn() {
        sender.sendReturn();
//        结果：消息发送到交换机，但路由不到队列（不存在队列匹配路由键）
//        ########### SendWReturn : Message sent to exist exchange! But no queue to routing to
//        Success... 消息成功发送到交换机! correlationData:null
//        Fail... message:(Body:'Message sent to exist exchange! But no queue to routing to' MessageProperties [headers={}, contentType=text/plain, contentEncoding=UTF-8, contentLength=0, receivedDeliveryMode=PERSISTENT, priority=0, deliveryTag=0]),从交换机exchange:directConfirmExchange,以路由键routingKey:not-exist,未找到匹配队列，replyCode:312,replyText:NO_ROUTE
    }

}
