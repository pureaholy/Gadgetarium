package us.peaksoft.gadgetarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.peaksoft.gadgetarium.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}