package com.example.bsm.security;

import com.example.bsm.entity.User;
import com.example.bsm.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

      private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> op=  userRepository.findByEmail(username);
       if(op.isEmpty())
           throw new UsernameNotFoundException("failed to authenticate User ");

       User user=op.get();
     return   org.springframework.security.core.userdetails.User.builder()
               .username(user.getEmail())
               .password(user.getPassword())
               .build();
    }
}
