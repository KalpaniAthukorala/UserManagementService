package com.example.userms.service;

import com.example.userms.dto.PreferenceDTO;
import com.example.userms.entity.Preference;
import com.example.userms.repo.PreferenceRepo;
import com.example.userms.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;


@CrossOrigin
@Service
@Transactional
public class PreferenceService {


    @Autowired
    private PreferenceRepo preferenceRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String savePreference(PreferenceDTO preferenceDTO){
        if (preferenceRepo.existsById(preferenceDTO.getId())){
            return VarList.RSP_DUPLICATED;
        } else {
            Preference preference = modelMapper.map(preferenceDTO, Preference.class);
            preferenceRepo.save(preference);
            return VarList.RSP_SUCCESS;
        }
    }

    public PreferenceDTO searchPreference(int preferenceID){
        if (preferenceRepo.existsById(preferenceID)){
            Preference preference =preferenceRepo.findById(preferenceID).orElse(null);
            return modelMapper.map(preference,PreferenceDTO.class);
        }else {
            return null;
        }
    }
}
