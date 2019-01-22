/**
 * FlightEquipmentV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class FlightEquipmentV2  implements java.io.Serializable {
    private com.conducivetech.cache.flighthistory.api_internal.v2.EquipmentV1 scheduledEquipment;

    private java.lang.String scheduledEquipmentIataCode;

    private com.conducivetech.cache.flighthistory.api_internal.v2.EquipmentV1 actualEquipment;

    private java.lang.String actualEquipmentIataCode;

    private java.lang.String tailNumber;

    public FlightEquipmentV2() {
    }

    public FlightEquipmentV2(
           com.conducivetech.cache.flighthistory.api_internal.v2.EquipmentV1 scheduledEquipment,
           java.lang.String scheduledEquipmentIataCode,
           com.conducivetech.cache.flighthistory.api_internal.v2.EquipmentV1 actualEquipment,
           java.lang.String actualEquipmentIataCode,
           java.lang.String tailNumber) {
           this.scheduledEquipment = scheduledEquipment;
           this.scheduledEquipmentIataCode = scheduledEquipmentIataCode;
           this.actualEquipment = actualEquipment;
           this.actualEquipmentIataCode = actualEquipmentIataCode;
           this.tailNumber = tailNumber;
    }


    /**
     * Gets the scheduledEquipment value for this FlightEquipmentV2.
     * 
     * @return scheduledEquipment
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.EquipmentV1 getScheduledEquipment() {
        return scheduledEquipment;
    }


    /**
     * Sets the scheduledEquipment value for this FlightEquipmentV2.
     * 
     * @param scheduledEquipment
     */
    public void setScheduledEquipment(com.conducivetech.cache.flighthistory.api_internal.v2.EquipmentV1 scheduledEquipment) {
        this.scheduledEquipment = scheduledEquipment;
    }


    /**
     * Gets the scheduledEquipmentIataCode value for this FlightEquipmentV2.
     * 
     * @return scheduledEquipmentIataCode
     */
    public java.lang.String getScheduledEquipmentIataCode() {
        return scheduledEquipmentIataCode;
    }


    /**
     * Sets the scheduledEquipmentIataCode value for this FlightEquipmentV2.
     * 
     * @param scheduledEquipmentIataCode
     */
    public void setScheduledEquipmentIataCode(java.lang.String scheduledEquipmentIataCode) {
        this.scheduledEquipmentIataCode = scheduledEquipmentIataCode;
    }


    /**
     * Gets the actualEquipment value for this FlightEquipmentV2.
     * 
     * @return actualEquipment
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.EquipmentV1 getActualEquipment() {
        return actualEquipment;
    }


    /**
     * Sets the actualEquipment value for this FlightEquipmentV2.
     * 
     * @param actualEquipment
     */
    public void setActualEquipment(com.conducivetech.cache.flighthistory.api_internal.v2.EquipmentV1 actualEquipment) {
        this.actualEquipment = actualEquipment;
    }


    /**
     * Gets the actualEquipmentIataCode value for this FlightEquipmentV2.
     * 
     * @return actualEquipmentIataCode
     */
    public java.lang.String getActualEquipmentIataCode() {
        return actualEquipmentIataCode;
    }


    /**
     * Sets the actualEquipmentIataCode value for this FlightEquipmentV2.
     * 
     * @param actualEquipmentIataCode
     */
    public void setActualEquipmentIataCode(java.lang.String actualEquipmentIataCode) {
        this.actualEquipmentIataCode = actualEquipmentIataCode;
    }


    /**
     * Gets the tailNumber value for this FlightEquipmentV2.
     * 
     * @return tailNumber
     */
    public java.lang.String getTailNumber() {
        return tailNumber;
    }


    /**
     * Sets the tailNumber value for this FlightEquipmentV2.
     * 
     * @param tailNumber
     */
    public void setTailNumber(java.lang.String tailNumber) {
        this.tailNumber = tailNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FlightEquipmentV2)) return false;
        FlightEquipmentV2 other = (FlightEquipmentV2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.scheduledEquipment==null && other.getScheduledEquipment()==null) || 
             (this.scheduledEquipment!=null &&
              this.scheduledEquipment.equals(other.getScheduledEquipment()))) &&
            ((this.scheduledEquipmentIataCode==null && other.getScheduledEquipmentIataCode()==null) || 
             (this.scheduledEquipmentIataCode!=null &&
              this.scheduledEquipmentIataCode.equals(other.getScheduledEquipmentIataCode()))) &&
            ((this.actualEquipment==null && other.getActualEquipment()==null) || 
             (this.actualEquipment!=null &&
              this.actualEquipment.equals(other.getActualEquipment()))) &&
            ((this.actualEquipmentIataCode==null && other.getActualEquipmentIataCode()==null) || 
             (this.actualEquipmentIataCode!=null &&
              this.actualEquipmentIataCode.equals(other.getActualEquipmentIataCode()))) &&
            ((this.tailNumber==null && other.getTailNumber()==null) || 
             (this.tailNumber!=null &&
              this.tailNumber.equals(other.getTailNumber())));
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
        if (getScheduledEquipment() != null) {
            _hashCode += getScheduledEquipment().hashCode();
        }
        if (getScheduledEquipmentIataCode() != null) {
            _hashCode += getScheduledEquipmentIataCode().hashCode();
        }
        if (getActualEquipment() != null) {
            _hashCode += getActualEquipment().hashCode();
        }
        if (getActualEquipmentIataCode() != null) {
            _hashCode += getActualEquipmentIataCode().hashCode();
        }
        if (getTailNumber() != null) {
            _hashCode += getTailNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FlightEquipmentV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightEquipmentV2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduledEquipment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scheduledEquipment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "equipmentV1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduledEquipmentIataCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scheduledEquipmentIataCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actualEquipment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "actualEquipment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "equipmentV1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actualEquipmentIataCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "actualEquipmentIataCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tailNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tailNumber"));
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
