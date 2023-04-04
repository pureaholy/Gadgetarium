package us.peaksoft.gadgetarium.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountResponse {
    private Long id;
    private LocalDate dateOfStart;
    private LocalDate dateOfFinish;
    private int percent;
    private String productName;

}
