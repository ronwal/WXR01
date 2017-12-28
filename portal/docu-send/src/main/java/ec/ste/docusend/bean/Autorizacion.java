package ec.ste.docusend.bean;

import ec.gob.sri.ws.autorizacion.offline.Autorizacion.Mensajes;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para autorizacion complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;complexType name="autorizacion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroAutorizacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaAutorizacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="ambiente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comprobante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mensajes" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="mensaje" type="{http://ec.gob.sri.ws.autorizacion}mensaje" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "autorizacion", propOrder = {
        "estado",
        "numeroAutorizacion",
        "fechaAutorizacion",
        "ambiente",
        "comprobante",
        "mensajes"
})
public class Autorizacion {

    protected String estado;
    protected String numeroAutorizacion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAutorizacion;
    protected String ambiente;
    protected String comprobante;
    protected Mensajes mensajes;

    public Autorizacion() {
    }

    public Autorizacion(String estado, String numeroAutorizacion, XMLGregorianCalendar fechaAutorizacion, String ambiente, String comprobante, Mensajes mensajes) {
        this.estado = estado;
        this.numeroAutorizacion = numeroAutorizacion;
        this.fechaAutorizacion = fechaAutorizacion;
        this.ambiente = ambiente;
        this.comprobante = comprobante;
        this.mensajes = mensajes;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroAutorizacion.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNumeroAutorizacion() {
        return numeroAutorizacion;
    }

    /**
     * Define el valor de la propiedad numeroAutorizacion.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNumeroAutorizacion(String value) {
        this.numeroAutorizacion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaAutorizacion.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    /**
     * Define el valor de la propiedad fechaAutorizacion.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setFechaAutorizacion(XMLGregorianCalendar value) {
        this.fechaAutorizacion = value;
    }

    /**
     * Obtiene el valor de la propiedad ambiente.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAmbiente() {
        return ambiente;
    }

    /**
     * Define el valor de la propiedad ambiente.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAmbiente(String value) {
        this.ambiente = value;
    }

    /**
     * Obtiene el valor de la propiedad comprobante.
     *
     * @return possible object is
     * {@link String }
     */
    public String getComprobante() {
        return comprobante;
    }

    /**
     * Define el valor de la propiedad comprobante.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setComprobante(String value) {
        this.comprobante = value;
    }

    /**
     * Obtiene el valor de la propiedad mensajes.
     *
     * @return possible object is
     * {@link Mensajes }
     */
    public Mensajes getMensajes() {
        return mensajes;
    }

    /**
     * Define el valor de la propiedad mensajes.
     *
     * @param value allowed object is
     *              {@link Mensajes }
     */
    public void setMensajes(Mensajes value) {
        this.mensajes = value;
    }
}
