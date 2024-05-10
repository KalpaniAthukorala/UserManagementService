package com.example.userms.service;

import com.example.userms.dto.UserDTO;
import com.example.userms.entity.User;
import com.example.userms.repo.UserRepo;
import com.example.userms.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveUser(UserDTO userDTO){
        if (userRepo.existsById(userDTO.getUserID())){
            return VarList.RSP_DUPLICATED;
        }else {
            userRepo.save(modelMapper.map(userDTO, User.class));
            return VarList.RSP_SUCCESS;
        }
    }
    public String updateUser(UserDTO userDTO){
        if (userRepo.existsById(userDTO.getUserID())){
            userRepo.save(modelMapper.map(userDTO, User.class));
            return VarList.RSP_SUCCESS;

        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<UserDTO> getAllUser(){
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<ArrayList<UserDTO>>(){
        }.getType());
    }

    public UserDTO searchUser(String userName){
        Optional<User> userOptional = userRepo.findByUserName(userName);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return modelMapper.map(user, UserDTO.class);
        } else {
            return null;
        }
    }


    public String deleteUser(int userID){
        if (userRepo.existsById(userID)){
            userRepo.deleteById(userID);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
