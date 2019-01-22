/**
 * RequestedString.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class RequestedString  implements java.io.Serializable {
    private java.lang.String requested;

    private java.lang.String interpreted;

    private java.lang.String error;

    public RequestedString() {
    }

    public RequestedString(
           java.lang.String requested,
           java.lang.String interpreted,
           java.lang.String error) {
           this.requested = requested;
           this.interpreted = interpreted;
           this.error = error;
    }


    /**
     * Gets the requested value for this RequestedString.
     * 
     * @return requested
     */
    public java.lang.String getRequested() {
        return requested;
    }


    /**
     * Sets the requested value for this RequestedString.
     * 
     * @param requested
     */
    public void setRequested(java.lang.String requested) {
        this.requested = requested;
    }


    /**
     * Gets the interpreted value for this RequestedString.
     * 
     * @return interpreted
     */
    public java.lang.String getInterpreted() {
        return interpreted;
    }


    /**
     * Sets the interpreted value for this RequestedString.
     * 
     * @param interpreted
     */
    public void setInterpreted(java.lang.String interpreted) {
        this.interpreted = interpreted;
    }


    /**
     * Gets the error value for this RequestedString.
     * 
     * @return error
     */
    public java.lang.String getError() {
        return error;
    }


    /**
     * Sets the error value for this RequestedString.
     * 
     * @param error
     */
    public void setError(java.lang.String error) {
        this.error = error;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RequestedString)) return false;
        RequestedString other = (RequestedString) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.requested==null && other.getRequested()==null) || 
             (this.requested!=null &&
              this.requested.equals(other.getRequested()))) &&
            ((this.interpreted==null && other.getInterpreted()==null) || 
             (this.interpreted!=null &&
              this.interpreted.equals(other.getInterpreted()))) &&
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
        if (getRequested() != null) {
            _hashCode += getRequested().hashCode();
        }
        if (getInterpreted() != null) {
            _hashCode += getInterpreted().hashCode();
        }
        if (getError() != null) {
            _hashCode += getError().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RequestedString.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedString"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requested");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requested"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interpreted");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interpreted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
