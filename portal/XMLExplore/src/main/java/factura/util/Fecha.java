/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author German17
 */
public class Fecha {

    private static final SimpleDateFormat formatoLargo=new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy HH:mm");
    private static final SimpleDateFormat formatoCorto=new SimpleDateFormat("yyyy/MM/dd");

    private static final long UN_DIA = 24 * 60 * 60 * 1000;
    private Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

    public Date getFechaInicial(Date fecha) {
        calendar.setTime(fecha);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public Date getFechaFinal(Date fecha) {
        calendar.setTime(fecha);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
        return calendar.getTime();
    }

    public Date getInicioMes(Date fecha) {
        fecha = getFechaInicial(fecha);
        calendar.setTime(fecha);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    public Date getFinMes(Date fecha) {
        fecha = getFechaFinal(fecha);
        calendar.setTime(fecha);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    public int getDiasMes(Date fecha) {
        calendar.setTime(fecha);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public int getDiasTranscurridosEnMes(Date fecha) {
        long inicio = getInicioMes(fecha).getTime();
        long actual = getFechaFinal(fecha).getTime();

        return (int) ((actual - inicio) / UN_DIA);
    }

    public int getDiasFaltantesEnMes(Date fecha) {
        long actual = getFechaInicial(fecha).getTime();
        long fin = getFinMes(fecha).getTime();

        return 1 + (int) ((fin - actual) / UN_DIA);
    }

    public int getDiferenciaDias(Date desde, Date hasta) {
        long actual = getFechaInicial(desde).getTime();
        long fin = getFechaFinal(hasta).getTime();

        return (int) ((fin - actual) / UN_DIA);
    }

    public boolean isMesesIguales(Date fecha1, Date fecha2) {
        int anio1, anio2, mes1, mes2;
        calendar.setTime(fecha1);
        anio1 = calendar.get(Calendar.YEAR);
        mes1 = calendar.get(Calendar.MONTH);
        calendar.setTime(fecha2);
        anio2 = calendar.get(Calendar.YEAR);
        mes2 = calendar.get(Calendar.MONTH);
        return anio1 == anio2 & mes1 == mes2;
    }

    public Date getSiguienteMes(Date fecha) {
        fecha = getFinMes(fecha);
        calendar.setTime(fecha);
        calendar.add(Calendar.MILLISECOND, 1);
        return calendar.getTime();
    }

    public Date getSiguienteDia(Date fecha) {
        calendar.setTime(fecha);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    public Date getAnteriorDia(Date fecha) {
        calendar.setTime(fecha);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public boolean isFechasIguales(Date fecha1, Date fecha2) {
        fecha1 = getFechaInicial(fecha1);
        fecha2 = getFechaInicial(fecha2);
        return fecha1.equals(fecha2);
    }

    public Date getFechaAgregada(Date inicial, int meses) {
        calendar.setTime(inicial);
        calendar.add(Calendar.MONTH, meses);
        return getFechaFinal(getAnteriorDia(calendar.getTime()));
    }
    
    public Date getFechaAgregadaDias(Date inicial, int dias) {
        calendar.setTime(inicial);
        calendar.add(Calendar.DATE, dias);
        return getFechaFinal(getAnteriorDia(calendar.getTime()));
    }

    public boolean esHoy(Date fecha){
        Date hoy=new Date();
        Date inicio=getFechaInicial(hoy);
        Date fin=getFechaFinal(hoy);
        return estaEnRango(inicio, fin, fecha);
    }

    public boolean isPosterior(Date referencia, Date fecha) {
        return fecha.getTime() > referencia.getTime();
    }

    public boolean isAnterior(Date referencia, Date fecha) {
        return fecha.getTime() < referencia.getTime();
    }

    public boolean estaEnRango(Date inicio, Date fin, Date fecha) {
        //System.out.println(CAFFormato.getStringYyyyMMddhhmmss(inicio)+"  >>>  "+CAFFormato.getStringYyyyMMddhhmmss(fin)+"  >>>  "+CAFFormato.getStringYyyyMMddhhmmss(fecha));
        return fecha.getTime() >= inicio.getTime() & fecha.getTime() <= fin.getTime();
    }

    public static String formatoLargoFecha(Date d){
        return formatoLargo.format(d);
    }
    
    public static String formatoCortoFecha(Date d){
        return formatoCorto.format(d);
    }
}
