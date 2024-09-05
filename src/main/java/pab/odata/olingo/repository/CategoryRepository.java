package pab.odata.olingo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pab.odata.olingo.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}