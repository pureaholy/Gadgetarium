package us.peaksoft.gadgetarium.dto;

import lombok.*;
import us.peaksoft.gadgetarium.enums.Role;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequest {

    private String firstName;

    private String lastname;

    private String email;

    private Role role;

    private String phoneNumber;

    private String password;

    private String passwordAdmit;

}