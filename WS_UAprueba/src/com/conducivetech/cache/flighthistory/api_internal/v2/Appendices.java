/**
 * Appendices.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class Appendices  implements java.io.Serializable {
    private com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1[] airlines;

    private com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1[] airports;

    private com.conducivetech.cache.flighthistory.api_internal.v2.EquipmentV1[] equipments;

    public Appendices() {
    }

    public Appendices(
           com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1[] airlines,
           com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1[] airports,
           com.conducivetech.cache.flighthistory.api_internal.v2.EquipmentV1[] equipments) {
           this.airlines = airlines;
           this.airports = airports;
           this.equipments = equipments;
    }


    /**
     * Gets the airlines value for this Appendices.
     * 
     * @return airlines
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1[] getAirlines() {
        return airlines;
    }


    /**
     * Sets the airlines value for this Appendices.
     * 
     * @param airlines
     */
    public void setAirlines(com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1[] airlines) {
        this.airlines = airlines;
    }


    /**
     * Gets the airports value for this Appendices.
     * 
     * @return airports
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1[] getAirports() {
        return airports;
    }


    /**
     * Sets the airports value for this Appendices.
     * 
     * @param airports
     */
    public void setAirports(com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1[] airports) {
        this.airports = airports;
    }


    /**
     * Gets the equipments value for this Appendices.
     * 
     * @return equipments
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.EquipmentV1[] getEquipments() {
        return equipments;
    }


    /**
     * Sets the equipments value for this Appendices.
     * 
     * @param equipments
     */
    public void setEquipments(com.conducivetech.cache.flighthistory.api_internal.v2.EquipmentV1[] equipments) {
        this.equipments = equipments;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Appendices)) return false;
        Appendices other = (Appendices) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.airlines==null && other.getAirlines()==null) || 
             (this.airlines!=null &&
              java.util.Arrays.equals(this.airlines, other.getAirlines()))) &&
            ((this.airports==null && other.getAirports()==null) || 
             (this.airports!=null &&
              java.util.Arrays.equals(this.airports, other.getAirports()))) &&
            ((this.equipments==null && other.getEquipments()==null) || 
             (this.equipments!=null &&
              java.util.Arrays.equals(this.equipments, other.getEquipments())));
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
        if (getAirlines() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAirlines());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAirlines(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAirports() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAirports());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAirports(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEquipments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEquipments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEquipments(), i);
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
        new org.apache.axis.description.TypeDesc(Appendices.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "appendices"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("airlines");
        elemField.setXmlName(new javax.xml.namespace.QName("", "airlines"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airlineV1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "airline"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("airports");
        elemField.setXmlName(new javax.xml.namespace.QName("", "airports"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airportV1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "airport"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("equipments");
        elemField.setXmlName(new javax.xml.namespace.QName("", "equipments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "equipmentV1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "equipment"));
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
