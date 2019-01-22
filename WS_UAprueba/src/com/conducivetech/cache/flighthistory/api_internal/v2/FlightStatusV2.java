/**
 * FlightStatusV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class FlightStatusV2  implements java.io.Serializable {
    private long flightId;

    private com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 carrier;

    private java.lang.String carrierFsCode;

    private java.lang.String flightNumber;

    private com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 departureAirport;

    private java.lang.String departureAirportFsCode;

    private com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 arrivalAirport;

    private java.lang.String arrivalAirportFsCode;

    private com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 divertedAirport;

    private java.lang.String divertedAirportFsCode;

    private com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2 departureDate;

    private com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2 arrivalDate;

    private java.lang.String status;

    private com.conducivetech.cache.flighthistory.api_internal.v2.ScheduleDataV2 schedule;

    private com.conducivetech.cache.flighthistory.api_internal.v2.OperationalTimesV2 operationalTimes;

    private com.conducivetech.cache.flighthistory.api_internal.v2.CodeshareV2[] codeshares;

    private com.conducivetech.cache.flighthistory.api_internal.v2.DelaysV2 delays;

    private com.conducivetech.cache.flighthistory.api_internal.v2.FlightDurationsV2 flightDurations;

    private com.conducivetech.cache.flighthistory.api_internal.v2.AirportResourcesV2 airportResources;

    private com.conducivetech.cache.flighthistory.api_internal.v2.FlightEquipmentV2 flightEquipment;

    private com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdateV2[] flightStatusUpdates;

    private com.conducivetech.cache.flighthistory.api_internal.v2.IrregularOperationV2[] irregularOperations;

    private com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 operatingCarrier;

    private java.lang.String operatingCarrierFsCode;

    private com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 primaryCarrier;

    private java.lang.String primaryCarrierFsCode;

    private com.conducivetech.cache.flighthistory.api_internal.v2.ConfirmedIncident confirmedIncident;

    public FlightStatusV2() {
    }

    public FlightStatusV2(
           long flightId,
           com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 carrier,
           java.lang.String carrierFsCode,
           java.lang.String flightNumber,
           com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 departureAirport,
           java.lang.String departureAirportFsCode,
           com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 arrivalAirport,
           java.lang.String arrivalAirportFsCode,
           com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 divertedAirport,
           java.lang.String divertedAirportFsCode,
           com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2 departureDate,
           com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2 arrivalDate,
           java.lang.String status,
           com.conducivetech.cache.flighthistory.api_internal.v2.ScheduleDataV2 schedule,
           com.conducivetech.cache.flighthistory.api_internal.v2.OperationalTimesV2 operationalTimes,
           com.conducivetech.cache.flighthistory.api_internal.v2.CodeshareV2[] codeshares,
           com.conducivetech.cache.flighthistory.api_internal.v2.DelaysV2 delays,
           com.conducivetech.cache.flighthistory.api_internal.v2.FlightDurationsV2 flightDurations,
           com.conducivetech.cache.flighthistory.api_internal.v2.AirportResourcesV2 airportResources,
           com.conducivetech.cache.flighthistory.api_internal.v2.FlightEquipmentV2 flightEquipment,
           com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdateV2[] flightStatusUpdates,
           com.conducivetech.cache.flighthistory.api_internal.v2.IrregularOperationV2[] irregularOperations,
           com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 operatingCarrier,
           java.lang.String operatingCarrierFsCode,
           com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 primaryCarrier,
           java.lang.String primaryCarrierFsCode,
           com.conducivetech.cache.flighthistory.api_internal.v2.ConfirmedIncident confirmedIncident) {
           this.flightId = flightId;
           this.carrier = carrier;
           this.carrierFsCode = carrierFsCode;
           this.flightNumber = flightNumber;
           this.departureAirport = departureAirport;
           this.departureAirportFsCode = departureAirportFsCode;
           this.arrivalAirport = arrivalAirport;
           this.arrivalAirportFsCode = arrivalAirportFsCode;
           this.divertedAirport = divertedAirport;
           this.divertedAirportFsCode = divertedAirportFsCode;
           this.departureDate = departureDate;
           this.arrivalDate = arrivalDate;
           this.status = status;
           this.schedule = schedule;
           this.operationalTimes = operationalTimes;
           this.codeshares = codeshares;
           this.delays = delays;
           this.flightDurations = flightDurations;
           this.airportResources = airportResources;
           this.flightEquipment = flightEquipment;
           this.flightStatusUpdates = flightStatusUpdates;
           this.irregularOperations = irregularOperations;
           this.operatingCarrier = operatingCarrier;
           this.operatingCarrierFsCode = operatingCarrierFsCode;
           this.primaryCarrier = primaryCarrier;
           this.primaryCarrierFsCode = primaryCarrierFsCode;
           this.confirmedIncident = confirmedIncident;
    }


    /**
     * Gets the flightId value for this FlightStatusV2.
     * 
     * @return flightId
     */
    public long getFlightId() {
        return flightId;
    }


    /**
     * Sets the flightId value for this FlightStatusV2.
     * 
     * @param flightId
     */
    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }


    /**
     * Gets the carrier value for this FlightStatusV2.
     * 
     * @return carrier
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 getCarrier() {
        return carrier;
    }


    /**
     * Sets the carrier value for this FlightStatusV2.
     * 
     * @param carrier
     */
    public void setCarrier(com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 carrier) {
        this.carrier = carrier;
    }


    /**
     * Gets the carrierFsCode value for this FlightStatusV2.
     * 
     * @return carrierFsCode
     */
    public java.lang.String getCarrierFsCode() {
        return carrierFsCode;
    }


    /**
     * Sets the carrierFsCode value for this FlightStatusV2.
     * 
     * @param carrierFsCode
     */
    public void setCarrierFsCode(java.lang.String carrierFsCode) {
        this.carrierFsCode = carrierFsCode;
    }


    /**
     * Gets the flightNumber value for this FlightStatusV2.
     * 
     * @return flightNumber
     */
    public java.lang.String getFlightNumber() {
        return flightNumber;
    }


    /**
     * Sets the flightNumber value for this FlightStatusV2.
     * 
     * @param flightNumber
     */
    public void setFlightNumber(java.lang.String flightNumber) {
        this.flightNumber = flightNumber;
    }


    /**
     * Gets the departureAirport value for this FlightStatusV2.
     * 
     * @return departureAirport
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 getDepartureAirport() {
        return departureAirport;
    }


    /**
     * Sets the departureAirport value for this FlightStatusV2.
     * 
     * @param departureAirport
     */
    public void setDepartureAirport(com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 departureAirport) {
        this.departureAirport = departureAirport;
    }


    /**
     * Gets the departureAirportFsCode value for this FlightStatusV2.
     * 
     * @return departureAirportFsCode
     */
    public java.lang.String getDepartureAirportFsCode() {
        return departureAirportFsCode;
    }


    /**
     * Sets the departureAirportFsCode value for this FlightStatusV2.
     * 
     * @param departureAirportFsCode
     */
    public void setDepartureAirportFsCode(java.lang.String departureAirportFsCode) {
        this.departureAirportFsCode = departureAirportFsCode;
    }


    /**
     * Gets the arrivalAirport value for this FlightStatusV2.
     * 
     * @return arrivalAirport
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 getArrivalAirport() {
        return arrivalAirport;
    }


    /**
     * Sets the arrivalAirport value for this FlightStatusV2.
     * 
     * @param arrivalAirport
     */
    public void setArrivalAirport(com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }


    /**
     * Gets the arrivalAirportFsCode value for this FlightStatusV2.
     * 
     * @return arrivalAirportFsCode
     */
    public java.lang.String getArrivalAirportFsCode() {
        return arrivalAirportFsCode;
    }


    /**
     * Sets the arrivalAirportFsCode value for this FlightStatusV2.
     * 
     * @param arrivalAirportFsCode
     */
    public void setArrivalAirportFsCode(java.lang.String arrivalAirportFsCode) {
        this.arrivalAirportFsCode = arrivalAirportFsCode;
    }


    /**
     * Gets the divertedAirport value for this FlightStatusV2.
     * 
     * @return divertedAirport
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 getDivertedAirport() {
        return divertedAirport;
    }


    /**
     * Sets the divertedAirport value for this FlightStatusV2.
     * 
     * @param divertedAirport
     */
    public void setDivertedAirport(com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 divertedAirport) {
        this.divertedAirport = divertedAirport;
    }


    /**
     * Gets the divertedAirportFsCode value for this FlightStatusV2.
     * 
     * @return divertedAirportFsCode
     */
    public java.lang.String getDivertedAirportFsCode() {
        return divertedAirportFsCode;
    }


    /**
     * Sets the divertedAirportFsCode value for this FlightStatusV2.
     * 
     * @param divertedAirportFsCode
     */
    public void setDivertedAirportFsCode(java.lang.String divertedAirportFsCode) {
        this.divertedAirportFsCode = divertedAirportFsCode;
    }


    /**
     * Gets the departureDate value for this FlightStatusV2.
     * 
     * @return departureDate
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2 getDepartureDate() {
        return departureDate;
    }


    /**
     * Sets the departureDate value for this FlightStatusV2.
     * 
     * @param departureDate
     */
    public void setDepartureDate(com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2 departureDate) {
        this.departureDate = departureDate;
    }


    /**
     * Gets the arrivalDate value for this FlightStatusV2.
     * 
     * @return arrivalDate
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2 getArrivalDate() {
        return arrivalDate;
    }


    /**
     * Sets the arrivalDate value for this FlightStatusV2.
     * 
     * @param arrivalDate
     */
    public void setArrivalDate(com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2 arrivalDate) {
        this.arrivalDate = arrivalDate;
    }


    /**
     * Gets the status value for this FlightStatusV2.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this FlightStatusV2.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the schedule value for this FlightStatusV2.
     * 
     * @return schedule
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.ScheduleDataV2 getSchedule() {
        return schedule;
    }


    /**
     * Sets the schedule value for this FlightStatusV2.
     * 
     * @param schedule
     */
    public void setSchedule(com.conducivetech.cache.flighthistory.api_internal.v2.ScheduleDataV2 schedule) {
        this.schedule = schedule;
    }


    /**
     * Gets the operationalTimes value for this FlightStatusV2.
     * 
     * @return operationalTimes
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.OperationalTimesV2 getOperationalTimes() {
        return operationalTimes;
    }


    /**
     * Sets the operationalTimes value for this FlightStatusV2.
     * 
     * @param operationalTimes
     */
    public void setOperationalTimes(com.conducivetech.cache.flighthistory.api_internal.v2.OperationalTimesV2 operationalTimes) {
        this.operationalTimes = operationalTimes;
    }


    /**
     * Gets the codeshares value for this FlightStatusV2.
     * 
     * @return codeshares
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.CodeshareV2[] getCodeshares() {
        return codeshares;
    }


    /**
     * Sets the codeshares value for this FlightStatusV2.
     * 
     * @param codeshares
     */
    public void setCodeshares(com.conducivetech.cache.flighthistory.api_internal.v2.CodeshareV2[] codeshares) {
        this.codeshares = codeshares;
    }


    /**
     * Gets the delays value for this FlightStatusV2.
     * 
     * @return delays
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.DelaysV2 getDelays() {
        return delays;
    }


    /**
     * Sets the delays value for this FlightStatusV2.
     * 
     * @param delays
     */
    public void setDelays(com.conducivetech.cache.flighthistory.api_internal.v2.DelaysV2 delays) {
        this.delays = delays;
    }


    /**
     * Gets the flightDurations value for this FlightStatusV2.
     * 
     * @return flightDurations
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.FlightDurationsV2 getFlightDurations() {
        return flightDurations;
    }


    /**
     * Sets the flightDurations value for this FlightStatusV2.
     * 
     * @param flightDurations
     */
    public void setFlightDurations(com.conducivetech.cache.flighthistory.api_internal.v2.FlightDurationsV2 flightDurations) {
        this.flightDurations = flightDurations;
    }


    /**
     * Gets the airportResources value for this FlightStatusV2.
     * 
     * @return airportResources
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.AirportResourcesV2 getAirportResources() {
        return airportResources;
    }


    /**
     * Sets the airportResources value for this FlightStatusV2.
     * 
     * @param airportResources
     */
    public void setAirportResources(com.conducivetech.cache.flighthistory.api_internal.v2.AirportResourcesV2 airportResources) {
        this.airportResources = airportResources;
    }


    /**
     * Gets the flightEquipment value for this FlightStatusV2.
     * 
     * @return flightEquipment
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.FlightEquipmentV2 getFlightEquipment() {
        return flightEquipment;
    }


    /**
     * Sets the flightEquipment value for this FlightStatusV2.
     * 
     * @param flightEquipment
     */
    public void setFlightEquipment(com.conducivetech.cache.flighthistory.api_internal.v2.FlightEquipmentV2 flightEquipment) {
        this.flightEquipment = flightEquipment;
    }


    /**
     * Gets the flightStatusUpdates value for this FlightStatusV2.
     * 
     * @return flightStatusUpdates
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdateV2[] getFlightStatusUpdates() {
        return flightStatusUpdates;
    }


    /**
     * Sets the flightStatusUpdates value for this FlightStatusV2.
     * 
     * @param flightStatusUpdates
     */
    public void setFlightStatusUpdates(com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdateV2[] flightStatusUpdates) {
        this.flightStatusUpdates = flightStatusUpdates;
    }


    /**
     * Gets the irregularOperations value for this FlightStatusV2.
     * 
     * @return irregularOperations
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.IrregularOperationV2[] getIrregularOperations() {
        return irregularOperations;
    }


    /**
     * Sets the irregularOperations value for this FlightStatusV2.
     * 
     * @param irregularOperations
     */
    public void setIrregularOperations(com.conducivetech.cache.flighthistory.api_internal.v2.IrregularOperationV2[] irregularOperations) {
        this.irregularOperations = irregularOperations;
    }


    /**
     * Gets the operatingCarrier value for this FlightStatusV2.
     * 
     * @return operatingCarrier
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 getOperatingCarrier() {
        return operatingCarrier;
    }


    /**
     * Sets the operatingCarrier value for this FlightStatusV2.
     * 
     * @param operatingCarrier
     */
    public void setOperatingCarrier(com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 operatingCarrier) {
        this.operatingCarrier = operatingCarrier;
    }


    /**
     * Gets the operatingCarrierFsCode value for this FlightStatusV2.
     * 
     * @return operatingCarrierFsCode
     */
    public java.lang.String getOperatingCarrierFsCode() {
        return operatingCarrierFsCode;
    }


    /**
     * Sets the operatingCarrierFsCode value for this FlightStatusV2.
     * 
     * @param operatingCarrierFsCode
     */
    public void setOperatingCarrierFsCode(java.lang.String operatingCarrierFsCode) {
        this.operatingCarrierFsCode = operatingCarrierFsCode;
    }


    /**
     * Gets the primaryCarrier value for this FlightStatusV2.
     * 
     * @return primaryCarrier
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 getPrimaryCarrier() {
        return primaryCarrier;
    }


    /**
     * Sets the primaryCarrier value for this FlightStatusV2.
     * 
     * @param primaryCarrier
     */
    public void setPrimaryCarrier(com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1 primaryCarrier) {
        this.primaryCarrier = primaryCarrier;
    }


    /**
     * Gets the primaryCarrierFsCode value for this FlightStatusV2.
     * 
     * @return primaryCarrierFsCode
     */
    public java.lang.String getPrimaryCarrierFsCode() {
        return primaryCarrierFsCode;
    }


    /**
     * Sets the primaryCarrierFsCode value for this FlightStatusV2.
     * 
     * @param primaryCarrierFsCode
     */
    public void setPrimaryCarrierFsCode(java.lang.String primaryCarrierFsCode) {
        this.primaryCarrierFsCode = primaryCarrierFsCode;
    }


    /**
     * Gets the confirmedIncident value for this FlightStatusV2.
     * 
     * @return confirmedIncident
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.ConfirmedIncident getConfirmedIncident() {
        return confirmedIncident;
    }


    /**
     * Sets the confirmedIncident value for this FlightStatusV2.
     * 
     * @param confirmedIncident
     */
    public void setConfirmedIncident(com.conducivetech.cache.flighthistory.api_internal.v2.ConfirmedIncident confirmedIncident) {
        this.confirmedIncident = confirmedIncident;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FlightStatusV2)) return false;
        FlightStatusV2 other = (FlightStatusV2) obj;
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
            ((this.divertedAirport==null && other.getDivertedAirport()==null) || 
             (this.divertedAirport!=null &&
              this.divertedAirport.equals(other.getDivertedAirport()))) &&
            ((this.divertedAirportFsCode==null && other.getDivertedAirportFsCode()==null) || 
             (this.divertedAirportFsCode!=null &&
              this.divertedAirportFsCode.equals(other.getDivertedAirportFsCode()))) &&
            ((this.departureDate==null && other.getDepartureDate()==null) || 
             (this.departureDate!=null &&
              this.departureDate.equals(other.getDepartureDate()))) &&
            ((this.arrivalDate==null && other.getArrivalDate()==null) || 
             (this.arrivalDate!=null &&
              this.arrivalDate.equals(other.getArrivalDate()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.schedule==null && other.getSchedule()==null) || 
             (this.schedule!=null &&
              this.schedule.equals(other.getSchedule()))) &&
            ((this.operationalTimes==null && other.getOperationalTimes()==null) || 
             (this.operationalTimes!=null &&
              this.operationalTimes.equals(other.getOperationalTimes()))) &&
            ((this.codeshares==null && other.getCodeshares()==null) || 
             (this.codeshares!=null &&
              java.util.Arrays.equals(this.codeshares, other.getCodeshares()))) &&
            ((this.delays==null && other.getDelays()==null) || 
             (this.delays!=null &&
              this.delays.equals(other.getDelays()))) &&
            ((this.flightDurations==null && other.getFlightDurations()==null) || 
             (this.flightDurations!=null &&
              this.flightDurations.equals(other.getFlightDurations()))) &&
            ((this.airportResources==null && other.getAirportResources()==null) || 
             (this.airportResources!=null &&
              this.airportResources.equals(other.getAirportResources()))) &&
            ((this.flightEquipment==null && other.getFlightEquipment()==null) || 
             (this.flightEquipment!=null &&
              this.flightEquipment.equals(other.getFlightEquipment()))) &&
            ((this.flightStatusUpdates==null && other.getFlightStatusUpdates()==null) || 
             (this.flightStatusUpdates!=null &&
              java.util.Arrays.equals(this.flightStatusUpdates, other.getFlightStatusUpdates()))) &&
            ((this.irregularOperations==null && other.getIrregularOperations()==null) || 
             (this.irregularOperations!=null &&
              java.util.Arrays.equals(this.irregularOperations, other.getIrregularOperations()))) &&
            ((this.operatingCarrier==null && other.getOperatingCarrier()==null) || 
             (this.operatingCarrier!=null &&
              this.operatingCarrier.equals(other.getOperatingCarrier()))) &&
            ((this.operatingCarrierFsCode==null && other.getOperatingCarrierFsCode()==null) || 
             (this.operatingCarrierFsCode!=null &&
              this.operatingCarrierFsCode.equals(other.getOperatingCarrierFsCode()))) &&
            ((this.primaryCarrier==null && other.getPrimaryCarrier()==null) || 
             (this.primaryCarrier!=null &&
              this.primaryCarrier.equals(other.getPrimaryCarrier()))) &&
            ((this.primaryCarrierFsCode==null && other.getPrimaryCarrierFsCode()==null) || 
             (this.primaryCarrierFsCode!=null &&
              this.primaryCarrierFsCode.equals(other.getPrimaryCarrierFsCode()))) &&
            ((this.confirmedIncident==null && other.getConfirmedIncident()==null) || 
             (this.confirmedIncident!=null &&
              this.confirmedIncident.equals(other.getConfirmedIncident())));
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
        if (getDivertedAirport() != null) {
            _hashCode += getDivertedAirport().hashCode();
        }
        if (getDivertedAirportFsCode() != null) {
            _hashCode += getDivertedAirportFsCode().hashCode();
        }
        if (getDepartureDate() != null) {
            _hashCode += getDepartureDate().hashCode();
        }
        if (getArrivalDate() != null) {
            _hashCode += getArrivalDate().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getSchedule() != null) {
            _hashCode += getSchedule().hashCode();
        }
        if (getOperationalTimes() != null) {
            _hashCode += getOperationalTimes().hashCode();
        }
        if (getCodeshares() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCodeshares());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCodeshares(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDelays() != null) {
            _hashCode += getDelays().hashCode();
        }
        if (getFlightDurations() != null) {
            _hashCode += getFlightDurations().hashCode();
        }
        if (getAirportResources() != null) {
            _hashCode += getAirportResources().hashCode();
        }
        if (getFlightEquipment() != null) {
            _hashCode += getFlightEquipment().hashCode();
        }
        if (getFlightStatusUpdates() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFlightStatusUpdates());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFlightStatusUpdates(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getOperatingCarrier() != null) {
            _hashCode += getOperatingCarrier().hashCode();
        }
        if (getOperatingCarrierFsCode() != null) {
            _hashCode += getOperatingCarrierFsCode().hashCode();
        }
        if (getPrimaryCarrier() != null) {
            _hashCode += getPrimaryCarrier().hashCode();
        }
        if (getPrimaryCarrierFsCode() != null) {
            _hashCode += getPrimaryCarrierFsCode().hashCode();
        }
        if (getConfirmedIncident() != null) {
            _hashCode += getConfirmedIncident().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FlightStatusV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightStatusV2"));
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
        elemField.setFieldName("divertedAirport");
        elemField.setXmlName(new javax.xml.namespace.QName("", "divertedAirport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airportV1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("divertedAirportFsCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "divertedAirportFsCode"));
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
        elemField.setFieldName("arrivalDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrivalDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "dateInfoV2"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("schedule");
        elemField.setXmlName(new javax.xml.namespace.QName("", "schedule"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "scheduleDataV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operationalTimes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operationalTimes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "operationalTimesV2"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codeshares");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codeshares"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "codeshareV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "codeshare"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("delays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "delays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "delaysV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flightDurations");
        elemField.setXmlName(new javax.xml.namespace.QName("", "flightDurations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightDurationsV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("airportResources");
        elemField.setXmlName(new javax.xml.namespace.QName("", "airportResources"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airportResourcesV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flightEquipment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "flightEquipment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightEquipmentV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flightStatusUpdates");
        elemField.setXmlName(new javax.xml.namespace.QName("", "flightStatusUpdates"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightStatusUpdateV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "flightStatusUpdate"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("irregularOperations");
        elemField.setXmlName(new javax.xml.namespace.QName("", "irregularOperations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "irregularOperationV2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "irregularOperation"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operatingCarrier");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operatingCarrier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airlineV1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operatingCarrierFsCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operatingCarrierFsCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaryCarrier");
        elemField.setXmlName(new javax.xml.namespace.QName("", "primaryCarrier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airlineV1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaryCarrierFsCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "primaryCarrierFsCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confirmedIncident");
        elemField.setXmlName(new javax.xml.namespace.QName("", "confirmedIncident"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "confirmedIncident"));
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
