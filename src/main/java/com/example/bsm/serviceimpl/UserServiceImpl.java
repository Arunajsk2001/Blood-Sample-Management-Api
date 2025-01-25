package com.example.bsm.serviceimpl;

import com.example.bsm.entity.User;
import com.example.bsm.exception.UserNotFoundByIdException;
import com.example.bsm.repository.UserRepository;
import com.example.bsm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(int userId) {
        Optional<User> optional=userRepository.findById(userId);

        if(optional.isEmpty()) {
            throw new UserNotFoundByIdException("Falied to find user");
        }
        return optional.get();
    }

    @Override
    public User updateUser(User user) {
        Optional<User> optional=userRepository.findById(user.getUserId());
        if(optional.isEmpty()) {
            throw new RuntimeException("failed to update the user");
        }else {
            User exuser = optional.get();
            exuser.setUserName(user.getUserName());
            exuser.setEmail(user.getEmail());
            exuser.setPassword(user.getPassword());
            exuser.setBloodGroup(user.getBloodGroup());
            exuser.setLastDonatedAt(user.getLastDonatedAt());
            exuser.setAge(user.getAge());
            exuser.setAvailableCity(user.getAvailableCity());
            exuser.setVerified(user.isVerified());
            return userRepository.save(exuser);
        }
    }

}
