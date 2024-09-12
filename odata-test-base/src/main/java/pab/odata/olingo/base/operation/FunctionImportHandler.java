package pab.odata.olingo.base.operation;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmParameter;
import com.sap.olingo.jpa.metadata.core.edm.mapper.extension.ODataFunction;
import jakarta.persistence.EntityManager;
import pab.odata.olingo.base.entity.Order;
import pab.odata.olingo.base.entity.OrderStatus;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Objects;

public class FunctionImportHandler implements ODataFunction {

    private final EntityManager em;

    public FunctionImportHandler(EntityManager em) {
        this.em = em;
    }

    @EdmFunction(name = "Sum", hasFunctionImport = true, returnType = @EdmFunction.ReturnType)
    public Long sum(@EdmParameter(name = "Num1") Long num1, @EdmParameter(name = "Num2") Long num2) {
        return num1 + num2;
    }


    @EdmFunction(name = "Pow", hasFunctionImport = true, returnType = @EdmFunction.ReturnType)
    public Double pow(@EdmParameter(name = "base") Double base, @EdmParameter(name = "pow") Double pow) {
        return Math.pow(base, pow);
    }

    @EdmFunction(name = "OrderToWork", hasFunctionImport = true, returnType = @EdmFunction.ReturnType(type = Order.class))
    public Order orderToWork(@EdmParameter(name = "Id", isNullable = false ) Long orderId) {
        Order order = em.find(Order.class, orderId);

        if (Objects.isNull(order)){
            throw new IllegalArgumentException("Order does not exist with id = " + orderId);
        }

        if (order.getStatus() != OrderStatus.DRAFT){
            throw new IllegalArgumentException("Order is not in status: " + OrderStatus.DRAFT.name());
        }

        ZoneId zoneId = ZoneId.systemDefault();
        OffsetDateTime odt = LocalDateTime.now().atZone(zoneId).toOffsetDateTime();

        order.setStatus(OrderStatus.PROCESS);
        order.setChangedAt(odt);

        var trx = em.getTransaction();

        trx.begin();
        em.persist(order);
        trx.commit();

        return order;
    }
}
