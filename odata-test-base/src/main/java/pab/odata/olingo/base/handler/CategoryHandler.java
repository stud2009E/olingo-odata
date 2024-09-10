package pab.odata.olingo.base.handler;

import com.sap.olingo.jpa.processor.core.exception.ODataJPAProcessException;
import com.sap.olingo.jpa.processor.core.exception.ODataJPAProcessorException;
import com.sap.olingo.jpa.processor.core.modify.JPAUpdateResult;
import com.sap.olingo.jpa.processor.core.processor.JPARequestEntity;
import jakarta.persistence.EntityManager;
import jakarta.servlet.annotation.HandlesTypes;
import org.apache.olingo.commons.api.http.HttpMethod;
import org.apache.olingo.commons.api.http.HttpStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pab.odata.olingo.base.entity.Category;
import pab.odata.olingo.base.entity.Product;
import pab.odata.olingo.base.repository.CategoryRepository;

import java.util.Set;

@Component
@HandlesTypes(Category.class)
public class CategoryHandler extends EntityHandler {

    @Autowired
    private CategoryRepository repository;

    @Override
    public JPAUpdateResult updateEntity(JPARequestEntity jpaRequestEntity, EntityManager entityManager, HttpMethod httpMethod) throws ODataJPAProcessException {
        Long categoryId = (Long) jpaRequestEntity.getKeys().get("id");

        Category category = repository.findById(categoryId)
                .orElseThrow(() -> new ODataJPAProcessorException(ODataJPAProcessorException.MessageKeys.RETURN_MISSING_ENTITY, HttpStatusCode.NOT_FOUND));

        jpaRequestEntity.getModifyUtil().setAttributes(jpaRequestEntity.getData(), category, jpaRequestEntity.getEntityType());
        repository.save(category);

        return new JPAUpdateResult(false, category);
    }
}