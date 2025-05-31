package org.example.notification.Service;

import org.example.notification.Config.RabbitMq;
import org.example.notification.DTO.NotificationDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotificationProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendNotification(NotificationDTO dto) {
        rabbitTemplate.convertAndSend(RabbitMq.EXCHANGE, RabbitMq.ROUTING_KEY, dto);
    }
}
