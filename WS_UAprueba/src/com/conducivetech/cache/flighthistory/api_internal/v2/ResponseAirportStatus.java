/**
 * ResponseAirportStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class ResponseAirportStatus  extends com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusesResponse  implements java.io.Serializable {
    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestAirportStatus request;

    public ResponseAirportStatus() {
    }

    public ResponseAirportStatus(
           com.conducivetech.cache.flighthistory.api_internal.v2.ApiResponseError error,
           com.conducivetech.cache.flighthistory.api_internal.v2.Appendices appendix,
           com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusV2[] flightStatuses,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestAirportStatus request) {
        super(
            error,
            appendix,
            flightStatuses);
        this.request = request;
    }


    /**
     * Gets the request value for this ResponseAirportStatus.
     * 
     * @return request
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestAirportStatus getRequest() {
        return request;
    }


    /**
     * Sets the request value for this ResponseAirportStatus.
     * 
     * @param request
     */
    public void setRequest(com.conducivetech.cache.flighthistory.api_internal.v2.RequestAirportStatus request) {
        this.request = request;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseAirportStatus)) return false;
        ResponseAirportStatus other = (ResponseAirportStatus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.request==null && other.getRequest()==null) || 
             (this.request!=null &&
              this.request.equals(other.getRequest())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getRequest() != null) {
            _hashCode += getRequest().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseAirportStatus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "responseAirportStatus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("request");
        elemField.setXmlName(new javax.xml.namespace.QName("", "request"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestAirportStatus"));
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
