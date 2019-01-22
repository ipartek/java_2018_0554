/**
 * CodeshareV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class CodeshareV2  implements java.io.Serializable {
    private com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 carrier;

    private java.lang.String fsCode;

    private java.lang.String flightNumber;

    private java.lang.String relationship;

    public CodeshareV2() {
    }

    public CodeshareV2(
           com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 carrier,
           java.lang.String fsCode,
           java.lang.String flightNumber,
           java.lang.String relationship) {
           this.carrier = carrier;
           this.fsCode = fsCode;
           this.flightNumber = flightNumber;
           this.relationship = relationship;
    }


    /**
     * Gets the carrier value for this CodeshareV2.
     * 
     * @return carrier
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 getCarrier() {
        return carrier;
    }


    /**
     * Sets the carrier value for this CodeshareV2.
     * 
     * @param carrier
     */
    public void setCarrier(com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 carrier) {
        this.carrier = carrier;
    }


    /**
     * Gets the fsCode value for this CodeshareV2.
     * 
     * @return fsCode
     */
    public java.lang.String getFsCode() {
        return fsCode;
    }


    /**
     * Sets the fsCode value for this CodeshareV2.
     * 
     * @param fsCode
     */
    public void setFsCode(java.lang.String fsCode) {
        this.fsCode = fsCode;
    }


    /**
     * Gets the flightNumber value for this CodeshareV2.
     * 
     * @return flightNumber
     */
    public java.lang.String getFlightNumber() {
        return flightNumber;
    }


    /**
     * Sets the flightNumber value for this CodeshareV2.
     * 
     * @param flightNumber
     */
    public void setFlightNumber(java.lang.String flightNumber) {
        this.flightNumber = flightNumber;
    }


    /**
     * Gets the relationship value for this CodeshareV2.
     * 
     * @return relationship
     */
    public java.lang.String getRelationship() {
        return relationship;
    }


    /**
     * Sets the relationship value for this CodeshareV2.
     * 
     * @param relationship
     */
    public void setRelationship(java.lang.String relationship) {
        this.relationship = relationship;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CodeshareV2)) return false;
        CodeshareV2 other = (CodeshareV2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.carrier==null && other.getCarrier()==null) || 
             (this.carrier!=null &&
              this.carrier.equals(other.getCarrier()))) &&
            ((this.fsCode==null && other.getFsCode()==null) || 
             (this.fsCode!=null &&
              this.fsCode.equals(other.getFsCode()))) &&
            ((this.flightNumber==null && other.getFlightNumber()==null) || 
             (this.flightNumber!=null &&
              this.flightNumber.equals(other.getFlightNumber()))) &&
            ((this.relationship==null && other.getRelationship()==null) || 
             (this.relationship!=null &&
              this.relationship.equals(other.getRelationship())));
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
        if (getCarrier() != null) {
            _hashCode += getCarrier().hashCode();
        }
        if (getFsCode() != null) {
            _hashCode += getFsCode().hashCode();
        }
        if (getFlightNumber() != null) {
            _hashCode += getFlightNumber().hashCode();
        }
        if (getRelationship() != null) {
            _hashCode += getRelationship().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CodeshareV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "codeshareV2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carrier");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carrier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airlineV1"));
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
        elemField.setFieldName("flightNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "flightNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relationship");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relationship"));
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
