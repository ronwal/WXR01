/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.beans;

import ec.ste.factura.dao.FacturaDao;
import ec.ste.factura.entities.Tipo;
import ec.ste.factura.exception.DaoException;
import ec.ste.factura.util.Fecha;
import org.icefaces.ace.component.chart.Axis;
import org.icefaces.ace.component.chart.AxisType;
import org.icefaces.ace.model.chart.CartesianSeries;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author German17
 */
@ManagedBean
@ViewScoped
public class GraficosComprasVentasBean implements Serializable {

    FacturaDao facturaDao = new FacturaDao();

    @ManagedProperty(value = "#{login}")
    private Login login;

    private static final SimpleDateFormat mes = new SimpleDateFormat("yyyy-MMM");

    public List<Intervalo> intervalos = new ArrayList<Intervalo>();

    private List<CartesianSeries> barData = new ArrayList<CartesianSeries>();

    /**
     * Creates a new instance of GraficosBean
     */
    public GraficosComprasVentasBean() {

    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    private Axis barDemoDefaultAxis = new Axis() {
        {
            setTickAngle(-30);
        }
    };

    private Axis barDemoXOneAxis = new Axis() {
        {
            setType(AxisType.CATEGORY);
        }
    };

    private Axis[] barDemoYAxes = new Axis[]{
        new Axis() {
            {
                setAutoscale(true);
                setLabel("USD");
            }
        },
        new Axis() {
            {
                setAutoscale(true);
                setLabel("USD");
            }
        }
    };

    private Axis barDemoXTwoAxis = new Axis() {
        {
            setType(AxisType.CATEGORY);
        }
    };

    private void updateData() {
        intervalos.clear();
        Date date = new Date();
        Fecha fecha = new Fecha();
        for (int i = 0; i < 12; i++) {
            Date inicio = fecha.getInicioMes(date);
            Date fin = fecha.getFinMes(date);
            intervalos.add(0, new Intervalo(mes.format(inicio), inicio, fin));
            date = fecha.getAnteriorDia(inicio);
        }

        CartesianSeries comprasSeries = new CartesianSeries();
        comprasSeries.setType(CartesianSeries.CartesianType.LINE);
        CartesianSeries ventasSeries = new CartesianSeries();
        ventasSeries.setType(CartesianSeries.CartesianType.LINE);
        final String xAxis[] = new String[12];
        int j = 0;
        for (Intervalo i : intervalos) {
            try {
                comprasSeries.add(i.getNombre(), facturaDao.getResumeData(login.getEmpresaTrabajo(), new Tipo("REC", null), i.getInicio(), i.getFin()));
                ventasSeries.add(i.getNombre(), facturaDao.getResumeData(login.getEmpresaTrabajo(), new Tipo("ENV", null), i.getInicio(), i.getFin()));
            } catch (DaoException ex) {
                Logger.getLogger(GraficosComprasVentasBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            xAxis[j] = i.getNombre();
            j++;
        }
        comprasSeries.setLabel("Compras");
        ventasSeries.setLabel("Ventas");
        barData.clear();
        barData.add(comprasSeries);
        barData.add(ventasSeries);

        barDemoXTwoAxis = new Axis() {
            {
                setTicks(xAxis);
                setType(AxisType.CATEGORY);
            }
        };
    }

    public List<CartesianSeries> getBarData() {

        updateData();

        return barData;
    }

    public void setBarData(List<CartesianSeries> barData) {
        this.barData = barData;
    }

    public Axis getBarDemoXOneAxis() {
        return barDemoXOneAxis;
    }

    public void setBarDemoXOneAxis(Axis barDemoXOneAxis) {
        this.barDemoXOneAxis = barDemoXOneAxis;
    }

    public Axis getBarDemoDefaultAxis() {
        return barDemoDefaultAxis;
    }

    public void setBarDemoDefaultAxis(Axis barDemoDefaultAxis) {
        this.barDemoDefaultAxis = barDemoDefaultAxis;
    }

    public Axis getBarDemoXTwoAxis() {
        return barDemoXTwoAxis;
    }

    public void setBarDemoXTwoAxis(Axis barDemoXTwoAxis) {
        this.barDemoXTwoAxis = barDemoXTwoAxis;
    }

    public Axis[] getBarDemoYAxes() {
        return barDemoYAxes;
    }

    public void setBarDemoYAxes(Axis[] barDemoYAxes) {
        this.barDemoYAxes = barDemoYAxes;
    }

}
