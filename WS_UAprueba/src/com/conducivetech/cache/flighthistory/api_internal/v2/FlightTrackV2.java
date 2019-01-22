/**
 * FlightTrackV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class FlightTrackV2  implements java.io.Serializable {
    private long flightId;

    private com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 carrier;

    private java.lang.String carrierFsCode;

    private java.lang.String flightNumber;

    private java.lang.String tailNumber;

    private java.lang.String callsign;

    private com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 departureAirport;

    private java.lang.String departureAirportFsCode;

    private com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 arrivalAirport;

    private java.lang.String arrivalAirportFsCode;

    private com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2 departureDate;

    private java.lang.String equipment;

    private java.lang.Integer delayMinutes;

    private double bearing;

    private java.lang.Double heading;

    private com.conducivetech.cache.flighthistory.api_internal.v2.PositionV2[] positions;

    private com.conducivetech.cache.flighthistory.api_internal.v2.WaypointV2[] waypoints;

    private java.lang.String legacyRoute;

    private com.conducivetech.cache.flighthistory.api_internal.v2.IrregularOperationV2[] irregularOperations;

    public FlightTrackV2() {
    }

    public FlightTrackV2(
           long flightId,
           com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 carrier,
           java.lang.String carrierFsCode,
           java.lang.String flightNumber,
           java.lang.String tailNumber,
           java.lang.String callsign,
           com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 departureAirport,
           java.lang.String departureAirportFsCode,
           com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 arrivalAirport,
           java.lang.String arrivalAirportFsCode,
           com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2 departureDate,
           java.lang.String equipment,
           java.lang.Integer delayMinutes,
           double bearing,
           java.lang.Double heading,
           com.conducivetech.cache.flighthistory.api_internal.v2.PositionV2[] positions,
           com.conducivetech.cache.flighthistory.api_internal.v2.WaypointV2[] waypoints,
           java.lang.String legacyRoute,
           com.conducivetech.cache.flighthistory.api_internal.v2.IrregularOperationV2[] irregularOperations) {
           this.flightId = flightId;
           this.carrier = carrier;
           this.carrierFsCode = carrierFsCode;
           this.flightNumber = flightNumber;
           this.tailNumber = tailNumber;
           this.callsign = callsign;
           this.departureAirport = departureAirport;
           this.departureAirportFsCode = departureAirportFsCode;
           this.arrivalAirport = arrivalAirport;
           this.arrivalAirportFsCode = arrivalAirportFsCode;
           this.departureDate = departureDate;
           this.equipment = equipment;
           this.delayMinutes = delayMinutes;
           this.bearing = bearing;
           this.heading = heading;
           this.positions = positions;
           this.waypoints = waypoints;
           this.legacyRoute = legacyRoute;
           this.irregularOperations = irregularOperations;
    }


    /**
     * Gets the flightId value for this FlightTrackV2.
     * 
     * @return flightId
     */
    public long getFlightId() {
        return flightId;
    }


    /**
     * Sets the flightId value for this FlightTrackV2.
     * 
     * @param flightId
     */
    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }


    /**
     * Gets the carrier value for this FlightTrackV2.
     * 
     * @return carrier
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 getCarrier() {
        return carrier;
    }


    /**
     * Sets the carrier value for this FlightTrackV2.
     * 
     * @param carrier
     */
    public void setCarrier(com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 carrier) {
        this.carrier = carrier;
    }


    /**
     * Gets the carrierFsCode value for this FlightTrackV2.
     * 
     * @return carrierFsCode
     */
    public java.lang.String getCarrierFsCode() {
        return carrierFsCode;
    }


    /**
     * Sets the carrierFsCode value for this FlightTrackV2.
     * 
     * @param carrierFsCode
     */
    public void setCarrierFsCode(java.lang.String carrierFsCode) {
        this.carrierFsCode = carrierFsCode;
    }


    /**
     * Gets the flightNumber value for this FlightTrackV2.
     * 
     * @return flightNumber
     */
    public java.lang.String getFlightNumber() {
        return flightNumber;
    }


    /**
     * Sets the flightNumber value for this FlightTrackV2.
     * 
     * @param flightNumber
     */
    public void setFlightNumber(java.lang.String flightNumber) {
        this.flightNumber = flightNumber;
    }


    /**
     * Gets the tailNumber value for this FlightTrackV2.
     * 
     * @return tailNumber
     */
    public java.lang.String getTailNumber() {
        return tailNumber;
    }


    /**
     * Sets the tailNumber value for this FlightTrackV2.
     * 
     * @param tailNumber
     */
    public void setTailNumber(java.lang.String tailNumber) {
        this.tailNumber = tailNumber;
    }


    /**
     * Gets the callsign value for this FlightTrackV2.
     * 
     * @return callsign
     */
    public java.lang.String getCallsign() {
        return callsign;
    }


    /**
     * Sets the callsign value for this FlightTrackV2.
     * 
     * @param callsign
     */
    public void setCallsign(java.lang.String callsign) {
        this.callsign = callsign;
    }


    /**
     * Gets the departureAirport value for this FlightTrackV2.
     * 
     * @return departureAirport
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 getDepartureAirport() {
        return departureAirport;
    }


    /**
     * Sets the departureAirport value for this FlightTrackV2.
     * 
     * @param departureAirport
     */
    public void setDepartureAirport(com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 departureAirport) {
        this.departureAirport = departureAirport;
    }


    /**
     * Gets the departureAirportFsCode value for this FlightTrackV2.
     * 
     * @return departureAirportFsCode
     */
    public java.lang.String getDepartureAirportFsCode() {
        return departureAirportFsCode;
    }


    /**
     * Sets the departureAirportFsCode value for this FlightTrackV2.
     * 
     * @param departureAirportFsCode
     */
    public void setDepartureAirportFsCode(java.lang.String departureAirportFsCode) {
        this.departureAirportFsCode = departureAirportFsCode;
    }


    /**
     * Gets the arrivalAirport value for this FlightTrackV2.
     * 
     * @return arrivalAirport
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 getArrivalAirport() {
        return arrivalAirport;
    }


    /**
     * Sets the arrivalAirport value for this FlightTrackV2.
     * 
     * @param arrivalAirport
     */
    public void setArrivalAirport(com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }


    /**
     * Gets the arrivalAirportFsCode value for this FlightTrackV2.
     * 
     * @return arrivalAirportFsCode
     */
    public java.lang.String getArrivalAirportFsCode() {
        return arrivalAirportFsCode;
    }


    /**
     * Sets the arrivalAirportFsCode value for this FlightTrackV2.
     * 
     * @param arrivalAirportFsCode
     */
    public void setArrivalAirportFsCode(java.lang.String arrivalAirportFsCode) {
        this.arrivalAirportFsCode = arrivalAirportFsCode;
    }


    /**
     * Gets the departureDate value for this FlightTrackV2.
     * 
     * @return departureDate
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2 getDepartureDate() {
        return departureDate;
    }


    /**
     * Sets the departureDate value for this FlightTrackV2.
     * 
     * @param departureDate
     */
    public void setDepartureDate(com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2 departureDate) {
        this.departureDate = departureDate;
    }


    /**
     * Gets the equipment value for this FlightTrackV2.
     * 
     * @return equipment
     */
    public java.lang.String getEquipment() {
        return equipment;
    }


    /**
     * Sets the equipment value for this FlightTrackV2.
     * 
     * @param equipment
     */
    public void setEquipment(java.lang.String equipment) {
        this.equipment = equipment;
    }


    /**
     * Gets the delayMinutes value for this FlightTrackV2.
     * 
     * @return delayMinutes
     */
    public java.lang.Integer getDelayMinutes() {
        return delayMinutes;
    }


    /**
     * Sets the delayMinutes value for this FlightTrackV2.
     * 
     * @param delayMinutes
     */
    public void setDelayMinutes(java.lang.Integer delayMinutes) {
        this.delayMinutes = delayMinutes;
    }


    /**
     * Gets the bearing value for this FlightTrackV2.
     * 
     * @return bearing
     */
    public double getBearing() {
        return bearing;
    }


    /**
     * Sets the bearing value for this FlightTrackV2.
     * 
     * @param bearing
     */
    public void setBearing(double bearing) {
        this.bearing = bearing;
    }


    /**
     * Gets the heading value for this FlightTrackV2.
     * 
     * @return heading
     */
    public java.lang.Double getHeading() {
        return heading;
    }


    /**
     * Sets the heading value for this FlightTrackV2.
     * 
     * @param heading
     */
    public void setHeading(java.lang.Double heading) {
        this.heading = heading;
    }


    /**
     * Gets the positions value for this FlightTrackV2.
     * 
     * @return positions
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.PositionV2[] getPositions() {
        return positions;
    }


    /**
     * Sets the positions value for this FlightTrackV2.
     * 
     * @param positions
     */
    public void setPositions(com.conducivetech.cache.flighthistory.api_internal.v2.PositionV2[] positions) {
        this.positions = positions;
    }


    /**
     * Gets the waypoints value for this FlightTrackV2.
     * 
     * @return waypoints
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.WaypointV2[] getWaypoints() {
        return waypoints;
    }


    /**
     * Sets the waypoints value for this FlightTrackV2.
     * 
     * @param waypoints
     */
    public void setWaypoints(com.conducivetech.cache.flighthistory.api_internal.v2.WaypointV2[] waypoints) {
        this.waypoints = waypoints;
    }


    /**
     * Gets the legacyRoute value for this FlightTrackV2.
     * 
     * @return legacyRoute
     */
    public java.lang.String getLegacyRoute() {
        return legacyRoute;
    }


    /**
     * Sets the legacyRoute value for this FlightTrackV2.
     * 
     * @param legacyRoute
     */
    public void setLegacyRoute(java.lang.String legacyRoute) {
        this.legacyRoute = legacyRoute;
    }


    /**
     * Gets the irregularOperations value for this FlightTrackV2.
     * 
     * @return irregularOperations
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.IrregularOperationV2[] getIrregularOperations() {
        return irregularOperations;
    }


    /**
     * Sets the irregularOperations value for this FlightTrackV2.
     * 
     * @param irregularOperations
     */
    public void setIrregularOperations(com.conducivetech.cache.flighthistory.api_internal.v2.IrregularOperationV2[] irregularOperations) {
        this.irregularOperations = irregularOperations;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FlightTrackV2)) return false;
        FlightTrackV2 other = (FlightTrackV2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.flightId == other.getFlightId() &&
            ((this.carrier==null && other.getCarrier()==null) || 
             (this.carrier!=null &&
              this.carrier.equals(other.getCarrier()))) &&
            ((this.carrierFsCode==null && other.getCarrierFsCode()==null) || 
             (this.carrierFsCode!=null &&
              this.carrierFsCode.equals(other.getCarrierFsCode()))) &&
            ((this.flightNumber==null && other.getFlightNumber()==null) || 
             (this.flightNumber!=null &&
              this.flightNumber.equals(other.getFlightNumber()))) &&
            ((this.tailNumber==null && other.getTailNumber()==null) || 
             (this.tailNumber!=null &&
              this.tailNumber.equals(other.getTailNumber()))) &&
            ((this.callsign==null && other.getCallsign()==null) || 
             (this.callsign!=null &&
              this.callsign.equals(other.getCallsign()))) &&
            ((this.departureAirport==null && other.getDepartureAirport()==null) || 
             (this.departureAirport!=null &&
              this.departureAirport.equals(other.getDepartureAirport()))) &&
            ((this.departureAirportFsCode==null && other.getDepartureAirportFsCode()==null) || 
             (this.departureAirportFsCode!=null &&
              this.departureAirportFsCode.equals(other.getDepartureAirportFsCode()))) &&
            ((this.arrivalAirport==null && other.getArrivalAirport()==null) || 
             (this.arrivalAirport!=null &&
              this.arrivalAirport.equals(other.getArrivalAirport()))) &&
            ((this.arrivalAirportFsCode==null && other.getArrivalAirportFsCode()==null) || 
             (this.arrivalAirportFsCode!=null &&
              this.arrivalAirportFsCode.equals(other.getArrivalAirportFsCode()))) &&
            ((this.departureDate==null && other.getDepartureDate()==null) || 
             (this.departureDate!=null &&
              this.departureDate.equals(other.getDepartureDate()))) &&
            ((this.equipment==null && other.getEquipment()==null) || 
             (this.equipment!=null &&
              this.equipment.equals(other.getEquipment()))) &&
            ((this.delayMinutes==null && other.getDelayMinutes()==null) || 
             (this.delayMinutes!=null &&
              this.delayMinutes.equals(other.getDelayMinutes()))) &&
            this.bearing == other.getBearing() &&
            ((this.heading==null && other.getHeading()==null) || 
             (this.heading!=null &&
              this.heading.equals(other.getHeading()))) &&
            ((this.positions==null && other.getPositions()==null) || 
             (this.positions!=null &&
              java.util.Arrays.equals(this.positions, other.getPositions()))) &&
            ((this.waypoints==null && other.getWaypoints()==null) || 
             (this.waypoints!=null &&
              java.util.Arrays.equals(this.waypoints, other.getWaypoints()))) &&
            ((this.legacyRoute==null && other.getLegacyRoute()==null) || 
             (this.legacyRoute!=null &&
              this.legacyRoute.equals(other.getLegacyRoute()))) &&
            ((this.irregularOperations==null && other.getIrregularOperations()==null) || 
             (this.irregularOperations!=null &&
              java.util.Arrays.equals(this.irregularOperations, other.getIrregularOperations())));
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
        _hashCode += new Long(getFlightId()).hashCode();
        if (getCarrier() != null) {
            _hashCode += getCarrier().hashCode();
        }
        if (getCarrierFsCode() != null) {
            _hashCode += getCarrierFsCode().hashCode();
        }
        if (getFlightNumber() != null) {
            _hashCode += getFlightNumber().hashCode();
        }
        if (getTailNumber() != null) {
            _hashCode += getTailNumber().hashCode();
        }
        if (getCallsign() != null) {
            _hashCode += getCallsign().hashCode();
        }
        if (getDepartureAirport() != null) {
            _hashCode += getDepartureAirport().hashCode();
        }
        if (getDepartureAirportFsCode() != null) {
            _hashCode += getDepartureAirportFsCode().hashCode();
        }
        if (getArrivalAirport() != null) {
            _hashCode += getArrivalAirport().hashCode();
        }
        if (getArrivalAirportFsCode() != null) {
            _hashCode += getArrivalAirportFsCode().hashCode();
        }
        if (getDepartureDate() != null) {
            _hashCode += getDepartureDate().hashCode();
        }
        if (getEquipment() != null) {
            _hashCode += getEquipment().hashCode();
        }
        if (getDelayMinutes() != null) {
            _hashCode += getDelayMinutes().hashCode();
        }
        _hashCode += new Double(getBearing()).hashCode();
        if (getHeading() != null) {
            _hashCode += getHeading().hashCode();
        }
        if (getPositions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPositions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPositions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWaypoints() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWaypoints());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWaypoints(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLegacyRoute() != null) {
            _hashCode += getLegacyRoute().hashCode();
        }
        if (getIrregularOperations() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIrregularOperations());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIrregularOperations(), i);
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
        new org.apache.axis.description.TypeDesc(FlightTrackV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightTrackV2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flightId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "flightId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carrier");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carrier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airlineV1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carrierFsCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carrierFsCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flightNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "flightNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tailNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tailNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("callsign");
        elemField.setXmlName(new javax.xml.namespace.QName("", "callsign"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departureAirport");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departureAirport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airportV1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departureAirportFsCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departureAirportFsCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrivalAirport");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrivalAirport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airportV1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrivalAirportFsCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrivalAirportFsCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departureDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departureDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "dateInfoV2"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("equipment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "equipment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("delayMinutes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "delayMinutes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bearing");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bearing"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("heading");
        elemField.setXmlName(new javax.xml.namespace.QName("", "heading"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("positions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "positions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "positionV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "position"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("waypoints");
        elemField.setXmlName(new javax.xml.namespace.QName("", "waypoints"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "waypointV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "waypoint"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("legacyRoute");
        elemField.setXmlName(new javax.xml.namespace.QName("", "legacyRoute"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("irregularOperations");
        elemField.setXmlName(new javax.xml.namespace.QName("", "irregularOperations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "irregularOperationV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "irregularOperation"));
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
