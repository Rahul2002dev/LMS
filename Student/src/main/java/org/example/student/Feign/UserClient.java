package org.example.student.Feign;

import org.example.student.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service",url = "http://localhost:8081")
public interface UserClient {
    @GetMapping("/auth/{id}")
    UserDTO getUserById(@PathVariable Long id);
}
