package com.dheeraj.expensetracker.service;
import com.dheeraj.expensetracker.entity.User;
import com.dheeraj.expensetracker.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder =bCryptPasswordEncoder;
    }

    public User register(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public String login(String email , String password){
        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("Email not found"));
        if(bCryptPasswordEncoder.matches(password, user.getPassword())){
            return "Login successful";
        }
        throw new RuntimeException("Invalid Password");
    }
}
