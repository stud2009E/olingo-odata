package pab.odata.olingo.base.config;

import com.sap.olingo.jpa.processor.core.api.JPAODataRequestContext;
import com.sap.olingo.jpa.processor.core.api.JPAODataServiceContext;
import com.sap.olingo.jpa.processor.core.api.JPAODataSessionContextAccess;
import jakarta.persistence.EntityManagerFactory;
import org.apache.olingo.commons.api.ex.ODataException;
import org.apache.olingo.server.api.debug.DefaultDebugSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pab.odata.olingo.base.handler.BaseCUDRequestHandler;

import javax.sql.DataSource;

@Configuration
public class Config {
    @Value("${odata.jpa.punit-name}")
    String pUnitName;

    @Value("${odata.jpa.root-packages}")
    String[] rootPackages;

    @Value("${odata.jpa.mapping-path}")
    String mappingPath;

    @Bean
    public JPAODataRequestContext requestContext(@Autowired BaseCUDRequestHandler requestHandler) {
        return JPAODataRequestContext.with()
                .setCUDRequestHandler(requestHandler)
                .setDebugSupport(new DefaultDebugSupport())
                .build();
    }

    @Bean
    public JPAODataSessionContextAccess sessionContext(@Autowired final EntityManagerFactory emf,
                                                       @Autowired final DataSource ds
    ) throws ODataException {
        return JPAODataServiceContext
                .with()
                .setEntityManagerFactory(emf)
                .setDataSource(ds)
                .setPUnit(pUnitName)
                .setTypePackage(rootPackages)
                .setRequestMappingPath(mappingPath)
                .build();
    }
}
