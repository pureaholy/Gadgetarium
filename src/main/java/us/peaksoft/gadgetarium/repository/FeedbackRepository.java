package us.peaksoft.gadgetarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import us.peaksoft.gadgetarium.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    @Query("select count (f.productEvaluation) from Feedback f where f.product.id=:id and f.productEvaluation=:rating")
    Integer countRating(@Param("id") Long id, byte rating);

    @Query("select avg(f.productEvaluation) from Feedback f  where f.product.id=:id")
    Double rating(@Param("id") Long id);

    @Query("select count (f.productEvaluation) from  Feedback f where f.product.id=:id")
    Long allfeedback(@Param("id") Long id);
}