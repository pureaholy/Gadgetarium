package us.peaksoft.gadgetarium.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum OrderStatus {
    CREATED, CONFIRMED, SHIPPED, CANCELLED, REFUNDED
}
