/**
 * RequestedAirlineV1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class RequestedAirlineV1  implements java.io.Serializable {
    private java.lang.String requestedCode;

    private java.lang.String fsCode;

    private com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 airline;

    private java.lang.String error;

    public RequestedAirlineV1() {
    }

    public RequestedAirlineV1(
           java.lang.String requestedCode,
           java.lang.String fsCode,
           com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 airline,
           java.lang.String error) {
           this.requestedCode = requestedCode;
           this.fsCode = fsCode;
           this.airline = airline;
           this.error = error;
    }


    /**
     * Gets the requestedCode value for this RequestedAirlineV1.
     * 
     * @return requestedCode
     */
    public java.lang.String getRequestedCode() {
        return requestedCode;
    }


    /**
     * Sets the requestedCode value for this RequestedAirlineV1.
     * 
     * @param requestedCode
     */
    public void setRequestedCode(java.lang.String requestedCode) {
        this.requestedCode = requestedCode;
    }


    /**
     * Gets the fsCode value for this RequestedAirlineV1.
     * 
     * @return fsCode
     */
    public java.lang.String getFsCode() {
        return fsCode;
    }


    /**
     * Sets the fsCode value for this RequestedAirlineV1.
     * 
     * @param fsCode
     */
    public void setFsCode(java.lang.String fsCode) {
        this.fsCode = fsCode;
    }


    /**
     * Gets the airline value for this RequestedAirlineV1.
     * 
     * @return airline
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 getAirline() {
        return airline;
    }


    /**
     * Sets the airline value for this RequestedAirlineV1.
     * 
     * @param airline
     */
    public void setAirline(com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 airline) {
        this.airline = airline;
    }


    /**
     * Gets the error value for this RequestedAirlineV1.
     * 
     * @return error
     */
    public java.lang.String getError() {
        return error;
    }


    /**
     * Sets the error value for this RequestedAirlineV1.
     * 
     * @param error
     */
    public void setError(java.lang.String error) {
        this.error = error;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RequestedAirlineV1)) return false;
        RequestedAirlineV1 other = (RequestedAirlineV1) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.requestedCode==null && other.getRequestedCode()==null) || 
             (this.requestedCode!=null &&
              this.requestedCode.equals(other.getRequestedCode()))) &&
            ((this.fsCode==null && other.getFsCode()==null) || 
             (this.fsCode!=null &&
              this.fsCode.equals(other.getFsCode()))) &&
            ((this.airline==null && other.getAirline()==null) || 
             (this.airline!=null &&
              this.airline.equals(other.getAirline()))) &&
            ((this.error==null && other.getError()==null) || 
             (this.error!=null &&
              this.error.equals(other.getError())));
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
        if (getRequestedCode() != null) {
            _hashCode += getRequestedCode().hashCode();
        }
        if (getFsCode() != null) {
            _hashCode += getFsCode().hashCode();
        }
        if (getAirline() != null) {
            _hashCode += getAirline().hashCode();
        }
        if (getError() != null) {
            _hashCode += getError().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RequestedAirlineV1.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedAirlineV1"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestedCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestedCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fsCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fsCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("airline");
        elemField.setXmlName(new javax.xml.namespace.QName("", "airline"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airlineV1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("error");
        elemField.setXmlName(new javax.xml.namespace.QName("", "error"));
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
