/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.beans;

import ec.ste.factura.dao.FacturaDao;
import ec.ste.factura.exception.DaoException;
import ec.ste.factura.util.Fecha;
import org.icefaces.ace.component.chart.Axis;
import org.icefaces.ace.component.chart.AxisType;
import org.icefaces.ace.model.chart.CartesianSeries;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
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
public class GraficosClientes implements Serializable {

    FacturaDao facturaDao = new FacturaDao();

    @ManagedProperty(value = "#{login}")
    private Login login;

    private Date desde;
    private Date hasta;

    private List<CartesianSeries> barData = new ArrayList<CartesianSeries>();

    /**
     * Creates a new instance of GraficosBean
     */
    public GraficosClientes() {

    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
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
        Fecha fecha = new Fecha();
        if (desde == null | hasta == null) {
            desde = facturaDao.getFirstDate(login.getEmpresaTrabajo());
            desde = fecha.getFechaInicial(desde);
            hasta = new Date();
        }
        try {
            List<TopConsulta> list = facturaDao.getTopVentas(login.getEmpresaTrabajo(), desde, hasta);

            CartesianSeries comprasSeries = new CartesianSeries();
            comprasSeries.setType(CartesianSeries.CartesianType.BAR);

            final String xAxis[] = new String[list.size()];
            int j = 0;
            for (TopConsulta i : list) {

                comprasSeries.add(i.getNombre(), i.getValor());

                xAxis[j] = i.getNombre();
                j++;
            }
            comprasSeries.setLabel("Clientes");
            barData.clear();
            barData.add(comprasSeries);

            barDemoXTwoAxis = new Axis() {
                {
                    setTicks(xAxis);
                    setType(AxisType.CATEGORY);
                }
            };
        } catch (DaoException ex) {
            Logger.getLogger(GraficosComprasVentasBean.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    
    public void update(ActionEvent e){
        
    }
}
