/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fecuador.util;

import com.icesoft.faces.component.selectinputtext.SelectInputText;
import ec.ste.factura.DatabaseEntity;
import ec.ste.factura.EntityInfo;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.apache.log4j.Logger;

/**
 *
 * @author German17
 */
public class PSAssistant<T extends DatabaseEntity> implements Serializable {

    private EntityInfo info;
    private Class entityClass;
    private Class daoClass;
    private T selected;
    private List<T> list = new ArrayList<T>();
    private Object dao;
    private Method filterMethod;
    private Field filterField;
    private Field pkField;
    private List<PSAListener> listeners = new ArrayList<PSAListener>();

    /**
     *
     * @param daoClass
     * @param daoMethodName
     * @param attributeName nombre de la propiedad con la cual comparar
     * @throws Exception
     */
    public PSAssistant(EntityInfo info) {
        this.info = info;

        entityClass = info.getEntityClass();
        daoClass = info.getDaoClass();
        try {
            selected = (T) info.getEntityClass().newInstance();
            pkField = entityClass.getDeclaredField(info.getPkAttributeName());
            pkField.setAccessible(true);
            filterField = entityClass.getDeclaredField(info.getFilterAttributeName());
            filterField.setAccessible(true);
            dao = info.getDaoClass().newInstance();
            filterMethod = daoClass.getDeclaredMethod(info.getFilterMethod(), String.class, int.class);
        } catch (Exception e) {
            Logger.getLogger(PSAssistant.class).info("Error al crear Predictive Search Assistant: " + info.getEntityClass().getName(), e);
        }
    }

    public T getSelected() {
        return selected;
    }

    public void setSelected(T selected) {
        this.selected = selected;
    }

    public List<T> getList() {
        return list;
    }

    public List<SelectItem> getSelectItems() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (T t : list) {
            Object value;
            try {
                value = filterField.get(t);
                items.add(new SelectItem(t, value.toString()));
            } catch (Exception ex) {
                Logger.getLogger(PSAssistant.class).info("No se pudo crear la Lista de Items predictivos", ex);
            }

        }
        return items;
    }

    public void updateList(String filter, int maxResults) throws Exception {
        list = (List<T>) filterMethod.invoke(dao, filter, maxResults);
    }

    public boolean find(String text) {
        try {
            Object value;
            for (T t : list) {

                value = filterField.get(t);
                if (value.toString().equalsIgnoreCase(text)) {
                    selected = t;
                    notifyListeners(t);
                    return true;
                }
            }

            selected = (T) entityClass.newInstance();
            filterField.set(selected, text);
        } catch (Exception e) {
            Logger.getLogger(PSAssistant.class).info(e.getMessage(), e);
        }


        return false;
    }

    public Class<?> getGenericClass() {
        Class<?> result = null;
        Type type = this.getClass().getGenericSuperclass();

        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            Type[] fieldArgTypes = pt.getActualTypeArguments();
            result = (Class<?>) fieldArgTypes[0];
        }
        return result;
    }

    public void addPSAListener(PSAListener listener) {
        listeners.add(listener);
    }

    public boolean isPersisted() {
        try {

            Object value = pkField.get(selected);
            if (value == null) {
                return false;
            } else if (value instanceof Number) {
                return ((Number) value).intValue() > 0;
            } else {
                return value.toString().trim().length() > 0;
            }
        } catch (Exception e) {
            Logger.getLogger(PSAssistant.class).info(e.getMessage(), e);
        }
        return false;
    }

    public void updateListener(ValueChangeEvent event) {
        Object searchWord = event.getNewValue();
        
        int maxMatches = ((SelectInputText) event.getComponent()).getRows();
        try {
            updateList(searchWord.toString(), maxMatches);
            if (event.getComponent() instanceof SelectInputText) {
                SelectInputText autoComplete = (SelectInputText) event.getComponent();
                if (autoComplete.getSelectedItem() != null) {
                    T buffer = (T) autoComplete.getSelectedItem().getValue();
                    setSelected(buffer);
                    notifyListeners(buffer);
                } else {
                    find(autoComplete.getValue().toString());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PSAssistant.class).info("Error al actualizar datos de PSAssistant", ex);
        }
    }

    private void notifyListeners(Object o) {
        for (PSAListener l : listeners) {
            l.valueChanged(o);
        }
    }
}
