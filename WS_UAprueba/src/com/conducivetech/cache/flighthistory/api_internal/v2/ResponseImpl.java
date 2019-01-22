/**
 * ResponseImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public abstract class ResponseImpl  implements java.io.Serializable {
    private com.conducivetech.cache.flighthistory.api_internal.v2.ApiResponseError error;

    private com.conducivetech.cache.flighthistory.api_internal.v2.Appendices appendix;

    public ResponseImpl() {
    }

    public ResponseImpl(
           com.conducivetech.cache.flighthistory.api_internal.v2.ApiResponseError error,
           com.conducivetech.cache.flighthistory.api_internal.v2.Appendices appendix) {
           this.error = error;
           this.appendix = appendix;
    }


    /**
     * Gets the error value for this ResponseImpl.
     * 
     * @return error
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.ApiResponseError getError() {
        return error;
    }


    /**
     * Sets the error value for this ResponseImpl.
     * 
     * @param error
     */
    public void setError(com.conducivetech.cache.flighthistory.api_internal.v2.ApiResponseError error) {
        this.error = error;
    }


    /**
     * Gets the appendix value for this ResponseImpl.
     * 
     * @return appendix
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.Appendices getAppendix() {
        return appendix;
    }


    /**
     * Sets the appendix value for this ResponseImpl.
     * 
     * @param appendix
     */
    public void setAppendix(com.conducivetech.cache.flighthistory.api_internal.v2.Appendices appendix) {
        this.appendix = appendix;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseImpl)) return false;
        ResponseImpl other = (ResponseImpl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.error==null && other.getError()==null) || 
             (this.error!=null &&
              this.error.equals(other.getError()))) &&
            ((this.appendix==null && other.getAppendix()==null) || 
             (this.appendix!=null &&
              this.appendix.equals(other.getAppendix())));
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
        if (getError() != null) {
            _hashCode += getError().hashCode();
        }
        if (getAppendix() != null) {
            _hashCode += getAppendix().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseImpl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "responseImpl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("error");
        elemField.setXmlName(new javax.xml.namespace.QName("", "error"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "apiResponseError"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appendix");
        elemField.setXmlName(new javax.xml.namespace.QName("", "appendix"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "appendices"));
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
