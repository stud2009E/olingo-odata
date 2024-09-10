package pab.odata.olingo.base.entity.calculation;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmTransientPropertyCalculator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import pab.odata.olingo.base.config.SpringContext;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class CategoryProductCount implements EdmTransientPropertyCalculator<Long> {

    @Nonnull
    @Override
    public List<Long> calculateCollectionProperty(@Nonnull Tuple row) {
        return EdmTransientPropertyCalculator.super.calculateCollectionProperty(row);
    }

    @Nullable
    @Override
    public Long calculateProperty(@Nonnull Tuple row) {
        Long categoryId = (Long) row.get("Id");
        EntityManager em = SpringContext.getEntityManager();

        TypedQuery<Long> query = em.createQuery("select count(p) from Product p where p.categoryId = :id", Long.class);
        query.setParameter("id", categoryId);

        Long productCount = query.getSingleResult();
        em.close();

        return productCount;
    }
}
