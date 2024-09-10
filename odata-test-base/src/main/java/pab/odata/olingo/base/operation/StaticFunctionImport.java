package pab.odata.olingo.base.operation;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmParameter;
import com.sap.olingo.jpa.metadata.core.edm.mapper.extension.ODataFunction;

public class StaticFunctionImport implements ODataFunction {

    public StaticFunctionImport() {
        super();
    }

    @EdmFunction(name = "Sum", hasFunctionImport = true, returnType = @EdmFunction.ReturnType)
    public Long sum(@EdmParameter(name = "Num1") Long num1, @EdmParameter(name = "Num2") Long num2) {
        return num1 + num2;
    }


    @EdmFunction(name = "Pow", hasFunctionImport = true, returnType = @EdmFunction.ReturnType)
    public Double pow(@EdmParameter(name = "base") Double base, @EdmParameter(name = "pow") Double pow) {
        return Math.pow(base, pow);
    }
}
