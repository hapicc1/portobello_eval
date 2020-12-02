package com.portobello.eval.message;

import com.portobello.eval.IntegrationApplication;
import com.portobello.eval.api.Request;
import com.portobello.eval.model.PracticalMessage;
import com.portobello.eval.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    private static final Logger log = LoggerFactory.getLogger(Sender.class);
    final static String GET_URL = "https://api.mercadolibre.com/products/MLB9652754";

    @Autowired
    private MessageRepository messageRepository;
    private final RabbitTemplate rabbitTemplate;

    private Sender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 60000L)
    public void sendMessage() {
        //mocked call to origin system API GET product
        PracticalMessage message = new PracticalMessage(Request.sendRequest(GET_URL, HttpMethod.GET, null),"sent");
        log.info(" -- GET REQUEST --");
        rabbitTemplate.convertAndSend(IntegrationApplication.EXCHANGE_NAME, IntegrationApplication.ROUTING_KEY, message);
        log.info("MESSAGE : "+messageRepository.save(message).getId()+" STATUS: "+ message.getStatus());
    }
}
