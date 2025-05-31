package org.example.notification.Service;

import org.example.notification.DTO.NotificationDTO;
import org.example.notification.DTO.UserDTo;
import org.example.notification.FeignClient.StudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotiificationService {
    @Autowired
    private StudentClient studentClient;

    @Autowired
    private NotificationProducer notificationProducer;

    public void notifyUser(Long userId, String message) {
        UserDTo user = studentClient.getStudentById(userId);

        NotificationDTO notification = new NotificationDTO();
        notification.setUserId(user.getId());
        notification.setEmail(user.getEmail());
        notification.setMessage(message);

        notificationProducer.sendNotification(notification);
    }
}
