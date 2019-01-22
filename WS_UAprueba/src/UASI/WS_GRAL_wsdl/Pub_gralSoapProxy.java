package UASI.WS_GRAL_wsdl;

public class Pub_gralSoapProxy implements UASI.WS_GRAL_wsdl.Pub_gralSoap {
  private String _endpoint = null;
  private UASI.WS_GRAL_wsdl.Pub_gralSoap pub_gralSoap = null;
  
  public Pub_gralSoapProxy() {
    _initPub_gralSoapProxy();
  }
  
  public Pub_gralSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initPub_gralSoapProxy();
  }
  
  private void _initPub_gralSoapProxy() {
    try {
      pub_gralSoap = (new UASI.WS_GRAL_wsdl.Pub_gralLocator()).getpub_gralSoap();
      if (pub_gralSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)pub_gralSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)pub_gralSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (pub_gralSoap != null)
      ((javax.xml.rpc.Stub)pub_gralSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public UASI.WS_GRAL_wsdl.Pub_gralSoap getPub_gralSoap() {
    if (pub_gralSoap == null)
      _initPub_gralSoapProxy();
    return pub_gralSoap;
  }
  
  public UASI.WS_GRAL_wsdl.ClaseNoticias[] wsnoticias(java.lang.String plengua, java.lang.String pfechaini) throws java.rmi.RemoteException{
    if (pub_gralSoap == null)
      _initPub_gralSoapProxy();
    return pub_gralSoap.wsnoticias(plengua, pfechaini);
  }
  
  public UASI.WS_GRAL_wsdl.ClaseDiasFestivos[] wsdiasfestivos(java.lang.String plengua, java.lang.String pcurso) throws java.rmi.RemoteException{
    if (pub_gralSoap == null)
      _initPub_gralSoapProxy();
    return pub_gralSoap.wsdiasfestivos(plengua, pcurso);
  }
  
  public UASI.WS_GRAL_wsdl.ClaseX500[] wsx500(java.lang.String plengua, java.lang.String ptexto) throws java.rmi.RemoteException{
    if (pub_gralSoap == null)
      _initPub_gralSoapProxy();
    return pub_gralSoap.wsx500(plengua, ptexto);
  }
  
  public UASI.WS_GRAL_wsdl.ClaseAlojamiento[] wsalojamientos() throws java.rmi.RemoteException{
    if (pub_gralSoap == null)
      _initPub_gralSoapProxy();
    return pub_gralSoap.wsalojamientos();
  }
  
  public UASI.WS_GRAL_wsdl.ClaseVideo[] wsvideo(java.lang.String plengua, java.lang.String pfechadesde) throws java.rmi.RemoteException{
    if (pub_gralSoap == null)
      _initPub_gralSoapProxy();
    return pub_gralSoap.wsvideo(plengua, pfechadesde);
  }
  
  
}