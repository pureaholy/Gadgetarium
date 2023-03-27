package us.peaksoft.gadgetarium.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDeleteResponse {
   private HttpStatus httpStatus;
}
