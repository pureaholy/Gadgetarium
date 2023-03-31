package us.peaksoft.gadgetarium.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import us.peaksoft.gadgetarium.dto.AuthenticationResponse;
import us.peaksoft.gadgetarium.dto.RegisterRequest;
import us.peaksoft.gadgetarium.entity.User;
import us.peaksoft.gadgetarium.enums.Role;
import us.peaksoft.gadgetarium.repository.UserRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User mapToEntity(RegisterRequest request) {
        return User.builder().firstName(request.getFirstName())
                .lastName(request.getLastname()).email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .phoneNumber(request.getPhoneNumber())
                .createdDate(LocalDate.now())
                .build();

    }

    public AuthenticationResponse responseForRegister(User user){
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setFirstname(user.getFirstName());
        authenticationResponse.setLastname(user.getLastName());
        authenticationResponse.setEmail(user.getEmail());
        authenticationResponse.setPhoneNumber(user.getPhoneNumber());
        authenticationResponse.setPassword(user.getPassword());
        authenticationResponse.setCreatedDate(user.getCreatedDate());
        return authenticationResponse;
    }
    public AuthenticationResponse register (RegisterRequest request){
        User user = mapToEntity(request);
        userRepository.save(user);
        return responseForRegister(user);
    }

}
