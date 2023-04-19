package us.peaksoft.gadgetarium.repository;

import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import us.peaksoft.gadgetarium.dto.SimpleResponse;
import us.peaksoft.gadgetarium.entity.Basket;
import us.peaksoft.gadgetarium.entity.Product;

import java.util.List;

@Repository
@Transactional
public interface BasketRepository extends JpaRepository<Basket, Long> {
    @Modifying
    @Query("DELETE FROM Product p WHERE p.basket.id=:id")
    void deleteProductFromBasket(@Param("id") Long id);

    @Query("update Product p set p.basket.id = null")
    Product setNull(@PathVariable("id") Long id);

//    @Query("SELECT p FROM Product p " +
//            "WHERE EXISTS(SELECT b FROM Basket b JOIN Product pr WHERE b.id=:id)")
//    Boolean existsProductInBasket(@Param("id") Long id);
@Query("SELECT p FROM Product p JOIN p.basket basket WHERE basket.id=:id")
List<Product> getProductsByBasketId(@PathVariable("id") Long id, Pageable pageable);
}