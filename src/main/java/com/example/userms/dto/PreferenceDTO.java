package com.example.userms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@AllArgsConstructor
@NoArgsConstructor
@Data
@CrossOrigin
public class PreferenceDTO {

    private int id;
    private String field;
    private Boolean preferred;

}
