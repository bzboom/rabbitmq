package com.example.rabbitmq.rabbit.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @RabbitListener(queues = {"first-queue","second-queue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(String msgContent, Channel channel, Message message) throws Exception {
        // 处理消息
        System.out.println("FirstConsumer {} handleMessage :"+msgContent);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
