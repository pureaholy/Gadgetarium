package us.peaksoft.gadgetarium.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthenticationRequest {

    private String email;
    private String password;
}