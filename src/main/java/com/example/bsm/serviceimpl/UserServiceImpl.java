package com.example.bsm.serviceimpl;

import com.example.bsm.entity.Admin;
import com.example.bsm.entity.User;
import com.example.bsm.enums.Role;
import com.example.bsm.exception.UserNotFoundByIdException;
import com.example.bsm.repository.AdminRepository;
import com.example.bsm.repository.UserRepository;
import com.example.bsm.request.UserRequest;
import com.example.bsm.response.AdminResponse;
import com.example.bsm.response.UserResponse;
import com.example.bsm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    private final PasswordEncoder passwordEncoder;

    private  UserResponse mapToResponse(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .role(user.getRole())
                .bloodGroup(user.getBloodGroup())
                .gender(user.getGender())
                .age(user.getAge())
                .availableCity(user.getAvailableCity())
                .lastDonatedAt(user.getLastDonatedAt())
                .lastModifiedAt(user.getLastModifiedAt())
                .lastCreatedAt(user.getLastCreatedAt())
                .build();
    }
    private  User mapToUser(UserRequest userRequest,User user) {
        user.setUserName(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhnonumber(userRequest.getPhnonumber());
        user.setBloodGroup(userRequest.getBloodGroup());
        user.setAge(userRequest.getAge());
        user.setGender(userRequest.getGender());
        user.setAvailableCity(userRequest.getAvailableCity());

        return user;

    }
    @Override
    public UserResponse registerUser(UserRequest userRequest) {

       User user=this.mapToUser(userRequest,new User());
       user.setRole(Role.USER);
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       user=userRepository.save(user);
         return this.mapToResponse(user);
    }


    @Override
    public UserResponse findUserById(int userId) {
        Optional<User> optional=userRepository.findById(userId);

        if(optional.isEmpty()) {
            throw new UserNotFoundByIdException("Falied to find user");
        }
        User user= optional.get();
        return this.mapToResponse(user);
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest,int userId) {
        Optional<User> optional=userRepository.findById(userId);

        if(optional.isEmpty()) {
            throw new UserNotFoundByIdException("failed to update the user");

        }else {
            User user = this.mapToUser(userRequest,optional.get());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return this.mapToResponse(user);

        }
    }

    @Override
    public UserResponse promoteToAdmin(int userId) {
        Optional<User> optional= userRepository.findById(userId);
        if (optional.isEmpty())
            throw new UserNotFoundByIdException("failed to update the user");

        User user=optional.get();
        user.setRole(Role.ADMIN);
        userRepository.save(user);

        Admin admin=new Admin();
        admin.setUser(user);
        adminRepository.save(admin);

        return this.mapToResponse(user);

    }

    @Override
    public AdminResponse registerAdmin(UserRequest userRequest) {
        User user=this.mapToUser(userRequest,new User());
        user.setRole(Role.USER);
        user=userRepository.save(user);

        Admin admin=new Admin();
        admin.setUser(user);
        adminRepository.save(admin);
        UserResponse userResponse=this.mapToResponse(user);
        return AdminResponse.builder()
                .adminId(admin.getAdminId())
                .adminType(admin.getAdminType())
                .userResponse(userResponse)
                .build();

    }


}
