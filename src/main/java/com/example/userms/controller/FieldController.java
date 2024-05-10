package com.example.userms.controller;

import com.example.userms.dto.FieldDTO;
import com.example.userms.dto.ResponseDTO;
import com.example.userms.service.FieldService;
import com.example.userms.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/field")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @Autowired
    private ResponseDTO responseDTO;
    @GetMapping("/getAllUsers")
    public ResponseEntity getAllFields(){
        try {
            List<FieldDTO> fieldDTOList = fieldService.getAllFields();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(fieldDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
