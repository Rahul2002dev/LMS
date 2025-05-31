package org.example.notification.Controller;

import org.example.notification.Service.NotiificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class NotificationController {
    @Autowired
    private NotiificationService notiificationService;

    @PostMapping("/{userId}")
    public String sendNotification(@PathVariable Long userId, @RequestBody String message) {
        notiificationService.notifyUser(userId, message);
        return "Notification sent!";
    }
}
