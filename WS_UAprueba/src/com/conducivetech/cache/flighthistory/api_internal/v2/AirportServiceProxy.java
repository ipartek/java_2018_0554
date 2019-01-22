package com.conducivetech.cache.flighthistory.api_internal.v2;

public class AirportServiceProxy implements com.conducivetech.cache.flighthistory.api_internal.v2.AirportService {
  private String _endpoint = null;
  private com.conducivetech.cache.flighthistory.api_internal.v2.AirportService airportService = null;
  
  public AirportServiceProxy() {
    _initAirportServiceProxy();
  }
  
  public AirportServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initAirportServiceProxy();
  }
  
  private void _initAirportServiceProxy() {
    try {
      airportService = (new com.conducivetech.cache.flighthistory.api_internal.v2.AirportSoapApiServiceLocator()).getairportServicePort();
      if (airportService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)airportService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)airportService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (airportService != null)
      ((javax.xml.rpc.Stub)airportService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.conducivetech.cache.flighthistory.api_internal.v2.AirportService getAirportService() {
    if (airportService == null)
      _initAirportServiceProxy();
    return airportService;
  }
  
  public com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportStatus airportStatus_arr(java.lang.String appId, java.lang.String appKey, java.lang.String airport, int year, int month, int day, java.lang.Integer hourOfDay, java.lang.Boolean utc, java.lang.Integer numHours, java.lang.String carrier, java.lang.String codeType, java.lang.Integer maxFlights, java.lang.String extendedOptions) throws java.rmi.RemoteException, com.conducivetech.cache.flighthistory.api_internal.v2.APIException{
    if (airportService == null)
      _initAirportServiceProxy();
    return airportService.airportStatus_arr(appId, appKey, airport, year, month, day, hourOfDay, utc, numHours, carrier, codeType, maxFlights, extendedOptions);
  }
  
  public com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportTracks airportTracks_arr(java.lang.String appId, java.lang.String appKey, java.lang.String airport, java.lang.String carrier, java.lang.Boolean includeFlightPlan, java.lang.Integer maxPositions, java.lang.Integer maxPositionAgeMinutes, java.lang.String sourceType, java.lang.String codeType, java.lang.Integer maxFlights, java.lang.String extendedOptions) throws java.rmi.RemoteException, com.conducivetech.cache.flighthistory.api_internal.v2.APIException{
    if (airportService == null)
      _initAirportServiceProxy();
    return airportService.airportTracks_arr(appId, appKey, airport, carrier, includeFlightPlan, maxPositions, maxPositionAgeMinutes, sourceType, codeType, maxFlights, extendedOptions);
  }
  
  public com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportStatus airportStatus_dep(java.lang.String appId, java.lang.String appKey, java.lang.String airport, int year, int month, int day, java.lang.Integer hourOfDay, java.lang.Boolean utc, java.lang.Integer numHours, java.lang.String carrier, java.lang.String codeType, java.lang.Integer maxFlights, java.lang.String extendedOptions) throws java.rmi.RemoteException, com.conducivetech.cache.flighthistory.api_internal.v2.APIException{
    if (airportService == null)
      _initAirportServiceProxy();
    return airportService.airportStatus_dep(appId, appKey, airport, year, month, day, hourOfDay, utc, numHours, carrier, codeType, maxFlights, extendedOptions);
  }
  
  public com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportTracks airportTracks_dep(java.lang.String appId, java.lang.String appKey, java.lang.String airport, java.lang.String carrier, java.lang.Boolean includeFlightPlan, java.lang.Integer maxPositions, java.lang.Integer maxPositionAgeMinutes, java.lang.String sourceType, java.lang.String codeType, java.lang.Integer maxFlights, java.lang.String extendedOptions) throws java.rmi.RemoteException, com.conducivetech.cache.flighthistory.api_internal.v2.APIException{
    if (airportService == null)
      _initAirportServiceProxy();
    return airportService.airportTracks_dep(appId, appKey, airport, carrier, includeFlightPlan, maxPositions, maxPositionAgeMinutes, sourceType, codeType, maxFlights, extendedOptions);
  }
  
  
}