/**
 * PositionV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class PositionV2  implements java.io.Serializable {
    private double lon;

    private double lat;

    private java.lang.Integer speedMph;

    private java.lang.Integer altitudeFt;

    private java.lang.String source;

    private java.lang.String date;

    private java.lang.Integer course;

    private java.lang.Integer vrateMps;

    private java.lang.String phase;

    private java.lang.String stationID;

    private java.lang.String lastObserved;

    public PositionV2() {
    }

    public PositionV2(
           double lon,
           double lat,
           java.lang.Integer speedMph,
           java.lang.Integer altitudeFt,
           java.lang.String source,
           java.lang.String date,
           java.lang.Integer course,
           java.lang.Integer vrateMps,
           java.lang.String phase,
           java.lang.String stationID,
           java.lang.String lastObserved) {
           this.lon = lon;
           this.lat = lat;
           this.speedMph = speedMph;
           this.altitudeFt = altitudeFt;
           this.source = source;
           this.date = date;
           this.course = course;
           this.vrateMps = vrateMps;
           this.phase = phase;
           this.stationID = stationID;
           this.lastObserved = lastObserved;
    }


    /**
     * Gets the lon value for this PositionV2.
     * 
     * @return lon
     */
    public double getLon() {
        return lon;
    }


    /**
     * Sets the lon value for this PositionV2.
     * 
     * @param lon
     */
    public void setLon(double lon) {
        this.lon = lon;
    }


    /**
     * Gets the lat value for this PositionV2.
     * 
     * @return lat
     */
    public double getLat() {
        return lat;
    }


    /**
     * Sets the lat value for this PositionV2.
     * 
     * @param lat
     */
    public void setLat(double lat) {
        this.lat = lat;
    }


    /**
     * Gets the speedMph value for this PositionV2.
     * 
     * @return speedMph
     */
    public java.lang.Integer getSpeedMph() {
        return speedMph;
    }


    /**
     * Sets the speedMph value for this PositionV2.
     * 
     * @param speedMph
     */
    public void setSpeedMph(java.lang.Integer speedMph) {
        this.speedMph = speedMph;
    }


    /**
     * Gets the altitudeFt value for this PositionV2.
     * 
     * @return altitudeFt
     */
    public java.lang.Integer getAltitudeFt() {
        return altitudeFt;
    }


    /**
     * Sets the altitudeFt value for this PositionV2.
     * 
     * @param altitudeFt
     */
    public void setAltitudeFt(java.lang.Integer altitudeFt) {
        this.altitudeFt = altitudeFt;
    }


    /**
     * Gets the source value for this PositionV2.
     * 
     * @return source
     */
    public java.lang.String getSource() {
        return source;
    }


    /**
     * Sets the source value for this PositionV2.
     * 
     * @param source
     */
    public void setSource(java.lang.String source) {
        this.source = source;
    }


    /**
     * Gets the date value for this PositionV2.
     * 
     * @return date
     */
    public java.lang.String getDate() {
        return date;
    }


    /**
     * Sets the date value for this PositionV2.
     * 
     * @param date
     */
    public void setDate(java.lang.String date) {
        this.date = date;
    }


    /**
     * Gets the course value for this PositionV2.
     * 
     * @return course
     */
    public java.lang.Integer getCourse() {
        return course;
    }


    /**
     * Sets the course value for this PositionV2.
     * 
     * @param course
     */
    public void setCourse(java.lang.Integer course) {
        this.course = course;
    }


    /**
     * Gets the vrateMps value for this PositionV2.
     * 
     * @return vrateMps
     */
    public java.lang.Integer getVrateMps() {
        return vrateMps;
    }


    /**
     * Sets the vrateMps value for this PositionV2.
     * 
     * @param vrateMps
     */
    public void setVrateMps(java.lang.Integer vrateMps) {
        this.vrateMps = vrateMps;
    }


    /**
     * Gets the phase value for this PositionV2.
     * 
     * @return phase
     */
    public java.lang.String getPhase() {
        return phase;
    }


    /**
     * Sets the phase value for this PositionV2.
     * 
     * @param phase
     */
    public void setPhase(java.lang.String phase) {
        this.phase = phase;
    }


    /**
     * Gets the stationID value for this PositionV2.
     * 
     * @return stationID
     */
    public java.lang.String getStationID() {
        return stationID;
    }


    /**
     * Sets the stationID value for this PositionV2.
     * 
     * @param stationID
     */
    public void setStationID(java.lang.String stationID) {
        this.stationID = stationID;
    }


    /**
     * Gets the lastObserved value for this PositionV2.
     * 
     * @return lastObserved
     */
    public java.lang.String getLastObserved() {
        return lastObserved;
    }


    /**
     * Sets the lastObserved value for this PositionV2.
     * 
     * @param lastObserved
     */
    public void setLastObserved(java.lang.String lastObserved) {
        this.lastObserved = lastObserved;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PositionV2)) return false;
        PositionV2 other = (PositionV2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.lon == other.getLon() &&
            this.lat == other.getLat() &&
            ((this.speedMph==null && other.getSpeedMph()==null) || 
             (this.speedMph!=null &&
              this.speedMph.equals(other.getSpeedMph()))) &&
            ((this.altitudeFt==null && other.getAltitudeFt()==null) || 
             (this.altitudeFt!=null &&
              this.altitudeFt.equals(other.getAltitudeFt()))) &&
            ((this.source==null && other.getSource()==null) || 
             (this.source!=null &&
              this.source.equals(other.getSource()))) &&
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            ((this.course==null && other.getCourse()==null) || 
             (this.course!=null &&
              this.course.equals(other.getCourse()))) &&
            ((this.vrateMps==null && other.getVrateMps()==null) || 
             (this.vrateMps!=null &&
              this.vrateMps.equals(other.getVrateMps()))) &&
            ((this.phase==null && other.getPhase()==null) || 
             (this.phase!=null &&
              this.phase.equals(other.getPhase()))) &&
            ((this.stationID==null && other.getStationID()==null) || 
             (this.stationID!=null &&
              this.stationID.equals(other.getStationID()))) &&
            ((this.lastObserved==null && other.getLastObserved()==null) || 
             (this.lastObserved!=null &&
              this.lastObserved.equals(other.getLastObserved())));
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
        _hashCode += new Double(getLon()).hashCode();
        _hashCode += new Double(getLat()).hashCode();
        if (getSpeedMph() != null) {
            _hashCode += getSpeedMph().hashCode();
        }
        if (getAltitudeFt() != null) {
            _hashCode += getAltitudeFt().hashCode();
        }
        if (getSource() != null) {
            _hashCode += getSource().hashCode();
        }
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        if (getCourse() != null) {
            _hashCode += getCourse().hashCode();
        }
        if (getVrateMps() != null) {
            _hashCode += getVrateMps().hashCode();
        }
        if (getPhase() != null) {
            _hashCode += getPhase().hashCode();
        }
        if (getStationID() != null) {
            _hashCode += getStationID().hashCode();
        }
        if (getLastObserved() != null) {
            _hashCode += getLastObserved().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PositionV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "positionV2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("speedMph");
        elemField.setXmlName(new javax.xml.namespace.QName("", "speedMph"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("altitudeFt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "altitudeFt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("source");
        elemField.setXmlName(new javax.xml.namespace.QName("", "source"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("course");
        elemField.setXmlName(new javax.xml.namespace.QName("", "course"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vrateMps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vrateMps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phase");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stationID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastObserved");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastObserved"));
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
