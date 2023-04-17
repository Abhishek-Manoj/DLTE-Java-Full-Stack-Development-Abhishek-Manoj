//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.14 at 10:01:16 AM IST 
//


package soap.project.bank;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loanScheme complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loanScheme">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="loanSchemeId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="loanSchemeType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="loanSchemeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="loanSchemeDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="loanSchemeRoi" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loanScheme", propOrder = {
    "loanSchemeId",
    "loanSchemeType",
    "loanSchemeName",
    "loanSchemeDesc",
    "loanSchemeRoi"
})
public class LoanScheme {

    protected long loanSchemeId;
    @XmlElement(required = true)
    protected String loanSchemeType;
    @XmlElement(required = true)
    protected String loanSchemeName;
    @XmlElement(required = true)
    protected String loanSchemeDesc;
    protected float loanSchemeRoi;

    /**
     * Gets the value of the loanSchemeId property.
     * 
     */
    public long getLoanSchemeId() {
        return loanSchemeId;
    }

    /**
     * Sets the value of the loanSchemeId property.
     * 
     */
    public void setLoanSchemeId(long value) {
        this.loanSchemeId = value;
    }

    /**
     * Gets the value of the loanSchemeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanSchemeType() {
        return loanSchemeType;
    }

    /**
     * Sets the value of the loanSchemeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanSchemeType(String value) {
        this.loanSchemeType = value;
    }

    /**
     * Gets the value of the loanSchemeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanSchemeName() {
        return loanSchemeName;
    }

    /**
     * Sets the value of the loanSchemeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanSchemeName(String value) {
        this.loanSchemeName = value;
    }

    /**
     * Gets the value of the loanSchemeDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanSchemeDesc() {
        return loanSchemeDesc;
    }

    /**
     * Sets the value of the loanSchemeDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanSchemeDesc(String value) {
        this.loanSchemeDesc = value;
    }

    /**
     * Gets the value of the loanSchemeRoi property.
     * 
     */
    public float getLoanSchemeRoi() {
        return loanSchemeRoi;
    }

    /**
     * Sets the value of the loanSchemeRoi property.
     * 
     */
    public void setLoanSchemeRoi(float value) {
        this.loanSchemeRoi = value;
    }

}