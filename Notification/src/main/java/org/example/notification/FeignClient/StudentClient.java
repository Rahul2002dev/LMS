package org.example.notification.FeignClient;
import org.example.notification.DTO.UserDTo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "${User.url}")
public interface StudentClient {
    @GetMapping("/user/{id}")
    UserDTo getStudentById(@PathVariable("id") Long id);
}
