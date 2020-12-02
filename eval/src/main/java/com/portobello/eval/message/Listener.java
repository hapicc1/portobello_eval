package com.portobello.eval.message;

import com.portobello.eval.IntegrationApplication;
import com.portobello.eval.api.Request;
import com.portobello.eval.model.PracticalMessage;
import com.portobello.eval.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;


@Service
public class Listener {

    private static final Logger log = LoggerFactory.getLogger(Sender.class);
    final static String POST_URL = "http://localhost:8081/products";
    @Autowired
    private MessageRepository messageRepository;

    @RabbitListener(queues = IntegrationApplication.DEFAULT_PARSING_QUEUE)
    public void consumeDefaultMessage(final PracticalMessage message) {
        Request.sendRequest(POST_URL, HttpMethod.POST, message.getPayload());
        log.info(" -- POST REQUEST SENT --");
        message.setStatus("read");
        PracticalMessage msgRead = messageRepository.save(message);
        log.info("MESSAGE ID: "+msgRead.getId() + " STATUS: "+msgRead.getStatus());
        log.info("PAYLOAD: "+msgRead.getPayload());
        log.info("TOTAL MESSAGES: "+messageRepository.count());
    }
}
