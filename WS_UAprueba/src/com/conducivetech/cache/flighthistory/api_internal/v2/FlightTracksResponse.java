/**
 * FlightTracksResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public abstract class FlightTracksResponse  extends com.conducivetech.cache.flighthistory.api_internal.v2.ResponseImpl  implements java.io.Serializable {
    private com.conducivetech.cache.flighthistory.api_internal.v2.FlightTrackV2[] flightTracks;

    public FlightTracksResponse() {
    }

    public FlightTracksResponse(
           com.conducivetech.cache.flighthistory.api_internal.v2.ApiResponseError error,
           com.conducivetech.cache.flighthistory.api_internal.v2.Appendices appendix,
           com.conducivetech.cache.flighthistory.api_internal.v2.FlightTrackV2[] flightTracks) {
        super(
            error,
            appendix);
        this.flightTracks = flightTracks;
    }


    /**
     * Gets the flightTracks value for this FlightTracksResponse.
     * 
     * @return flightTracks
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.FlightTrackV2[] getFlightTracks() {
        return flightTracks;
    }


    /**
     * Sets the flightTracks value for this FlightTracksResponse.
     * 
     * @param flightTracks
     */
    public void setFlightTracks(com.conducivetech.cache.flighthistory.api_internal.v2.FlightTrackV2[] flightTracks) {
        this.flightTracks = flightTracks;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FlightTracksResponse)) return false;
        FlightTracksResponse other = (FlightTracksResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.flightTracks==null && other.getFlightTracks()==null) || 
             (this.flightTracks!=null &&
              java.util.Arrays.equals(this.flightTracks, other.getFlightTracks())));
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
        if (getFlightTracks() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFlightTracks());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFlightTracks(), i);
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
        new org.apache.axis.description.TypeDesc(FlightTracksResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightTracksResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flightTracks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "flightTracks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightTrackV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "flightTrack"));
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
