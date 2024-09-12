package pab.odata.olingo.base.handler;

import com.sap.olingo.jpa.metadata.core.edm.mapper.api.JPAAssociationPath;
import com.sap.olingo.jpa.processor.core.exception.ODataJPAInvocationTargetException;
import com.sap.olingo.jpa.processor.core.exception.ODataJPAProcessException;
import com.sap.olingo.jpa.processor.core.exception.ODataJPAProcessorException;
import com.sap.olingo.jpa.processor.core.processor.JPARequestEntity;
import jakarta.persistence.EntityManager;
import jakarta.servlet.annotation.HandlesTypes;
import org.springframework.stereotype.Component;
import pab.odata.olingo.base.entity.Order;
import pab.odata.olingo.base.entity.OrderItem;
import pab.odata.olingo.base.entity.OrderStatus;
import pab.odata.olingo.base.entity.Product;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Component
@HandlesTypes(Order.class)
public class OrderHandler extends EntityHandler {

    @Override
    public Object createEntity(JPARequestEntity requestEntity, EntityManager em) throws ODataJPAProcessException {

        Order order = new Order();
        requestEntity.getModifyUtil().setAttributes(requestEntity.getData(), order, requestEntity.getEntityType());

        ZoneId zoneId = ZoneId.systemDefault();
        OffsetDateTime odt = LocalDateTime.now().atZone(zoneId).toOffsetDateTime();

        order.setCreatedAt(odt);
        order.setChangedAt(odt);
        order.setStatus(OrderStatus.DRAFT);

        em.persist(order);

        createRelatedEntities(requestEntity, order, em);

        em.persist(order);

        return order;
    }


    private void createRelatedEntities(JPARequestEntity requestEntity, Order parent, EntityManager em) throws ODataJPAProcessException {
        Map<JPAAssociationPath, List<JPARequestEntity>> relatedEntities = requestEntity.getRelatedEntities();

        for (Map.Entry<JPAAssociationPath, List<JPARequestEntity>> entity : relatedEntities.entrySet()) {
            if (entity.getKey().getTargetType().getTypeClass().equals(OrderItem.class)) {

                createOrderItems(entity.getKey(), entity.getValue(), parent, em);
            }
        }
    }

    private void createOrderItems(JPAAssociationPath path, List<JPARequestEntity> entities, Order order, EntityManager em) throws ODataJPAProcessorException, ODataJPAInvocationTargetException {
        for (JPARequestEntity entity : entities) {
            OrderItem item = new OrderItem();

            entity.getModifyUtil().setAttributes(entity.getData(), item, entity.getEntityType());
            entity.getModifyUtil().linkEntities(order, item, path);
            item.setOrderId(order.getId());

            Product product = em.find(Product.class, item.getProductId());
            if (Objects.isNull(product)){
                throw new IllegalArgumentException("Can not find product with id = " + item.getProductId());
            }
        }
    }
}