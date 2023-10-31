package ru.skypro.homework.security;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.skypro.homework.dto.Register;
import ru.skypro.homework.dto.Role;
import ru.skypro.homework.dto.model_dto.UserDto;

import java.util.*;

/**
 * Класс является реализацией UserDetails интерфейса, предоставляемого Spring Security
 */
@RequiredArgsConstructor
public class MyUserDetails implements UserDetails {

      private final Register register;

      @Override
      public Collection<? extends GrantedAuthority> getAuthorities() {
            Set<Role> roles = Collections.singleton(register.getRole());
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for (Role role : roles) {
                  authorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()));
            }
            return authorities;
      }
      @Override
      public String getPassword() {return register.getPassword();}

      @Override
      public String getUsername() {return register.getUsername();}

      @Override
      public boolean isAccountNonExpired() {return true;}

      @Override
      public boolean isAccountNonLocked() {return true;}

      @Override
      public boolean isCredentialsNonExpired() {return true;}

      @Override
      public boolean isEnabled() {return true;}
}
