package com.example.userms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@AllArgsConstructor
@NoArgsConstructor
@Data
@CrossOrigin
public class UserDTO {
    private int userID;
    private String userName;
    private String name;
    private String userAddress;
    private String userMNumber;
    private String field;
}
