/**
 * AirportService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public interface AirportService extends java.rmi.Remote {
    public com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportStatus airportStatus_arr(java.lang.String appId, java.lang.String appKey, java.lang.String airport, int year, int month, int day, java.lang.Integer hourOfDay, java.lang.Boolean utc, java.lang.Integer numHours, java.lang.String carrier, java.lang.String codeType, java.lang.Integer maxFlights, java.lang.String extendedOptions) throws java.rmi.RemoteException, com.conducivetech.cache.flighthistory.api_internal.v2.APIException;
    public com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportTracks airportTracks_arr(java.lang.String appId, java.lang.String appKey, java.lang.String airport, java.lang.String carrier, java.lang.Boolean includeFlightPlan, java.lang.Integer maxPositions, java.lang.Integer maxPositionAgeMinutes, java.lang.String sourceType, java.lang.String codeType, java.lang.Integer maxFlights, java.lang.String extendedOptions) throws java.rmi.RemoteException, com.conducivetech.cache.flighthistory.api_internal.v2.APIException;
    public com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportStatus airportStatus_dep(java.lang.String appId, java.lang.String appKey, java.lang.String airport, int year, int month, int day, java.lang.Integer hourOfDay, java.lang.Boolean utc, java.lang.Integer numHours, java.lang.String carrier, java.lang.String codeType, java.lang.Integer maxFlights, java.lang.String extendedOptions) throws java.rmi.RemoteException, com.conducivetech.cache.flighthistory.api_internal.v2.APIException;
    public com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportTracks airportTracks_dep(java.lang.String appId, java.lang.String appKey, java.lang.String airport, java.lang.String carrier, java.lang.Boolean includeFlightPlan, java.lang.Integer maxPositions, java.lang.Integer maxPositionAgeMinutes, java.lang.String sourceType, java.lang.String codeType, java.lang.Integer maxFlights, java.lang.String extendedOptions) throws java.rmi.RemoteException, com.conducivetech.cache.flighthistory.api_internal.v2.APIException;
}
