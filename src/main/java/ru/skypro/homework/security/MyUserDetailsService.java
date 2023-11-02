package ru.skypro.homework.security;

import liquibase.pro.packaged.nn;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.skypro.homework.dto.Register;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.UserRepository;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService  {

      @Autowired
      private final UserRepository userRepository;

      private final UserMapper userMapper;

      @Override
      @Transactional
      public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            User user = userRepository.findByEmail(email).orElseThrow();
            return new MyUserDetails(userMapper.toRegister(user));
      }
}


