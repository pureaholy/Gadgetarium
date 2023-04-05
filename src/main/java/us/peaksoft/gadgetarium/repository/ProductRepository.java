package us.peaksoft.gadgetarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import us.peaksoft.gadgetarium.dto.ProductResponse;
import us.peaksoft.gadgetarium.entity.Product;
import us.peaksoft.gadgetarium.enums.Brand;
import us.peaksoft.gadgetarium.enums.Color;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT COUNT(u) FROM Product u WHERE u.brand=:brand and u.color=:color and u.ram=:ram and u.quantityOfSim=:sim and u.price=:price")
    Long Quantity(@Param("brand") Brand brand, @Param("color") Color color, @Param("ram") String ram, @Param("sim") Long sim, @Param("price") int price);

    @Query("SELECT p from Product p WHERE upper(p.name) LIKE concat('%', :text, '%') or upper(p.brand) LIKE concat('%', :text, '%')")
    List<ProductResponse> search(@Param("text") String text, int page, int size);

}