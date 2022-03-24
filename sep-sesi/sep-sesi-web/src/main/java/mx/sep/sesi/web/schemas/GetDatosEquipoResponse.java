//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.03.24 a las 10:54:26 AM CST 
//


package mx.sep.sesi.web.schemas;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="datosEquipo" type="{http://web.sesi.sep.mx/schemas}datosEquipo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="statusOper" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="tipoError" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "datosEquipo",
    "statusOper",
    "tipoError"
})
@XmlRootElement(name = "getDatosEquipoResponse")
public class GetDatosEquipoResponse {

    protected List<DatosEquipo> datosEquipo;
    protected short statusOper;
    @XmlElement(required = true)
    protected String tipoError;

    /**
     * Gets the value of the datosEquipo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datosEquipo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatosEquipo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatosEquipo }
     * 
     * 
     */
    public List<DatosEquipo> getDatosEquipo() {
        if (datosEquipo == null) {
            datosEquipo = new ArrayList<DatosEquipo>();
        }
        return this.datosEquipo;
    }

    /**
     * Obtiene el valor de la propiedad statusOper.
     * 
     */
    public short getStatusOper() {
        return statusOper;
    }

    /**
     * Define el valor de la propiedad statusOper.
     * 
     */
    public void setStatusOper(short value) {
        this.statusOper = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoError() {
        return tipoError;
    }

    /**
     * Define el valor de la propiedad tipoError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoError(String value) {
        this.tipoError = value;
    }

}
