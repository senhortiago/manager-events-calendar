package com.tiago.leal.manager.events.calendar.service;

import com.tiago.leal.manager.events.calendar.domain.User;
import com.tiago.leal.manager.events.calendar.dto.UserRequestDTO;
import com.tiago.leal.manager.events.calendar.dto.UserResponseDTO;
import com.tiago.leal.manager.events.calendar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserRequestDTO userRequestDTO){
        Optional<User> user = userRepository.findByEmail(userRequestDTO.email());
        if(user.isEmpty()) {
            User newUser = new User();
            newUser.setName(userRequestDTO.name());
            newUser.setEmail(userRequestDTO.email());
            newUser.setPassword(userRequestDTO.password());
            newUser.setMinistry(userRequestDTO.ministry());
            newUser.setUserType(userRequestDTO.userType());
            newUser.setCreateTime(LocalDateTime.now());
            newUser.setUpdateTime(LocalDateTime.now());
            this.userRepository.save(newUser);
        }
    }

    public void deleteUser(String id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            this.userRepository.deleteById(id);
        }
    }

    public void updateUser(String id, UserRequestDTO userRequestDTO){

        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            User updateUser = user.get();
            if (userRequestDTO.name()!= null){
                updateUser.setName(userRequestDTO.name());
            }
            if (userRequestDTO.password()!= null){
                updateUser.setPassword(userRequestDTO.password());
            }
            if (userRequestDTO.email()!= null){
                updateUser.setEmail(userRequestDTO.email());
            }
            if (userRequestDTO.ministry()!=null){
                updateUser.setMinistry(userRequestDTO.ministry());
            }
            if (userRequestDTO.userType()!=null){
                updateUser.setUserType(userRequestDTO.userType());
            }
            user.get().setUpdateTime(LocalDateTime.now());
            this.userRepository.save(updateUser);
        }

    }

    public List<UserResponseDTO> listUsers(){
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOS = new ArrayList<>();
        for(User user : users){
            UserResponseDTO dto = new UserResponseDTO(user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getMinistry(),
                    user.getUserType(),
                    user.getCreateTime(),
                    user.getUpdateTime());
            userResponseDTOS.add(dto);
        }
        return userResponseDTOS;
    }
}
