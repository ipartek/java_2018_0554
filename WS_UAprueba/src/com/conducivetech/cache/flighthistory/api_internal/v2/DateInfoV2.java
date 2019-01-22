/**
 * DateInfoV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class DateInfoV2  implements java.io.Serializable {
    private java.lang.String dateLocal;

    private java.lang.String dateUtc;

    public DateInfoV2() {
    }

    public DateInfoV2(
           java.lang.String dateLocal,
           java.lang.String dateUtc) {
           this.dateLocal = dateLocal;
           this.dateUtc = dateUtc;
    }


    /**
     * Gets the dateLocal value for this DateInfoV2.
     * 
     * @return dateLocal
     */
    public java.lang.String getDateLocal() {
        return dateLocal;
    }


    /**
     * Sets the dateLocal value for this DateInfoV2.
     * 
     * @param dateLocal
     */
    public void setDateLocal(java.lang.String dateLocal) {
        this.dateLocal = dateLocal;
    }


    /**
     * Gets the dateUtc value for this DateInfoV2.
     * 
     * @return dateUtc
     */
    public java.lang.String getDateUtc() {
        return dateUtc;
    }


    /**
     * Sets the dateUtc value for this DateInfoV2.
     * 
     * @param dateUtc
     */
    public void setDateUtc(java.lang.String dateUtc) {
        this.dateUtc = dateUtc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DateInfoV2)) return false;
        DateInfoV2 other = (DateInfoV2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dateLocal==null && other.getDateLocal()==null) || 
             (this.dateLocal!=null &&
              this.dateLocal.equals(other.getDateLocal()))) &&
            ((this.dateUtc==null && other.getDateUtc()==null) || 
             (this.dateUtc!=null &&
              this.dateUtc.equals(other.getDateUtc())));
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
        if (getDateLocal() != null) {
            _hashCode += getDateLocal().hashCode();
        }
        if (getDateUtc() != null) {
            _hashCode += getDateUtc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DateInfoV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "dateInfoV2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateLocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateLocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateUtc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateUtc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
