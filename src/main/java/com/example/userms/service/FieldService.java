package com.example.userms.service;

import com.example.userms.dto.FieldDTO;
import com.example.userms.entity.Field;
import com.example.userms.repo.FieldRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Service
@Transactional
public class FieldService {

    @Autowired
    private FieldRepo fieldRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<FieldDTO> getAllFields(){
        List<Field> fieldList = fieldRepo.findAll();
        return modelMapper.map(fieldList,new TypeToken<ArrayList<FieldDTO>>(){
        }.getType());
    }

}
