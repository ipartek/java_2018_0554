/**
 * AirportResourcesV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class AirportResourcesV2  implements java.io.Serializable {
    private java.lang.String departureTerminal;

    private java.lang.String departureGate;

    private java.lang.String arrivalTerminal;

    private java.lang.String arrivalGate;

    private java.lang.String baggage;

    public AirportResourcesV2() {
    }

    public AirportResourcesV2(
           java.lang.String departureTerminal,
           java.lang.String departureGate,
           java.lang.String arrivalTerminal,
           java.lang.String arrivalGate,
           java.lang.String baggage) {
           this.departureTerminal = departureTerminal;
           this.departureGate = departureGate;
           this.arrivalTerminal = arrivalTerminal;
           this.arrivalGate = arrivalGate;
           this.baggage = baggage;
    }


    /**
     * Gets the departureTerminal value for this AirportResourcesV2.
     * 
     * @return departureTerminal
     */
    public java.lang.String getDepartureTerminal() {
        return departureTerminal;
    }


    /**
     * Sets the departureTerminal value for this AirportResourcesV2.
     * 
     * @param departureTerminal
     */
    public void setDepartureTerminal(java.lang.String departureTerminal) {
        this.departureTerminal = departureTerminal;
    }


    /**
     * Gets the departureGate value for this AirportResourcesV2.
     * 
     * @return departureGate
     */
    public java.lang.String getDepartureGate() {
        return departureGate;
    }


    /**
     * Sets the departureGate value for this AirportResourcesV2.
     * 
     * @param departureGate
     */
    public void setDepartureGate(java.lang.String departureGate) {
        this.departureGate = departureGate;
    }


    /**
     * Gets the arrivalTerminal value for this AirportResourcesV2.
     * 
     * @return arrivalTerminal
     */
    public java.lang.String getArrivalTerminal() {
        return arrivalTerminal;
    }


    /**
     * Sets the arrivalTerminal value for this AirportResourcesV2.
     * 
     * @param arrivalTerminal
     */
    public void setArrivalTerminal(java.lang.String arrivalTerminal) {
        this.arrivalTerminal = arrivalTerminal;
    }


    /**
     * Gets the arrivalGate value for this AirportResourcesV2.
     * 
     * @return arrivalGate
     */
    public java.lang.String getArrivalGate() {
        return arrivalGate;
    }


    /**
     * Sets the arrivalGate value for this AirportResourcesV2.
     * 
     * @param arrivalGate
     */
    public void setArrivalGate(java.lang.String arrivalGate) {
        this.arrivalGate = arrivalGate;
    }


    /**
     * Gets the baggage value for this AirportResourcesV2.
     * 
     * @return baggage
     */
    public java.lang.String getBaggage() {
        return baggage;
    }


    /**
     * Sets the baggage value for this AirportResourcesV2.
     * 
     * @param baggage
     */
    public void setBaggage(java.lang.String baggage) {
        this.baggage = baggage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AirportResourcesV2)) return false;
        AirportResourcesV2 other = (AirportResourcesV2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.departureTerminal==null && other.getDepartureTerminal()==null) || 
             (this.departureTerminal!=null &&
              this.departureTerminal.equals(other.getDepartureTerminal()))) &&
            ((this.departureGate==null && other.getDepartureGate()==null) || 
             (this.departureGate!=null &&
              this.departureGate.equals(other.getDepartureGate()))) &&
            ((this.arrivalTerminal==null && other.getArrivalTerminal()==null) || 
             (this.arrivalTerminal!=null &&
              this.arrivalTerminal.equals(other.getArrivalTerminal()))) &&
            ((this.arrivalGate==null && other.getArrivalGate()==null) || 
             (this.arrivalGate!=null &&
              this.arrivalGate.equals(other.getArrivalGate()))) &&
            ((this.baggage==null && other.getBaggage()==null) || 
             (this.baggage!=null &&
              this.baggage.equals(other.getBaggage())));
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
        if (getDepartureTerminal() != null) {
            _hashCode += getDepartureTerminal().hashCode();
        }
        if (getDepartureGate() != null) {
            _hashCode += getDepartureGate().hashCode();
        }
        if (getArrivalTerminal() != null) {
            _hashCode += getArrivalTerminal().hashCode();
        }
        if (getArrivalGate() != null) {
            _hashCode += getArrivalGate().hashCode();
        }
        if (getBaggage() != null) {
            _hashCode += getBaggage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AirportResourcesV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airportResourcesV2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departureTerminal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departureTerminal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departureGate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departureGate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrivalTerminal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrivalTerminal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrivalGate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrivalGate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baggage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "baggage"));
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
