package pab.odata.olingo.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pab.odata.olingo.base.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}