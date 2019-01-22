/**
 * IrregularOperationV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class IrregularOperationV2  implements java.io.Serializable {
    private java.lang.String type;

    private java.lang.String newArrivalAirportFsCode;

    private java.lang.Long relatedFlightId;

    private java.lang.String dateUtc;

    private java.lang.String message;

    public IrregularOperationV2() {
    }

    public IrregularOperationV2(
           java.lang.String type,
           java.lang.String newArrivalAirportFsCode,
           java.lang.Long relatedFlightId,
           java.lang.String dateUtc,
           java.lang.String message) {
           this.type = type;
           this.newArrivalAirportFsCode = newArrivalAirportFsCode;
           this.relatedFlightId = relatedFlightId;
           this.dateUtc = dateUtc;
           this.message = message;
    }


    /**
     * Gets the type value for this IrregularOperationV2.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this IrregularOperationV2.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the newArrivalAirportFsCode value for this IrregularOperationV2.
     * 
     * @return newArrivalAirportFsCode
     */
    public java.lang.String getNewArrivalAirportFsCode() {
        return newArrivalAirportFsCode;
    }


    /**
     * Sets the newArrivalAirportFsCode value for this IrregularOperationV2.
     * 
     * @param newArrivalAirportFsCode
     */
    public void setNewArrivalAirportFsCode(java.lang.String newArrivalAirportFsCode) {
        this.newArrivalAirportFsCode = newArrivalAirportFsCode;
    }


    /**
     * Gets the relatedFlightId value for this IrregularOperationV2.
     * 
     * @return relatedFlightId
     */
    public java.lang.Long getRelatedFlightId() {
        return relatedFlightId;
    }


    /**
     * Sets the relatedFlightId value for this IrregularOperationV2.
     * 
     * @param relatedFlightId
     */
    public void setRelatedFlightId(java.lang.Long relatedFlightId) {
        this.relatedFlightId = relatedFlightId;
    }


    /**
     * Gets the dateUtc value for this IrregularOperationV2.
     * 
     * @return dateUtc
     */
    public java.lang.String getDateUtc() {
        return dateUtc;
    }


    /**
     * Sets the dateUtc value for this IrregularOperationV2.
     * 
     * @param dateUtc
     */
    public void setDateUtc(java.lang.String dateUtc) {
        this.dateUtc = dateUtc;
    }


    /**
     * Gets the message value for this IrregularOperationV2.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this IrregularOperationV2.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IrregularOperationV2)) return false;
        IrregularOperationV2 other = (IrregularOperationV2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.newArrivalAirportFsCode==null && other.getNewArrivalAirportFsCode()==null) || 
             (this.newArrivalAirportFsCode!=null &&
              this.newArrivalAirportFsCode.equals(other.getNewArrivalAirportFsCode()))) &&
            ((this.relatedFlightId==null && other.getRelatedFlightId()==null) || 
             (this.relatedFlightId!=null &&
              this.relatedFlightId.equals(other.getRelatedFlightId()))) &&
            ((this.dateUtc==null && other.getDateUtc()==null) || 
             (this.dateUtc!=null &&
              this.dateUtc.equals(other.getDateUtc()))) &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage())));
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
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getNewArrivalAirportFsCode() != null) {
            _hashCode += getNewArrivalAirportFsCode().hashCode();
        }
        if (getRelatedFlightId() != null) {
            _hashCode += getRelatedFlightId().hashCode();
        }
        if (getDateUtc() != null) {
            _hashCode += getDateUtc().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IrregularOperationV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "irregularOperationV2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newArrivalAirportFsCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "newArrivalAirportFsCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relatedFlightId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relatedFlightId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateUtc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateUtc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("", "message"));
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
