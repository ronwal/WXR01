/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.fecuador.portal.common.session;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * @author @rw_r
 */
public class ShowcaseExceptionHandlerFactory extends ExceptionHandlerFactory {

    private ExceptionHandlerFactory base;

    public ShowcaseExceptionHandlerFactory(ExceptionHandlerFactory base) {
        this.base = base;
    }

    @Override
    public ExceptionHandler getExceptionHandler() {
        return new ShowcaseExceptionHandler(base.getExceptionHandler());
    }

}
