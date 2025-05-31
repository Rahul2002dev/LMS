package org.example.notification.DTO;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class NotificationDTO {

    private Long userId;
    private String email;
    private String message;
}
