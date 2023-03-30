package us.peaksoft.gadgetarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.peaksoft.gadgetarium.entity.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
}