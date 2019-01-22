/**
 * RequestAirportStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class RequestAirportStatus  extends com.conducivetech.cache.flighthistory.api_internal.v2.RequestBase  implements java.io.Serializable {
    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirportV1 airport;

    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirlineV1 carrier;

    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedDate date;

    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger hourOfDay;

    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger numHours;

    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedBoolean utc;

    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString codeType;

    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger maxFlights;

    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString extendedOptions;

    public RequestAirportStatus() {
    }

    public RequestAirportStatus(
           java.lang.String url,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirportV1 airport,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirlineV1 carrier,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedDate date,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger hourOfDay,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger numHours,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedBoolean utc,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString codeType,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger maxFlights,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString extendedOptions) {
        super(
            url);
        this.airport = airport;
        this.carrier = carrier;
        this.date = date;
        this.hourOfDay = hourOfDay;
        this.numHours = numHours;
        this.utc = utc;
        this.codeType = codeType;
        this.maxFlights = maxFlights;
        this.extendedOptions = extendedOptions;
    }


    /**
     * Gets the airport value for this RequestAirportStatus.
     * 
     * @return airport
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirportV1 getAirport() {
        return airport;
    }


    /**
     * Sets the airport value for this RequestAirportStatus.
     * 
     * @param airport
     */
    public void setAirport(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirportV1 airport) {
        this.airport = airport;
    }


    /**
     * Gets the carrier value for this RequestAirportStatus.
     * 
     * @return carrier
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirlineV1 getCarrier() {
        return carrier;
    }


    /**
     * Sets the carrier value for this RequestAirportStatus.
     * 
     * @param carrier
     */
    public void setCarrier(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirlineV1 carrier) {
        this.carrier = carrier;
    }


    /**
     * Gets the date value for this RequestAirportStatus.
     * 
     * @return date
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedDate getDate() {
        return date;
    }


    /**
     * Sets the date value for this RequestAirportStatus.
     * 
     * @param date
     */
    public void setDate(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedDate date) {
        this.date = date;
    }


    /**
     * Gets the hourOfDay value for this RequestAirportStatus.
     * 
     * @return hourOfDay
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger getHourOfDay() {
        return hourOfDay;
    }


    /**
     * Sets the hourOfDay value for this RequestAirportStatus.
     * 
     * @param hourOfDay
     */
    public void setHourOfDay(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger hourOfDay) {
        this.hourOfDay = hourOfDay;
    }


    /**
     * Gets the numHours value for this RequestAirportStatus.
     * 
     * @return numHours
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger getNumHours() {
        return numHours;
    }


    /**
     * Sets the numHours value for this RequestAirportStatus.
     * 
     * @param numHours
     */
    public void setNumHours(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger numHours) {
        this.numHours = numHours;
    }


    /**
     * Gets the utc value for this RequestAirportStatus.
     * 
     * @return utc
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedBoolean getUtc() {
        return utc;
    }


    /**
     * Sets the utc value for this RequestAirportStatus.
     * 
     * @param utc
     */
    public void setUtc(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedBoolean utc) {
        this.utc = utc;
    }


    /**
     * Gets the codeType value for this RequestAirportStatus.
     * 
     * @return codeType
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString getCodeType() {
        return codeType;
    }


    /**
     * Sets the codeType value for this RequestAirportStatus.
     * 
     * @param codeType
     */
    public void setCodeType(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString codeType) {
        this.codeType = codeType;
    }


    /**
     * Gets the maxFlights value for this RequestAirportStatus.
     * 
     * @return maxFlights
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger getMaxFlights() {
        return maxFlights;
    }


    /**
     * Sets the maxFlights value for this RequestAirportStatus.
     * 
     * @param maxFlights
     */
    public void setMaxFlights(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger maxFlights) {
        this.maxFlights = maxFlights;
    }


    /**
     * Gets the extendedOptions value for this RequestAirportStatus.
     * 
     * @return extendedOptions
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString getExtendedOptions() {
        return extendedOptions;
    }


    /**
     * Sets the extendedOptions value for this RequestAirportStatus.
     * 
     * @param extendedOptions
     */
    public void setExtendedOptions(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString extendedOptions) {
        this.extendedOptions = extendedOptions;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RequestAirportStatus)) return false;
        RequestAirportStatus other = (RequestAirportStatus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.airport==null && other.getAirport()==null) || 
             (this.airport!=null &&
              this.airport.equals(other.getAirport()))) &&
            ((this.carrier==null && other.getCarrier()==null) || 
             (this.carrier!=null &&
              this.carrier.equals(other.getCarrier()))) &&
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            ((this.hourOfDay==null && other.getHourOfDay()==null) || 
             (this.hourOfDay!=null &&
              this.hourOfDay.equals(other.getHourOfDay()))) &&
            ((this.numHours==null && other.getNumHours()==null) || 
             (this.numHours!=null &&
              this.numHours.equals(other.getNumHours()))) &&
            ((this.utc==null && other.getUtc()==null) || 
             (this.utc!=null &&
              this.utc.equals(other.getUtc()))) &&
            ((this.codeType==null && other.getCodeType()==null) || 
             (this.codeType!=null &&
              this.codeType.equals(other.getCodeType()))) &&
            ((this.maxFlights==null && other.getMaxFlights()==null) || 
             (this.maxFlights!=null &&
              this.maxFlights.equals(other.getMaxFlights()))) &&
            ((this.extendedOptions==null && other.getExtendedOptions()==null) || 
             (this.extendedOptions!=null &&
              this.extendedOptions.equals(other.getExtendedOptions())));
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
        if (getAirport() != null) {
            _hashCode += getAirport().hashCode();
        }
        if (getCarrier() != null) {
            _hashCode += getCarrier().hashCode();
        }
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        if (getHourOfDay() != null) {
            _hashCode += getHourOfDay().hashCode();
        }
        if (getNumHours() != null) {
            _hashCode += getNumHours().hashCode();
        }
        if (getUtc() != null) {
            _hashCode += getUtc().hashCode();
        }
        if (getCodeType() != null) {
            _hashCode += getCodeType().hashCode();
        }
        if (getMaxFlights() != null) {
            _hashCode += getMaxFlights().hashCode();
        }
        if (getExtendedOptions() != null) {
            _hashCode += getExtendedOptions().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RequestAirportStatus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestAirportStatus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("airport");
        elemField.setXmlName(new javax.xml.namespace.QName("", "airport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedAirportV1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carrier");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carrier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedAirlineV1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedDate"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hourOfDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hourOfDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedInteger"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numHours");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numHours"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedInteger"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("utc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "utc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedBoolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codeType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codeType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedString"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxFlights");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxFlights"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedInteger"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extendedOptions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "extendedOptions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedString"));
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
