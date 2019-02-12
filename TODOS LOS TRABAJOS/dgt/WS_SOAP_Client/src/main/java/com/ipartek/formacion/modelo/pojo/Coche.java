/**
 * Coche.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ipartek.formacion.modelo.pojo;

public class Coche  implements java.io.Serializable {
    private java.lang.Long id;

    private java.lang.Integer km;

    private java.lang.String matricula;

    private java.lang.String modelo;

    public Coche() {
    }

    public Coche(
           java.lang.Long id,
           java.lang.Integer km,
           java.lang.String matricula,
           java.lang.String modelo) {
           this.id = id;
           this.km = km;
           this.matricula = matricula;
           this.modelo = modelo;
    }


    /**
     * Gets the id value for this Coche.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this Coche.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the km value for this Coche.
     * 
     * @return km
     */
    public java.lang.Integer getKm() {
        return km;
    }


    /**
     * Sets the km value for this Coche.
     * 
     * @param km
     */
    public void setKm(java.lang.Integer km) {
        this.km = km;
    }


    /**
     * Gets the matricula value for this Coche.
     * 
     * @return matricula
     */
    public java.lang.String getMatricula() {
        return matricula;
    }


    /**
     * Sets the matricula value for this Coche.
     * 
     * @param matricula
     */
    public void setMatricula(java.lang.String matricula) {
        this.matricula = matricula;
    }


    /**
     * Gets the modelo value for this Coche.
     * 
     * @return modelo
     */
    public java.lang.String getModelo() {
        return modelo;
    }


    /**
     * Sets the modelo value for this Coche.
     * 
     * @param modelo
     */
    public void setModelo(java.lang.String modelo) {
        this.modelo = modelo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Coche)) return false;
        Coche other = (Coche) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.km==null && other.getKm()==null) || 
             (this.km!=null &&
              this.km.equals(other.getKm()))) &&
            ((this.matricula==null && other.getMatricula()==null) || 
             (this.matricula!=null &&
              this.matricula.equals(other.getMatricula()))) &&
            ((this.modelo==null && other.getModelo()==null) || 
             (this.modelo!=null &&
              this.modelo.equals(other.getModelo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getKm() != null) {
            _hashCode += getKm().hashCode();
        }
        if (getMatricula() != null) {
            _hashCode += getMatricula().hashCode();
        }
        if (getModelo() != null) {
            _hashCode += getModelo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Coche.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pojo.modelo.formacion.ipartek.com", "Coche"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.modelo.formacion.ipartek.com", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("km");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.modelo.formacion.ipartek.com", "km"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matricula");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.modelo.formacion.ipartek.com", "matricula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modelo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.modelo.formacion.ipartek.com", "modelo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

	@Override
	public String toString() {
		return "Coche [id=" + id + ", km=" + km + ", matricula=" + matricula + ", modelo=" + modelo + ", __equalsCalc="
				+ __equalsCalc + ", __hashCodeCalc=" + __hashCodeCalc + "]";
	}
    
    

}
