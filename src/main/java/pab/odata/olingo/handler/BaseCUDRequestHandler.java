package pab.odata.olingo.handler;

import com.sap.olingo.jpa.processor.core.api.JPACUDRequestHandler;
import com.sap.olingo.jpa.processor.core.api.example.JPAExampleCUDRequestHandler;
import com.sap.olingo.jpa.processor.core.exception.ODataJPAProcessException;
import com.sap.olingo.jpa.processor.core.modify.JPAUpdateResult;
import com.sap.olingo.jpa.processor.core.processor.JPARequestEntity;
import jakarta.persistence.EntityManager;
import jakarta.servlet.annotation.HandlesTypes;
import org.apache.olingo.commons.api.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BaseCUDRequestHandler implements JPACUDRequestHandler {

    private final JPACUDRequestHandler baseHandler;

    @Autowired
    private List<EntityHandler> entityHandlerList;

    public BaseCUDRequestHandler(JPACUDRequestHandler handler) {
        baseHandler = handler;
    }

    public BaseCUDRequestHandler() {
        this(new JPAExampleCUDRequestHandler());
    }

    @Override
    public void deleteEntity(JPARequestEntity jpaRequestEntity, EntityManager entityManager) throws ODataJPAProcessException {
        defineHandler(jpaRequestEntity).deleteEntity(jpaRequestEntity, entityManager);
    }

    @Override
    public Object createEntity(JPARequestEntity jpaRequestEntity, EntityManager entityManager) throws ODataJPAProcessException {
        return defineHandler(jpaRequestEntity).createEntity(jpaRequestEntity, entityManager);
    }

    @Override
    public JPAUpdateResult updateEntity(JPARequestEntity jpaRequestEntity, EntityManager entityManager, HttpMethod httpMethod) throws ODataJPAProcessException {
        return defineHandler(jpaRequestEntity).updateEntity(jpaRequestEntity, entityManager, httpMethod);
    }

    @Override
    public void validateChanges(EntityManager entityManager) throws ODataJPAProcessException {
        baseHandler.validateChanges(entityManager);
    }

    /**
     * Define request handler by annotation
     * @param jpaRequestEntity request wrapper
     * @return JPACUDRequestHandler handler for odata request
     */
    private JPACUDRequestHandler defineHandler(JPARequestEntity jpaRequestEntity) {
        return entityHandlerList.stream()
                .filter(entityHandler -> {
                    HandlesTypes handlers = entityHandler.getClass().getAnnotation(HandlesTypes.class);
                    Class<?> entityType = jpaRequestEntity.getEntityType().getTypeClass();

                    return Arrays.asList(handlers.value()).contains(entityType);
                })
                .map(entityHandler -> (JPACUDRequestHandler) entityHandler)
                .findFirst()
                .orElse(baseHandler);
    }
}
