package pab.odata.olingo.base.handler;

import com.sap.olingo.jpa.processor.core.exception.ODataJPAProcessException;
import com.sap.olingo.jpa.processor.core.processor.JPARequestEntity;
import jakarta.persistence.EntityManager;
import jakarta.servlet.annotation.HandlesTypes;
import org.springframework.stereotype.Component;
import pab.odata.olingo.base.entity.OrderItem;


@Component
@HandlesTypes(OrderItem.class)
public class OrderItemHandler extends EntityHandler {

    @Override
    public Object createEntity(JPARequestEntity requestEntity, EntityManager em) throws ODataJPAProcessException {

        return null;

    }

}