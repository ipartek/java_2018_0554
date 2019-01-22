/**
 * FlightStatusUpdatedTextV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class FlightStatusUpdatedTextV2  implements java.io.Serializable {
    private java.lang.String field;

    private java.lang.String originalText;

    private java.lang.String newText;

    public FlightStatusUpdatedTextV2() {
    }

    public FlightStatusUpdatedTextV2(
           java.lang.String field,
           java.lang.String originalText,
           java.lang.String newText) {
           this.field = field;
           this.originalText = originalText;
           this.newText = newText;
    }


    /**
     * Gets the field value for this FlightStatusUpdatedTextV2.
     * 
     * @return field
     */
    public java.lang.String getField() {
        return field;
    }


    /**
     * Sets the field value for this FlightStatusUpdatedTextV2.
     * 
     * @param field
     */
    public void setField(java.lang.String field) {
        this.field = field;
    }


    /**
     * Gets the originalText value for this FlightStatusUpdatedTextV2.
     * 
     * @return originalText
     */
    public java.lang.String getOriginalText() {
        return originalText;
    }


    /**
     * Sets the originalText value for this FlightStatusUpdatedTextV2.
     * 
     * @param originalText
     */
    public void setOriginalText(java.lang.String originalText) {
        this.originalText = originalText;
    }


    /**
     * Gets the newText value for this FlightStatusUpdatedTextV2.
     * 
     * @return newText
     */
    public java.lang.String getNewText() {
        return newText;
    }


    /**
     * Sets the newText value for this FlightStatusUpdatedTextV2.
     * 
     * @param newText
     */
    public void setNewText(java.lang.String newText) {
        this.newText = newText;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FlightStatusUpdatedTextV2)) return false;
        FlightStatusUpdatedTextV2 other = (FlightStatusUpdatedTextV2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.field==null && other.getField()==null) || 
             (this.field!=null &&
              this.field.equals(other.getField()))) &&
            ((this.originalText==null && other.getOriginalText()==null) || 
             (this.originalText!=null &&
              this.originalText.equals(other.getOriginalText()))) &&
            ((this.newText==null && other.getNewText()==null) || 
             (this.newText!=null &&
              this.newText.equals(other.getNewText())));
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
        if (getField() != null) {
            _hashCode += getField().hashCode();
        }
        if (getOriginalText() != null) {
            _hashCode += getOriginalText().hashCode();
        }
        if (getNewText() != null) {
            _hashCode += getNewText().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FlightStatusUpdatedTextV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightStatusUpdatedTextV2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("field");
        elemField.setXmlName(new javax.xml.namespace.QName("", "field"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalText");
        elemField.setXmlName(new javax.xml.namespace.QName("", "originalText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newText");
        elemField.setXmlName(new javax.xml.namespace.QName("", "newText"));
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
