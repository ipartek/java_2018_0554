/**
 * Pub_gralLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package UASI.WS_GRAL_wsdl;

public class Pub_gralLocator extends org.apache.axis.client.Service implements UASI.WS_GRAL_wsdl.Pub_gral {

    public Pub_gralLocator() {
    }


    public Pub_gralLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Pub_gralLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for pub_gralSoap
    private java.lang.String pub_gralSoap_address = "https://cvnet.cpd.ua.es/servicioweb/publicos/pub_gral.asmx";

    public java.lang.String getpub_gralSoapAddress() {
        return pub_gralSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String pub_gralSoapWSDDServiceName = "pub_gralSoap";

    public java.lang.String getpub_gralSoapWSDDServiceName() {
        return pub_gralSoapWSDDServiceName;
    }

    public void setpub_gralSoapWSDDServiceName(java.lang.String name) {
        pub_gralSoapWSDDServiceName = name;
    }

    public UASI.WS_GRAL_wsdl.Pub_gralSoap getpub_gralSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(pub_gralSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getpub_gralSoap(endpoint);
    }

    public UASI.WS_GRAL_wsdl.Pub_gralSoap getpub_gralSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            UASI.WS_GRAL_wsdl.Pub_gralSoapStub _stub = new UASI.WS_GRAL_wsdl.Pub_gralSoapStub(portAddress, this);
            _stub.setPortName(getpub_gralSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setpub_gralSoapEndpointAddress(java.lang.String address) {
        pub_gralSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (UASI.WS_GRAL_wsdl.Pub_gralSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                UASI.WS_GRAL_wsdl.Pub_gralSoapStub _stub = new UASI.WS_GRAL_wsdl.Pub_gralSoapStub(new java.net.URL(pub_gralSoap_address), this);
                _stub.setPortName(getpub_gralSoapWSDDServiceName());
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
        if ("pub_gralSoap".equals(inputPortName)) {
            return getpub_gralSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "pub_gral");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "pub_gralSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("pub_gralSoap".equals(portName)) {
            setpub_gralSoapEndpointAddress(address);
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
