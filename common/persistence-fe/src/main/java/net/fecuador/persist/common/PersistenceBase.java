package net.fecuador.persist.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Latinus on 28/2/16.
 */
public class PersistenceBase {
    private static String APP_CONTEXT_DEV[] = {"context-persitencia.xml"};
    @Autowired
    private ApplicationContext appContext;

    public PersistenceBase() {
        appContext = (ApplicationContext) new ClassPathXmlApplicationContext(APP_CONTEXT_DEV);
    }

    public Object getBean(String beanName) {
        return appContext.getBean(beanName);
    }
}
