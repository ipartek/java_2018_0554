/**
 * DelaysV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class DelaysV2  implements java.io.Serializable {
    private java.lang.Integer departureGateDelayMinutes;

    private java.lang.Integer departureRunwayDelayMinutes;

    private java.lang.Integer arrivalGateDelayMinutes;

    private java.lang.Integer arrivalRunwayDelayMinutes;

    public DelaysV2() {
    }

    public DelaysV2(
           java.lang.Integer departureGateDelayMinutes,
           java.lang.Integer departureRunwayDelayMinutes,
           java.lang.Integer arrivalGateDelayMinutes,
           java.lang.Integer arrivalRunwayDelayMinutes) {
           this.departureGateDelayMinutes = departureGateDelayMinutes;
           this.departureRunwayDelayMinutes = departureRunwayDelayMinutes;
           this.arrivalGateDelayMinutes = arrivalGateDelayMinutes;
           this.arrivalRunwayDelayMinutes = arrivalRunwayDelayMinutes;
    }


    /**
     * Gets the departureGateDelayMinutes value for this DelaysV2.
     * 
     * @return departureGateDelayMinutes
     */
    public java.lang.Integer getDepartureGateDelayMinutes() {
        return departureGateDelayMinutes;
    }


    /**
     * Sets the departureGateDelayMinutes value for this DelaysV2.
     * 
     * @param departureGateDelayMinutes
     */
    public void setDepartureGateDelayMinutes(java.lang.Integer departureGateDelayMinutes) {
        this.departureGateDelayMinutes = departureGateDelayMinutes;
    }


    /**
     * Gets the departureRunwayDelayMinutes value for this DelaysV2.
     * 
     * @return departureRunwayDelayMinutes
     */
    public java.lang.Integer getDepartureRunwayDelayMinutes() {
        return departureRunwayDelayMinutes;
    }


    /**
     * Sets the departureRunwayDelayMinutes value for this DelaysV2.
     * 
     * @param departureRunwayDelayMinutes
     */
    public void setDepartureRunwayDelayMinutes(java.lang.Integer departureRunwayDelayMinutes) {
        this.departureRunwayDelayMinutes = departureRunwayDelayMinutes;
    }


    /**
     * Gets the arrivalGateDelayMinutes value for this DelaysV2.
     * 
     * @return arrivalGateDelayMinutes
     */
    public java.lang.Integer getArrivalGateDelayMinutes() {
        return arrivalGateDelayMinutes;
    }


    /**
     * Sets the arrivalGateDelayMinutes value for this DelaysV2.
     * 
     * @param arrivalGateDelayMinutes
     */
    public void setArrivalGateDelayMinutes(java.lang.Integer arrivalGateDelayMinutes) {
        this.arrivalGateDelayMinutes = arrivalGateDelayMinutes;
    }


    /**
     * Gets the arrivalRunwayDelayMinutes value for this DelaysV2.
     * 
     * @return arrivalRunwayDelayMinutes
     */
    public java.lang.Integer getArrivalRunwayDelayMinutes() {
        return arrivalRunwayDelayMinutes;
    }


    /**
     * Sets the arrivalRunwayDelayMinutes value for this DelaysV2.
     * 
     * @param arrivalRunwayDelayMinutes
     */
    public void setArrivalRunwayDelayMinutes(java.lang.Integer arrivalRunwayDelayMinutes) {
        this.arrivalRunwayDelayMinutes = arrivalRunwayDelayMinutes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DelaysV2)) return false;
        DelaysV2 other = (DelaysV2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.departureGateDelayMinutes==null && other.getDepartureGateDelayMinutes()==null) || 
             (this.departureGateDelayMinutes!=null &&
              this.departureGateDelayMinutes.equals(other.getDepartureGateDelayMinutes()))) &&
            ((this.departureRunwayDelayMinutes==null && other.getDepartureRunwayDelayMinutes()==null) || 
             (this.departureRunwayDelayMinutes!=null &&
              this.departureRunwayDelayMinutes.equals(other.getDepartureRunwayDelayMinutes()))) &&
            ((this.arrivalGateDelayMinutes==null && other.getArrivalGateDelayMinutes()==null) || 
             (this.arrivalGateDelayMinutes!=null &&
              this.arrivalGateDelayMinutes.equals(other.getArrivalGateDelayMinutes()))) &&
            ((this.arrivalRunwayDelayMinutes==null && other.getArrivalRunwayDelayMinutes()==null) || 
             (this.arrivalRunwayDelayMinutes!=null &&
              this.arrivalRunwayDelayMinutes.equals(other.getArrivalRunwayDelayMinutes())));
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
        if (getDepartureGateDelayMinutes() != null) {
            _hashCode += getDepartureGateDelayMinutes().hashCode();
        }
        if (getDepartureRunwayDelayMinutes() != null) {
            _hashCode += getDepartureRunwayDelayMinutes().hashCode();
        }
        if (getArrivalGateDelayMinutes() != null) {
            _hashCode += getArrivalGateDelayMinutes().hashCode();
        }
        if (getArrivalRunwayDelayMinutes() != null) {
            _hashCode += getArrivalRunwayDelayMinutes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DelaysV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "delaysV2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departureGateDelayMinutes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departureGateDelayMinutes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departureRunwayDelayMinutes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departureRunwayDelayMinutes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrivalGateDelayMinutes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrivalGateDelayMinutes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrivalRunwayDelayMinutes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrivalRunwayDelayMinutes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
