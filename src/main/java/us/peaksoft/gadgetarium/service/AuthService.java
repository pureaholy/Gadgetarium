package us.peaksoft.gadgetarium.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import us.peaksoft.gadgetarium.dto.AuthenticationResponse;
import us.peaksoft.gadgetarium.entity.User;
import us.peaksoft.gadgetarium.repository.UserRepository;



@Service
@RequiredArgsConstructor
public class AuthService {
  private final UserRepository userRepository;

  public AuthenticationResponse view(String token, String message, User user) {
    AuthenticationResponse response = new AuthenticationResponse();
    User user1 = userRepository.findById(user.getId()).get();
    response.setEmail(user1.getEmail());
    response.setPassword(user1.getPassword());
    response.setFirstname(user1.getFirstName());
    response.setLastname(user1.getLastName());
    response.setCreatedDate(user1.getCreatedDate());
    response.setAuthority(user1.getEmail());
    response.setPhoneNumber(user1.getPhoneNumber());
    response.setRole(user1.getRole());
    response.setToken(token);
    response.setMessage(message);

    if (user != null) {
      response.setAuthority(user.getRole().getAuthority());
    }
    return response;
  }
}