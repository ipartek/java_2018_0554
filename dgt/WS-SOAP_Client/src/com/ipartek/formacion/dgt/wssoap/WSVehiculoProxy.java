package com.ipartek.formacion.dgt.wssoap;

public class WSVehiculoProxy implements com.ipartek.formacion.dgt.wssoap.WSVehiculo {
  private String _endpoint = null;
  private com.ipartek.formacion.dgt.wssoap.WSVehiculo wSVehiculo = null;
  
  public WSVehiculoProxy() {
    _initWSVehiculoProxy();
  }
  
  public WSVehiculoProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSVehiculoProxy();
  }
  
  private void _initWSVehiculoProxy() {
    try {
      wSVehiculo = (new com.ipartek.formacion.dgt.wssoap.WSVehiculoServiceLocator()).getWSVehiculo();
      if (wSVehiculo != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSVehiculo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSVehiculo)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSVehiculo != null)
      ((javax.xml.rpc.Stub)wSVehiculo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ipartek.formacion.dgt.wssoap.WSVehiculo getWSVehiculo() {
    if (wSVehiculo == null)
      _initWSVehiculoProxy();
    return wSVehiculo;
  }
  
  public com.ipartek.appMultas.modelo.pojo.Coche obtenerDatos(java.lang.String matricula) throws java.rmi.RemoteException{
    if (wSVehiculo == null)
      _initWSVehiculoProxy();
    return wSVehiculo.obtenerDatos(matricula);
  }
  
  
}