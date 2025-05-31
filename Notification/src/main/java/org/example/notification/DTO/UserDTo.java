package org.example.notification.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTo {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
