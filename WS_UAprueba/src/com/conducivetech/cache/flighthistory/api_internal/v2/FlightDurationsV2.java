/**
 * FlightDurationsV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class FlightDurationsV2  implements java.io.Serializable {
    private java.lang.Integer scheduledBlockMinutes;

    private java.lang.Integer blockMinutes;

    private java.lang.Integer scheduledAirMinutes;

    private java.lang.Integer airMinutes;

    private java.lang.Integer scheduledTaxiOutMinutes;

    private java.lang.Integer taxiOutMinutes;

    private java.lang.Integer scheduledTaxiInMinutes;

    private java.lang.Integer taxiInMinutes;

    public FlightDurationsV2() {
    }

    public FlightDurationsV2(
           java.lang.Integer scheduledBlockMinutes,
           java.lang.Integer blockMinutes,
           java.lang.Integer scheduledAirMinutes,
           java.lang.Integer airMinutes,
           java.lang.Integer scheduledTaxiOutMinutes,
           java.lang.Integer taxiOutMinutes,
           java.lang.Integer scheduledTaxiInMinutes,
           java.lang.Integer taxiInMinutes) {
           this.scheduledBlockMinutes = scheduledBlockMinutes;
           this.blockMinutes = blockMinutes;
           this.scheduledAirMinutes = scheduledAirMinutes;
           this.airMinutes = airMinutes;
           this.scheduledTaxiOutMinutes = scheduledTaxiOutMinutes;
           this.taxiOutMinutes = taxiOutMinutes;
           this.scheduledTaxiInMinutes = scheduledTaxiInMinutes;
           this.taxiInMinutes = taxiInMinutes;
    }


    /**
     * Gets the scheduledBlockMinutes value for this FlightDurationsV2.
     * 
     * @return scheduledBlockMinutes
     */
    public java.lang.Integer getScheduledBlockMinutes() {
        return scheduledBlockMinutes;
    }


    /**
     * Sets the scheduledBlockMinutes value for this FlightDurationsV2.
     * 
     * @param scheduledBlockMinutes
     */
    public void setScheduledBlockMinutes(java.lang.Integer scheduledBlockMinutes) {
        this.scheduledBlockMinutes = scheduledBlockMinutes;
    }


    /**
     * Gets the blockMinutes value for this FlightDurationsV2.
     * 
     * @return blockMinutes
     */
    public java.lang.Integer getBlockMinutes() {
        return blockMinutes;
    }


    /**
     * Sets the blockMinutes value for this FlightDurationsV2.
     * 
     * @param blockMinutes
     */
    public void setBlockMinutes(java.lang.Integer blockMinutes) {
        this.blockMinutes = blockMinutes;
    }


    /**
     * Gets the scheduledAirMinutes value for this FlightDurationsV2.
     * 
     * @return scheduledAirMinutes
     */
    public java.lang.Integer getScheduledAirMinutes() {
        return scheduledAirMinutes;
    }


    /**
     * Sets the scheduledAirMinutes value for this FlightDurationsV2.
     * 
     * @param scheduledAirMinutes
     */
    public void setScheduledAirMinutes(java.lang.Integer scheduledAirMinutes) {
        this.scheduledAirMinutes = scheduledAirMinutes;
    }


    /**
     * Gets the airMinutes value for this FlightDurationsV2.
     * 
     * @return airMinutes
     */
    public java.lang.Integer getAirMinutes() {
        return airMinutes;
    }


    /**
     * Sets the airMinutes value for this FlightDurationsV2.
     * 
     * @param airMinutes
     */
    public void setAirMinutes(java.lang.Integer airMinutes) {
        this.airMinutes = airMinutes;
    }


    /**
     * Gets the scheduledTaxiOutMinutes value for this FlightDurationsV2.
     * 
     * @return scheduledTaxiOutMinutes
     */
    public java.lang.Integer getScheduledTaxiOutMinutes() {
        return scheduledTaxiOutMinutes;
    }


    /**
     * Sets the scheduledTaxiOutMinutes value for this FlightDurationsV2.
     * 
     * @param scheduledTaxiOutMinutes
     */
    public void setScheduledTaxiOutMinutes(java.lang.Integer scheduledTaxiOutMinutes) {
        this.scheduledTaxiOutMinutes = scheduledTaxiOutMinutes;
    }


    /**
     * Gets the taxiOutMinutes value for this FlightDurationsV2.
     * 
     * @return taxiOutMinutes
     */
    public java.lang.Integer getTaxiOutMinutes() {
        return taxiOutMinutes;
    }


    /**
     * Sets the taxiOutMinutes value for this FlightDurationsV2.
     * 
     * @param taxiOutMinutes
     */
    public void setTaxiOutMinutes(java.lang.Integer taxiOutMinutes) {
        this.taxiOutMinutes = taxiOutMinutes;
    }


    /**
     * Gets the scheduledTaxiInMinutes value for this FlightDurationsV2.
     * 
     * @return scheduledTaxiInMinutes
     */
    public java.lang.Integer getScheduledTaxiInMinutes() {
        return scheduledTaxiInMinutes;
    }


    /**
     * Sets the scheduledTaxiInMinutes value for this FlightDurationsV2.
     * 
     * @param scheduledTaxiInMinutes
     */
    public void setScheduledTaxiInMinutes(java.lang.Integer scheduledTaxiInMinutes) {
        this.scheduledTaxiInMinutes = scheduledTaxiInMinutes;
    }


    /**
     * Gets the taxiInMinutes value for this FlightDurationsV2.
     * 
     * @return taxiInMinutes
     */
    public java.lang.Integer getTaxiInMinutes() {
        return taxiInMinutes;
    }


    /**
     * Sets the taxiInMinutes value for this FlightDurationsV2.
     * 
     * @param taxiInMinutes
     */
    public void setTaxiInMinutes(java.lang.Integer taxiInMinutes) {
        this.taxiInMinutes = taxiInMinutes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FlightDurationsV2)) return false;
        FlightDurationsV2 other = (FlightDurationsV2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.scheduledBlockMinutes==null && other.getScheduledBlockMinutes()==null) || 
             (this.scheduledBlockMinutes!=null &&
              this.scheduledBlockMinutes.equals(other.getScheduledBlockMinutes()))) &&
            ((this.blockMinutes==null && other.getBlockMinutes()==null) || 
             (this.blockMinutes!=null &&
              this.blockMinutes.equals(other.getBlockMinutes()))) &&
            ((this.scheduledAirMinutes==null && other.getScheduledAirMinutes()==null) || 
             (this.scheduledAirMinutes!=null &&
              this.scheduledAirMinutes.equals(other.getScheduledAirMinutes()))) &&
            ((this.airMinutes==null && other.getAirMinutes()==null) || 
             (this.airMinutes!=null &&
              this.airMinutes.equals(other.getAirMinutes()))) &&
            ((this.scheduledTaxiOutMinutes==null && other.getScheduledTaxiOutMinutes()==null) || 
             (this.scheduledTaxiOutMinutes!=null &&
              this.scheduledTaxiOutMinutes.equals(other.getScheduledTaxiOutMinutes()))) &&
            ((this.taxiOutMinutes==null && other.getTaxiOutMinutes()==null) || 
             (this.taxiOutMinutes!=null &&
              this.taxiOutMinutes.equals(other.getTaxiOutMinutes()))) &&
            ((this.scheduledTaxiInMinutes==null && other.getScheduledTaxiInMinutes()==null) || 
             (this.scheduledTaxiInMinutes!=null &&
              this.scheduledTaxiInMinutes.equals(other.getScheduledTaxiInMinutes()))) &&
            ((this.taxiInMinutes==null && other.getTaxiInMinutes()==null) || 
             (this.taxiInMinutes!=null &&
              this.taxiInMinutes.equals(other.getTaxiInMinutes())));
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
        if (getScheduledBlockMinutes() != null) {
            _hashCode += getScheduledBlockMinutes().hashCode();
        }
        if (getBlockMinutes() != null) {
            _hashCode += getBlockMinutes().hashCode();
        }
        if (getScheduledAirMinutes() != null) {
            _hashCode += getScheduledAirMinutes().hashCode();
        }
        if (getAirMinutes() != null) {
            _hashCode += getAirMinutes().hashCode();
        }
        if (getScheduledTaxiOutMinutes() != null) {
            _hashCode += getScheduledTaxiOutMinutes().hashCode();
        }
        if (getTaxiOutMinutes() != null) {
            _hashCode += getTaxiOutMinutes().hashCode();
        }
        if (getScheduledTaxiInMinutes() != null) {
            _hashCode += getScheduledTaxiInMinutes().hashCode();
        }
        if (getTaxiInMinutes() != null) {
            _hashCode += getTaxiInMinutes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FlightDurationsV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightDurationsV2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduledBlockMinutes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scheduledBlockMinutes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("blockMinutes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "blockMinutes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduledAirMinutes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scheduledAirMinutes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("airMinutes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "airMinutes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduledTaxiOutMinutes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scheduledTaxiOutMinutes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxiOutMinutes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taxiOutMinutes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduledTaxiInMinutes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scheduledTaxiInMinutes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxiInMinutes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taxiInMinutes"));
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
