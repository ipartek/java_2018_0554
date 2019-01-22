/**
 * ScheduleDataV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class ScheduleDataV2  implements java.io.Serializable {
    private java.lang.String flightType;

    private java.lang.String serviceClasses;

    private java.lang.String restrictions;

    private com.conducivetech.cache.flighthistory.api_internal.v2.UplineFlightV2[] uplines;

    private com.conducivetech.cache.flighthistory.api_internal.v2.DownlineFlightV2[] downlines;

    public ScheduleDataV2() {
    }

    public ScheduleDataV2(
           java.lang.String flightType,
           java.lang.String serviceClasses,
           java.lang.String restrictions,
           com.conducivetech.cache.flighthistory.api_internal.v2.UplineFlightV2[] uplines,
           com.conducivetech.cache.flighthistory.api_internal.v2.DownlineFlightV2[] downlines) {
           this.flightType = flightType;
           this.serviceClasses = serviceClasses;
           this.restrictions = restrictions;
           this.uplines = uplines;
           this.downlines = downlines;
    }


    /**
     * Gets the flightType value for this ScheduleDataV2.
     * 
     * @return flightType
     */
    public java.lang.String getFlightType() {
        return flightType;
    }


    /**
     * Sets the flightType value for this ScheduleDataV2.
     * 
     * @param flightType
     */
    public void setFlightType(java.lang.String flightType) {
        this.flightType = flightType;
    }


    /**
     * Gets the serviceClasses value for this ScheduleDataV2.
     * 
     * @return serviceClasses
     */
    public java.lang.String getServiceClasses() {
        return serviceClasses;
    }


    /**
     * Sets the serviceClasses value for this ScheduleDataV2.
     * 
     * @param serviceClasses
     */
    public void setServiceClasses(java.lang.String serviceClasses) {
        this.serviceClasses = serviceClasses;
    }


    /**
     * Gets the restrictions value for this ScheduleDataV2.
     * 
     * @return restrictions
     */
    public java.lang.String getRestrictions() {
        return restrictions;
    }


    /**
     * Sets the restrictions value for this ScheduleDataV2.
     * 
     * @param restrictions
     */
    public void setRestrictions(java.lang.String restrictions) {
        this.restrictions = restrictions;
    }


    /**
     * Gets the uplines value for this ScheduleDataV2.
     * 
     * @return uplines
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.UplineFlightV2[] getUplines() {
        return uplines;
    }


    /**
     * Sets the uplines value for this ScheduleDataV2.
     * 
     * @param uplines
     */
    public void setUplines(com.conducivetech.cache.flighthistory.api_internal.v2.UplineFlightV2[] uplines) {
        this.uplines = uplines;
    }


    /**
     * Gets the downlines value for this ScheduleDataV2.
     * 
     * @return downlines
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.DownlineFlightV2[] getDownlines() {
        return downlines;
    }


    /**
     * Sets the downlines value for this ScheduleDataV2.
     * 
     * @param downlines
     */
    public void setDownlines(com.conducivetech.cache.flighthistory.api_internal.v2.DownlineFlightV2[] downlines) {
        this.downlines = downlines;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ScheduleDataV2)) return false;
        ScheduleDataV2 other = (ScheduleDataV2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.flightType==null && other.getFlightType()==null) || 
             (this.flightType!=null &&
              this.flightType.equals(other.getFlightType()))) &&
            ((this.serviceClasses==null && other.getServiceClasses()==null) || 
             (this.serviceClasses!=null &&
              this.serviceClasses.equals(other.getServiceClasses()))) &&
            ((this.restrictions==null && other.getRestrictions()==null) || 
             (this.restrictions!=null &&
              this.restrictions.equals(other.getRestrictions()))) &&
            ((this.uplines==null && other.getUplines()==null) || 
             (this.uplines!=null &&
              java.util.Arrays.equals(this.uplines, other.getUplines()))) &&
            ((this.downlines==null && other.getDownlines()==null) || 
             (this.downlines!=null &&
              java.util.Arrays.equals(this.downlines, other.getDownlines())));
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
        if (getFlightType() != null) {
            _hashCode += getFlightType().hashCode();
        }
        if (getServiceClasses() != null) {
            _hashCode += getServiceClasses().hashCode();
        }
        if (getRestrictions() != null) {
            _hashCode += getRestrictions().hashCode();
        }
        if (getUplines() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUplines());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUplines(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDownlines() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDownlines());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDownlines(), i);
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
        new org.apache.axis.description.TypeDesc(ScheduleDataV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "scheduleDataV2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flightType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "flightType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceClasses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceClasses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("restrictions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "restrictions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uplines");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uplines"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "uplineFlightV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "upline"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("downlines");
        elemField.setXmlName(new javax.xml.namespace.QName("", "downlines"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "downlineFlightV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "downline"));
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
