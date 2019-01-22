/**
 * AirportSoapApiServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class AirportSoapApiServiceLocator extends org.apache.axis.client.Service implements com.conducivetech.cache.flighthistory.api_internal.v2.AirportSoapApiService {

    public AirportSoapApiServiceLocator() {
    }


    public AirportSoapApiServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AirportSoapApiServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for airportServicePort
    private java.lang.String airportServicePort_address = "https://api.flightstats.com:443/flex/flightstatus/soap/v2/airportService";

    public java.lang.String getairportServicePortAddress() {
        return airportServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String airportServicePortWSDDServiceName = "airportServicePort";

    public java.lang.String getairportServicePortWSDDServiceName() {
        return airportServicePortWSDDServiceName;
    }

    public void setairportServicePortWSDDServiceName(java.lang.String name) {
        airportServicePortWSDDServiceName = name;
    }

    public com.conducivetech.cache.flighthistory.api_internal.v2.AirportService getairportServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(airportServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getairportServicePort(endpoint);
    }

    public com.conducivetech.cache.flighthistory.api_internal.v2.AirportService getairportServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.conducivetech.cache.flighthistory.api_internal.v2.AirportServicePortBindingStub _stub = new com.conducivetech.cache.flighthistory.api_internal.v2.AirportServicePortBindingStub(portAddress, this);
            _stub.setPortName(getairportServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setairportServicePortEndpointAddress(java.lang.String address) {
        airportServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.conducivetech.cache.flighthistory.api_internal.v2.AirportService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.conducivetech.cache.flighthistory.api_internal.v2.AirportServicePortBindingStub _stub = new com.conducivetech.cache.flighthistory.api_internal.v2.AirportServicePortBindingStub(new java.net.URL(airportServicePort_address), this);
                _stub.setPortName(getairportServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("airportServicePort".equals(inputPortName)) {
            return getairportServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "AirportSoapApiService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airportServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("airportServicePort".equals(portName)) {
            setairportServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
