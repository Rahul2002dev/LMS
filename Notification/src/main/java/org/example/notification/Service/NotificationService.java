package org.example.notification.Service;

import org.example.notification.DTO.NotificationDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @RabbitListener(queues = "notification.queue")
    public void receiveNotification(NotificationDTO notificationDTO) {
        System.out.println("📩 Received Notification for User: " + notificationDTO.getEmail());
        System.out.println("📨 Message: " + notificationDTO.getMessage());
    }
}
