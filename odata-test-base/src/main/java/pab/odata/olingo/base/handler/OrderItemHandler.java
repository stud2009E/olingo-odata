package pab.odata.olingo.base.handler;

import com.sap.olingo.jpa.processor.core.exception.ODataJPAProcessException;
import com.sap.olingo.jpa.processor.core.processor.JPARequestEntity;
import jakarta.persistence.EntityManager;
import jakarta.servlet.annotation.HandlesTypes;
import org.springframework.stereotype.Component;
import pab.odata.olingo.base.entity.Order;
import pab.odata.olingo.base.entity.OrderItem;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Objects;


@Component
@HandlesTypes(OrderItem.class)
public class OrderItemHandler extends EntityHandler {

    @Override
    public Object createEntity(JPARequestEntity requestEntity, EntityManager em) throws ODataJPAProcessException {

        Long orderId = (Long) requestEntity.getData().get("orderId");

        Order order = em.find(Order.class, orderId);
        if (Objects.isNull(order)) {
            throw new IllegalArgumentException("Can not find order with id = " + orderId);
        }

        OrderItem item = new OrderItem();
        requestEntity.getModifyUtil().setAttributes(requestEntity.getData(), item, requestEntity.getEntityType());

        ZoneId zoneId = ZoneId.systemDefault();
        OffsetDateTime odt = LocalDateTime.now().atZone(zoneId).toOffsetDateTime();

        order.setChangedAt(odt);
        em.persist(order);
        em.persist(item);

        return item;
    }
}