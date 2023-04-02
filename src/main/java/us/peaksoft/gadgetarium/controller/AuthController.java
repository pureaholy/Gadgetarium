package us.peaksoft.gadgetarium.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.peaksoft.gadgetarium.dto.AuthenticationRequest;
import us.peaksoft.gadgetarium.dto.AuthenticationResponse;
import us.peaksoft.gadgetarium.dto.RegisterRequest;
import us.peaksoft.gadgetarium.entity.User;
import us.peaksoft.gadgetarium.repository.UserRepository;
import us.peaksoft.gadgetarium.security.JwtService;
import us.peaksoft.gadgetarium.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;
  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;
  private final JwtService tokenUtil;

  @PostMapping("/authenticate")
  public AuthenticationResponse login(@RequestBody AuthenticationRequest request){
    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword());
    authenticationManager.authenticate(token);
    User user = userRepository.findByEmail(token.getName()).orElseThrow();
    return authService.view(tokenUtil.generateToken(user),"successful",user);
  }

    @PostMapping("register")
    public AuthenticationResponse register(@RequestBody RegisterRequest request){
        return  authService.register(request);
    }
}