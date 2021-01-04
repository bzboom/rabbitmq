package com.example.rabbitmq.rabbit.service;

import com.example.rabbitmq.rabbit.RabbitMqConfiger;
import com.example.rabbitmq.rabbit.callback.MsgCallBack;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MsgCallBack msgCallBack;

    public void sendToDirect(String uuid,String message){
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(RabbitMqConfiger.DIRECT_EXCHANGE, "randomkey",
                message, correlationId);
    }
}
