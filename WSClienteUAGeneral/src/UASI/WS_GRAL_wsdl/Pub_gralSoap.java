/**
 * Pub_gralSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package UASI.WS_GRAL_wsdl;

public interface Pub_gralSoap extends java.rmi.Remote {
    public UASI.WS_GRAL_wsdl.ClaseNoticias[] wsnoticias(java.lang.String plengua, java.lang.String pfechaini) throws java.rmi.RemoteException;
    public UASI.WS_GRAL_wsdl.ClaseDiasFestivos[] wsdiasfestivos(java.lang.String plengua, java.lang.String pcurso) throws java.rmi.RemoteException;
    public UASI.WS_GRAL_wsdl.ClaseX500[] wsx500(java.lang.String plengua, java.lang.String ptexto) throws java.rmi.RemoteException;
    public UASI.WS_GRAL_wsdl.ClaseAlojamiento[] wsalojamientos() throws java.rmi.RemoteException;
    public UASI.WS_GRAL_wsdl.ClaseVideo[] wsvideo(java.lang.String plengua, java.lang.String pfechadesde) throws java.rmi.RemoteException;
}
