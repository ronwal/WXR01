/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fecuador.persistence.test;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mauriciochilan
 */
public class TestBase {

    private static String APP_CONTEXT_DEV[] = {"context-persitencia.xml"};
    private ApplicationContext appContext;

    @Before
    public void runBefore() throws Exception {
        appContext = (ApplicationContext) new ClassPathXmlApplicationContext(APP_CONTEXT_DEV);
    }

    public Object getBean(String beanName) {
        return appContext.getBean(beanName);
    }
}
