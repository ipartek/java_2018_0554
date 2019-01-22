/**
 * FlightStatusUpdateV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class FlightStatusUpdateV2  implements java.io.Serializable {
    private com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2 updatedAt;

    private java.lang.String source;

    private com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdatedTextV2[] updatedTextFields;

    private com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdatedDateV2[] updatedDateFields;

    public FlightStatusUpdateV2() {
    }

    public FlightStatusUpdateV2(
           com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2 updatedAt,
           java.lang.String source,
           com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdatedTextV2[] updatedTextFields,
           com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdatedDateV2[] updatedDateFields) {
           this.updatedAt = updatedAt;
           this.source = source;
           this.updatedTextFields = updatedTextFields;
           this.updatedDateFields = updatedDateFields;
    }


    /**
     * Gets the updatedAt value for this FlightStatusUpdateV2.
     * 
     * @return updatedAt
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2 getUpdatedAt() {
        return updatedAt;
    }


    /**
     * Sets the updatedAt value for this FlightStatusUpdateV2.
     * 
     * @param updatedAt
     */
    public void setUpdatedAt(com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2 updatedAt) {
        this.updatedAt = updatedAt;
    }


    /**
     * Gets the source value for this FlightStatusUpdateV2.
     * 
     * @return source
     */
    public java.lang.String getSource() {
        return source;
    }


    /**
     * Sets the source value for this FlightStatusUpdateV2.
     * 
     * @param source
     */
    public void setSource(java.lang.String source) {
        this.source = source;
    }


    /**
     * Gets the updatedTextFields value for this FlightStatusUpdateV2.
     * 
     * @return updatedTextFields
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdatedTextV2[] getUpdatedTextFields() {
        return updatedTextFields;
    }


    /**
     * Sets the updatedTextFields value for this FlightStatusUpdateV2.
     * 
     * @param updatedTextFields
     */
    public void setUpdatedTextFields(com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdatedTextV2[] updatedTextFields) {
        this.updatedTextFields = updatedTextFields;
    }


    /**
     * Gets the updatedDateFields value for this FlightStatusUpdateV2.
     * 
     * @return updatedDateFields
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdatedDateV2[] getUpdatedDateFields() {
        return updatedDateFields;
    }


    /**
     * Sets the updatedDateFields value for this FlightStatusUpdateV2.
     * 
     * @param updatedDateFields
     */
    public void setUpdatedDateFields(com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdatedDateV2[] updatedDateFields) {
        this.updatedDateFields = updatedDateFields;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FlightStatusUpdateV2)) return false;
        FlightStatusUpdateV2 other = (FlightStatusUpdateV2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.updatedAt==null && other.getUpdatedAt()==null) || 
             (this.updatedAt!=null &&
              this.updatedAt.equals(other.getUpdatedAt()))) &&
            ((this.source==null && other.getSource()==null) || 
             (this.source!=null &&
              this.source.equals(other.getSource()))) &&
            ((this.updatedTextFields==null && other.getUpdatedTextFields()==null) || 
             (this.updatedTextFields!=null &&
              java.util.Arrays.equals(this.updatedTextFields, other.getUpdatedTextFields()))) &&
            ((this.updatedDateFields==null && other.getUpdatedDateFields()==null) || 
             (this.updatedDateFields!=null &&
              java.util.Arrays.equals(this.updatedDateFields, other.getUpdatedDateFields())));
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
        if (getUpdatedAt() != null) {
            _hashCode += getUpdatedAt().hashCode();
        }
        if (getSource() != null) {
            _hashCode += getSource().hashCode();
        }
        if (getUpdatedTextFields() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUpdatedTextFields());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUpdatedTextFields(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUpdatedDateFields() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUpdatedDateFields());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUpdatedDateFields(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FlightStatusUpdateV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightStatusUpdateV2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updatedAt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "updatedAt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "dateInfoV2"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("source");
        elemField.setXmlName(new javax.xml.namespace.QName("", "source"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updatedTextFields");
        elemField.setXmlName(new javax.xml.namespace.QName("", "updatedTextFields"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightStatusUpdatedTextV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "updatedTextField"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updatedDateFields");
        elemField.setXmlName(new javax.xml.namespace.QName("", "updatedDateFields"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightStatusUpdatedDateV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "updatedDateField"));
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
