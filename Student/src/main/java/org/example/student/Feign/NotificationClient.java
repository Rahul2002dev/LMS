package org.example.student.Feign;

import org.example.student.dto.NotificationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "notification-service")
public interface NotificationClient { @GetMapping("/notifications/student/{studentId}")
List<NotificationDTO> getNotifications(@PathVariable Long studentId);
}
