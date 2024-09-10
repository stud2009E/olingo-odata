package pab.odata.olingo.base.config;


import com.sap.olingo.jpa.processor.core.api.JPAODataSessionContextAccess;
import jakarta.annotation.Nonnull;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext context;


    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }

    public static EntityManager getEntityManager(){
        JPAODataSessionContextAccess contextAccess = getBean(JPAODataSessionContextAccess.class);

        EntityManagerFactory emf = contextAccess.getEntityManagerFactory()
                .orElseThrow(() -> new RuntimeException("Entity manager factory does not exist"));

        return emf.createEntityManager();
    }

    @Override
    public void setApplicationContext(@Nonnull ApplicationContext context) throws BeansException {
        setContext(context);
    }


    private static synchronized void setContext(ApplicationContext context) {
        SpringContext.context = context;
    }
}
