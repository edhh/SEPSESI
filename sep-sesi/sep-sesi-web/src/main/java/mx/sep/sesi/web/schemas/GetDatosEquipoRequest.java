//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.03.24 a las 10:54:26 AM CST 
//


package mx.sep.sesi.web.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="curp">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="numSerie">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="idPartida" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tipoOperacion" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="correo">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "curp",
    "numSerie",
    "idPartida",
    "tipoOperacion",
    "correo"
})
@XmlRootElement(name = "getDatosEquipoRequest")
public class GetDatosEquipoRequest {

    @XmlElement(required = true)
    protected String curp;
    @XmlElement(required = true)
    protected String numSerie;
    protected long idPartida;
    protected long tipoOperacion;
    @XmlElement(required = true)
    protected String correo;

    /**
     * Obtiene el valor de la propiedad curp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Define el valor de la propiedad curp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurp(String value) {
        this.curp = value;
    }

    /**
     * Obtiene el valor de la propiedad numSerie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSerie() {
        return numSerie;
    }

    /**
     * Define el valor de la propiedad numSerie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSerie(String value) {
        this.numSerie = value;
    }

    /**
     * Obtiene el valor de la propiedad idPartida.
     * 
     */
    public long getIdPartida() {
        return idPartida;
    }

    /**
     * Define el valor de la propiedad idPartida.
     * 
     */
    public void setIdPartida(long value) {
        this.idPartida = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoOperacion.
     * 
     */
    public long getTipoOperacion() {
        return tipoOperacion;
    }

    /**
     * Define el valor de la propiedad tipoOperacion.
     * 
     */
    public void setTipoOperacion(long value) {
        this.tipoOperacion = value;
    }

    /**
     * Obtiene el valor de la propiedad correo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Define el valor de la propiedad correo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorreo(String value) {
        this.correo = value;
    }

}
