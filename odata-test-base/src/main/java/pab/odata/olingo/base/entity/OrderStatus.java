package pab.odata.olingo.base.entity;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration()
public enum OrderStatus {
    NEW,
    REJECT,
    PROCESS,
    DELIVERY,
    DONE
}
