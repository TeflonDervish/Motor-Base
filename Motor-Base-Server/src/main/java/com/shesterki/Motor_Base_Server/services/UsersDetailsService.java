package com.shesterki.Motor_Base_Server.services;

import com.shesterki.Motor_Base_Server.model.UserDetailsAdapter;
import com.shesterki.Motor_Base_Server.model.Users;
import com.shesterki.Motor_Base_Server.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class UsersDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
        return new UserDetailsAdapter(user);
    }
}
