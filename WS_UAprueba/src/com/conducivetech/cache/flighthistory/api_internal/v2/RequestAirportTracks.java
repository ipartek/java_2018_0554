/**
 * RequestAirportTracks.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class RequestAirportTracks  extends com.conducivetech.cache.flighthistory.api_internal.v2.RequestBase  implements java.io.Serializable {
    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirportV1 airport;

    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirlineV1 carrier;

    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedBoolean includeFlightPlan;

    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger maxPositions;

    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger maxPositionAgeMinutes;

    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString codeType;

    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger maxFlights;

    private com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString extendedOptions;

    public RequestAirportTracks() {
    }

    public RequestAirportTracks(
           java.lang.String url,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirportV1 airport,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirlineV1 carrier,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedBoolean includeFlightPlan,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger maxPositions,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger maxPositionAgeMinutes,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString codeType,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger maxFlights,
           com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString extendedOptions) {
        super(
            url);
        this.airport = airport;
        this.carrier = carrier;
        this.includeFlightPlan = includeFlightPlan;
        this.maxPositions = maxPositions;
        this.maxPositionAgeMinutes = maxPositionAgeMinutes;
        this.codeType = codeType;
        this.maxFlights = maxFlights;
        this.extendedOptions = extendedOptions;
    }


    /**
     * Gets the airport value for this RequestAirportTracks.
     * 
     * @return airport
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirportV1 getAirport() {
        return airport;
    }


    /**
     * Sets the airport value for this RequestAirportTracks.
     * 
     * @param airport
     */
    public void setAirport(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirportV1 airport) {
        this.airport = airport;
    }


    /**
     * Gets the carrier value for this RequestAirportTracks.
     * 
     * @return carrier
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirlineV1 getCarrier() {
        return carrier;
    }


    /**
     * Sets the carrier value for this RequestAirportTracks.
     * 
     * @param carrier
     */
    public void setCarrier(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirlineV1 carrier) {
        this.carrier = carrier;
    }


    /**
     * Gets the includeFlightPlan value for this RequestAirportTracks.
     * 
     * @return includeFlightPlan
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedBoolean getIncludeFlightPlan() {
        return includeFlightPlan;
    }


    /**
     * Sets the includeFlightPlan value for this RequestAirportTracks.
     * 
     * @param includeFlightPlan
     */
    public void setIncludeFlightPlan(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedBoolean includeFlightPlan) {
        this.includeFlightPlan = includeFlightPlan;
    }


    /**
     * Gets the maxPositions value for this RequestAirportTracks.
     * 
     * @return maxPositions
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger getMaxPositions() {
        return maxPositions;
    }


    /**
     * Sets the maxPositions value for this RequestAirportTracks.
     * 
     * @param maxPositions
     */
    public void setMaxPositions(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger maxPositions) {
        this.maxPositions = maxPositions;
    }


    /**
     * Gets the maxPositionAgeMinutes value for this RequestAirportTracks.
     * 
     * @return maxPositionAgeMinutes
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger getMaxPositionAgeMinutes() {
        return maxPositionAgeMinutes;
    }


    /**
     * Sets the maxPositionAgeMinutes value for this RequestAirportTracks.
     * 
     * @param maxPositionAgeMinutes
     */
    public void setMaxPositionAgeMinutes(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger maxPositionAgeMinutes) {
        this.maxPositionAgeMinutes = maxPositionAgeMinutes;
    }


    /**
     * Gets the codeType value for this RequestAirportTracks.
     * 
     * @return codeType
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString getCodeType() {
        return codeType;
    }


    /**
     * Sets the codeType value for this RequestAirportTracks.
     * 
     * @param codeType
     */
    public void setCodeType(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString codeType) {
        this.codeType = codeType;
    }


    /**
     * Gets the maxFlights value for this RequestAirportTracks.
     * 
     * @return maxFlights
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger getMaxFlights() {
        return maxFlights;
    }


    /**
     * Sets the maxFlights value for this RequestAirportTracks.
     * 
     * @param maxFlights
     */
    public void setMaxFlights(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger maxFlights) {
        this.maxFlights = maxFlights;
    }


    /**
     * Gets the extendedOptions value for this RequestAirportTracks.
     * 
     * @return extendedOptions
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString getExtendedOptions() {
        return extendedOptions;
    }


    /**
     * Sets the extendedOptions value for this RequestAirportTracks.
     * 
     * @param extendedOptions
     */
    public void setExtendedOptions(com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString extendedOptions) {
        this.extendedOptions = extendedOptions;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RequestAirportTracks)) return false;
        RequestAirportTracks other = (RequestAirportTracks) obj;
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
            ((this.includeFlightPlan==null && other.getIncludeFlightPlan()==null) || 
             (this.includeFlightPlan!=null &&
              this.includeFlightPlan.equals(other.getIncludeFlightPlan()))) &&
            ((this.maxPositions==null && other.getMaxPositions()==null) || 
             (this.maxPositions!=null &&
              this.maxPositions.equals(other.getMaxPositions()))) &&
            ((this.maxPositionAgeMinutes==null && other.getMaxPositionAgeMinutes()==null) || 
             (this.maxPositionAgeMinutes!=null &&
              this.maxPositionAgeMinutes.equals(other.getMaxPositionAgeMinutes()))) &&
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
        if (getIncludeFlightPlan() != null) {
            _hashCode += getIncludeFlightPlan().hashCode();
        }
        if (getMaxPositions() != null) {
            _hashCode += getMaxPositions().hashCode();
        }
        if (getMaxPositionAgeMinutes() != null) {
            _hashCode += getMaxPositionAgeMinutes().hashCode();
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
        new org.apache.axis.description.TypeDesc(RequestAirportTracks.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestAirportTracks"));
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
        elemField.setFieldName("includeFlightPlan");
        elemField.setXmlName(new javax.xml.namespace.QName("", "includeFlightPlan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedBoolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxPositions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxPositions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedInteger"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxPositionAgeMinutes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxPositionAgeMinutes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedInteger"));
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
