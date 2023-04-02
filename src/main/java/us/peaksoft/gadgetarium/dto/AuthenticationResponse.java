package us.peaksoft.gadgetarium.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import us.peaksoft.gadgetarium.enums.Role;
import java.time.LocalDate;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
  private String token;
  private String message;
  private String authority;
  private String firstname;
  private String lastname;
  private String email;
  private String password;
  private String phoneNumber;
  private Role role;
  private LocalDate createdDate;
}