package us.peaksoft.gadgetarium.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import us.peaksoft.gadgetarium.enums.Brand;
import us.peaksoft.gadgetarium.enums.Color;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceAndQuantityResponse {
    private Brand brand;
    private Color color;
    private String capacityBattery;
    private String rom;
    private String sim;
    private LocalDate dateOfProduction;
    private Long quantityOfProducts;
    private int price;

}
