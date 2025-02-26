package service;
import model.*;
import repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthenticationService implements IAuthenticationService , UserDetailsService {
    IAuthenticationRepository authenticationRepository;

    public AuthenticationService(IAuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    public boolean register(User user) throws IOException {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        String passwordEncoded = bc.encode(user.getPassword());
        user.setPassword(passwordEncoded);
        return authenticationRepository.save(user);
    }

    @Override
    public boolean login(String username, String password) throws IOException {
        User user = authenticationRepository.findByUsername(username);
        if (user != null) {
            BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
            return bc.matches(password, user.getPassword());
        }
        return false;
    }

    @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    try {
        User user = authenticationRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles("USER") 
                .build();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

}
