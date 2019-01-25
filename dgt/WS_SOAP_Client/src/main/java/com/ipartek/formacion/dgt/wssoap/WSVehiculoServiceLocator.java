/**
 * WSVehiculoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ipartek.formacion.dgt.wssoap;

public class WSVehiculoServiceLocator extends org.apache.axis.client.Service implements com.ipartek.formacion.dgt.wssoap.WSVehiculoService {

    public WSVehiculoServiceLocator() {
    }


    public WSVehiculoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSVehiculoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSVehiculo
    private java.lang.String WSVehiculo_address = "http://localhost:8080/wssoap/services/WSVehiculo";

    public java.lang.String getWSVehiculoAddress() {
        return WSVehiculo_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSVehiculoWSDDServiceName = "WSVehiculo";

    public java.lang.String getWSVehiculoWSDDServiceName() {
        return WSVehiculoWSDDServiceName;
    }

    public void setWSVehiculoWSDDServiceName(java.lang.String name) {
        WSVehiculoWSDDServiceName = name;
    }

    public com.ipartek.formacion.dgt.wssoap.WSVehiculo getWSVehiculo() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSVehiculo_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSVehiculo(endpoint);
    }

    public com.ipartek.formacion.dgt.wssoap.WSVehiculo getWSVehiculo(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ipartek.formacion.dgt.wssoap.WSVehiculoSoapBindingStub _stub = new com.ipartek.formacion.dgt.wssoap.WSVehiculoSoapBindingStub(portAddress, this);
            _stub.setPortName(getWSVehiculoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSVehiculoEndpointAddress(java.lang.String address) {
        WSVehiculo_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ipartek.formacion.dgt.wssoap.WSVehiculo.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ipartek.formacion.dgt.wssoap.WSVehiculoSoapBindingStub _stub = new com.ipartek.formacion.dgt.wssoap.WSVehiculoSoapBindingStub(new java.net.URL(WSVehiculo_address), this);
                _stub.setPortName(getWSVehiculoWSDDServiceName());
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
        if ("WSVehiculo".equals(inputPortName)) {
            return getWSVehiculo();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wssoap.dgt.formacion.ipartek.com", "WSVehiculoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wssoap.dgt.formacion.ipartek.com", "WSVehiculo"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSVehiculo".equals(portName)) {
            setWSVehiculoEndpointAddress(address);
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
