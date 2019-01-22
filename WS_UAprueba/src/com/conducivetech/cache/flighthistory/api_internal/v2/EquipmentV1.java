/**
 * EquipmentV1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class EquipmentV1  implements java.io.Serializable {
    private java.lang.String iata;

    private java.lang.String name;

    private boolean turboProp;

    private boolean jet;

    private boolean widebody;

    private boolean regional;

    public EquipmentV1() {
    }

    public EquipmentV1(
           java.lang.String iata,
           java.lang.String name,
           boolean turboProp,
           boolean jet,
           boolean widebody,
           boolean regional) {
           this.iata = iata;
           this.name = name;
           this.turboProp = turboProp;
           this.jet = jet;
           this.widebody = widebody;
           this.regional = regional;
    }


    /**
     * Gets the iata value for this EquipmentV1.
     * 
     * @return iata
     */
    public java.lang.String getIata() {
        return iata;
    }


    /**
     * Sets the iata value for this EquipmentV1.
     * 
     * @param iata
     */
    public void setIata(java.lang.String iata) {
        this.iata = iata;
    }


    /**
     * Gets the name value for this EquipmentV1.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this EquipmentV1.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the turboProp value for this EquipmentV1.
     * 
     * @return turboProp
     */
    public boolean isTurboProp() {
        return turboProp;
    }


    /**
     * Sets the turboProp value for this EquipmentV1.
     * 
     * @param turboProp
     */
    public void setTurboProp(boolean turboProp) {
        this.turboProp = turboProp;
    }


    /**
     * Gets the jet value for this EquipmentV1.
     * 
     * @return jet
     */
    public boolean isJet() {
        return jet;
    }


    /**
     * Sets the jet value for this EquipmentV1.
     * 
     * @param jet
     */
    public void setJet(boolean jet) {
        this.jet = jet;
    }


    /**
     * Gets the widebody value for this EquipmentV1.
     * 
     * @return widebody
     */
    public boolean isWidebody() {
        return widebody;
    }


    /**
     * Sets the widebody value for this EquipmentV1.
     * 
     * @param widebody
     */
    public void setWidebody(boolean widebody) {
        this.widebody = widebody;
    }


    /**
     * Gets the regional value for this EquipmentV1.
     * 
     * @return regional
     */
    public boolean isRegional() {
        return regional;
    }


    /**
     * Sets the regional value for this EquipmentV1.
     * 
     * @param regional
     */
    public void setRegional(boolean regional) {
        this.regional = regional;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EquipmentV1)) return false;
        EquipmentV1 other = (EquipmentV1) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.iata==null && other.getIata()==null) || 
             (this.iata!=null &&
              this.iata.equals(other.getIata()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.turboProp == other.isTurboProp() &&
            this.jet == other.isJet() &&
            this.widebody == other.isWidebody() &&
            this.regional == other.isRegional();
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
        if (getIata() != null) {
            _hashCode += getIata().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += (isTurboProp() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isJet() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isWidebody() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isRegional() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EquipmentV1.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "equipmentV1"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iata");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iata"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("turboProp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "turboProp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("widebody");
        elemField.setXmlName(new javax.xml.namespace.QName("", "widebody"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regional");
        elemField.setXmlName(new javax.xml.namespace.QName("", "regional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
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

}
