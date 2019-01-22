/**
 * FlightStatusUpdatedDateV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class FlightStatusUpdatedDateV2  implements java.io.Serializable {
    private java.lang.String field;

    private java.lang.String originalDateLocal;

    private java.lang.String newDateLocal;

    private java.lang.String originalDateUtc;

    private java.lang.String newDateUtc;

    public FlightStatusUpdatedDateV2() {
    }

    public FlightStatusUpdatedDateV2(
           java.lang.String field,
           java.lang.String originalDateLocal,
           java.lang.String newDateLocal,
           java.lang.String originalDateUtc,
           java.lang.String newDateUtc) {
           this.field = field;
           this.originalDateLocal = originalDateLocal;
           this.newDateLocal = newDateLocal;
           this.originalDateUtc = originalDateUtc;
           this.newDateUtc = newDateUtc;
    }


    /**
     * Gets the field value for this FlightStatusUpdatedDateV2.
     * 
     * @return field
     */
    public java.lang.String getField() {
        return field;
    }


    /**
     * Sets the field value for this FlightStatusUpdatedDateV2.
     * 
     * @param field
     */
    public void setField(java.lang.String field) {
        this.field = field;
    }


    /**
     * Gets the originalDateLocal value for this FlightStatusUpdatedDateV2.
     * 
     * @return originalDateLocal
     */
    public java.lang.String getOriginalDateLocal() {
        return originalDateLocal;
    }


    /**
     * Sets the originalDateLocal value for this FlightStatusUpdatedDateV2.
     * 
     * @param originalDateLocal
     */
    public void setOriginalDateLocal(java.lang.String originalDateLocal) {
        this.originalDateLocal = originalDateLocal;
    }


    /**
     * Gets the newDateLocal value for this FlightStatusUpdatedDateV2.
     * 
     * @return newDateLocal
     */
    public java.lang.String getNewDateLocal() {
        return newDateLocal;
    }


    /**
     * Sets the newDateLocal value for this FlightStatusUpdatedDateV2.
     * 
     * @param newDateLocal
     */
    public void setNewDateLocal(java.lang.String newDateLocal) {
        this.newDateLocal = newDateLocal;
    }


    /**
     * Gets the originalDateUtc value for this FlightStatusUpdatedDateV2.
     * 
     * @return originalDateUtc
     */
    public java.lang.String getOriginalDateUtc() {
        return originalDateUtc;
    }


    /**
     * Sets the originalDateUtc value for this FlightStatusUpdatedDateV2.
     * 
     * @param originalDateUtc
     */
    public void setOriginalDateUtc(java.lang.String originalDateUtc) {
        this.originalDateUtc = originalDateUtc;
    }


    /**
     * Gets the newDateUtc value for this FlightStatusUpdatedDateV2.
     * 
     * @return newDateUtc
     */
    public java.lang.String getNewDateUtc() {
        return newDateUtc;
    }


    /**
     * Sets the newDateUtc value for this FlightStatusUpdatedDateV2.
     * 
     * @param newDateUtc
     */
    public void setNewDateUtc(java.lang.String newDateUtc) {
        this.newDateUtc = newDateUtc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FlightStatusUpdatedDateV2)) return false;
        FlightStatusUpdatedDateV2 other = (FlightStatusUpdatedDateV2) obj;
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
            ((this.originalDateLocal==null && other.getOriginalDateLocal()==null) || 
             (this.originalDateLocal!=null &&
              this.originalDateLocal.equals(other.getOriginalDateLocal()))) &&
            ((this.newDateLocal==null && other.getNewDateLocal()==null) || 
             (this.newDateLocal!=null &&
              this.newDateLocal.equals(other.getNewDateLocal()))) &&
            ((this.originalDateUtc==null && other.getOriginalDateUtc()==null) || 
             (this.originalDateUtc!=null &&
              this.originalDateUtc.equals(other.getOriginalDateUtc()))) &&
            ((this.newDateUtc==null && other.getNewDateUtc()==null) || 
             (this.newDateUtc!=null &&
              this.newDateUtc.equals(other.getNewDateUtc())));
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
        if (getOriginalDateLocal() != null) {
            _hashCode += getOriginalDateLocal().hashCode();
        }
        if (getNewDateLocal() != null) {
            _hashCode += getNewDateLocal().hashCode();
        }
        if (getOriginalDateUtc() != null) {
            _hashCode += getOriginalDateUtc().hashCode();
        }
        if (getNewDateUtc() != null) {
            _hashCode += getNewDateUtc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FlightStatusUpdatedDateV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightStatusUpdatedDateV2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("field");
        elemField.setXmlName(new javax.xml.namespace.QName("", "field"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalDateLocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "originalDateLocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newDateLocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "newDateLocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalDateUtc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "originalDateUtc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newDateUtc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "newDateUtc"));
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
