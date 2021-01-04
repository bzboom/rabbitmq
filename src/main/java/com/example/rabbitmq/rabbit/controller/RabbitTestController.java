package com.example.rabbitmq.rabbit.controller;

import com.example.rabbitmq.rabbit.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RabbitTestController {

    @Autowired
    private ProducerService producerService;


    @RequestMapping("send")
    @ResponseBody
    public void send(String msg){
        producerService.sendToDirect("777788888","xixihaha");

    }
}
